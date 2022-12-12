package com.rememberwords.model;

import java.util.Date;

public class Logs {
    private String logsId;          //日志编号
    private Date loginTime;         //登陆时间
    private Date exitTime;          //退出时间
    private Double studyTime;        //此次学习时长
    private String userId;          //用户编号

    public Logs(String logsId, Date loginTime, Date exitTime, Double studyTime, String userId) {
        this.logsId = logsId;
        this.loginTime = loginTime;
        this.exitTime = exitTime;
        this.studyTime = studyTime;
        this.userId = userId;
    }

    public Logs() {
    }

    public String getLogsId() {
        return logsId;
    }

    public void setLogsId(String logsId) {
        this.logsId = logsId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Double getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Double studyTime) {
        this.studyTime = studyTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "logsId='" + logsId + '\'' +
                ", loginTime=" + loginTime +
                ", exitTime=" + exitTime +
                ", studyTime=" + studyTime +
                ", userId='" + userId + '\'' +
                '}';
    }
}
