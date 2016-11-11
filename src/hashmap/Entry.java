package hashmap;

import java.util.Map;

public class Entry<K,V> implements Map.Entry<K,V>{

	Entry<K,V> next;
	V value;
	K key;
	int hash;
	
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
	public Entry(int hash, K key, V value, Entry<K, V> next){
		
		this.hash = hash;
		this.value = value;
		this.key = key;
		this.next = next;
	}
	
	public int hashCode(){
		return (key==null?0:key.hashCode())^(value==null?0:value.hashCode());
	}

}
