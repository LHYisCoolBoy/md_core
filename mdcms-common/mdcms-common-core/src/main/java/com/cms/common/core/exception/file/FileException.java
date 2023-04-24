package com.cms.common.core.exception.file;

import com.cms.common.core.exception.BaseException;

/**
 * 文件信息异常类
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
