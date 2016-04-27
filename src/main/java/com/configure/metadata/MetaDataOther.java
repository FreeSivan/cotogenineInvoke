package com.configure.metadata;

import java.util.HashMap;
import java.util.Map;

public class MetaDataOther {
	private Map<String, String> dataMap = new HashMap<String, String>();
	
	public void addToDataMap(String key, String value) {
		dataMap.put(key, value);
	}
	
	public String getFromDataMap(String key) {
		return dataMap.get(key);
	}
	
}
