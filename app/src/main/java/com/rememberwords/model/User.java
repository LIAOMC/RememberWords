package com.rememberwords.model;

public class User {
    private Integer userId;      //编号
    private String account;     //账号
    private String password;    //密码
    private String nickName;    //昵称
    private String mobile;      //电话
    private String question;    //安全问题
    private  String answer;     //问题答案
    private int currencyNum;    //酷币数量

    public User(Integer userId, String account, String password, String nickName, String mobile, String question, String answer, int currencyNum) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.nickName = nickName;
        this.mobile = mobile;
        this.question = question;
        this.answer = answer;
        this.currencyNum = currencyNum;
    }

    public User() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCurrencyNum() {
        return currencyNum;
    }

    public void setCurrencyNum(int currencyNum) {
        this.currencyNum = currencyNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", currencyNum=" + currencyNum +
                '}';
    }
}
