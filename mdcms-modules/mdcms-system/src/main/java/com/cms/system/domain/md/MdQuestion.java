package com.cms.system.domain.md;

import com.cms.common.core.web.domain.BaseEntity;
import lombok.Data;

@Data
public class MdQuestion extends BaseEntity {
    private String id;
    private String title;
    private String option;
    private String type;
    private String class_id;
    private String mark;
}
