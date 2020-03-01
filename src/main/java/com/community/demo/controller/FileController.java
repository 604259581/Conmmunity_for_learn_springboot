package com.community.demo.controller;

import com.community.demo.dto.FileDTO;
import com.community.demo.provider.UCloudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private UCloudProvider uCloudProvider;
    @ResponseBody
    @RequestMapping("/file/load")
    public FileDTO upLoad(HttpServletRequest request){
        MultipartHttpServletRequest multipartHttpServletRequest =(MultipartHttpServletRequest) request; //强制转换
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("从前端的id拿到图片对象");
        try {
            uCloudProvider.uoload(multipartFile.getInputStream(),multipartFile.getContentType(),multipartFile.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/image/cat.jpg");
        System.out.println("我好困啊");
        return fileDTO;
    }
}
