package com.javapractice.app.mybatis.client;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TbDiaryAkDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4973357+09:00", comments="Source Table: tb_diary_ak")
    public static final TbDiaryAk tbDiaryAk = new TbDiaryAk();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4983327+09:00", comments="Source field: tb_diary_ak.diary_id")
    public static final SqlColumn<String> diaryId = tbDiaryAk.diaryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4983327+09:00", comments="Source field: tb_diary_ak.subject_type")
    public static final SqlColumn<String> subjectType = tbDiaryAk.subjectType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4983327+09:00", comments="Source field: tb_diary_ak.title")
    public static final SqlColumn<String> title = tbDiaryAk.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4983327+09:00", comments="Source field: tb_diary_ak.regist_date")
    public static final SqlColumn<Date> registDate = tbDiaryAk.registDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4983327+09:00", comments="Source field: tb_diary_ak.remarks")
    public static final SqlColumn<String> remarks = tbDiaryAk.remarks;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4983327+09:00", comments="Source field: tb_diary_ak.content_1")
    public static final SqlColumn<String> content1 = tbDiaryAk.content1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4983327+09:00", comments="Source field: tb_diary_ak.content_2")
    public static final SqlColumn<String> content2 = tbDiaryAk.content2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4993302+09:00", comments="Source field: tb_diary_ak.content_3")
    public static final SqlColumn<String> content3 = tbDiaryAk.content3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.4983327+09:00", comments="Source Table: tb_diary_ak")
    public static final class TbDiaryAk extends AliasableSqlTable<TbDiaryAk> {
        public final SqlColumn<String> diaryId = column("diary_id", JDBCType.CHAR);

        public final SqlColumn<String> subjectType = column("subject_type", JDBCType.CHAR);

        public final SqlColumn<String> title = column("title", JDBCType.CHAR);

        public final SqlColumn<Date> registDate = column("regist_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> remarks = column("remarks", JDBCType.CHAR);

        public final SqlColumn<String> content1 = column("content_1", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> content2 = column("content_2", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> content3 = column("content_3", JDBCType.LONGVARCHAR);

        public TbDiaryAk() {
            super("tb_diary_ak", TbDiaryAk::new);
        }
    }
}