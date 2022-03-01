package cn.jr.service.impl;

import cn.jr.service.OssService;
import cn.jr.utils.ConstantProperties;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFile(MultipartFile file) {
        //获取阿里云存储相关常量
        String endpoint= ConstantProperties.END_POINT;
        String keyId=ConstantProperties.KEY_ID;
        String keySecret=ConstantProperties.KEY_SECRET;
        String bucketName=ConstantProperties.BUCKET_NAME;

        try{
            //创建OSS实例
            OSS oss = new OSSClientBuilder().build(endpoint, keyId, keySecret);
            //获取上传文件的输入流
            InputStream inputStream = file.getInputStream();
            //获取文件名称
            String fileName= file.getOriginalFilename();

            //在文件名称中添加随机唯一值
            String s = UUID.randomUUID().toString();

            //把文件按日期分类
            String s1 = new DateTime().toString("yyyy/MM/dd");

            fileName=s1+"/"+s+fileName;
            //第一个参数:BucketName
            //第二个参数：上传到oss文件的路径和文件名称
            //第三个参数：上传文件的输入流
            oss.putObject(bucketName,fileName,inputStream);
            //关闭oss
            oss.shutdown();

            //把上传之后的路径返回 https://edu-guli-jr.oss-cn-beijing.aliyuncs.com/mac.jpg
            String url="https://"+bucketName+"."+endpoint+"/"+fileName;

            return url;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
