package com.javapractice.app.mybatis.model;

import java.util.Date;
import javax.annotation.Generated;

public class TbDiary {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5433026+09:00", comments="Source field: tb_diary.diary_id")
    private String diary_Id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.subject_type")
    private String subject_Type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.regist_date")
    private Date regist_Date;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.remarks")
    private String remarks;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5514188+09:00", comments="Source field: tb_diary.content_1")
    private String content_1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5514188+09:00", comments="Source field: tb_diary.content_2")
    private String content_2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5514188+09:00", comments="Source field: tb_diary.content_3")
    private String content_3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.549423+09:00", comments="Source field: tb_diary.diary_id")
    public String getDiaryId() {
        return diary_Id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.diary_id")
    public void setDiaryId(String diaryId) {
        this.diary_Id = diaryId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.subject_type")
    public String getSubjectType() {
        return subject_Type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.subject_type")
    public void setSubjectType(String subjectType) {
        this.subject_Type = subjectType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.title")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.title")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.regist_date")
    public Date getRegistDate() {
        return regist_Date;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.regist_date")
    public void setRegistDate(Date registDate) {
        this.regist_Date = registDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.remarks")
    public String getRemarks() {
        return remarks;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5504185+09:00", comments="Source field: tb_diary.remarks")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5514188+09:00", comments="Source field: tb_diary.content_1")
    public String getContent1() {
        return content_1;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5514188+09:00", comments="Source field: tb_diary.content_1")
    public void setContent1(String content1) {
        this.content_1 = content1;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5514188+09:00", comments="Source field: tb_diary.content_2")
    public String getContent2() {
        return content_2;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5514188+09:00", comments="Source field: tb_diary.content_2")
    public void setContent2(String content2) {
        this.content_2 = content2;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5514188+09:00", comments="Source field: tb_diary.content_3")
    public String getContent3() {
        return content_3;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5514188+09:00", comments="Source field: tb_diary.content_3")
    public void setContent3(String content3) {
        this.content_3 = content3;
    }
}