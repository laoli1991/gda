package com.da.vo;

/**
 * @Author: liyang117
 * @Date: 2018/6/30 14:17
 * @Description:
 */
public class UploadFileResponse {
    private String status;
    private String imgPath;
    private String imgSrc;
    private String uuidFileName;
    private String type;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getUuidFileName() {
        return uuidFileName;
    }

    public void setUuidFileName(String uuidFileName) {
        this.uuidFileName = uuidFileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
