package com.configure.callproxy;

import java.util.Map;

import com.configure.invoker.Invoker;
import com.configure.metadata.MetaDataInput;
import com.configure.xmlparse.XmlParseData;

public interface ICallProxy {
	public void call(Map<Integer, MetaDataInput> input);
	
	public Invoker getInvoke();
	
	public void setInvoke(Invoker invoke);

	public XmlParseData getParseData();

	public void setParseData(XmlParseData parseData);
}
