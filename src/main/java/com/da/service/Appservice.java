package com.da.service;

import com.da.dao.TeacherMapper;
import com.da.po.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: liyang117
 * @Date: 2018/6/30 12:58
 * @Description:
 */
@Service
public class Appservice {

    @Autowired
    private TeacherMapper teacherDao;

    public void addTeaher(Teacher teacher){
        teacherDao.insertSelective(teacher);
    }

}
