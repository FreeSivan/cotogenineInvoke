package com.configure.xmlparse.impl;

import org.dom4j.Element;

import com.configure.xmlparse.XmlParse;
import com.configure.xmlparse.XmlParseData;

public class HttpXmlParse implements XmlParse{

	public XmlParseData parse(Element body) {
		HttpXmlParseData parseData = new HttpXmlParseData();
		body.elements("params");
		return parseData;
	}

}
