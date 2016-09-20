package pool;

public class Application {
	public static void main(String args[]) throws InterruptedException{
		MyObjectPool pool = new MyObjectPool(3,5);  // Created object pool 
		PoolableObject str = pool.getObject();  // Grabbed an object from pool
		
		
		// Objects grabbed from pool by different threads 
		pool.getObject();
		pool.getObject();
		pool.getObject();
		pool.getObject();
		
		// did some work
		//...
		pool.returnBack(str);  // returning the object to the pool by first Thread
		
		Thread.sleep(12000);
		
		pool.shutdown();  // shutting down the pool
	}
}
