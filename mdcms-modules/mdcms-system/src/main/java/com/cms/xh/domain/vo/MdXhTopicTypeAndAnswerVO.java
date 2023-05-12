package com.cms.xh.domain.vo;

import com.cms.common.core.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class MdXhTopicTypeAndAnswerVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 题目类型
     */
    private Long type;

    /**
     * 题目正确答案
     */
    private String answer;
}
