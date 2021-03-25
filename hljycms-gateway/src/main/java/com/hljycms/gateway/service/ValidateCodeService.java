package com.hljycms.gateway.service;

import java.io.IOException;

import com.hljycms.common.core.exception.CaptchaException;
import com.hljycms.common.core.web.domain.AjaxResult;

/**
 * 验证码处理
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public AjaxResult createCapcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCapcha(String key, String value) throws CaptchaException;
}
