package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*
 * If two numbers have same frequency give preference to larger number
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "1 1 1 4 3 1 2 3 2 5 3 4";
		
		int n = 3;
		Map<Integer,Integer> map = new HashMap();
		String arr[]  = s.split(" ");
		
		for(String k : arr){
			Integer key = Integer.parseInt(k);
			Integer count = map.get(key);
			if(count == null){
				map.put(key, 1);
			}else{
				map.put(key, count +1);
			}
		}
		
		for(Integer k : map.keySet()){
			System.out.println("key : " + k + "value : " + map.get(k));
		}
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
		
		
		list.sort(new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				
				if(o1.getValue() == o2.getValue()){
					return o2.getKey().compareTo(o1.getKey()); 
				}else{
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		});
		
		Map<Integer,Integer> sortedByFrequency = new HashMap<Integer, Integer>();
		int i =0;
		for(Map.Entry<Integer, Integer> m :  list){
			if(i < n){
				sortedByFrequency.put(m.getKey(), m.getValue());
				System.out.println("Key :" + m.getKey() +  ", Value : "+m.getValue());
			}else{
				break;
			}
			i++;
		}
		
		solutionUsingPriorityQueue();
		solutionWithOn();
	}
	
	public static void solutionUsingPriorityQueue(){
	
		String s = "1 1 1 4 3 1 2 3 2 5 3 4";
		
		int n = 3;
		Map<Integer,Integer> map = new HashMap();
		String arr[]  = s.split(" ");
		
		for(String k : arr){
			Integer key = Integer.parseInt(k);
			Integer count = map.get(key);
			if(count == null){
				map.put(key, 1);
			}else{
				map.put(key, count +1);
			}
		}
		
		
		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				
				if(o1.getValue().equals(o2.getValue())){
					return o2.getKey() - o1.getKey();
				}else{
					return o2.getValue() - o1.getValue();
				}
				
			}
		});
		
		for(Entry<Integer, Integer> entry : map.entrySet()){
			pq.offer(entry);
		}
		
		for(int i =0 ;i < n;i++){
			
			Entry<Integer, Integer> e = pq.poll();
			System.out.println("key: "+ e.getKey() + ",value:"+e.getValue());
		}
	}
	
	// https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/

	
	//Solution with time complexity O(n) 
	// Exception: If there is a tie, we need to prefer the elements whose first appearance is first.
	//the max frequency will be size of array - n i.e when all the elements are same
	//we will create a array of size n + 1 , and store the the key at the index = frequency
	
	public static void solutionWithOn(){
		String s = "1 1 1 4 3 1 2 3 2 5 3 4";
		
		int n = 3;
		Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
		String arr[]  = s.split(" ");
		
		for(String k : arr){
			Integer key = Integer.parseInt(k);
			Integer count = map.get(key);
			if(count == null){
				map.put(key, 1);
			}else{
				map.put(key, count +1);
			}
		}
		
		List<Integer> frequencyIndex[] = new ArrayList[arr.length + 1];
		System.out.println("arr length :" + arr.length);
		System.out.println("size of frequencyIndex : " + frequencyIndex.length);
		
		for(Entry<Integer, Integer> entry :  map.entrySet()){
			
			List<Integer> a = frequencyIndex[entry.getValue()];
			if(a == null){
				List<Integer> iarr = new ArrayList<Integer>();
				iarr.add(entry.getKey());
				frequencyIndex[entry.getValue()] = iarr;
			}else{
				a.add(entry.getKey());
			}
		}
		
		int k = 0;
		for(int i = arr.length;i > 0 ; i--){
			
			if(frequencyIndex[i]!= null){
				
				for(Integer m : frequencyIndex[i]){
					System.out.println("key : " + m + ",value :" + i);
					k++;
					if(k==n){
						return;
					}
				}
				
			}
			
		}
		
	}
	
}
