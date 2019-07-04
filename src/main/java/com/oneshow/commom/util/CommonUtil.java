package com.oneshow.commom.util;



import com.oneshow.commom.exception.SBException;
import com.oneshow.commom.exception.SystemErrorCode;

import java.util.HashMap;
import java.util.Map;

public class CommonUtil {

	public static Map<String, Object> getDefualtResult() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", "success");
		return resultMap;
	}

	public static String getErrorMessage(Exception e) {
		String errMsg = "";
		if (e instanceof SBException) {
			SBException sbException = (SBException) e;
			errMsg = sbException.getMessage();
			if (StringUtil.isEmpty(errMsg)) {
				errMsg = sbException.getErrorCode().getDescription();
			}
		} else {
			errMsg = e.getMessage();
		}
		return errMsg;
	}

	public static Map<String, Object> getErrorResultMap(Map<String, Object> map, Exception e) {
		if (map == null) {
			map = new HashMap<String, Object>();
		} else {
			map.clear();
		}
		map.put("status", "error");
		if (e instanceof SBException) {
			SBException sbException = (SBException) e;
			String errMsg = sbException.getMessage();
			if (StringUtil.isEmpty(errMsg)) {
				errMsg = sbException.getErrorCode().getDescription();
			}
			map.put("msg", errMsg);
		} else {
			map.put("msg", SystemErrorCode.UNKNOWN_ERROR.getDescription());
		}
		return map;
	}

	public static Map<String, Object> getErrorResultMap(Map<String, Object> map, String msg) {
		if (map == null) {
			map = new HashMap<String, Object>();
		} else {
			map.clear();
		}
		map.put("status", "error");
		map.put("msg", msg);
		return map;
	}

	public static Map<String, Object> getErrorResultMap(Map<String, Object> map, SystemErrorCode errorCode) {
		if (map == null) {
			map = new HashMap<String, Object>();
		} else {
			map.clear();
		}
		map.put("status", "error");
		map.put("msg", errorCode.getDescription());
		return map;
	}
}