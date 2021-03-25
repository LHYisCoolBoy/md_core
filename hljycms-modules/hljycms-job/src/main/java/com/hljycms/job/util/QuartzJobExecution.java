package com.hljycms.job.util;

import org.quartz.JobExecutionContext;

import com.hljycms.job.domain.SysJob;

/**
 * 定时任务处理（允许并发执行）
 * 
 * @author hljycms  官方网站：www.hljycms.com
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
