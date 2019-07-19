package com.oneshow.commom.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * The class JacksonUtil
 *
 * json字符与对像转换
 * 
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public final class JacksonUtil {

	public static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
	public static ObjectMapper objectMapper;

	/**
	 * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
	 * (1)转换为普通JavaBean：readValue(json,Student.class)
	 * (2)转换为List,如List<Student>,将第二个参数传递为Student
	 * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
	 * 
	 * @param jsonStr
	 * @param valueType
	 * @return
	 */
	public static <T> T readValue(String jsonStr, Class<T> valueType) throws Exception{
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.readValue(jsonStr, valueType);
		} catch (Exception e) {
			logger.warn("[readValue]将json串转化为javaBean对象出错,jsonString:"+jsonStr+"出错原因："+e.getMessage());
			throw e;
		}

	}
	/**
	 * @description: 把输入流转化为valueType	
	 * @return:T
	 * @param is
	 * @param valueType
	 * @return
	 * @throws Exception
	 */
	public static <T> T readValue(InputStream is, Class<T> valueType) throws Exception{
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		try {
			return objectMapper.readValue(is, valueType);
		} catch (Exception e) {
			logger.warn("[readValue]将输入流转化为javaBean对象出错，错误原因为：" + e.getMessage());
			throw e;
		}
	}
	
	/**
	 * json数组转List
	 * @param jsonStr
	 * @param valueTypeRef
	 * @return
	 */
	public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef){
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		try {
			return objectMapper.readValue(jsonStr, valueTypeRef);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 把JavaBean转换为json字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String toJSon(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.warn("[readValue]将输入流转化为javaBean对象出错，错误原因为：" + e.getMessage());
		}

		return null;
	}
	
	/**
	 * @description: 序列化对象到文件中	
	 * @return:void
	 * @param fileName
	 * @param object
	 */
	public static void serializeObjectToFile(File fileName, Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			objectMapper.writeValue(fileName, object);
		} catch (JsonGenerationException e) {
			logger.warn("[serializeObjectToFile]对象序列化到文件中出错:" + e.toString());
			
		} catch (JsonMappingException e) {
			logger.warn("[serializeObjectToFile]对象序列化到文件中出错:" + e.toString());
		} catch (IOException e) {
			logger.warn("[serializeObjectToFile]对象序列化到文件中出错:" + e.toString());
		}
	}
//	public static void main(String[] args) {
//		String agg = "{\r\n" + 
//				"    \"sortDate\": \"terms\",\r\n" + 
//				"    \"dataType\": \"terms\"\r\n" + 
//				"}";
//		try {
//			HashMap<String,String> appMap = readValue(agg, HashMap.class);
//			appMap.keySet();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		String searchObject = "[\r\n" + 
////				"    {\r\n" + 
////				"        \"field\": \"name\",\r\n" + 
////				"        \"key\":\"key\",\r\n" + 
////				"        \"searchType\":\"1\",\r\n" + 
////				"        \"oprType\":\"2\"\r\n" + 
////				"    },\r\n" + 
////				"    {\r\n" + 
////				"        \"field\": \"name\",\r\n" + 
////				"        \"key\":\"key\",\r\n" + 
////				"        \"searchType\":\"1\",\r\n" + 
////				"        \"oprType\":\"2\"\r\n" + 
////				"    }\r\n" + 
////				"\r\n" + 
////				"]";
////		try {
////			Map[] objects = JacksonUtil.readValue(searchObject, Map[].class);
////			
////			for (Map object : objects) {
////				String searchType = "1";
////				String oprType = "1";
////				if(!object.containsKey("field") || !object.containsKey("key")) {
////					//如果不包含field和key则读取下一条
////					continue;
////				}
////				String field = (String) object.get("field");
////				String key = (String)object.get("key");
////				if(object.containsKey("searchType") ) {
////					//校验searchType的值是否正确
////					searchType = (String) object.get("searchType");
////				}
////				if(object.containsKey("operType") ) {
////					//校验searchType的值是否正确
////					oprType = (String) object.get("oprType");
////				}
////				
////				//String
////			}
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//	}
	
}
