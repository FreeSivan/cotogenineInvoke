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
import com.configure.exception.InvokerIDconfilct;
import com.configure.xmlparse.XmlParse;
import com.configure.xmlparse.impl.DispatchXmlParse;

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
	 */
	public void parseXml(String xmlfile) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(xmlfile));
		Element root = document.getRootElement();
		System.out.println("root name = "+root.getName());
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = root.elementIterator();
		while (iterator.hasNext()) {
			Element element = iterator.next();
			System.out.println("element = "+element.getName());
			if ("invoke".equals(element.getName())) {
				String id = element.attribute("id").getText();
				System.out.println("id = " + id);
			}
			xmlparse.parse(element);
			System.out.println("------------------------------");
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
	
	public static void main(String[] args) throws DocumentException {
		CIContext context = new CIContext();
		context.setXmlparse(new DispatchXmlParse());
		context.parseXml("ciconf.xml");
	}
}
