package com.github.shiyajian.cool.support.common.exception;

import lombok.Data;

/**
 * @author shiyajian
 * create: 2022-08-03
 */
@Data
public class BizException extends RuntimeException {

    private IErrorCode error;

    public BizException(IErrorCode errorCode) {
        this.error = errorCode;
    }



}
