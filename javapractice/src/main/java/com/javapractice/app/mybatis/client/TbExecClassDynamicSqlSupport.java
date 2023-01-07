package com.javapractice.app.mybatis.client;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TbExecClassDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9732888+09:00", comments="Source Table: tb_exec_class")
    public static final TbExecClass tbExecClass = new TbExecClass();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9732888+09:00", comments="Source field: tb_exec_class.class_name")
    public static final SqlColumn<String> className = tbExecClass.className;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9742862+09:00", comments="Source field: tb_exec_class.exec_flg")
    public static final SqlColumn<String> execFlg = tbExecClass.execFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9742862+09:00", comments="Source field: tb_exec_class.regist_date")
    public static final SqlColumn<Date> registDate = tbExecClass.registDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9742862+09:00", comments="Source field: tb_exec_class.remarks")
    public static final SqlColumn<String> remarks = tbExecClass.remarks;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9732888+09:00", comments="Source Table: tb_exec_class")
    public static final class TbExecClass extends AliasableSqlTable<TbExecClass> {
        public final SqlColumn<String> className = column("class_name", JDBCType.CHAR);

        public final SqlColumn<String> execFlg = column("exec_flg", JDBCType.CHAR);

        public final SqlColumn<Date> registDate = column("regist_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> remarks = column("remarks", JDBCType.CHAR);

        public TbExecClass() {
            super("tb_exec_class", TbExecClass::new);
        }
    }
}