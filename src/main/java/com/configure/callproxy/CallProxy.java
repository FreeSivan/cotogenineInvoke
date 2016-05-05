package com.configure.callproxy;

import java.util.Map;

import com.configure.invoker.Invoker;
import com.configure.metadata.MetaDataInput;
import com.configure.metadata.XmlParseData;

public abstract class CallProxy {
	
	private Invoker invoke;
	
	private XmlParseData parseData;
	
	public Invoker getInvoke() {
		return this.invoke;
	}
	
	public void setInvoke(Invoker invoke) {
		this.invoke = invoke;
	}

	public XmlParseData getParseData() {
		return this.parseData;
	}

	public void setParseData(XmlParseData parseData) {
		this.parseData = parseData;
	}
	
	public abstract void call(Map<Integer, MetaDataInput> input);
}
