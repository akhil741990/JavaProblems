package pool;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class MyGenericPool<T extends Poolable> {
	 private LinkedHashMap<T,PoolMetadata> pool;
	 private int minPoolSize;
	 private int maxPoolSize;
	 private long expiryTimeinMilliSeconds = 5*1000;  // this can be made configurable by passing to the constructor;
	 private long cleanupThreadIntervalInSeconds = 10; // this can be made configurable by passing to the constructor;
	 private ScheduledExecutorService executorService;
	 public MyGenericPool(int minPoolSize, int maxPoolSize) {
		 // LinkedHashMap maintains insertion order, so objects will be sorted on timestamp of objects added to the pool
		 pool = new LinkedHashMap<T,PoolMetadata>();
		 this.minPoolSize = minPoolSize;
		 this.maxPoolSize = maxPoolSize;
		 initialize();
		 executorService = Executors.newSingleThreadScheduledExecutor();
		// start clean up thread
		startCleanUpThread(); 
	 }
	 
	 private void startCleanUpThread(){
		 executorService.scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Clean up Thread started");
				
				synchronized (pool) {
					
					if(pool.size() > minPoolSize) {    // this ensures that there are always minPoolSize objects in the pool
						Iterator<Entry<T,PoolMetadata>> itr = pool.entrySet().iterator();
						while(itr.hasNext()){
							Entry<T,PoolMetadata> entry = itr.next();
							if(!entry.getValue().isInUse()){
								if(System.currentTimeMillis() - entry.getValue().getTimestamp() >= expiryTimeinMilliSeconds){
									T obj = entry.getKey();
									obj.close();  //  release the resource held by the old object
									System.out.println("Removed old object:"+ obj + " from pool" );
									itr.remove();
								}else{
									// LinkedHashMap maintains insertion order so it is sorted on timestamp  
									// no need to check the expiration of rest object as their timestamp will be greater 
									// than current object
									break;
								}
							}
							if(pool.size() == minPoolSize){   // this ensures that there are always minPoolSize objects in the pool
								break;
							}
						}
					}
				}
			}
		}, cleanupThreadIntervalInSeconds, cleanupThreadIntervalInSeconds, TimeUnit.SECONDS);
	 }
	 
	 private void initialize() {
		 
		 for(int i = 0; i < minPoolSize ; i++){
			 T obj = create();
			 pool.put(obj, new PoolMetadata());
		 }
		 System.out.println("Initialized pool with "+minPoolSize + " objects" );
	 }
	 public abstract T create();
	 
	 public T getObject(){
		 T obj = null;
		 PoolMetadata metadata = null;
		 
		synchronized (pool) {
			Iterator<Entry<T,PoolMetadata>> itr = pool.entrySet().iterator();
			 while(itr.hasNext()){
				 Entry<T,PoolMetadata> entry = itr.next();
				 if(! entry.getValue().isInUse()){
					 obj = entry.getKey();
					 break;
				 }
			 }
			 if(obj != null){
				 metadata = pool.get(obj);
				 metadata.setInUse(true);    // marking the object as InUse
				 pool.put(obj, metadata);
				 System.out.println("Got object " + obj + "from pool");
			 }else if (pool.size() < maxPoolSize){  // ensuring not more than maxPoolSize objects are created
				 obj = create();
				 metadata = new PoolMetadata();
				 metadata.setInUse(true);    // marking the object as InUse
				 pool.put(obj,metadata);
				 System.out.println("Addd new object "+ obj + "to the pool");
				 System.out.println("Got object " + obj + "from pool");
			 }else{
				 System.out.println("Pool's capacity is full, cannot create new Instance");
			 }
			return obj;
		}
		 	 
	 }
	 
	 public void returnBack(T obj){
		synchronized (pool) {
			System.out.println("Returning object :"+obj + "to the pool");
			PoolMetadata metadata = pool.get(obj);
			metadata.setTimestamp(System.currentTimeMillis());
			metadata.setInUse(false);
			// obj needs to be added to the end of the linkedList so that ordering on timestamp is maintained
			// so removing and then inserting the object instead of updating the value for the object
			pool.remove(obj);   
			pool.put(obj, metadata);
		} 
	 }
	 public void shutdown(){
		System.out.println("Shuting down the pool");
		if(executorService != null){
			executorService.shutdown();
		}
		synchronized (pool) {
			Iterator<Entry<T,PoolMetadata>> itr = pool.entrySet().iterator();
			while(itr.hasNext()){
				T obj = itr.next().getKey();
				obj.close();
			}
			pool.clear();
		}
	 }
}
