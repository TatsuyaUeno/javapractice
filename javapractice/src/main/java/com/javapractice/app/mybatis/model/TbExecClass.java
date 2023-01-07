package com.javapractice.app.mybatis.model;

import java.util.Date;
import javax.annotation.Generated;

public class TbExecClass {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9593259+09:00", comments="Source field: tb_exec_class.class_name")
    private String class_Name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.exec_flg")
    private String exec_Flg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.regist_date")
    private Date regist_Date;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.remarks")
    private String remarks;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9623474+09:00", comments="Source field: tb_exec_class.class_name")
    public String getClassName() {
        return class_Name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.class_name")
    public void setClassName(String className) {
        this.class_Name = className;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.exec_flg")
    public String getExecFlg() {
        return exec_Flg;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.exec_flg")
    public void setExecFlg(String execFlg) {
        this.exec_Flg = execFlg;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.regist_date")
    public Date getRegistDate() {
        return regist_Date;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.regist_date")
    public void setRegistDate(Date registDate) {
        this.regist_Date = registDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.remarks")
    public String getRemarks() {
        return remarks;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9633151+09:00", comments="Source field: tb_exec_class.remarks")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}