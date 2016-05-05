package com.configure.xmlparse.impl;

import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.configure.metadata.XmlParseData;
import com.configure.util.CConst;
import com.configure.xmlparse.XmlParse;
/**
 * 
 * @author xiwen.yxw
 *
 * 
 *
 */
public class DispatchXmlParse implements XmlParse{

	private Map<String, XmlParse> xmlParseMap;
	
	public XmlParseData parse(Element body) {
		Element element = body.element(CConst.TAG_PROTOCOL);
		Attribute attribute = element.attribute(CConst.TAG_NAME);
		String protocolName = attribute.getText();
		XmlParseData parseData = xmlParseMap.get(protocolName).parse(element);
		parseData.setProtocolName(protocolName);
		return parseData;
	}

	public Map<String, XmlParse> getXmlParseMap() {
		return xmlParseMap;
	}

	public void setXmlParseMap(Map<String, XmlParse> xmlParseMap) {
		this.xmlParseMap = xmlParseMap;
		
	}
	
}
