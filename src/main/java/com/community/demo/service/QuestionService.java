package com.community.demo.service;

import com.community.demo.Mapper.QuestionMapper;
import com.community.demo.Model.Question;
import com.community.demo.Model.QuestionExample;
import com.community.demo.exception.CustomizeErrorCode;
import com.community.demo.exception.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionMapper questionMapper2;


    public void createOrUpdate(Question quesion) {
        if(quesion.getId()==null || quesion.getId().equals(0)){ // 原来使用Integer的时候，如果值为null，让它与0比较是会报错，返回空指针异常的！
            quesion.setGmtCreate(System.currentTimeMillis());
            quesion.setGmtModified(System.currentTimeMillis());
            quesion.setCommentCount(0);
            quesion.setViewCount(0);
            quesion.setLikeCount(0);
            questionMapper2.insert(quesion);
        }else {
            quesion.setGmtModified(System.currentTimeMillis());
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTitle(quesion.getTitle());
            updateQuestion.setDescription(quesion.getDescription());
            updateQuestion.setTag(quesion.getTag());
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria()
                    .andIdEqualTo(quesion.getId());
            int updated = questionMapper2.updateByExampleSelective(updateQuestion, questionExample);
            if(updated!=1){
                throw new CustomizeException(CustomizeErrorCode.Question_NOT_FOUND);
            }
        }
    }
}
