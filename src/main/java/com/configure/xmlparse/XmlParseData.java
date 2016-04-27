package com.configure.xmlparse;

import java.util.Map;

import com.configure.metadata.MetaDataOther;
import com.configure.metadata.MetaDataParam;
import com.configure.metadata.MetaDataRet;

public interface XmlParseData {
	public MetaDataOther getOtherData();
	public Map<String, MetaDataParam> getParamData();
	public Map<String, MetaDataRet> getRetData();
}
