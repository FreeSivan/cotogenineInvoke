package com.configure.maintest;

import org.dom4j.DocumentException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.configure.cicontext.CIContext;

public class TestMain {
	private CIContext context;

	public CIContext getContext() {
		return context;
	}

	public void setContext(CIContext context) {
		this.context = context;
	}
	
	@Test
	public void testMain() throws DocumentException {
		@SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
		context = (CIContext)ac.getBean("context");
		context.parseXml("ciconf.xml");
	}
}
