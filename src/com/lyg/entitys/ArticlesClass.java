package com.lyg.entitys;

public class ArticlesClass {
	
	
    private Integer classId;

    private String className;

    private String classIcon;

    private String createTime;

    private String updateTime;

    private Integer userId;

    private Integer isUsed;
    
    private Integer isShow;  //是否首页显示
    
    private String bgStyle;  //背景样式

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getClassIcon() {
        return classIcon;
    }

    public void setClassIcon(String classIcon) {
        this.classIcon = classIcon == null ? null : classIcon.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
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

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public String getBgStyle() {
		return bgStyle;
	}

	public void setBgStyle(String bgStyle) {
		this.bgStyle = bgStyle;
	}
    
    
    
}