package com.da.controller;

import com.da.condition.TeacherQueryCondition;
import com.da.constants.StatusCode;
import com.da.po.Teacher;
import com.da.service.Appservice;
import com.da.utils.PropertiesUtils;
import com.da.vo.FindTeacherRequest;
import com.da.vo.FindTeacherResponse;
import com.da.vo.TeacherRequest;
import com.da.vo.TeacherVo;
import com.da.vo.UploadFileResponse;
import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
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
            File folder = new File(dataDir);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            folder = new File(path);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            file.transferTo(targetFile);
            UploadFileResponse uploadFileResponse = new UploadFileResponse();
            uploadFileResponse.setStatus(StatusCode.SUCCESS);
            uploadFileResponse.setImgPath(targetFile.getAbsolutePath());
            uploadFileResponse.setImgSrc("upload/" + uuidFileName);
            uploadFileResponse.setUuidFileName(uuidFileName);
            File copyFile = new File(dataDir, uuidFileName);
            FileUtils.copyFile(targetFile, copyFile);
            return uploadFileResponse;
        } catch (Exception ex) {
        }
        UploadFileResponse uploadFileResponse = new UploadFileResponse();
        uploadFileResponse.setStatus(StatusCode.ERROR);
        return uploadFileResponse;
    }

    @RequestMapping(value = "/add-teatcher", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Boolean addTeatcher(@RequestBody TeacherRequest teacherRequest) {
        try {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherRequest, teacher);
            appservice.addTeaher(teacher);
            return Boolean.TRUE;
        } catch (Exception ex) {
        }
        return Boolean.FALSE;
    }

    @RequestMapping(value = "/query-teacher", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public TeacherVo queryTeacherById(HttpServletRequest request, @RequestParam(value = "id", required = true) Integer id) {
        try {
            TeacherVo teacherVo = appservice.queryTeacherById(id);
            String path = request.getSession().getServletContext().getRealPath("upload");
            File targetFile = new File(path, teacherVo.getIdentityImgSrc());
            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            File file = new File(dataDir, teacherVo.getIdentityImgSrc());
            FileUtils.copyFile(file, targetFile);
            teacherVo.setIdentityImgSrc("upload/" + teacherVo.getIdentityImgSrc());
            return teacherVo;
        } catch (Exception ex) {
        }
        return null;
    }

    @RequestMapping(value = "/find-teachers", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public FindTeacherResponse findTeachers(@RequestBody FindTeacherRequest request) {
        try {
            FindTeacherResponse response = new FindTeacherResponse();
            response.setStatus(StatusCode.SUCCESS);
            TeacherQueryCondition queryCondition = new TeacherQueryCondition();
            if (StringUtils.isBlank(request.getIdentityNO())) {
                request.setIdentityNO(null);
            }
            if (StringUtils.isBlank(request.getTeacherNo())) {
                request.setTeacherNo(null);
            }
            if (StringUtils.isBlank(request.getName())) {
                request.setName(null);
            }
            if (request.getPageNO() == null) {
                request.setPageNO(1);
            }
            BeanUtils.copyProperties(request, queryCondition);
            return appservice.findTeachers(queryCondition);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        FindTeacherResponse response = new FindTeacherResponse();
        response.setStatus(StatusCode.ERROR);
        return response;
    }

}
