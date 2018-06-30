package com.da.po;

import java.util.Date;

public class Teacher {
    private Integer id;

    private String name;

    private Integer sex;

    private String identityNO;

    private String teacherNo;

    private String birthPlace;

    private String identityImgSrc;

    private Integer education;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
        this.identityNO = identityNO == null ? null : identityNO.trim();
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo == null ? null : teacherNo.trim();
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace == null ? null : birthPlace.trim();
    }

    public String getIdentityImgSrc() {
        return identityImgSrc;
    }

    public void setIdentityImgSrc(String identityImgSrc) {
        this.identityImgSrc = identityImgSrc == null ? null : identityImgSrc.trim();
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
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Teacher other = (Teacher) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getIdentityNO() == null ? other.getIdentityNO() == null : this.getIdentityNO().equals(other.getIdentityNO()))
            && (this.getTeacherNo() == null ? other.getTeacherNo() == null : this.getTeacherNo().equals(other.getTeacherNo()))
            && (this.getBirthPlace() == null ? other.getBirthPlace() == null : this.getBirthPlace().equals(other.getBirthPlace()))
            && (this.getIdentityImgSrc() == null ? other.getIdentityImgSrc() == null : this.getIdentityImgSrc().equals(other.getIdentityImgSrc()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getIdentityNO() == null) ? 0 : getIdentityNO().hashCode());
        result = prime * result + ((getTeacherNo() == null) ? 0 : getTeacherNo().hashCode());
        result = prime * result + ((getBirthPlace() == null) ? 0 : getBirthPlace().hashCode());
        result = prime * result + ((getIdentityImgSrc() == null) ? 0 : getIdentityImgSrc().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}