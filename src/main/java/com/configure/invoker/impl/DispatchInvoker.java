package com.configure.invoker.impl;

import java.util.Map;

import com.configure.invoker.Invoker;

public class DispatchInvoker implements Invoker{
	
	private Map<String, Invoker> invokerMap;

	public Map<String, Invoker> getInvokerMap() {
		return invokerMap;
	}

	public void setInvokerMap(Map<String, Invoker> invokerMap) {
		this.invokerMap = invokerMap;
	}

	public void testinvoker() {
		
	}
	
}
