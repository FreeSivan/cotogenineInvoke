package com.configure.cicontext;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.configure.callproxy.CallProxy;
import com.configure.callproxy.FactoryCallProxy;
import com.configure.callproxy.HttpCallProxy;
import com.configure.exception.InvokerIDconfilct;
import com.configure.metadata.MetaDataInput;
import com.configure.metadata.MetaDataParam;
import com.configure.metadata.XmlParseData;
import com.configure.util.CConst;
import com.configure.xmlparse.XmlParse;

public class CIContext {
	
	private Map<String, CallProxy> cpMap = new HashMap<String, CallProxy>();

	private XmlParse xmlparse;
	
	/**
	 * 
	 * @param invokerName
	 * @param invoker
	 * @throws InvokerIDconfilct
	 */
	public void addInvoker(String invokerName, CallProxy callProxy) throws InvokerIDconfilct {
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
			if (!CConst.TAG_INVOKE.equals(element.getName())) {
				continue;
			}
			XmlParseData parseData = xmlparse.parse(element);
			String invokeID = element.attribute(CConst.TAG_ID).getText();
			CallProxy callProxy = FactoryCallProxy.instance().getCallProxy(parseData.getProtocolName());
			callProxy.setParseData(parseData);
			addInvoker(invokeID, callProxy);
		}
	}
	
	
	public void mainCall(String id, List<MetaDataInput> lst) {
		Map<Integer, MetaDataInput> map = new HashMap<>();
		for (MetaDataInput item : lst) {
			map.put(item.getIndex(), item);
		}
		cpMap.get(id).call(map);
	}
	
	public Map<String, CallProxy> getCpMap() {
		return cpMap;
	}

	public XmlParse getXmlparse() {
		return xmlparse;
	}

	public void setXmlparse(XmlParse xmlparse) {
		this.xmlparse = xmlparse;
	}
	
}
