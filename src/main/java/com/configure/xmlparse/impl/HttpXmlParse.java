package com.configure.xmlparse.impl;

import java.util.Iterator;

import org.dom4j.Element;

import com.configure.metadata.MetaDataParam;
import com.configure.metadata.MetaDataRet;
import com.configure.xmlparse.XmlParse;
import com.configure.xmlparse.XmlParseData;

public class HttpXmlParse implements XmlParse{
	
	private static final String PARAMS_TAG = "params";
	
	private static final String PARAM_TAG = "param";
	
	private static final String RETS_TAG = "returnValues";
	
	private static final String RET_TAG = "returnValue";
	
	private static final String PARAMINDEX_TAG = "paramIndex";
	
	private static final String PARAMTYPE_TAG = "paramType";
	
	private static final String PARAMNAME_TAG = "paramName";
	
	private static final String PARAMVALUE_TAG = "paramValue";
	
	private static final String RETTYPE_TAG = "name";
	
	private static final String RETNAME_TAG = "type";
	
	private static final String RETVALUE_TAG = "value";
	
	@SuppressWarnings("unchecked")
	public XmlParseData parse(Element body) {
		XmlParseData parseData = new HttpXmlParseData();
		Iterator<Element> iterator = body.elementIterator();
		while(iterator.hasNext()) {
			Element element = iterator.next();
			if (PARAMS_TAG.equals(element.getName())) {
				parseParam(element, parseData);
			}
			else if (RETS_TAG.equals(element.getName())) {
				parseRet(element, parseData);
			}
			else {
				String name = element.getName();
				String value = element.getTextTrim();
				parseData.getOtherData().addToDataMap(name, value);
			}
		}
		return parseData;
	}

	/**
	 * 
	 * @param element
	 * @param parseData
	 */
	private void parseRet(Element element, XmlParseData parseData) {
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = element.elementIterator();
		while (iterator.hasNext()) {
			Element item = iterator.next();
			if (!RET_TAG.equals(item.getName())) {
				continue;
			}
			MetaDataRet ret = new MetaDataRet();
			ret.setRetName(item.element(RETNAME_TAG).getTextTrim());
			ret.setRetType(item.element(RETTYPE_TAG).getTextTrim());
			ret.setRetVal(item.element(RETVALUE_TAG).getTextTrim());
			parseData.getRetData().put(ret.getRetName(), ret);
		}
	}

	/**
	 * 
	 * @param element
	 * @param parseData
	 */
	private void parseParam(Element element, XmlParseData parseData) {
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = element.elementIterator();
		while (iterator.hasNext()) {
			Element param = iterator.next();
			if (!PARAM_TAG.equals(param.getName())) {
				continue;
			}
			MetaDataParam data = new MetaDataParam();
			data.setParamIndex(param.element(PARAMINDEX_TAG).getTextTrim());
			data.setParamType(param.element(PARAMTYPE_TAG).getTextTrim());
			data.setParamName(param.element(PARAMNAME_TAG).getTextTrim());
			data.setParamValue(param.element(PARAMVALUE_TAG).getTextTrim());
			parseData.getParamData().put(data.getParamIndex(), data);
		}
	}

}
