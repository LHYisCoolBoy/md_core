package com.cms.common.core.exception.user;

import com.cms.common.core.exception.BaseException;

/**
 * 用户信息异常类
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
