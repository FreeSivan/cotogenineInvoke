package com.configure.xmlparse;

import org.dom4j.Element;

public interface XmlParse {
	/**
	 * 
	 * @param body
	 * @return
	 */
	public XmlParseData parse(Element body);
}
