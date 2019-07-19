package com.oneshow.commom.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ExceptionUtil {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger("ERROR");

    /**
     * 禁用构造函数
     */
    private ExceptionUtil() {
        // 禁用构造函数
    }

    /**
     * 捕捉错误日志并输出到日志文件：common-error.log
     * 
     * @param e
     *            异常堆栈
     * @param message
     *            错误日志上下文信息描述，尽量带上业务特征
     */
    public static void caught(Exception e, Object... message) {
        logger.error(LoggerUtil.getLogString(message), e);
    }

}