package com.jun.oneshow.exception;

public enum ExceptionType {
	/** 系统异常 */
    SYSTEM_ERROR,

    /** 登陆 */
    LOGON,

    /** 通讯 */
    COMMUNICATION,

    /** 解析器 */
    PARSER,

    /** 校验 */
    VALIDATION;

    /**
     * 枚举名称
     * 
     * @return
     */
    public String getCode() {
        return this.name();
    }
}
