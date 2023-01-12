package com.javapractice.app.mybatis.client;

import static com.javapractice.app.mybatis.client.TbExecClassDynamicSqlSupport.*;
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
import org.apache.ibatis.annotations.Update;
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

import com.javapractice.app.mybatis.model.TbExecClass;

@Mapper
public interface TbExecClassMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<TbExecClass>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9902441+09:00", comments="Source Table: tb_exec_class")
    BasicColumn[] selectList = BasicColumn.columnList(className, execFlg, registDate, remarks);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9762811+09:00", comments="Source Table: tb_exec_class")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbExecClassResult", value = {
        @Result(column="class_name", property="className", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="exec_flg", property="execFlg", jdbcType=JdbcType.CHAR),
        @Result(column="regist_date", property="registDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.CHAR)
    })
    List<TbExecClass> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9792731+09:00", comments="Source Table: tb_exec_class")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbExecClassResult")
    Optional<TbExecClass> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9802704+09:00", comments="Source Table: tb_exec_class")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbExecClass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9812685+09:00", comments="Source Table: tb_exec_class")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbExecClass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9822662+09:00", comments="Source Table: tb_exec_class")
    default int deleteByPrimaryKey(String className_) {
        return delete(c -> 
            c.where(className, isEqualTo(className_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9842735+09:00", comments="Source Table: tb_exec_class")
    default int insert(TbExecClass row) {
        return MyBatis3Utils.insert(this::insert, row, tbExecClass, c ->
            c.map(className).toProperty("className")
            .map(execFlg).toProperty("execFlg")
            .map(registDate).toProperty("registDate")
            .map(remarks).toProperty("remarks")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9882501+09:00", comments="Source Table: tb_exec_class")
    default int insertMultiple(Collection<TbExecClass> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbExecClass, c ->
            c.map(className).toProperty("className")
            .map(execFlg).toProperty("execFlg")
            .map(registDate).toProperty("registDate")
            .map(remarks).toProperty("remarks")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9892474+09:00", comments="Source Table: tb_exec_class")
    default int insertSelective(TbExecClass row) {
        return MyBatis3Utils.insert(this::insert, row, tbExecClass, c ->
            c.map(className).toPropertyWhenPresent("className", row::getClassName)
            .map(execFlg).toPropertyWhenPresent("execFlg", row::getExecFlg)
            .map(registDate).toPropertyWhenPresent("registDate", row::getRegistDate)
            .map(remarks).toPropertyWhenPresent("remarks", row::getRemarks)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9912415+09:00", comments="Source Table: tb_exec_class")
    default Optional<TbExecClass> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbExecClass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9912415+09:00", comments="Source Table: tb_exec_class")
    default List<TbExecClass> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbExecClass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9922383+09:00", comments="Source Table: tb_exec_class")
    default List<TbExecClass> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbExecClass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9922383+09:00", comments="Source Table: tb_exec_class")
    default Optional<TbExecClass> selectByPrimaryKey(String className_) {
        return selectOne(c ->
            c.where(className, isEqualTo(className_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9932455+09:00", comments="Source Table: tb_exec_class")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbExecClass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9952312+09:00", comments="Source Table: tb_exec_class")
    static UpdateDSL<UpdateModel> updateAllColumns(TbExecClass row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(className).equalTo(row::getClassName)
                .set(execFlg).equalTo(row::getExecFlg)
                .set(registDate).equalTo(row::getRegistDate)
                .set(remarks).equalTo(row::getRemarks);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9952312+09:00", comments="Source Table: tb_exec_class")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbExecClass row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(className).equalToWhenPresent(row::getClassName)
                .set(execFlg).equalToWhenPresent(row::getExecFlg)
                .set(registDate).equalToWhenPresent(row::getRegistDate)
                .set(remarks).equalToWhenPresent(row::getRemarks);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.996228+09:00", comments="Source Table: tb_exec_class")
    default int updateByPrimaryKey(TbExecClass row) {
        return update(c ->
            c.set(execFlg).equalTo(row::getExecFlg)
            .set(registDate).equalTo(row::getRegistDate)
            .set(remarks).equalTo(row::getRemarks)
            .where(className, isEqualTo(row::getClassName))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2023-01-06T22:32:43.9972243+09:00", comments="Source Table: tb_exec_class")
    default int updateByPrimaryKeySelective(TbExecClass row) {
        return update(c ->
            c.set(execFlg).equalToWhenPresent(row::getExecFlg)
            .set(registDate).equalToWhenPresent(row::getRegistDate)
            .set(remarks).equalToWhenPresent(row::getRemarks)
            .where(className, isEqualTo(row::getClassName))
        );
    }

    @Select("SELECT * FROM tb_exec_class")
    List<TbExecClass> selectAll();

    @Select("SELECT class_name FROM tb_exec_class WHERE exec_flg = #{execFlg}")
    List<String> selectActiveExecFlg(String execFlg);

    @Select("SELECT COUNT(class_name) FROM tb_exec_class WHERE class_name = #{className}")
	int countPk(String className);

    @Update("UPDATE tb_exec_class set exec_flg = #{execFlg} where class_name = #{className}")
	void updateExecFlg(String className, String execFlg);
}