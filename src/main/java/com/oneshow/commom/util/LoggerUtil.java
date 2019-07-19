package com.oneshow.commom.util;

import org.slf4j.Logger;

/**
 * 规范化日志打印工具，注意日志的级别选择：<br>
 * 
 * <p>
 * <ol>
 * <li>DEBUG <b>开发环境</b>应用调试，输出详细的应用状态
 * <li>INFO <b>生产环境</b>运行状态观察，输出应用生命周期的中<b>正常重要事件</b>
 * <li>WARN <b>生产环境</b>故障诊断，输出应用中的<b>可预期的异常事件</b>
 * <li>ERROR <b>生产环境</b>境故障诊断，输出应用中的<b>未预期的异常事件</b>
 * </ol>
 * </p>
 * 
 * <p>
 * 注意：ERROR日志记录请使用{@link ExceptionUtil}，避免日志的重复记录
 * </p>
 * 
 * @author xiaoyi@sunwayInfo.com
 *
 * @version v 0.1 LoggerUtil.java, 2018-4-20 
 */
public final class LoggerUtil {

    /** 线程编号修饰符 */
    private static final char THREAD_RIGHT_TAG = ']';

    /** 线程编号修饰符 */
    private static final char THREAD_LEFT_TAG  = '[';

    /** 换行符 */
    public static final char  ENTERSTR         = '\n';

    /** 逗号 */
    public static final char  COMMA            = ',';

    /**
     * 禁用构造函数
     */
    private LoggerUtil() {
        // 禁用构造函数
    }

    /**
     * 生成<font color="blue">调试</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 
     * @param logger
     * @param obj
     */
    public static void debug(Logger logger, Object... obj) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogString(obj));
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 
     * @param logger
     * @param obj
     */
    public static void info(Logger logger, Object... obj) {
        if (logger.isInfoEnabled()) {
            logger.info(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 
     * @param logger
     * @param obj
     */
    public static void warn(Logger logger, Object... obj) {
        if (logger.isWarnEnabled()) {
            logger.warn(getLogString(obj));
        }
    }
    /**
     * @description:统计日志	
     * @return:void
     * @param logger
     * @param modual
     * @param obj
     */
    public static void stat(Logger logger, String modual, Object...obj ) {
    	try {
    		logger.warn(getStatLogString(modual,obj));
		} catch (Exception e) {
			//不处理异常
		}
    }

    /**
     * 生成输出到日志的字符串
     * 
     * @param obj
     *            任意个要输出到日志的参数
     * @return
     */
    public static String getLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId()).append(THREAD_RIGHT_TAG);
        for (Object o : obj) {
            log.append(o);
        }
        return log.toString();
    }
    /**
     * @description:在线程后面添加modual模块名称
     * 如果2016-11-07 19:30:00,025 WARN  [][pool-1-thread-1] c.t.b.t.p.i.PrStoreSearchImpl - [63][tmxmall-alinger]+json	
     * @return:String
     * @param obj
     * @return
     */
    public static String getStatLogString(String modual, Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId()).append(THREAD_RIGHT_TAG);
        for (Object o : obj) {
            log.append(JacksonUtil.toJSon(o));
        }
        return log.toString();
    }
}

