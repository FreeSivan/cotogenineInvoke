package com.configure.callproxy.impl;

import java.util.Map;

import com.configure.callproxy.ICallProxy;
import com.configure.invoker.Invoker;
import com.configure.metadata.MetaDataInput;
import com.configure.metadata.MetaDataParam;
import com.configure.metadata.XmlParseData;

public class HttpCallProxy implements ICallProxy{
	
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

	@Override
	public void call(Map<Integer, MetaDataInput> input) {
		Map<String, MetaDataParam> paramMap = parseData.getParamMap();
		for (Integer item : input.keySet()) {
			System.out.println("item = "+item);
			Class<?> clazz = input.get(item).getClazz();
			Object object = input.get(item).getObject();
			System.out.println("class = "+clazz.getName());
			System.out.println("value = "+clazz.cast(object));
		}
	}

}
