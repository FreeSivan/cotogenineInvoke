package com.configure.cicontext;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.configure.exception.InvokerIDconfilct;
import com.configure.invoker.Invoker;
import com.configure.xmlparse.XmlParse;

public class CIContext {
	private Map<String, Invoker> cpMap = new HashMap<String, Invoker>();

	private XmlParse xmlparse;
	
	/**
	 * 
	 * @param invokerName
	 * @param invoker
	 * @throws InvokerIDconfilct
	 */
	public void addInvoker(String invokerName, Invoker invoker) throws InvokerIDconfilct {
		if (cpMap.containsKey(invokerName)) {
			throw new InvokerIDconfilct();
		}
		getCpMap().put(invokerName, invoker);
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
		
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = root.elementIterator();
		while (iterator.hasNext()) {
			Element element = iterator.next();
			if ("invoke".equals(element.getName())) {
				String id = element.attribute("id").getText();
				
			}
		}
		
		xmlparse.parse(root);
	}
	
	public Map<String, Invoker> getCpMap() {
		return cpMap;
	}

	public XmlParse getXmlparse() {
		return xmlparse;
	}

	public void setXmlparse(XmlParse xmlparse) {
		this.xmlparse = xmlparse;
	}
}
