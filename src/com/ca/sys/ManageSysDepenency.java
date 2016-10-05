package com.ca.sys;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManageSysDepenency {

	private static enum SysDependencyInput {
	    depend, install, remove, list, q;
	}
	
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
	        	
	        	key = args1[0];
	        	

	        	//String value; // assume input
	        	SysDependencyInput sysDependencyInput = SysDependencyInput.valueOf(key.toLowerCase()); // surround with try/catch

	        	switch(sysDependencyInput) {
	        	    case depend:
	        	    	performDependencyCheck.depend(args1);
	        	    	performDependencyCheck.checkListValue();
	        	        break;
	        	    case install:
	        	    	performDependencyCheck.install(args1);
	        	        break;
	        	    case remove:
	        	    	performDependencyCheck.remove(args1);
	        	        break;
	        	    case list:
	        	    	performDependencyCheck.list();
	        	        break;	
	        	    case q:
	        	    	//performDependencyCheck.list(args1);
	        	    	System.exit(0);
	        	        break;		        	        
	        	    default:{
	        	    	System.out.println("default");
	        	    	break;
	        	    }
	        	}

	            
	            //sperformDependencyCheck.install(args1);
	        }
	    }
	}
	public static void main(String[] args) {
		
		PerformDependencyCheck performDependencyCheck = new PerformDependencyCheck();
		processInput(performDependencyCheck);
	}

}
