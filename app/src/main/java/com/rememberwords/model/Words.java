package com.rememberwords.model;

public class Words {
    private String wordId;              //单词编号
    private String word;                //单词
    private String phonetics;           //但从音标
    private String pronunciationAddress;//单词发音地址
    private String mvAddress;           //单词视频地址
    private String belongTo;        //单词所属（四级，六级）
    private String type;            //单词类型（名词，动词）
    private String interpretation;  //单词意思
    private String example;         //例句

    public Words(String wordId, String word, String phonetics, String pronunciationAddress, String mvAddress, String belongTo, String type, String interpretation, String example) {
        this.wordId = wordId;
        this.word = word;
        this.phonetics = phonetics;
        this.pronunciationAddress = pronunciationAddress;
        this.mvAddress = mvAddress;
        this.belongTo = belongTo;
        this.type = type;
        this.interpretation = interpretation;
        this.example = example;
    }

    public Words() {
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(String phonetics) {
        this.phonetics = phonetics;
    }

    public String getPronunciationAddress() {
        return pronunciationAddress;
    }

    public void setPronunciationAddress(String pronunciationAddress) {
        this.pronunciationAddress = pronunciationAddress;
    }

    public String getMvAddress() {
        return mvAddress;
    }

    public void setMvAddress(String mvAddress) {
        this.mvAddress = mvAddress;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Words{" +
                "wordId='" + wordId + '\'' +
                ", word='" + word + '\'' +
                ", phonetics='" + phonetics + '\'' +
                ", pronunciationAddress='" + pronunciationAddress + '\'' +
                ", mvAddress='" + mvAddress + '\'' +
                ", belongTo='" + belongTo + '\'' +
                ", type='" + type + '\'' +
                ", interpretation='" + interpretation + '\'' +
                ", example='" + example + '\'' +
                '}';
    }
}
