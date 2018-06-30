package com.da.vo;

import java.util.Date;

/**
 * @Author: liyang117
 * @Date: 2018/6/30 12:57
 * @Description:
 */
public class TeacherVo {

    private Integer id;

    private String name;

    private String sex;

    private String identityNO;

    private String teacherNo;

    private String birthPlace;

    private String identityImgSrc;

    private String education;

    private String updateBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentityNO() {
        return identityNO;
    }

    public void setIdentityNO(String identityNO) {
        this.identityNO = identityNO;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getIdentityImgSrc() {
        return identityImgSrc;
    }

    public void setIdentityImgSrc(String identityImgSrc) {
        this.identityImgSrc = identityImgSrc;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
