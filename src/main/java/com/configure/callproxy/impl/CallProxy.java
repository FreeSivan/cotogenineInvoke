package com.configure.callproxy.impl;

import com.configure.invoker.Invoker;
import com.configure.xmlparse.XmlParseData;

public class CallProxy {
	
	private Invoker invoke;
	
	private XmlParseData parseData;

	public Invoker getInvoke() {
		return invoke;
	}

	public void setInvoke(Invoker invoke) {
		this.invoke = invoke;
	}

	public XmlParseData getParseData() {
		return parseData;
	}

	public void setParseData(XmlParseData parseData) {
		this.parseData = parseData;
	}

	
}
