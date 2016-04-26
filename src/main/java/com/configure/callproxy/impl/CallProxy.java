package com.configure.callproxy.impl;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.configure.invoker.Invoker;
import com.configure.xmlparse.XmlParse;

public class CallProxy {
	
	private Invoker invoke;
	
	private XmlParse xmlparse;

	public Invoker getInvoke() {
		return invoke;
	}

	public void setInvoke(Invoker invoke) {
		this.invoke = invoke;
	}

	public XmlParse getXmlparse() {
		return xmlparse;
	}

	public void setXmlparse(XmlParse xmlparse) {
		this.xmlparse = xmlparse;
	}
	
	public void parseXml(String xmlBody) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(xmlBody));
		Element root = document.getRootElement();
		xmlparse.parse(root);
	}
	
}
