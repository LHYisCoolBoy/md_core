package com.cms.system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.cms.common.datasource.annotation.Master;
import com.cms.common.datasource.annotation.Slave;
import com.cms.system.domain.md.MdPaper;
import com.cms.system.domain.md.MdQuestion;
import com.cms.system.mapper.MDPaperMapper;
import com.cms.system.mapper.MDQuestionMapper;
import com.cms.system.service.MdQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * w
 *
 * @author mdcms  官方网站：www.mdcms.vip
 */
@Service
public class MdQuestionServiceImpl implements MdQuestionService {

    @Autowired
    private MDPaperMapper paperMapper;
    @Autowired
    private MDQuestionMapper questionMapper;

    @Override
    public MdPaper getPaper(String id) {
        MdPaper dbpaper = paperMapper.getPaper(id);

        List<MdQuestion> qList = new ArrayList<>();
        String[] split = dbpaper.getQSort().split(",");
        for (String qid : split) {
            MdQuestion dbquestion = questionMapper.getQuestion(qid);

        }
        return dbpaper;
    }

}
