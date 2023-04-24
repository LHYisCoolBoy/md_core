package com.cms.common.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.cms.system.api.RemoteLogService;
import com.cms.system.api.domain.SysOperLog;

/**
 * 异步调用日志服务
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
@Service
public class AsyncLogService
{
    @Autowired
    private RemoteLogService remoteLogService;

    /**
     * 保存系统日志记录
     */
    @Async
    public void saveSysLog(SysOperLog sysOperLog)
    {
        remoteLogService.saveLog(sysOperLog);
    }
}