package com.oneshow.commom.exception;

import com.oneshow.commom.util.StringUtil;

public class SBException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final ErrorCode resultCode;

    public SBException(ErrorCode resultCode) {
        this.resultCode = resultCode;
    }

    public SBException(ErrorCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public SBException(ErrorCode resultCode, Throwable e) {
        super(e);
        this.resultCode = resultCode;
    }

    public SBException(ErrorCode resultCode, String message, Throwable e) {
        super(message, e);
        this.resultCode = resultCode;
    }

    public ExceptionType getType() {
        return resultCode.getType();
    }

    public ErrorCode getErrorCode() {
        return resultCode;
    }

    @Override
    public String getMessage() {
        if (StringUtil.isEmpty(super.getMessage())) {
            return this.getErrorCode().getDescription();
        } else {
            return super.getMessage();
        }
    }


}