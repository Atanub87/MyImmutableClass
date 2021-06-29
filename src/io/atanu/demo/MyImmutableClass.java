package io.atanu.demo;

import java.util.HashMap;
import java.util.Iterator;

public final class MyImmutableClass {
	
	private final long id;
	private final String name;
	private final HashMap<String, String> someMap;
	
	// Constructor with Deep Copy

	public MyImmutableClass(long id, String name, HashMap<String, String> someMap) {
		this.id = id;
		this.name = name;
		
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = someMap.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, someMap.get(key));
		}
		this.someMap=tempMap;
	}
	
	// only getters
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public HashMap<String, String> getSomeMap() {
		return (HashMap<String, String>) someMap.clone();
	}

}
