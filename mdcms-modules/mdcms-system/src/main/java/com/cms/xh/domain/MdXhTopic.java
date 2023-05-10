package com.cms.xh.domain;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 题目对象 md_xh_topic
 *
 * @author lhy
 * @date 2023-05-09
 */
public class MdXhTopic extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Excel(name = "主键")
    private Long id;

    /**
     * 题目类型
     */
    @Excel(name = "题目类型")
    private Long type;

    /**
     * 题目内容
     */
    @Excel(name = "题目内容")
    private String question;

    /**
     * 题目的选项
     */
    @Excel(name = "题目的选项")
    private String questionOption;

    /**
     * 题目正确答案
     */
    @Excel(name = "题目正确答案")
    private String answer;

    /**
     * 逻辑删除 0 - 未删除，1 - 已删除
     */
    private Long isDelete;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getType() {
        return type;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    public String getQuestionOption() {
        return questionOption;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("type", getType())
                .append("question", getQuestion())
                .append("questionOption", getQuestionOption())
                .append("answer", getAnswer())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
