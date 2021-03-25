package com.hljycms.common.core.exception.file;

import com.hljycms.common.core.exception.BaseException;

/**
 * 文件信息异常类
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
