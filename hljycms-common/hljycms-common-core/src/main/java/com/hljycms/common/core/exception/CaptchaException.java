package com.hljycms.common.core.exception;

/**
 * 验证码错误异常类
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
public class CaptchaException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public CaptchaException(String msg)
    {
        super(msg);
    }
}
