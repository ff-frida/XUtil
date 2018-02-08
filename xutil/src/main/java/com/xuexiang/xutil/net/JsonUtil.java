
/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xutil.net;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * json转化工具
 * @author xuexiang
 * @date 2018/2/9 上午1:24
 */
public final class JsonUtil {

	/**
	 * 解析Json字符串
	 * @param json Json字符串
	 * @param classOfT 类
	 * @param <T>
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> classOfT) {
		try {
			return new Gson().fromJson(json, classOfT);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析Json字符串
	 * @param json Json字符串
	 * @param typeOfT 泛型类
	 * @param <T>
	 * @return
	 */
	public static <T> T fromJson(String json, Type typeOfT) {
		try {
			return new Gson().fromJson(json, typeOfT);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 对象转json
	 * @param src
	 * @return
	 */
	public static String toJson(Object src) {
		return new Gson().toJson(src);
	}

	/**
	 * 对象转JSONObject
	 * @param src
	 * @return
	 */
	public static JSONObject toJSONObject(Object src) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(toJson(src));
		} catch (JSONException e) {
			e.printStackTrace();
		}  
		return jsonObject;
	}
}
