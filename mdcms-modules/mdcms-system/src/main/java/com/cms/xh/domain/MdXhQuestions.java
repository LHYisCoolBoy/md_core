package com.cms.xh.domain;

import com.cms.common.core.annotation.Excel;

/**
 * 问卷答题对象 md_xh_questions
 *
 * @author lhy
 * @date 2023-05-05
 */
public class MdXhQuestions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键，答题 ID */
    private Long id;

    /** 题目内容 */
    @Excel(name = "题目内容")
    private String question;

    /** 用户提交的答案 */
    @Excel(name = "用户提交的答案")
    private String userAnswer;

    /** 正确答案 */
    @Excel(name = "正确答案")
    private String answer;

    /** 分数及格之后给的图片 */
    @Excel(name = "分数及格之后给的图片")
    private String imgUrl;

    /** 逻辑删除（0 - 未删除，1 - 已删除） */
    private Long isDelete;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getQuestion()
    {
        return question;
    }
    public void setUserAnswer(String userAnswer)
    {
        this.userAnswer = userAnswer;
    }

    public String getUserAnswer()
    {
        return userAnswer;
    }
    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getAnswer()
    {
        return answer;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setIsDelete(Long isDelete)
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete()
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("question", getQuestion())
            .append("userAnswer", getUserAnswer())
            .append("answer", getAnswer())
            .append("imgUrl", getImgUrl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
