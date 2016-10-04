package com.ca.sys.datastructure;

import java.util.*;

public class KeyValueStructure {

	//Map<String, List<String>> mapOfList = new HashMap<String, List<String>>();
	
	//LinkedHashMapTable<String, List<String>> mapOfList = new LinkedHashMap<String, List<String>>();
	
	private Map<String, List<String>> map;
	public KeyValueStructure(){
		map = new HashMap<String, List<String>>();
	}
	public void add( String key, List<String> value) {
		//map.putIfAbsent(key,value);
		//map.putIfAbsent("raj",Arrays.asList("one", "two", "three"));
		
		List<String> values = map.get(key);
	    if (values != null) {

	    	Set<String> temp = new TreeSet<>();  
	    	temp.addAll(values);
	    	temp.addAll(value);

	        List<String> combinedList = new ArrayList<>(temp);
	        
	    	map.put(key, combinedList);
	    	System.out.println(values);
	    } else {
	    	//System.out.println(values);
	    	map.put(key, value);
	    }
	    //values.add(value);
	    
	}
	
	//addValueListKeyList
	
	public boolean isExists(String input){
		boolean bool = false;
		return bool;
	}
	
	//map.putIfAbsent("raj",Arrays.asList("one", "two", "three"));
	
	public void print(String key){
		System.out.println(map.get(key));
	}
	
	//mapOfList.put();
	
	//mapOfList.put("mykey", Arrays.asList("one", "two", "three"));
	
	public static void main(String[] args) {
		
		KeyValueStructure testStruc = new KeyValueStructure();
		String key = "raj";
		List<String> value = Arrays.asList("one", "two", "three");
		testStruc.add( key, value);
		List<String> value2 = Arrays.asList("one1", "tw1o", "thre1e");
		testStruc.add( key, value2);
		testStruc.print(key);
	}
	
	
}
