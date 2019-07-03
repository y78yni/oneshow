package com.jun.oneshow.exception;

public interface ErrorCode {

	/**
     * 获取异常类型
     * 
     * @return 异常类型枚举
     */
    public ExceptionType getType();

    /**
     * 获取错误代码
     * 
     * @return
     */
    public String getCode();

    /**
     * 获取错误描述
     * 
     * @return
     */
    public String getDescription();
}
