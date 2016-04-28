package com.configure.metadata;

import java.util.HashMap;
import java.util.Map;

public class XmlParseData {
	
	private MetaDataOther otherdata = new MetaDataOther();
	
	private Map<String, MetaDataParam> paramMap = new HashMap<>();
	
	private Map<String, MetaDataRet> retMap = new HashMap<>();
	
	private String protocolName;

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

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}
	
}
