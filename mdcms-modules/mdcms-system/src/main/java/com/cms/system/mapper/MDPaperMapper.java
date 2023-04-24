package com.cms.system.mapper;

import com.cms.common.datasource.annotation.Slave;
import com.cms.system.domain.md.MdPaper;
import org.apache.ibatis.annotations.Param;

/**
 * 部门管理 数据层
 *
 * @author mdcms  官方网站：www.mdcms.vip
 */
@Slave
public interface MDPaperMapper {

    MdPaper getPaper(@Param("id") String id);
}
