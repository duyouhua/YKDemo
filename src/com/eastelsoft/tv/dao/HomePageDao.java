package com.eastelsoft.tv.dao;

import java.util.HashMap;

import com.eastelsoft.tv.bean.HomePageBean;
import com.eastelsoft.tv.util.http.HttpMethod;
import com.eastelsoft.tv.util.http.HttpUtility;
import com.google.gson.Gson;


public class HomePageDao {

	private String mUrl;
	private HashMap<String, String> mParams;
	
	public HomePageDao(String url,HashMap<String, String> params) {
		this.mUrl = url;
		this.mParams = params;
	}
	
	public String getJSON() throws Exception{
		return HttpUtility.getInstance().executeNormalTask(HttpMethod.Get, mUrl, mParams);
	}
	
	public HomePageBean getBean() {
		try {
			String jsonString = getJSON();
			Gson gson = new Gson();
			HomePageBean bean = gson.fromJson(jsonString, HomePageBean.class);
			System.out.println("data : "+bean.getStatus());
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
