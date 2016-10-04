package com.ca.sys;

import java.util.List;

import com.ca.sys.datastructure.KeyValueStructure;

public class PerformDependencyCheck {

	private KeyValueStructure depenencyKeyValue;
	
	private KeyValueStructure depenencyValueKey;
	
	
	//public 
	
	public void addKeyValueList(String key, List<String> value){
		depenencyKeyValue.add(key, value);
	}
	
	public void addValueListKeyList(String key, List<String> value){
		depenencyKeyValue.add(key, value);
	}
	
}
