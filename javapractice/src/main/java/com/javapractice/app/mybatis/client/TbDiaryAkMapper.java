package com.javapractice.app.mybatis.client;

import static com.javapractice.app.mybatis.client.TbDiaryAkDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import com.javapractice.app.mybatis.model.TbDiaryAk;

@Mapper
public interface TbDiaryAkMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<TbDiaryAk>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5153238+09:00", comments="Source Table: tb_diary_ak")
    BasicColumn[] selectList = BasicColumn.columnList(diaryId, subjectType, title, registDate, remarks, content1, content2, content3);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5013329+09:00", comments="Source Table: tb_diary_ak")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbDiaryAkResult", value = {
        @Result(column="diary_id", property="diaryId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="subject_type", property="subjectType", jdbcType=JdbcType.CHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.CHAR),
        @Result(column="regist_date", property="registDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.CHAR),
        @Result(column="content_1", property="content1", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="content_2", property="content2", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="content_3", property="content3", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TbDiaryAk> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5043165+09:00", comments="Source Table: tb_diary_ak")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbDiaryAkResult")
    Optional<TbDiaryAk> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5053138+09:00", comments="Source Table: tb_diary_ak")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbDiaryAk, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5063112+09:00", comments="Source Table: tb_diary_ak")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbDiaryAk, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5063112+09:00", comments="Source Table: tb_diary_ak")
    default int deleteByPrimaryKey(String diaryId_) {
        return delete(c -> 
            c.where(diaryId, isEqualTo(diaryId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5073084+09:00", comments="Source Table: tb_diary_ak")
    default int insert(TbDiaryAk row) {
        return MyBatis3Utils.insert(this::insert, row, tbDiaryAk, c ->
            c.map(diaryId).toProperty("diaryId")
            .map(subjectType).toProperty("subjectType")
            .map(title).toProperty("title")
            .map(registDate).toProperty("registDate")
            .map(remarks).toProperty("remarks")
            .map(content1).toProperty("content1")
            .map(content2).toProperty("content2")
            .map(content3).toProperty("content3")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.511311+09:00", comments="Source Table: tb_diary_ak")
    default int insertMultiple(Collection<TbDiaryAk> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbDiaryAk, c ->
            c.map(diaryId).toProperty("diaryId")
            .map(subjectType).toProperty("subjectType")
            .map(title).toProperty("title")
            .map(registDate).toProperty("registDate")
            .map(remarks).toProperty("remarks")
            .map(content1).toProperty("content1")
            .map(content2).toProperty("content2")
            .map(content3).toProperty("content3")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5132958+09:00", comments="Source Table: tb_diary_ak")
    default int insertSelective(TbDiaryAk row) {
        return MyBatis3Utils.insert(this::insert, row, tbDiaryAk, c ->
            c.map(diaryId).toPropertyWhenPresent("diaryId", row::getDiaryId)
            .map(subjectType).toPropertyWhenPresent("subjectType", row::getSubjectType)
            .map(title).toPropertyWhenPresent("title", row::getTitle)
            .map(registDate).toPropertyWhenPresent("registDate", row::getRegistDate)
            .map(remarks).toPropertyWhenPresent("remarks", row::getRemarks)
            .map(content1).toPropertyWhenPresent("content1", row::getContent1)
            .map(content2).toPropertyWhenPresent("content2", row::getContent2)
            .map(content3).toPropertyWhenPresent("content3", row::getContent3)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5163211+09:00", comments="Source Table: tb_diary_ak")
    default Optional<TbDiaryAk> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbDiaryAk, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5172844+09:00", comments="Source Table: tb_diary_ak")
    default List<TbDiaryAk> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbDiaryAk, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5172844+09:00", comments="Source Table: tb_diary_ak")
    default List<TbDiaryAk> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbDiaryAk, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5182814+09:00", comments="Source Table: tb_diary_ak")
    default Optional<TbDiaryAk> selectByPrimaryKey(String diaryId_) {
        return selectOne(c ->
            c.where(diaryId, isEqualTo(diaryId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5192786+09:00", comments="Source Table: tb_diary_ak")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbDiaryAk, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5192786+09:00", comments="Source Table: tb_diary_ak")
    static UpdateDSL<UpdateModel> updateAllColumns(TbDiaryAk row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(diaryId).equalTo(row::getDiaryId)
                .set(subjectType).equalTo(row::getSubjectType)
                .set(title).equalTo(row::getTitle)
                .set(registDate).equalTo(row::getRegistDate)
                .set(remarks).equalTo(row::getRemarks)
                .set(content1).equalTo(row::getContent1)
                .set(content2).equalTo(row::getContent2)
                .set(content3).equalTo(row::getContent3);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5203096+09:00", comments="Source Table: tb_diary_ak")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbDiaryAk row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(diaryId).equalToWhenPresent(row::getDiaryId)
                .set(subjectType).equalToWhenPresent(row::getSubjectType)
                .set(title).equalToWhenPresent(row::getTitle)
                .set(registDate).equalToWhenPresent(row::getRegistDate)
                .set(remarks).equalToWhenPresent(row::getRemarks)
                .set(content1).equalToWhenPresent(row::getContent1)
                .set(content2).equalToWhenPresent(row::getContent2)
                .set(content3).equalToWhenPresent(row::getContent3);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5213068+09:00", comments="Source Table: tb_diary_ak")
    default int updateByPrimaryKey(TbDiaryAk row) {
        return update(c ->
            c.set(subjectType).equalTo(row::getSubjectType)
            .set(title).equalTo(row::getTitle)
            .set(registDate).equalTo(row::getRegistDate)
            .set(remarks).equalTo(row::getRemarks)
            .set(content1).equalTo(row::getContent1)
            .set(content2).equalTo(row::getContent2)
            .set(content3).equalTo(row::getContent3)
            .where(diaryId, isEqualTo(row::getDiaryId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-10T21:26:08.5222706+09:00", comments="Source Table: tb_diary_ak")
    default int updateByPrimaryKeySelective(TbDiaryAk row) {
        return update(c ->
            c.set(subjectType).equalToWhenPresent(row::getSubjectType)
            .set(title).equalToWhenPresent(row::getTitle)
            .set(registDate).equalToWhenPresent(row::getRegistDate)
            .set(remarks).equalToWhenPresent(row::getRemarks)
            .set(content1).equalToWhenPresent(row::getContent1)
            .set(content2).equalToWhenPresent(row::getContent2)
            .set(content3).equalToWhenPresent(row::getContent3)
            .where(diaryId, isEqualTo(row::getDiaryId))
        );
    }

    /** ----------------SELECT------------------- */
    /** お試し */
    @Select("SELECT * FROM tb_diary_ak ORDER BY regist_date DESC")
    List<TbDiaryAk> selectAll();

    @Select("SELECT * FROM tb_diary_ak WHERE subject_type = #{subjectType} ORDER BY regist_date DESC")
	List<TbDiaryAk> selectSubjectType(String subjectType); 
}