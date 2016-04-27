package com.configure.cicontext;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.configure.callproxy.ICallProxy;
import com.configure.callproxy.impl.CallProxy;
import com.configure.exception.InvokerIDconfilct;
import com.configure.xmlparse.XmlParse;
import com.configure.xmlparse.XmlParseData;

public class CIContext {
	
	private Map<String, ICallProxy> cpMap = new HashMap<String, ICallProxy>();

	private XmlParse xmlparse;
	
	/**
	 * 
	 * @param invokerName
	 * @param invoker
	 * @throws InvokerIDconfilct
	 */
	public void addInvoker(String invokerName, ICallProxy callProxy) throws InvokerIDconfilct {
		if (cpMap.containsKey(invokerName)) {
			throw new InvokerIDconfilct();
		}
		getCpMap().put(invokerName, callProxy);
	}

	/**
	 * 
	 * @param xmlfile
	 * @throws DocumentException
	 * @throws InvokerIDconfilct 
	 */
	public void parseXml(String xmlfile) throws DocumentException, InvokerIDconfilct {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(xmlfile));
		Element root = document.getRootElement();
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = root.elementIterator();
		while (iterator.hasNext()) {
			Element element = iterator.next();
			if (!"invoke".equals(element.getName())) {
				continue;
			}
			XmlParseData parseData = xmlparse.parse(element);
			String invokeID = element.attribute("id").getText();
			ICallProxy callProxy = new CallProxy();
			callProxy.setParseData(parseData);
			addInvoker(invokeID, callProxy);
		}
	}
	
	public Map<String, ICallProxy> getCpMap() {
		return cpMap;
	}

	public XmlParse getXmlparse() {
		return xmlparse;
	}

	public void setXmlparse(XmlParse xmlparse) {
		this.xmlparse = xmlparse;
	}
	
}
