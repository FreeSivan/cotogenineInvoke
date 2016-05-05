package com.configure.callproxy;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.configure.metadata.MetaDataInput;
import com.configure.metadata.MetaDataParam;
import com.configure.util.CConst;

public class CallProxyHttp extends CallProxy{

	@Override
	public void call(Map<Integer, MetaDataInput> input) {
		for (Integer item : input.keySet()) {
			System.out.println("item = "+item);
			Class<?> clazz = input.get(item).getClazz();
			Object object = input.get(item).getObject();
			System.out.println("class = "+clazz.getName());
			System.out.println("value = "+clazz.cast(object));
		}
		String method = getParseData().getOtherdata().getFromDataMap(CConst.TAG_METHOD);
		if (CConst.TAG_METHOD_POST.equals(method)) {
			postCall(input);
		}
		else if(CConst.TAG_METHOD_GET.equals(method)) {
			getCall(input);
		}
	}

	private void getCall(Map<Integer, MetaDataInput> input) {
		// TODO Auto-generated method stub
		
	}

	private void postCall(Map<Integer, MetaDataInput> input) {
		Map<String, MetaDataParam> paramMap = getParseData().getParamMap();
		String url = getParseData().getOtherdata().getFromDataMap(CConst.TAG_URL);
		String encode = getParseData().getOtherdata().getFromDataMap(CConst.TAG_ENCODE);
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		for (Integer item : input.keySet()) {
			String index = item.toString();
			String tagname = paramMap.get(index).getParamName();
			Class<?> clazz = input.get(item).getClazz();
			Object object = input.get(item).getObject();
			clazz.cast(object);
			list.add(new BasicNameValuePair(tagname, (String) clazz.cast(object)));
		}
		try {
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list,encode);
			post.setEntity(uefEntity);
			HttpResponse httpResponse = httpclient.execute(post);
			String json = EntityUtils.toString(httpResponse.getEntity());
			System.out.println(json);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
