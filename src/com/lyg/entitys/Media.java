package com.lyg.entitys;

public class Media {
    private Integer id;

    private String mediaName;

    private String mediaUrl;

    private Integer isMusic;

    private Integer isMovie;

    private String mediaIcon;

    private Integer mediaSort;

    private String addTime;

    private String userDefined1;

    private String userDefined2;

    private String userDefined3;

    private Integer isUsed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName == null ? null : mediaName.trim();
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
    }

    public Integer getIsMusic() {
        return isMusic;
    }

    public void setIsMusic(Integer isMusic) {
        this.isMusic = isMusic;
    }

    public Integer getIsMovie() {
        return isMovie;
    }

    public void setIsMovie(Integer isMovie) {
        this.isMovie = isMovie;
    }

    public String getMediaIcon() {
        return mediaIcon;
    }

    public void setMediaIcon(String mediaIcon) {
        this.mediaIcon = mediaIcon == null ? null : mediaIcon.trim();
    }

    public Integer getMediaSort() {
        return mediaSort;
    }

    public void setMediaSort(Integer mediaSort) {
        this.mediaSort = mediaSort;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getUserDefined1() {
        return userDefined1;
    }

    public void setUserDefined1(String userDefined1) {
        this.userDefined1 = userDefined1 == null ? null : userDefined1.trim();
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

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }
}