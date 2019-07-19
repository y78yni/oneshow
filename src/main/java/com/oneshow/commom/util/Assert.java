
package com.oneshow.commom.util;

import com.oneshow.commom.exception.SBException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/***数据校验***/

@Slf4j
public abstract class Assert {

	public static void isBlank(String str, String message) {
		if (StringUtils.isBlank(str)) {
			throw new SBException( message);
		}
	}

	public static void isNull(Object object, String message) {
		if (object == null) {
			throw new SBException(message);
		}
	}

	public static void isNotNull(Object object, String message) {
		if (object != null) {
			throw new SBException(message);
		}
	}

	public static void arraySize(List objectList, String message) {
		if (objectList.size() < 1) {
			throw new SBException(message);
		}
	}
}
