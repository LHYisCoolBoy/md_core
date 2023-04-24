package com.cms.system.domain.md;

import com.cms.common.core.web.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class MdOption extends BaseEntity {
    private String opt;
    private String desc;
    private List<?> questionList;
}
