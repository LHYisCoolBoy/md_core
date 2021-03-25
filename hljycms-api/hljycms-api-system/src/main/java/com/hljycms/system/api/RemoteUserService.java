package com.hljycms.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hljycms.common.core.constant.ServiceNameConstants;
import com.hljycms.common.core.domain.R;
import com.hljycms.system.api.factory.RemoteUserFallbackFactory;
import com.hljycms.system.api.model.LoginUser;

/**
 * 用户服务
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService
{
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 结果
     */
    @GetMapping(value = "/user/info/{username}")
    public R<LoginUser> getUserInfo(@PathVariable("username") String username);
}
