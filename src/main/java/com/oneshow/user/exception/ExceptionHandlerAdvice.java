package com.oneshow.user.exception;

import com.oneshow.commom.exception.SBException;
import com.oneshow.commom.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;


/**
 * 全局异常类
 * 
 * @author LZJ
 * @time 2019年5月27日16:29:35
 */
@RestControllerAdvice(value = "com.oneshow")
public class ExceptionHandlerAdvice {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 拦截全局SBException异常
	 * 
	 * @param e
	 * @return result
	 */
	@ExceptionHandler(SBException.class)
	public R handleSBException(SBException e) {
		R r = new R();
		r.put("code",e.getCode());
		r.put("msg",e.getMessage());
		// 打印堆栈信息到日志文件，方便查询具体错误位置
		StringWriter errorsWriter = new StringWriter();
		// TODO打印错误堆栈到控制台，项目上线的时候记得删除此方法
		e.printStackTrace(new PrintWriter(errorsWriter));
		logger.error("发生SBException异常：" + errorsWriter);
		return r;
	}

	/**
	 * 拦截全局Exception异常
	 *
	 * @param e
	 * @return result
	 */
	@ExceptionHandler(Exception.class)
	public R handleException(Exception e) {
		StringWriter errorsWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(errorsWriter));
		logger.error("发生Exception异常：" + errorsWriter);
		return R.error();
	}


//	/**
//	 * 请求方式不支持
//	 */
//	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
//	public Map<String, Object> handleException(HttpRequestMethodNotSupportedException e) {
//		Map<String, Object> result = CommonUtil.getDefualtResult();
//		StringWriter errorsWriter = new StringWriter();
//		e.printStackTrace(new PrintWriter(errorsWriter));
//		logger.error("请求异常：" + errorsWriter);
//		return CommonUtil.getErrorResultMap(result, "不支持' " + e.getMethod() + "'请求");
//	}

}
