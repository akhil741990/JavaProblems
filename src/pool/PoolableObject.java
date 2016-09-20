package pool;

public class PoolableObject implements Poolable {

	@Override
	public void close() {
		System.out.println("Releasing resources held by "+this);
		// release the resources
		
	}

}
