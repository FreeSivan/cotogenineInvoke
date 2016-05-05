package com.configure.callproxy;

import com.configure.util.CConst;

public class FactoryCallProxy {
	
	private static FactoryCallProxy ins = new FactoryCallProxy();
	
	private FactoryCallProxy() {
	}
	
	public static FactoryCallProxy instance() {
		return ins;
	}
	
	public CallProxy getCallProxy(String callStyle) {
		if (CConst.TAG_HTTP.equals(callStyle)) {
			return getHttpCallProxy();
		}
		else if(CConst.TAG_LOCALCALL.equals(callStyle)) {
			return getLocalCallProxy();
		}
		return null;
	}
	
	public CallProxy getHttpCallProxy() {
		return new HttpCallProxy();
	}
	
	public CallProxy getLocalCallProxy() {
		return new LocalCallProxy();
	}
	
}
