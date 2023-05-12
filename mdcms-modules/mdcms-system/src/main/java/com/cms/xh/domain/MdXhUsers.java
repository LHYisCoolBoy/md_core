package com.cms.xh.domain;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 用户信息对象 md_xh_users
 *
 * @author lhy
 * @date 2023-05-12
 */
public class MdXhUsers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private Long id;

    /** 用户 ID */
    @Excel(name = "用户 ID")
    private Long userId;

    /** 已观看时间（默认 0） */
    @Excel(name = "已观看时间", readConverterExp = "默=认,0=")
    private Long watchTime;

    /** 观看次数 */
    @Excel(name = "观看次数")
    private Long watchCount;

    /** 答题得分 */
    @Excel(name = "答题得分")
    private Long score;

    /** 补考次数 */
    @Excel(name = "补考次数")
    private Long num;

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
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setWatchTime(Long watchTime)
    {
        this.watchTime = watchTime;
    }

    public Long getWatchTime()
    {
        return watchTime;
    }
    public void setWatchCount(Long watchCount)
    {
        this.watchCount = watchCount;
    }

    public Long getWatchCount()
    {
        return watchCount;
    }
    public void setScore(Long score)
    {
        this.score = score;
    }

    public Long getScore()
    {
        return score;
    }
    public void setNum(Long num)
    {
        this.num = num;
    }

    public Long getNum()
    {
        return num;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("watchTime", getWatchTime())
            .append("watchCount", getWatchCount())
            .append("score", getScore())
            .append("num", getNum())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
