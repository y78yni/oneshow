package com.jun.oneshow.exception;

import com.jun.oneshow.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;


/**
 * 全局异常类
 * 
 * @author LZJ
 * @time 2019年5月27日16:29:35
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 拦截全局SBException异常
	 * 
	 * @param e
	 * @return result
	 */
	@ExceptionHandler(SBException.class)
	public Map<String, Object> handleSBException(SBException e) {
		Map<String, Object> result = CommonUtil.getDefualtResult();
		// 打印堆栈信息到日志文件，方便查询具体错误位置
		StringWriter errorsWriter = new StringWriter();
		// TODO打印错误堆栈到控制台，项目上线的时候记得删除此方法
		e.printStackTrace(new PrintWriter(errorsWriter));
		logger.error("发生SBException异常：" + errorsWriter);
		return CommonUtil.getErrorResultMap(result, e);
	}

	/**
	 * 拦截未知的运行时异常
	 */
	@ExceptionHandler(RuntimeException.class)
	public Map<String, Object> notFount(RuntimeException e) {
		Map<String, Object> result = CommonUtil.getDefualtResult();
		StringWriter errorsWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(errorsWriter));
		logger.error("发生未知异常：" + errorsWriter);
		return CommonUtil.getErrorResultMap(result, "运行时异常:" + e.getMessage());
	}

	/**
	 * 拦截全局Exception异常
	 * 
	 * @param e
	 * @return result
	 */
	@ExceptionHandler(Exception.class)
	public Map<String, Object> handleException(Exception e) {
		Map<String, Object> result = CommonUtil.getDefualtResult();
		StringWriter errorsWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(errorsWriter));
		logger.error("发生Exception异常：" + errorsWriter);
		return CommonUtil.getErrorResultMap(result, SystemErrorCode.SYS_INIT_ERROR);
	}

	/**
	 * 拦截全局Validated异常
	 *
	 * @param e
	 * @return result
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, Object> Validated(ConstraintViolationException e) {
		Map<String, Object> result = CommonUtil.getDefualtResult();
		StringWriter errorsWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(errorsWriter));
		logger.error("发生Exception异常：" + errorsWriter);
		return CommonUtil.getErrorResultMap(result, e);
	}
	/**
	 * 请求方式不支持
	 */
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public Map<String, Object> handleException(HttpRequestMethodNotSupportedException e) {
		Map<String, Object> result = CommonUtil.getDefualtResult();
		StringWriter errorsWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(errorsWriter));
		logger.error("请求异常：" + errorsWriter);
		return CommonUtil.getErrorResultMap(result, "不支持' " + e.getMethod() + "'请求");
	}

}
