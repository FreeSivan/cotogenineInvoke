package com.configure.xmlparse.impl;

import java.util.Map;

import org.dom4j.Element;

import com.configure.xmlparse.XmlParse;

public class DispatchXmlParse implements XmlParse{

	private Map<String, XmlParse> xmlParseMap;
	
	
	public void parse(Element body) {
		
		
	}

	public Map<String, XmlParse> getXmlParseMap() {
		return xmlParseMap;
	}

	public void setXmlParseMap(Map<String, XmlParse> xmlParseMap) {
		this.xmlParseMap = xmlParseMap;
	}
	
}
