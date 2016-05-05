package com.configure.xmlparse.impl;

import java.util.Iterator;

import org.dom4j.Element;

import com.configure.metadata.MetaDataParam;
import com.configure.metadata.MetaDataRet;
import com.configure.metadata.XmlParseData;
import com.configure.util.CConst;
import com.configure.xmlparse.XmlParse;

public class HttpXmlParse implements XmlParse{
	
	@Override
	public XmlParseData parse(Element body) {
		XmlParseData parseData = new XmlParseData();
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = body.elementIterator();
		while(iterator.hasNext()) {
			Element element = iterator.next();
			if (CConst.TAG_PARAMS.equals(element.getName())) {
				parseParam(element, parseData);
			}
			else if (CConst.TAG_RETS.equals(element.getName())) {
				parseRet(element, parseData);
			}
			else {
				String name = element.getName();
				String value = element.getTextTrim();
				parseData.getOtherdata().addToDataMap(name, value);
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
			if (!CConst.TAG_RET.equals(item.getName())) {
				continue;
			}
			MetaDataRet ret = new MetaDataRet();
			ret.setRetName(item.element(CConst.TAG_RETNAME).getTextTrim());
			ret.setRetType(item.element(CConst.TAG_RETTYPE).getTextTrim());
			ret.setRetVal(item.element(CConst.TAG_RETVALUE).getTextTrim());
			parseData.getRetMap().put(ret.getRetName(), ret);
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
			if (!CConst.TAG_PARAM.equals(param.getName())) {
				continue;
			}
			MetaDataParam data = new MetaDataParam();
			data.setParamIndex(param.element(CConst.TAG_PARAMINDEX).getTextTrim());
			data.setParamType(param.element(CConst.TAG_PARAMTYPE).getTextTrim());
			data.setParamName(param.element(CConst.TAG_PARAMNAME).getTextTrim());
			data.setParamValue(param.element(CConst.TAG_PARAMVALUE).getTextTrim());
			parseData.getParamMap().put(data.getParamIndex(), data);
		}
	}

}
