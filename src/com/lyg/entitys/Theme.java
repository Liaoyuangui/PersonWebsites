package com.lyg.entitys;

public class Theme {
    private Integer id;

    private String themeName;

    private String headImgurl;

    private String headSign;

    private String indexLburl1;

    private String indexLburl2;

    private String indexLburl3;

    private String footLabel1;

    private String footLabel;

    private Integer userDefined1;

    private String userDefined2;

    private String userDefined3;

    private String addTime;

    private String updateTime;

    private Integer isStart;

    private Integer isUsed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName == null ? null : themeName.trim();
    }

    public String getHeadImgurl() {
        return headImgurl;
    }

    public void setHeadImgurl(String headImgurl) {
        this.headImgurl = headImgurl == null ? null : headImgurl.trim();
    }

    public String getHeadSign() {
        return headSign;
    }

    public void setHeadSign(String headSign) {
        this.headSign = headSign == null ? null : headSign.trim();
    }

    public String getIndexLburl1() {
        return indexLburl1;
    }

    public void setIndexLburl1(String indexLburl1) {
        this.indexLburl1 = indexLburl1 == null ? null : indexLburl1.trim();
    }

    public String getIndexLburl2() {
        return indexLburl2;
    }

    public void setIndexLburl2(String indexLburl2) {
        this.indexLburl2 = indexLburl2 == null ? null : indexLburl2.trim();
    }

    public String getIndexLburl3() {
        return indexLburl3;
    }

    public void setIndexLburl3(String indexLburl3) {
        this.indexLburl3 = indexLburl3 == null ? null : indexLburl3.trim();
    }

    public String getFootLabel1() {
        return footLabel1;
    }

    public void setFootLabel1(String footLabel1) {
        this.footLabel1 = footLabel1 == null ? null : footLabel1.trim();
    }

    public String getFootLabel() {
        return footLabel;
    }

    public void setFootLabel(String footLabel) {
        this.footLabel = footLabel == null ? null : footLabel.trim();
    }

    public Integer getUserDefined1() {
        return userDefined1;
    }

    public void setUserDefined1(Integer userDefined1) {
        this.userDefined1 = userDefined1;
    }

    public String getUserDefined2() {
        return userDefined2;
    }

    public void setUserDefined2(String userDefined2) {
        this.userDefined2 = userDefined2 == null ? null : userDefined2.trim();
    }

    public String getUserDefined3() {
        return userDefined3;
    }

    public void setUserDefined3(String userDefined3) {
        this.userDefined3 = userDefined3 == null ? null : userDefined3.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }
}