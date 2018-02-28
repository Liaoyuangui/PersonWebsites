package com.lyg.entitys;

public class Articles {
    private Integer articlesId;

    private Integer classId;

    private String cententTitle;

    private String contentIcon;

    private String content1;

    private String content1Img;

    private String content2;

    private String content2Img;

    private String content3;

    private String content3Img;

    private String content4;

    private String content4Img;

    private String content5;

    private String content5Img;

    private String addTime;

    private String updateTime;

    private Integer userId;

    private Integer isUsed;
    //是否推荐
    private Integer isTj;

    public Integer getArticlesId() {
        return articlesId;
    }

    public void setArticlesId(Integer articlesId) {
        this.articlesId = articlesId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getCententTitle() {
        return cententTitle;
    }

    public void setCententTitle(String cententTitle) {
        this.cententTitle = cententTitle == null ? null : cententTitle.trim();
    }

    public String getContentIcon() {
        return contentIcon;
    }

    public void setContentIcon(String contentIcon) {
        this.contentIcon = contentIcon == null ? null : contentIcon.trim();
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1 == null ? null : content1.trim();
    }

    public String getContent1Img() {
        return content1Img;
    }

    public void setContent1Img(String content1Img) {
        this.content1Img = content1Img == null ? null : content1Img.trim();
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2 == null ? null : content2.trim();
    }

    public String getContent2Img() {
		return content2Img;
	}

	public void setContent2Img(String content2Img) {
		this.content2Img = content2Img;
	}

	public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3 == null ? null : content3.trim();
    }

    public String getContent3Img() {
        return content3Img;
    }

    public void setContent3Img(String content3Img) {
        this.content3Img = content3Img == null ? null : content3Img.trim();
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4 == null ? null : content4.trim();
    }

    public String getContent4Img() {
        return content4Img;
    }

    public void setContent4Img(String content4Img) {
        this.content4Img = content4Img == null ? null : content4Img.trim();
    }

    public String getContent5() {
        return content5;
    }

    public void setContent5(String content5) {
        this.content5 = content5 == null ? null : content5.trim();
    }

    public String getContent5Img() {
        return content5Img;
    }

    public void setContent5Img(String content5Img) {
        this.content5Img = content5Img == null ? null : content5Img.trim();
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

	public Integer getIsTj() {
		return isTj;
	}

	public void setIsTj(Integer isTj) {
		this.isTj = isTj;
	}
    
}