package com.hljycms.common.core.exception.user;

import com.hljycms.common.core.exception.BaseException;

/**
 * 用户信息异常类
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
