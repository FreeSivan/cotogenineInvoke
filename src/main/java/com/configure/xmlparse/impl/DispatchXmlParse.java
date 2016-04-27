package com.configure.xmlparse.impl;

import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Element;
import com.configure.xmlparse.XmlParse;
import com.configure.xmlparse.XmlParseData;
/**
 * 
 * @author xiwen.yxw
 *
 * 
 *
 */
public class DispatchXmlParse implements XmlParse{

	private Map<String, XmlParse> xmlParseMap;
	
	private final String ATTRIBUTE_TAG = "name";
	
	private final String ELEMENT_TAG = "protocol";
	
	public XmlParseData parse(Element body) {
		System.out.println("body = "+body.getName());
		Element element = body.element(ELEMENT_TAG);
		System.out.println("element name = "+element.getName());
		Attribute attribute = element.attribute(ATTRIBUTE_TAG);
		String protocolName = attribute.getText();
		System.out.println("protocolName = "+protocolName);
		return xmlParseMap.get(protocolName).parse(element);
	}

	public Map<String, XmlParse> getXmlParseMap() {
		return xmlParseMap;
	}

	public void setXmlParseMap(Map<String, XmlParse> xmlParseMap) {
		this.xmlParseMap = xmlParseMap;
		
	}
	
}
