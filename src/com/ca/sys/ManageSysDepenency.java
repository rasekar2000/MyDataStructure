package com.ca.sys;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManageSysDepenency {


	
	public static void processInput(PerformDependencyCheck performDependencyCheck){

		Scanner sc = new Scanner(System.in);

	    while(sc.hasNextLine()) {

	        String line = sc.nextLine().replaceAll("\n", "");

	        // return pressed
	        if (line.length() == 0) {
	            continue;
	        }

	        // split line into arguments
	        String[] args1 = line.split(" ");
	        String key;

	        // process arguments
	        if (args1.length > 0) {
	            if (args1[0].equalsIgnoreCase("q")) {
	                System.exit(0);
	            } else if (args1[0].equalsIgnoreCase("DEPEND")) {
	                // Put stuff here
	            	System.out.println("SomeInput"+ key);
	            	key = args1[0];
	            	String[] dependencies = Arrays.copyOfRange(args1,1, args1.length);
	            	List<String> value = Arrays.asList(dependencies);
	            	//value.remove(0);
	            	System.out.println(" value" + value);
	            	performDependencyCheck.addKeyValueList(key,value);
	            	//performDependencyCheck.addValueListKeyList(value, key);
	            } else {
	                System.out.println(args1[0]);
	                //System.exit(0);
	            }
	        }
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		PerformDependencyCheck performDependencyCheck = new PerformDependencyCheck();
		processInput(performDependencyCheck);
	}

}
