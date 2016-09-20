package pool;

public class PoolMetadata {
	private long timestamp;
	private boolean inUse;
	PoolMetadata(){
		this.timestamp = System.currentTimeMillis();
		this.inUse = false;
	}
	public long  getTimestamp(){
		return timestamp;
	}
	public void setTimestamp(long timestamp){
		this.timestamp = timestamp;
	}
	public boolean isInUse(){
		return inUse;
	}
	public void setInUse(boolean inUse){
		this.inUse = inUse;
	}
}
