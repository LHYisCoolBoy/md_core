package com.cms.common.security.feign;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import com.cms.common.core.constant.CacheConstants;
import com.cms.common.core.utils.ServletUtils;
import com.cms.common.core.utils.StringUtils;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * feign 请求拦截器
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor
{
    @Override
    public void apply(RequestTemplate requestTemplate)
    {
        HttpServletRequest httpServletRequest = ServletUtils.getRequest();
        if (StringUtils.isNotNull(httpServletRequest))
        {
            Map<String, String> headers = ServletUtils.getHeaders(httpServletRequest);
            // 传递用户信息请求头，防止丢失
            String userId = headers.get(CacheConstants.DETAILS_USER_ID);
            if (StringUtils.isNotEmpty(userId))
            {
                requestTemplate.header(CacheConstants.DETAILS_USER_ID, userId);
            }
            String userName = headers.get(CacheConstants.DETAILS_USERNAME);
            if (StringUtils.isNotEmpty(userName))
            {
                requestTemplate.header(CacheConstants.DETAILS_USERNAME, userName);
            }
            String authentication = headers.get(CacheConstants.AUTHORIZATION_HEADER);
            if (StringUtils.isNotEmpty(authentication))
            {
                requestTemplate.header(CacheConstants.AUTHORIZATION_HEADER, authentication);
            }
        }
    }
}
