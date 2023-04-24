package com.cms.system.api;

import com.cms.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cms.common.core.constant.ServiceNameConstants;
import com.cms.common.core.domain.R;
import com.cms.system.api.factory.RemoteUserFallbackFactory;

/**
 * 用户服务
 *
 * @author mdcms  官方网站：www.mdcms.com
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
    R<LoginUser> getUserInfo(@PathVariable("username") String username);
}
