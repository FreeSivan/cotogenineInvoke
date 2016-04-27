package com.configure.maintest;

import java.util.Map;

import org.dom4j.DocumentException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.configure.callproxy.ICallProxy;
import com.configure.cicontext.CIContext;
import com.configure.exception.InvokerIDconfilct;
import com.configure.xmlparse.XmlParseData;

public class TestMain {
	private CIContext context;

	public CIContext getContext() {
		return context;
	}

	public void setContext(CIContext context) {
		this.context = context;
	}
	
	@Test
	public void testMain() throws DocumentException, InvokerIDconfilct {
		@SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
		context = (CIContext)ac.getBean("context");
		context.parseXml("ciconf.xml");
		
		Map<String, ICallProxy> cpMap = context.getCpMap();
		for (String key1 : cpMap.keySet()) {
			ICallProxy callProxy = cpMap.get(key1);
			XmlParseData parseData = callProxy.getParseData();
			System.out.println("method = " + parseData.getOtherData().getFromDataMap("method"));
			System.out.println("url    = " + parseData.getOtherData().getFromDataMap("url"));
			
			for (String key : parseData.getParamData().keySet()) {
				String name = parseData.getParamData().get(key).getParamName();
				String type = parseData.getParamData().get(key).getParamType();
				String value = parseData.getParamData().get(key).getParamType();
				System.out.println("index  = "+key+" name = "+name+" type = "+type + " value = "+value);
			}
			
			for (String key : parseData.getRetData().keySet()) {
				String name = key;
				String type = parseData.getRetData().get(key).getRetType();
				String value = parseData.getRetData().get(key).getRetVal();
				System.out.println("name   = "+name+" type = "+type+" value = "+value);
			}
			System.out.println("-----------------------------------------------------------");
		}
	}
}
