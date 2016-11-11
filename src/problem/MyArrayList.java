package problem;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements List<T> {
	int size;
	Object[] elementData;
	
	public  MyArrayList(int capacity) {
		// TODO Auto-generated constructor stub
		elementData = new Object[capacity];
	}
	
	public  MyArrayList() {
		this(10);// TODO Auto-generated constructor stub
	} 
	
	private void ensureCapacity(int minCapacity){
		int oldCapacity = elementData.length;
		if(minCapacity > oldCapacity){
			int newCapacity =(oldCapacity * 3)/2 + 1;
			if(newCapacity < minCapacity){
				newCapacity = minCapacity;
			}
			elementData = Arrays.copyOf(elementData,newCapacity);
		}
		
	}
	@Override
	public boolean add(T arg0) {
		ensureCapacity(size+1);
		elementData[size++] = arg0;
		return false;
	}

	@Override
	public void add(int arg0, T arg1) {
		rangeCheckForAdd(arg0);
		ensureCapacity(size + 1);
		for(int i =size-1;i >=(size-arg0-1) ;i--){
			elementData[i+1] = elementData[i];
		}
		elementData[arg0] = arg1;
		size++;
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		Object [] a = arg0.toArray();
		ensureCapacity(size + a.length);
		System.arraycopy(a, 0, elementData, size, a.length);
		size = size + a.length;
		return a.length!=0;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		// TODO Auto-generated method stub
		Object [] a = arg1.toArray();
		ensureCapacity(size + a.length);
		if(size - arg0 > 0){
			System.arraycopy(elementData, arg0, elementData, size+arg0, size -arg0);
		}
		System.arraycopy(a, 0, elementData, arg0, a.length);
		size = size + a.length;
		return a.length!=0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i = 0;i < size ; i++){
			elementData[i] = null;
		}
		size = 0;
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		
		return indexOf(arg0) >= 0 ;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		Iterator<?> i= arg0.iterator();
		while(i.hasNext()){
			if(!contains(i.next())){
				return false;
			}
		}
		return true;
	}

	@Override
	public T get(int arg0) {
		// TODO Auto-generated method stub
		rangeCheck(arg0);
		return (T)elementData[arg0];
	}

	private void rangeCheck(int index){
		if(index>=size || index < 0){
			throw new IndexOutOfBoundsException("Index="+index+" ,Size="+size);
		}
	}
	private void rangeCheckForAdd(int index){
		if(index > size || index < 0){
			throw new IndexOutOfBoundsException("Index="+index+" ,Size="+size);
		}
	}
	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		int index = -1;
		if(arg0 == null){
			for(int i=0;i<size;i++){
				if(elementData[i] == null){
					index= i;
					break;
				}
			}
		}else{
			for(int i=0;i<size;i++){
				if(arg0.equals(elementData[i])){
					index = i;
					break;
				}
			}
		}
		return index;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size ==0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	class Itr implements Iterator<T>{

		int cursor;
		int lastRet = -1;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor != size;
		}

		@Override
		public T next() {
			int i = cursor;
			if(cursor >= size){
				throw new NoSuchElementException();
			}
			if(cursor>elementData.length){
				throw new ConcurrentModificationException();
			}
			cursor = i + 1;
			// TODO Auto-generated method stub
			return (T)elementData[lastRet = i];
		}
		public void remove(){
			if(lastRet < 0){
				throw new IllegalStateException();
			}
			MyArrayList.this.remove(elementData[lastRet]);
			cursor = lastRet;
			lastRet = -1;
		}
		
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0 == null){
			for(int i=size-1;i >=0;i--){
				if(elementData[i] == null){
					return i;
				}
			}
		}else{
			for(int i=size-1;i >=0;i--){
				if(arg0.equals(elementData[i])){
					return i;
				}
				
			}
		}
		
		return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		int index = indexOf(arg0);
		if(index < 0){
			return false;
		}else{
			System.arraycopy(elementData, index+1, elementData, index, size - index -1);
			elementData[size-1] = null;
			size--;
			return true;
		}
		
	}

	@Override
	public T remove(int arg0) {
		// TODO Auto-generated method stub
		rangeCheck(arg0);
		System.arraycopy(elementData, arg0+1, elementData, arg0, size - arg0 -1);
		elementData[size-1] = null;
		size--;
		return (T)elementData[arg0];
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int arg0, T arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public List<T> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void printArrayList(){
		for(int i =0 ;i<size;i++){
			System.out.println(elementData[i]);
		}
	}
}
