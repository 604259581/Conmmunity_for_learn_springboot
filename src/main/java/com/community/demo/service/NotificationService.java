package com.community.demo.service;

import com.community.demo.Mapper.NotificationMapper;
import com.community.demo.Model.*;
import com.community.demo.dto.NotificationDTO;
import com.community.demo.dto.PageDTO;
import com.community.demo.dto.QuestionDTO;
import com.community.demo.enums.NotificationStatusEnum;
import com.community.demo.enums.NotificationTypeEnum;
import com.community.demo.exception.CustomizeErrorCode;
import com.community.demo.exception.CustomizeException;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationMapper notificationMapper;
    public PageDTO<NotificationDTO> List(int userId, int page, int size) {
        PageDTO<NotificationDTO> pageDTO=new PageDTO();
        NotificationExample notificationExample =new NotificationExample();
        notificationExample.createCriteria()
                .andReceiverEqualTo(userId);
        int totalCount= (int) notificationMapper.countByExample(notificationExample);
        pageDTO.setPagination(totalCount,page,size);
        if(page>pageDTO.getTotalPage()){
            page=pageDTO.getTotalPage();
        }
        if(page<1){
            page=1;
        }
        int offset = size*(page-1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andReceiverEqualTo(userId);
        example.setOrderByClause("gmt_create desc");
        List<Notification> notifications = notificationMapper.selectByExampleWithRowbounds(example,new RowBounds(offset,size));
        if(notifications.size()==0){
            return pageDTO;
        }
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        for (Notification notification : notifications) {
            NotificationDTO notificationDTO = new NotificationDTO();
            BeanUtils.copyProperties(notification,notificationDTO);
            notificationDTO.setTypeName(NotificationTypeEnum.nameOf(notification.getType()));
            notificationDTOS.add(notificationDTO);
        }
        pageDTO.setData(notificationDTOS);
        return pageDTO;
    }

    public Long unreadCount(Integer id) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                .andReceiverEqualTo(id)
                .andStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        return notificationMapper.countByExample(notificationExample);
    }

    public NotificationDTO read(Integer id, User user) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        if(notification==null){
            throw new CustomizeException(CustomizeErrorCode.NOTICICATION_NOT_FOUND);
        }
        if(notification.getReceiver()!=user.getId()){
            throw new CustomizeException(CustomizeErrorCode.READ_NOTIFICATION_FAIL);
        }
        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification); //直接将所有内容全部更新
        NotificationDTO notificationDTO = new NotificationDTO();
        BeanUtils.copyProperties(notification,notificationDTO);
        notificationDTO.setTypeName(NotificationTypeEnum.nameOf(notification.getType()));
        return notificationDTO;
    }
}
