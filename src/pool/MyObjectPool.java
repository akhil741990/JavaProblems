package pool;

public class MyObjectPool extends MyGenericPool<PoolableObject>{

	public MyObjectPool(int minPoolSize, int maxPoolSize) {
		super(minPoolSize,maxPoolSize);
	}

	@Override
	public PoolableObject create() {
		return new PoolableObject();
	}	
}
