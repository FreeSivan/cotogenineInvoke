package com.configure.xmlparse;

import org.dom4j.Element;

import com.configure.metadata.XmlParseData;

public interface XmlParse {
	/**
	 * 
	 * @param body
	 * @return
	 */
	public XmlParseData parse(Element body);
}
