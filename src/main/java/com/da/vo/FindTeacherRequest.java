package com.da.vo;

import com.github.pagehelper.PageInfo;

/**
 * @Author: liyang117
 * @Date: 2018/6/30 16:47
 * @Description:
 */
public class FindTeacherRequest {
    private String name;
    private String identityNO;
    private String teacherNo;
    private Integer pageNO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getPageNO() {
        return pageNO;
    }

    public void setPageNO(Integer pageNO) {
        this.pageNO = pageNO;
    }
}
