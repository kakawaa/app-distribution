package com.cube.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * httputil
 * 
 * @author lvchaohua
 *
 */
public class HttpUtil {

	
	private static final String CHARSET = "UTF-8";

	/**
	 * http get请求
	 * 
	 * @param url
	 *            请求地址
	 * @param
	 *            请求参数
	 * @return
	 */
	public static String get(String url) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String str = EntityUtils.toString(entity, CHARSET);
					return str;
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
		return null;
	}

	/**
	 * http get请求
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @return
	 */
	public static String get(String url, Map<String, Object> params) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			url = url + "?";
			for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				String temp = key + "=" + params.get(key) + "&";
				url = url + temp;
			}
			url = url.substring(0, url.length() - 1);
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String str = EntityUtils.toString(entity, CHARSET);
					return str;
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
		return null;
	}

	/**
	 * http post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @return
	 */
	public static String post(String url, Map<String, Object> params) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Content-Type","application/json;charset=utf-8");
			
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				parameters.add(new BasicNameValuePair(key, params.get(key).toString()));
			}
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(parameters, CHARSET);
			httpPost.setEntity(uefEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String str = EntityUtils.toString(entity, CHARSET);
					return str;
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
		return null;
	}

	/**
	 * http post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @return
	 */
	public static String post(String url, String params,String token) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			//httpPost.setHeader("Content-Type","application/json;charset=utf-8");
			//httpPost.setHeader("Token", token);
			StringEntity sEntity = new StringEntity(params, CHARSET);
			httpPost.setEntity(sEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					return EntityUtils.toString(entity, CHARSET);
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
		return null;
	}
	public static String post(String url, String params) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			//httpPost.setHeader("Content-Type","application/json;charset=utf-8");
			//httpPost.setHeader("Token", token);
			StringEntity sEntity = new StringEntity(params, CHARSET);
			httpPost.setEntity(sEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					return EntityUtils.toString(entity, CHARSET);
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
		return null;
	}
	/**
	 * http post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param
	 *
	 * @return
	 */
	public static String post(String url) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Content-Type","application/json;charset=utf-8");
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					return EntityUtils.toString(entity, CHARSET);
				}
			} finally {
				response.close();
				httpClient.close();
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
		return null;
	}
}
