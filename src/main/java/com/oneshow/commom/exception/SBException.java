package com.oneshow.commom.exception;

import com.oneshow.commom.util.StringUtil;

public class SBException extends RuntimeException{


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private final ErrorCode resultCode;
	
	/**
     * 构造函数
     * 
     * @param resultCode
     */
    public SBException(ErrorCode resultCode) {
        this.resultCode = resultCode;
    }
    
    /**
     * 构造函数
     * 
     * @param resultCode
     * @param message
     */
    public SBException(ErrorCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
        
        
    }
    
    /**
     * 构造函数
     * 
     * @param e
     */
    public SBException(ErrorCode resultCode, Throwable e) {
        super(e);
        this.resultCode = resultCode;
    }
    
    /**
     * 构造函数
     * 
     * @param resultCode
     * @param message
     * @param e
     */
    public SBException(ErrorCode resultCode, String message, Throwable e) {
        super(message, e);
        this.resultCode = resultCode;
    }

    /**
     * 获取异常类型
     * 
     * @return
     */
//    public ExceptionType getType() {
//        return resultCode.getType();
//    }

    /**
     * 获取异常代码
     * 
     * @return property value of resultCode
     */
    public ErrorCode getErrorCode() {
        return resultCode;
    }

    /**
     * @see Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        if (StringUtil.isEmpty(super.getMessage())) {
            return this.getErrorCode().getDescription();
        } else {
            return super.getMessage();
        }
    }


}