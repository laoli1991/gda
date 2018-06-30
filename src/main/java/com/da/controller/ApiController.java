package com.da.controller;

import com.da.po.Teacher;
import com.da.service.Appservice;
import com.da.utils.PropertiesUtils;
import com.da.vo.TeacherVo;
import com.da.vo.UploadFileResponse;
import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: liyang117
 * @Date: 2018/6/29 23:16
 * @Description:
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private Appservice appservice;

    private static final String dataDir = PropertiesUtils.getProperty("data.dir");

    @RequestMapping(value = "/upload", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public UploadFileResponse upload(
            @RequestParam(value = "file", required = true) MultipartFile file,
            @RequestParam(value = "type", required = true) String type,
            HttpServletRequest request) throws IllegalStateException, IOException {
        try {
            String name = file.getOriginalFilename();
            int dot = name.lastIndexOf(".");
            String uuidFileName = UUID.randomUUID().toString().replace("-", "").toLowerCase() + name.substring(dot);
            String path = request.getSession().getServletContext().getRealPath("upload");
            File targetFile = new File(path, uuidFileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
            UploadFileResponse uploadFileResponse = new UploadFileResponse();
            uploadFileResponse.setStatus("seccessed");
            uploadFileResponse.setImgPath(targetFile.getAbsolutePath());
            uploadFileResponse.setImgSrc("upload/" + uuidFileName);
            uploadFileResponse.setUuidFileName(uuidFileName);
            File copyFile = new File(dataDir, uuidFileName);
            FileUtils.copyFile(targetFile, copyFile);
            return uploadFileResponse;
        } catch (Exception ex) {
        }
        UploadFileResponse uploadFileResponse = new UploadFileResponse();
        uploadFileResponse.setStatus("error");
        return uploadFileResponse;
    }

    @RequestMapping(value = "/add-teatcher", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Boolean addTeatcher(@RequestBody TeacherVo teacherVo) {
        try {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherVo, teacher);
            appservice.addTeaher(teacher);
            return Boolean.TRUE;
        } catch (Exception ex) {
        }
        return Boolean.FALSE;
    }

}
