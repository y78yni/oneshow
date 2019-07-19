package com.oneshow.commom.util;

import java.util.Random;

//
//
//import com.oneshow.commom.exception.SBException;
//
//import java.util.HashMap;
//import java.util.Map;
//
public class CommonUtil {

    /**
     * 随机生成指定字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }


//	public static Map<String, Object> getDefualtResult() {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("status", "success");
//		return resultMap;
//	}
//
//	public static String getErrorMessage(Exception e) {
//		String errMsg = "";
//		if (e instanceof SBException) {
//			SBException sbException = (SBException) e;
//			errMsg = sbException.getMessage();
//		} else {
//			errMsg = e.getMessage();
//		}
//		return errMsg;
//	}
//
//	public static Map<String, Object> getErrorResultMap(Map<String, Object> map, Exception e) {
//		if (map == null) {
//			map = new HashMap<String, Object>();
//		} else {
//			map.clear();
//		}
//		map.put("status", "error");
//		if (e instanceof SBException) {
//			SBException sbException = (SBException) e;
//			String errMsg = sbException.getMessage();
//			map.put("msg", "[" + sbException.getErrorCode().getCode() + "," + errMsg + "]");
//		} else {
//			map.put("msg", e.getMessage() == null ? e.toString() : e.getMessage());
//		}
//		return map;
//	}
//
//	public static Map<String, Object> getErrorResultMap(Map<String, Object> map, String msg) {
//		if (map == null) {
//			map = new HashMap<String, Object>();
//		} else {
//			map.clear();
//		}
//		map.put("status", "error");
//		map.put("msg", msg);
//		return map;
//	}
}
