package com.configure.callproxy;

import java.util.Map;

import com.configure.metadata.MetaDataInput;

public interface ICallProxy {
	public void call(Map<Integer, MetaDataInput> input);
}
