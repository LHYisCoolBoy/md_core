package com.cms.system.mapper;

import com.cms.system.domain.md.MdPaper;
import com.cms.system.domain.md.MdQuestion;
import org.apache.ibatis.annotations.Param;

/**
 * 部门管理 数据层
 *
 * @author mdcms  官方网站：www.mdcms.vip
 */
public interface MDQuestionMapper {

    MdQuestion getQuestion(@Param("id") String id);
}
