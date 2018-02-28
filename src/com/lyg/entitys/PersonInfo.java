package com.lyg.entitys;

public class PersonInfo {
    private Integer id;

    private String personName;

    private String personSex;

    private String personHobby;

    private String personAddress;

    private String personSign;

    private String personExplanin;

    private String personWork;

    private String personTel;

    private String personQq;

    private String personTx;

    private String personOthers;

    private Integer userId;

    private Integer isUsed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex == null ? null : personSex.trim();
    }

    public String getPersonHobby() {
        return personHobby;
    }

    public void setPersonHobby(String personHobby) {
        this.personHobby = personHobby == null ? null : personHobby.trim();
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress == null ? null : personAddress.trim();
    }

    public String getPersonSign() {
        return personSign;
    }

    public void setPersonSign(String personSign) {
        this.personSign = personSign == null ? null : personSign.trim();
    }

    public String getPersonExplanin() {
        return personExplanin;
    }

    public void setPersonExplanin(String personExplanin) {
        this.personExplanin = personExplanin == null ? null : personExplanin.trim();
    }

    public String getPersonWork() {
        return personWork;
    }

    public void setPersonWork(String personWork) {
        this.personWork = personWork == null ? null : personWork.trim();
    }

    public String getPersonTel() {
        return personTel;
    }

    public void setPersonTel(String personTel) {
        this.personTel = personTel == null ? null : personTel.trim();
    }

    public String getPersonQq() {
        return personQq;
    }

    public void setPersonQq(String personQq) {
        this.personQq = personQq == null ? null : personQq.trim();
    }

    public String getPersonTx() {
        return personTx;
    }

    public void setPersonTx(String personTx) {
        this.personTx = personTx == null ? null : personTx.trim();
    }

    public String getPersonOthers() {
        return personOthers;
    }

    public void setPersonOthers(String personOthers) {
        this.personOthers = personOthers == null ? null : personOthers.trim();
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
}