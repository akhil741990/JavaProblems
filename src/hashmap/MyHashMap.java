package hashmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K,V> {

	static final int DEFAULT_INITIAL_CAPACITY = 4;
	static final float loadFactor = 0.75f;
	hashmap.Entry<K, V>[] table;
	int size;
	int threshold;
	public MyHashMap() {
		table = new hashmap.Entry[DEFAULT_INITIAL_CAPACITY];
		threshold = (int) (loadFactor * DEFAULT_INITIAL_CAPACITY);
	}
	
	
	public static final int hash(Object key){
		int h;
		return key == null ? 0 : (h = key.hashCode())^ (h >>> 16);
	}
	
	static int indexFor(int h, int length){
		System.out.println("Index is"+(h & (length -1)));
		return h & (length -1);
		
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		if (key == null){
			System.out.println("Key is null");
			return null;
		}else{
			
			int h = hash(key);
			System.out.println("Hash="+h);
			int i = indexFor(h, table.length);
			
			for(hashmap.Entry<K, V> e = table[i]; e != null; e = e.next){
				if(e.hash == h && ((key == e.key) || key.equals(e.key))){
					V oldValue = e.value;
					e.value = value;
					return oldValue;
				}
			}
			addEntry(h, key, value, i);
			return null;
			
		}
	}
	
	void addEntry(int hash,K key,V value, int i){
		hashmap.Entry<K, V> e = table[i];
		table[i] = new hashmap.Entry(hash, key, value, e);
		if (size++ > threshold ){
			// resize hashmap
		}
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
