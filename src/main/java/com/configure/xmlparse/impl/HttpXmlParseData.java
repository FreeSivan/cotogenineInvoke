package com.configure.xmlparse.impl;

import java.util.HashMap;
import java.util.Map;

import com.configure.metadata.MetaDataOther;
import com.configure.metadata.MetaDataParam;
import com.configure.metadata.MetaDataRet;
import com.configure.xmlparse.XmlParseData;

public class HttpXmlParseData implements XmlParseData{
	
	private MetaDataOther otherdata;
	
	private Map<String, MetaDataParam> paramMap = new HashMap<>();
	
	private Map<String, MetaDataRet> retMap = new HashMap<>();

	public MetaDataOther getOtherdata() {
		return otherdata;
	}

	public void setOtherdata(MetaDataOther otherdata) {
		this.otherdata = otherdata;
	}

	public Map<String, MetaDataRet> getRetMap() {
		return retMap;
	}

	public void setRetMap(Map<String, MetaDataRet> retMap) {
		this.retMap = retMap;
	}

	public Map<String, MetaDataParam> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, MetaDataParam> paramMap) {
		this.paramMap = paramMap;
	}

	@Override
	public MetaDataOther getOtherData() {
		return getOtherdata();
	}

	@Override
	public Map<String, MetaDataParam> getParamData() {
		return getParamMap();
	}

	@Override
	public Map<String, MetaDataRet> getRetData() {
		return getRetMap();
	}
	
}
