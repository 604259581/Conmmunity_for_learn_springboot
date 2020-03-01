package com.community.demo.provider;

import cn.ucloud.ufile.UfileClient;
import cn.ucloud.ufile.api.object.ObjectConfig;
import cn.ucloud.ufile.auth.*;
import cn.ucloud.ufile.bean.PutObjectResultBean;
import cn.ucloud.ufile.exception.UfileClientException;
import cn.ucloud.ufile.exception.UfileServerException;
import cn.ucloud.ufile.http.OnProgressListener;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class UCloudProvider {
    @Value("${ucloud.ufile.publicKey}")
    private String publicKey;
    @Value("${ucloud.ufile.privateKey}")
    private String privateKey;
    // Bucket相关API的授权器
    ObjectAuthorization OBJECT_AUTHORIZER = new UfileObjectLocalAuthorization(
            publicKey, privateKey);

    ObjectConfig config = new ObjectConfig("cn-sh2", "ufileos.com");
    public String uoload(InputStream inputStream, String mimeType, String fileName)
    {
        String generateFileName = "";
        String[] fileSpliter = fileName.split(".");
        if(fileSpliter.length>1){
            generateFileName= UUID.randomUUID().toString()+"."+fileSpliter[fileSpliter.length-1];
        }else {
            return  null;
        }
        try {
            PutObjectResultBean response = UfileClient.object(OBJECT_AUTHORIZER , config)
                    .putObject(inputStream, mimeType)
                    .nameAs(generateFileName)
                    .toBucket("dmpark")
                    /**
                     * 是否上传校验MD5, Default = true
                     */
                    //  .withVerifyMd5(false)
                    /**
                     * 指定progress callback的间隔, Default = 每秒回调
                     */
                    //  .withProgressConfig(ProgressConfig.callbackWithPercent(10))
                    /**
                     * 配置进度监听
                     */
                    .setOnProgressListener((bytesWritten, contentLength) -> {

                    })
                    .execute();
        } catch (
                UfileClientException e) {
            e.printStackTrace();
            return null;
        } catch (
                UfileServerException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
