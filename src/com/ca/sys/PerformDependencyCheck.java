package com.ca.sys;

import java.util.Arrays;
import java.util.List;

import com.ca.sys.datastructure.KeyValueStructure;

public class PerformDependencyCheck {

	private KeyValueStructure depenencyKeyValue;
	
	private KeyValueStructure depenencyValueKey;
	
	
	public PerformDependencyCheck(){
		depenencyKeyValue = new KeyValueStructure();
		depenencyValueKey = new KeyValueStructure();
	}
	
	public void addKeyValueList(String key, List<String> value){
		depenencyKeyValue.add(key, value);
	}
	
	public void addValueListKeyList(List<String>  key, String value){
		
		for (String oneKey: key) {
		    //System.out.println(oneKey);
		    depenencyValueKey.addKeyValue(oneKey, value);
		}
		
	}
	
	public void depend(String[] keyValue){
    	String key = keyValue[1];
    	//System.out.println("SomeInput"+ key);
    	
    	String[] dependencies = Arrays.copyOfRange(keyValue,2, keyValue.length);
    	List<String> value = Arrays.asList(dependencies);
    	//value.remove(0);
    	//System.out.println(" value" + value);
    	this.addKeyValueList(key,value);
    	this.addValueListKeyList(value, key);
		return;
	}
	public void install(String[] keyValue){
		return;
	}
	public void remove(String[] keyValue){
		return;
	}
	public void list(String[] keyValue){
		return;
	}	
	
	public void checkListValue(){
		System.out.println("----KEY Value Pair -----");
		depenencyKeyValue.printAllValues();
		System.out.println("----VALUE Value Pair -----");
		depenencyValueKey.printAllValues();
		System.out.println("---- END -----");
	}
	
}
