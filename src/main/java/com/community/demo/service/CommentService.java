package com.community.demo.service;
import com.community.demo.Mapper.*;
import com.community.demo.Model.*;
import com.community.demo.dto.CommentDTO;
import com.community.demo.enums.CommentTypeEnum;
import com.community.demo.enums.NotificationStatusEnum;
import com.community.demo.enums.NotificationTypeEnum;
import com.community.demo.exception.CustomizeErrorCode;
import com.community.demo.exception.CustomizeException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentExtMapper commentExtMapper;
    @Autowired
    private NotificationMapper notificationMapper;

    @Transactional //保证事务性
    public void insert(Comment comment, User user) {
        if(comment.getParentId() == null || comment.getParentId()==0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if(comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if(comment.getType() == CommentTypeEnum.COMMENT.getType()){
            //回复评论
            Comment dbComment1 = commentMapper.selectByPrimaryKey(comment.getParentId());
            if(dbComment1 ==null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            Question question = questionMapper.selectByPrimaryKey(dbComment1.getParentId());
            if(question ==null){
                throw new CustomizeException(CustomizeErrorCode.Question_NOT_FOUND);
            }
            commentMapper.insert(comment);
            //增加评论数
            Comment parentComment = new Comment();
            parentComment.setId(comment.getParentId());
            parentComment.setCommentCount(1);
            commentExtMapper.incCommentCount(parentComment);
            Notification notification =  createNotify(comment, question.getTitle(), user.getName(), NotificationTypeEnum.REPLY_COMMENT, dbComment1.getCommentator(),question.getId()); //创建通知
            notificationMapper.insert(notification);
        }else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if(question ==null){
                throw new CustomizeException(CustomizeErrorCode.Question_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
            Notification notification = createNotify(comment, question.getTitle(),user.getName(),NotificationTypeEnum.REPLY_QUESTION, question.getCreator(),question.getId());
            notificationMapper.insert(notification);
        }
    }

    private Notification createNotify(Comment comment, String title, String name, NotificationTypeEnum replyQuestion, Integer creator,Integer outerId) {
        Notification notification = new Notification();
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setOuterId(outerId);
        notification.setType(replyQuestion.getType());
        notification.setOuterId(comment.getParentId());
        notification.setNotifier(comment.getCommentator());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(creator);
        notification.setNotifierName(name);
        notification.setNotifierName(title);
        return notification;
    }


    public List<CommentDTO> listByTargetId(int id, CommentTypeEnum type) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria()
                .andParentIdEqualTo(id)
                .andTypeEqualTo(type.getType());
        commentExample.setOrderByClause("gmt_create desc"); //按照创建时间的倒序进行排列
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        if(comments.size()==0) {
            return null;
        }else{
            //获取去重的评论人
            Set<Integer> commentators = comments.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());
            List<Integer> userIds = new ArrayList<>();
            userIds.addAll(commentators);

            //获取评论人
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andIdIn(userIds);
            List<User> users = userMapper.selectByExample(userExample);

            //将评论人转换为Map
            Map<Integer, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));

            //转换comment为commentDTO
            List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
                CommentDTO commentDTO = new CommentDTO();
                BeanUtils.copyProperties(comment,commentDTO);
                commentDTO.setUser(userMap.get(comment.getCommentator()));

                return commentDTO;
            }).collect(Collectors.toList());

            return commentDTOS;

        }
    }
}
