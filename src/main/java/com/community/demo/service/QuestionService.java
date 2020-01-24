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
        System.out.println("question.getID:"+quesion.getId());
        if(quesion.getId()==0){
            quesion.setGmtCreate(System.currentTimeMillis());
            quesion.setGmtModified(System.currentTimeMillis());
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
