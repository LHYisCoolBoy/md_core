package com.cms.system.domain.md;

import com.cms.common.core.web.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class MdPaper extends BaseEntity {
    private String title;
    private String desc;
    private List<?> classList;
    private String qSort;
}
