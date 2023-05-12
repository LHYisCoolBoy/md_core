package com.cms.xh.mapper;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.web.domain.BaseEntity;
import com.cms.xh.domain.MdXhImgTable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.stereotype.Repository;

/**
 * 图片表
 *
 * @author lhy
 * @date 2023-05-09
 */
@Repository
public interface MdXhImgTableMapper {
    /**
     * 查询图片
     *
     * @return
     */
    MdXhImgTable getAll();
}
