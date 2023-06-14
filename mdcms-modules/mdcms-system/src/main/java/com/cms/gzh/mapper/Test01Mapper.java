package com.cms.gzh.mapper;

import com.cms.gzh.domain.MdEssayDTO;
import com.cms.gzh.domain.Test01;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Test01Mapper {
    int addText(Test01 test01);
    int updateText(Test01 test01);

    Test01 getText(Test01 test01);
}
