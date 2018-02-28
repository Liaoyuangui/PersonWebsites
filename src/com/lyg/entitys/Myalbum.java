package com.lyg.entitys;

public class Myalbum {
    private Integer albumId;

    private String albumName;

    private String albumDescription;

    private String albumType;

    private Integer albumRole;

    private String coverUrl;

    private Integer orderNo;

    private String createTime;

    private String updateTime;

    private Integer userId;

    private Integer isUsed;
    
    //相册中的照片总数
    private Integer sumPhoto;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription == null ? null : albumDescription.trim();
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType == null ? null : albumType.trim();
    }

    public Integer getAlbumRole() {
        return albumRole;
    }

    public void setAlbumRole(Integer albumRole) {
        this.albumRole = albumRole;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl == null ? null : coverUrl.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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

	public Integer getSumPhoto() {
		return sumPhoto;
	}

	public void setSumPhoto(Integer sumPhoto) {
		this.sumPhoto = sumPhoto;
	}
    
    
}