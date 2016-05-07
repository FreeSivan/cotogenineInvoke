package com.configure.callproxy;

import java.util.Map;

import com.configure.metadata.MetaDataInput;
import com.configure.metadata.XmlParseData;

public abstract class CallProxy {
	
	private XmlParseData parseData;

	public XmlParseData getParseData() {
		return this.parseData;
	}

	public void setParseData(XmlParseData parseData) {
		this.parseData = parseData;
	}
	
	public abstract void call(Map<Integer, MetaDataInput> input);
}
