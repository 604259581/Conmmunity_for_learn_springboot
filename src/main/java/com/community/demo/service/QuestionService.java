package com.community.demo.service;


import com.community.demo.Mapper.QuestionMapper2;
import com.community.demo.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionMapper2 questionMapper2;


    public void createOrUpdate(Question quesion) {
        System.out.println("question.getID:"+quesion.getId());
        if(quesion.getId()==0){
            quesion.setGmt_create(System.currentTimeMillis());
            quesion.setGmt_modified(System.currentTimeMillis());
            questionMapper2.create(quesion);
        }else {
            quesion.setGmt_modified(System.currentTimeMillis());
            questionMapper2.update(quesion);
        }
    }
}
