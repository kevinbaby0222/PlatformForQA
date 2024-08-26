package com.mr.platform.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String up(String nickname, MultipartFile document, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        // 获取文档原始名称
        System.out.println(document.getOriginalFilename());
        // 获取文件类型
        System.out.println(document.getContentType());
        System.out.println(System.getProperty("user.dir"));

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(document,path);
        return "上传成功";
    }
    private void saveFile(MultipartFile document, String path) throws IOException {
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file = new File(path + File.separator + document.getOriginalFilename()); // 使用 File.separator 来确保路径分隔符正确
        document.transferTo(file);
    }
}
