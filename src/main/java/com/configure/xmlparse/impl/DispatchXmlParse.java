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
	
	private static final String ATTRIBUTE_TAG = "name";
	
	private static final String ELEMENT_TAG = "protocol";
	
	public XmlParseData parse(Element body) {
		Element element = body.element(ELEMENT_TAG);
		Attribute attribute = element.attribute(ATTRIBUTE_TAG);
		String protocolName = attribute.getText();
		return xmlParseMap.get(protocolName).parse(element);
	}

	public Map<String, XmlParse> getXmlParseMap() {
		return xmlParseMap;
	}

	public void setXmlParseMap(Map<String, XmlParse> xmlParseMap) {
		this.xmlParseMap = xmlParseMap;
		
	}
	
}
