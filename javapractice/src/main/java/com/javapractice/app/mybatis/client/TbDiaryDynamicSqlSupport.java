package com.javapractice.app.mybatis.client;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TbDiaryDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5606364+09:00", comments="Source Table: tb_diary")
    public static final TbDiary tbDiary = new TbDiary();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5606364+09:00", comments="Source field: tb_diary.diary_id")
    public static final SqlColumn<String> diaryId = tbDiary.diaryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5606364+09:00", comments="Source field: tb_diary.subject_type")
    public static final SqlColumn<String> subjectType = tbDiary.subjectType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5616731+09:00", comments="Source field: tb_diary.title")
    public static final SqlColumn<String> title = tbDiary.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5616731+09:00", comments="Source field: tb_diary.regist_date")
    public static final SqlColumn<Date> registDate = tbDiary.registDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5616731+09:00", comments="Source field: tb_diary.remarks")
    public static final SqlColumn<String> remarks = tbDiary.remarks;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5616731+09:00", comments="Source field: tb_diary.content_1")
    public static final SqlColumn<String> content1 = tbDiary.content1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5616731+09:00", comments="Source field: tb_diary.content_2")
    public static final SqlColumn<String> content2 = tbDiary.content2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5616731+09:00", comments="Source field: tb_diary.content_3")
    public static final SqlColumn<String> content3 = tbDiary.content3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-06T23:13:59.5606364+09:00", comments="Source Table: tb_diary")
    public static final class TbDiary extends AliasableSqlTable<TbDiary> {
        public final SqlColumn<String> diaryId = column("diary_id", JDBCType.CHAR);

        public final SqlColumn<String> subjectType = column("subject_type", JDBCType.CHAR);

        public final SqlColumn<String> title = column("title", JDBCType.CHAR);

        public final SqlColumn<Date> registDate = column("regist_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> remarks = column("remarks", JDBCType.CHAR);

        public final SqlColumn<String> content1 = column("content_1", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> content2 = column("content_2", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> content3 = column("content_3", JDBCType.LONGVARCHAR);

        public TbDiary() {
            super("tb_diary", TbDiary::new);
        }
    }
}