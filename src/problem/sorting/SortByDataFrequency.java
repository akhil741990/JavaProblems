package problem.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class SortByDataFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "4 1 3 2 3 4 2 1 3 6 1 2 4 3 4 1 2";
		System.out.println("Input :" + str);
		String arr [] = str.split(" ");
		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		for(String s :  arr){
			Integer count = map.get(s);
			if(map.get(s) == null){
				map.put(s, 1);
			}else{
				map.put(s, count  + 1);
			}
		}
		sortMapByValue(map);
		
		Map<Integer,List<String>> invertedMap = new LinkedHashMap<Integer,List<String>>();
		for(Entry<String, Integer> entry : map.entrySet() ){
			List<String> strList = invertedMap.get(entry.getValue());
			if(strList == null){
				strList = new ArrayList<String>();
				invertedMap.put(entry.getValue(), strList);
			}
			strList.add(entry.getKey());
		}
		List<Integer> frequency = new ArrayList<Integer>(invertedMap.keySet());
		Collections.sort(frequency,Collections.reverseOrder());
		for(int i : frequency){
			List<String> s = invertedMap.get(i);
			for(String key :  s){
				for(int j = 0; j < i ;j++){
					System.out.print(key+" ");
				}
			}
			
		}
	}
	/*
	 * Optimized one
	 */
	public static void sortMapByValue(Map<String,Integer> map){
		List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		
		Collections.sort(list ,new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		Map<String,Integer> mapNew =  new LinkedHashMap<String, Integer>();
		for(Entry<String, Integer> e :  list){
			mapNew.put(e.getKey(), e.getValue());
		}
		for(String key : mapNew.keySet()){
			System.out.println("key : "+key + "value:"+ mapNew.get(key));
		}
	}

}
