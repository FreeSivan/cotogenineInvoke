package com.configure.maintest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.configure.callproxy.CallProxy;
import com.configure.cicontext.CIContext;
import com.configure.exception.InvokerIDconfilct;
import com.configure.metadata.MetaDataInput;
import com.configure.metadata.XmlParseData;

public class TestMain {
	private CIContext context;

	public CIContext getContext() {
		return context;
	}

	public void setContext(CIContext context) {
		this.context = context;
	}
	
	
	public void testfunc(String val1, double d, int val3, char c) {
		List<MetaDataInput> lst = new ArrayList<>();
		// 应该写一个类专门负责生成MetaDataInput对象
		lst.add(new MetaDataInput(1, val1.getClass(), val1));
		Double tmpd = d;
		lst.add(new MetaDataInput(2, tmpd.getClass(), tmpd));
		Integer tmpval3 = val3;
		lst.add(new MetaDataInput(3, tmpval3.getClass(), tmpval3));
		Character tmpc = c;
		lst.add(new MetaDataInput(4, tmpc.getClass(), tmpc));
		context.mainCall("1", lst);
	}
	
	@Test
	public void testMain() throws DocumentException, InvokerIDconfilct {
		@SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
		context = (CIContext)ac.getBean("context");
		context.parseXml("ciconf.xml");
		
		Map<String, CallProxy> cpMap = context.getCpMap();
		for (String key1 : cpMap.keySet()) {
			CallProxy callProxy = cpMap.get(key1);
			XmlParseData parseData = callProxy.getParseData();
			System.out.println("method = " + parseData.getOtherdata().getFromDataMap("method"));
			System.out.println("url    = " + parseData.getOtherdata().getFromDataMap("url"));
			
			for (String key : parseData.getParamMap().keySet()) {
				String name = parseData.getParamMap().get(key).getParamName();
				String type = parseData.getParamMap().get(key).getParamType();
				String value = parseData.getParamMap().get(key).getParamType();
				System.out.println("index  = "+key+" name = "+name+" type = "+type + " value = "+value);
			}
			
			for (String key : parseData.getRetMap().keySet()) {
				String name = key;
				String type = parseData.getRetMap().get(key).getRetType();
				String value = parseData.getRetMap().get(key).getRetVal();
				System.out.println("name   = "+name+" type = "+type+" value = "+value);
			}
			System.out.println("-----------------------------------------------------------");
		}
		
		System.out.println("=================================================================");
		testfunc("teststr", 0.1, 40000, 'a');
	}
	
}
