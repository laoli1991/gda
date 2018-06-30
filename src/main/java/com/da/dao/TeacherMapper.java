package com.da.dao;

import com.da.condition.TeacherQueryCondition;
import com.da.po.Teacher;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> findTeachers(TeacherQueryCondition teacher);
}