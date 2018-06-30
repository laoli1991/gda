package com.da.vo;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: liyang117
 * @Date: 2018/6/30 16:47
 * @Description:
 */
public class FindTeacherResponse {
    private List<TeacherVo> teacherVos;
    private String status;
    private Long totalCount;
    private Integer totalPages;
    private Integer pageNum;

    public List<TeacherVo> getTeacherVos() {
        return teacherVos;
    }

    public void setTeacherVos(List<TeacherVo> teacherVos) {
        this.teacherVos = teacherVos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
