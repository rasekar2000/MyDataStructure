package com.ca.sys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ca.sys.datastructure.KeyValueStructure;

public class PerformDependencyCheck {

	private KeyValueStructure depenencyKeyValue;

	private KeyValueStructure depenencyValueKey;

	private ArrayList<String> installedComponents;

	public PerformDependencyCheck() {
		depenencyKeyValue = new KeyValueStructure();
		depenencyValueKey = new KeyValueStructure();
		installedComponents = new ArrayList<String>();
	}

	public void addKeyValueList(String key, List<String> value) {
		depenencyKeyValue.add(key, value);
	}

	public void addValueListKeyList(List<String> key, String value) {

		for (String oneKey : key) {
			// System.out.println(oneKey);
			depenencyValueKey.addKeyValue(oneKey, value);
		}

	}

	public void depend(String inputLine, String[] keyValue) {
		String key = keyValue[1];
		System.out.println(inputLine);

		String[] dependencies = Arrays
				.copyOfRange(keyValue, 2, keyValue.length);
		List<String> value = Arrays.asList(dependencies);

		this.addKeyValueList(key, value);
		this.addValueListKeyList(value, key);

		return;
	}

	public void install(String[] keyValue) {
		// If this key wasn't part of the depenencyKeyValue then add it to the
		// installedComponents
		String key = keyValue[1];
		boolean aIsExistByIndex = false;
		int listValuesSize = 0;
		// System.out.println("key "+ key);

		List<String> listValues = depenencyKeyValue.getValueList(key);
		if (listValues != null) {
			// System.out.println("Installing "+listValues);
			listValuesSize = listValues.size();
			for (String installingComponent : listValues) {

				aIsExistByIndex = installedComponents
						.contains(installingComponent);
				if (aIsExistByIndex) {
					if (listValuesSize == 1) {
						System.out.println("\t" + installingComponent
								+ " is already installed.");
					}
				} else {
					System.out.println("\t" + "Installing "
							+ installingComponent);
					installedComponents.add(installingComponent);
				}
				// depenencyValueKey.addKeyValue(oneKey, value);
			}
		}// else {
		aIsExistByIndex = installedComponents.contains(key);
		if (aIsExistByIndex) {
			System.out.println("\t" + key + " is already installed.");
		} else {
			System.out.println("\t" + "Installing " + key);
			installedComponents.add(key);
		}
		// System.out.println("key "+ key + " null list");
		// System.out.println(installedComponents.get(0));
		// }
		return;
	}

	public void remove(String[] keyValue) {
		String key = keyValue[1];
		boolean aIsExistByIndex = false;
		boolean isItemNotRemoveable = false;
		int listValuesSize = 0;
		// System.out.println("key "+ key);

		/*
		 List<String> listValues = depenencyKeyValue.getValueList(key);
		 
		if (listValues != null) {
			// System.out.println("Installing "+listValues);
			listValuesSize = listValues.size();
			for (String installingComponent : listValues) {

				aIsExistByIndex = installedComponents
						.contains(installingComponent);
				if (aIsExistByIndex) {
					if (listValuesSize == 1) {
						System.out.println("\t" + installingComponent
								+ " is already installed.");
					}
				} else {
					System.out.println("\t" + "Installing "
							+ installingComponent);
					installedComponents.add(installingComponent);
				}
				// depenencyValueKey.addKeyValue(oneKey, value);
			}
		}// else {
		*/
		
		 List<String> listValues = depenencyValueKey.getValueList(key);
		 
		if (listValues != null) {
			// System.out.println("Installing "+listValues);
			listValuesSize = listValues.size();
			for (String dependencyComponent : listValues) {

				isItemNotRemoveable = installedComponents
						.contains(dependencyComponent);
				if (isItemNotRemoveable) { 
					break;
				}
				/*
				if (aIsExistByIndex) {
					if (listValuesSize == 1) {
						System.out.println("\t" + dependencyComponent
								+ " is still needed.");
					}
				} else {
					System.out.println("\t" + "Removing "
							+ dependencyComponent);
					installedComponents.remove(dependencyComponent);
				}
				*/
				// depenencyValueKey.addKeyValue(oneKey, value);
			}
			if (isItemNotRemoveable) {
				System.out.println("\t" + key
						+ " is still needed.");
			} else {
				System.out.println("\t" + "Removing "
						+ key);
				installedComponents.remove(key);				
			}
			
		} else {
			aIsExistByIndex = installedComponents.contains(key);
			if (aIsExistByIndex) {
				System.out.println("\t" + "Removing " + key);
				installedComponents.remove(key);			
			} else {
				System.out.println("\t" + key + " is not installed.");
			}
		}
	}

	public void list() {
		// System.out.println("installedComponents"
		// +installedComponents.size());
		for (String installedComponent : installedComponents) {
			System.out.println("\t" + installedComponent);
			// depenencyValueKey.addKeyValue(oneKey, value);
		}
		// return;
	}

	public void checkListValue() {
		System.out.println("----KEY Value Pair -----");
		depenencyKeyValue.printAllValues();
		System.out.println("----VALUE Value Pair -----");
		depenencyValueKey.printAllValues();
		System.out.println("---- END -----");
	}

}
