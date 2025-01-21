package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.utils.FileUtil;
import com.leon.pojo.FilesAndApps;
import com.leon.service.impl.FilesAndAppsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileAndAppController {
    @Autowired
    FilesAndAppsServiceImpl filesAndAppsService;

    @Resource
    private HttpServletResponse response;
    @Resource
    private HttpServletRequest request;

    String filesName = "";
//    文件上传
    @RequestMapping("filesAppsUpLoads")
    public String upload(@RequestParam MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()){
            String uploadPath = "/jar/file";
            // 如果目录不存在则创建
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String OriginalFilename = file.getOriginalFilename();//获取原文件名
            String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
            //重新随机生成名字
            String filename = UUID.randomUUID().toString() +suffixName;
            filesName = filename;
            File localFile = new File(uploadPath+"/"+filename);
            try {
                file.transferTo(localFile); //把上传的文件保存至本地
                /**
                 * 这里应该把filename保存到数据库,供前端访问时使用
                 */
                return filename;//上传成功，返回保存的文件地址
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("上传失败");
                return "";
            }
        }else{
            System.out.println("文件为空");
            return "";
        }
    }


    @RequestMapping("insertFile")
    public int insertFile(@RequestBody FilesAndApps filesAndApps){
       return filesAndAppsService.insertFile(filesAndApps);
    }
    @RequestMapping("updateFile")
    public int updateFile(@RequestBody FilesAndApps filesAndApps){
        return filesAndAppsService.updateFile(filesAndApps);
    }
    @RequestMapping("deleteFile")
    public int deleteFile(@RequestBody FilesAndApps filesAndApps){
        return filesAndAppsService.deleteFile(filesAndApps.getFileId());
    }
    @RequestMapping("selectAllFiles")
    public String selectAllFiles(){
        return JSON.toJSONString(filesAndAppsService.selectAllFiles());
    }

//    文件下载

    @RequestMapping("downLoadFiles")
    public void downloadFileStream(@RequestBody FilesAndApps filesAndApps) {
        // 文件本地位置
        String fileBasePath = "/jar/file";
        String fileAddPath = filesAndApps.getFilePath();
        String filePath = fileBasePath +"/"+ fileAddPath;
        System.out.println(filePath);
        // 文件名称
        String fileName = filesAndApps.getFileName();
        File file = new File(filePath);
        System.out.println(fileAddPath);
        FileUtil.downloadFile(file, request, response, fileName,fileAddPath);

    }





}
