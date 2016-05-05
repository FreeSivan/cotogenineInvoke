package com.configure.callproxy;

import java.util.Map;

import com.configure.metadata.MetaDataInput;
import com.configure.metadata.MetaDataParam;

public class CallProxyHttp extends CallProxy{

	@Override
	public void call(Map<Integer, MetaDataInput> input) {
		@SuppressWarnings("unused")
		Map<String, MetaDataParam> paramMap = getParseData().getParamMap();
		for (Integer item : input.keySet()) {
			System.out.println("item = "+item);
			Class<?> clazz = input.get(item).getClazz();
			Object object = input.get(item).getObject();
			System.out.println("class = "+clazz.getName());
			System.out.println("value = "+clazz.cast(object));
		}
		String method = getParseData().getOtherdata().getFromDataMap("method");
		if ("post".equals(method)) {
			postCall(input);
		}
		else if("get".equals(method)) {
			getCall(input);
		}
	}

	private void getCall(Map<Integer, MetaDataInput> input) {
		// TODO Auto-generated method stub
		
	}

	private void postCall(Map<Integer, MetaDataInput> input) {
		// TODO Auto-generated method stub
		
	}

}
