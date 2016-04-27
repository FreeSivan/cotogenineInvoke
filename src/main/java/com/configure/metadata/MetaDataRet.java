package com.configure.metadata;

public class MetaDataRet {
	
	private String retName;
	
	private String retType;
	
	private String retVal;
	
	public MetaDataRet(){
	}
	
	public MetaDataRet(String retName, String retType, String retVal) {
		this.retName = retName;
		this.retType = retType;
		this.retVal = retVal;
	}
	
	public String getRetName() {
		return retName;
	}
	public void setRetName(String retName) {
		this.retName = retName;
	}
	public String getRetType() {
		return retType;
	}
	public void setRetType(String retType) {
		this.retType = retType;
	}
	public String getRetVal() {
		return retVal;
	}
	public void setRetVal(String retVal) {
		this.retVal = retVal;
	}
}
