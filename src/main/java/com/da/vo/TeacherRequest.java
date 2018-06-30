package com.da.vo;

/**
 * @Author: liyang117
 * @Date: 2018/6/30 12:57
 * @Description:
 */
public class TeacherRequest {

    private String name;

    private Integer sex;

    private String identityNO;

    private String teacherNo;

    private String birthPlace;

    private String identityImgSrc;

    private Integer education;

    private String updateBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

}
