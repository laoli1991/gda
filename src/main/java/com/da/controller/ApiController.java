package com.da.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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

    @RequestMapping(value = "/upload", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Map<String, String> upload(
            @RequestParam(value = "file", required = true) MultipartFile file,
            @RequestParam(value = "type", required = true) String type,
            HttpServletRequest request) throws IllegalStateException, IOException {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        Map<String, String> map = Maps.newHashMap();
        String path = request.getSession().getServletContext().getRealPath("upload");
        File targetFile = new File(path, uuid);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        map.put("status", "seccessed");
        map.put("imgPath", targetFile.getAbsolutePath());
        map.put("imgSrc", "upload/" + uuid);
        return map;
    }

}
