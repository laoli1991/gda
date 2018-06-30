package com.da.service;

import com.alibaba.fastjson.JSON;
import com.da.condition.TeacherQueryCondition;
import com.da.dao.TeacherMapper;
import com.da.po.Teacher;
import com.da.vo.FindTeacherResponse;
import com.da.vo.TeacherVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author: liyang117
 * @Date: 2018/6/30 12:58
 * @Description:
 */
@Service
public class Appservice {

    @Autowired
    private TeacherMapper teacherDao;

    public void addTeaher(Teacher teacher) {
        teacherDao.insertSelective(teacher);
    }

    public TeacherVo queryTeacherById(Integer id) {
        Teacher teacher = teacherDao.selectByPrimaryKey(id);
        return buildBotoVo(teacher);
    }

    public FindTeacherResponse findTeachers(TeacherQueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNO(), 10);
        List<Teacher> teachers = teacherDao.findTeachers(queryCondition);
        PageInfo pageInfo = new PageInfo<Teacher>(teachers);
        FindTeacherResponse response = new FindTeacherResponse();
        response.setTotalCount(pageInfo.getTotal());
        response.setTotalPages(pageInfo.getPages());
        response.setPageNum(pageInfo.getPageNum());
        List<TeacherVo> teacherVos = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(teachers)) {
            for (Teacher teacher : teachers) {
                teacherVos.add(buildBotoVo(teacher));
            }
        }
        response.setTeacherVos(teacherVos);
        return response;
    }


    private TeacherVo buildBotoVo(Teacher teacher) {
        TeacherVo teacherVo = new TeacherVo();
        BeanUtils.copyProperties(teacher, teacherVo);
        switch (teacher.getSex()) {
            case 1:
                teacherVo.setSex("男");
                break;
            case 2:
                teacherVo.setSex("女");
                break;
        }
        switch (teacher.getEducation()) {
            case 1:
                teacherVo.setEducation("大学专科");
                break;
            case 2:
                teacherVo.setEducation("大学本科");
                break;
            case 3:
                teacherVo.setEducation("硕士研究生");
                break;
            case 4:
                teacherVo.setEducation("博士研究生");
                break;
        }
        return teacherVo;
    }

}
