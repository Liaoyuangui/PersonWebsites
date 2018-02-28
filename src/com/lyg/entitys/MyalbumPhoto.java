package com.lyg.entitys;

public class MyalbumPhoto {
    private Integer photoId;

    private Integer albumId;

    private String photoName;

    private String photoDescription;

    private String photoTags;

    private String createTime;

    private String photoUrl;

    private String smallPhotoUrl;

    private Integer isUsed;
    
    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription == null ? null : photoDescription.trim();
    }

    public String getPhotoTags() {
        return photoTags;
    }

    public void setPhotoTags(String photoTags) {
        this.photoTags = photoTags == null ? null : photoTags.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getSmallPhotoUrl() {
        return smallPhotoUrl;
    }

    public void setSmallPhotoUrl(String smallPhotoUrl) {
        this.smallPhotoUrl = smallPhotoUrl == null ? null : smallPhotoUrl.trim();
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }
}