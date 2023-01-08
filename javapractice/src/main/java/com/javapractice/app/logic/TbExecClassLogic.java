package com.javapractice.app.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.javapractice.app.constants.Constants;
import com.javapractice.app.mybatis.client.TbExecClassMapper;
import com.javapractice.app.mybatis.model.TbExecClass;
import com.javapractice.app.util.SqlSessionUtil;

/**
 * tb_exec_class(クラス実行テーブル)のロジッククラス<br>
 * @author tatsuya
 *
 */
@Component
public class TbExecClassLogic {

	/** SqlSessionFactory */
	private SqlSessionFactory sqlSessionFactory;

	/** 
	 * コンストラクタ<br>
	 * SQL操作を行うためのSqlSessionをmybatis-config(設定ファイル)から読み込む
	 * @throws IOException 
	 */
	public TbExecClassLogic() throws IOException {
		this.sqlSessionFactory = SqlSessionUtil.getSqlSession();
	}

	/** ログ */
	private static final Log logger = LogFactory.getLog(TbExecClassLogic.class);

	/**
	 * 実行フラグ = 1(処理する)レコードを検索<br>
	 * @return List<クラス名>
	 * @throws Exception 
	 */
	public List<String> selectActiveExecFlg() throws Exception {
		List<String> result = null;
		try {
			SqlSession session = sqlSessionFactory.openSession();
			// 設定ファイルに定義したmapperクラスをget
			TbExecClassMapper mapper = session.getMapper(TbExecClassMapper.class);
			
			result = mapper.selectActiveExecFlg(Constants.START_EXEC_FLG);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
		return result;
	}

	/**
	 * クラス名と実行フラグを受け取りレコードを更新する<br>
	 * @param className クラス名(プライマリーキー)
	 * @param execFlg　実行フラグ
	 * @throws Exception
	 */
	@Transactional
	public void updateExecFlg(String className, String execFlg, String logPrefix) throws Exception {
		try {
			logger.info(logPrefix + "クラス実行テーブル更新処理を開始します。");
			SqlSession session = sqlSessionFactory.openSession();
			// 設定ファイルに定義したmapperクラスをget
			TbExecClassMapper mapper = session.getMapper(TbExecClassMapper.class);
			mapper.updateExecFlg(className, execFlg);
			session.commit();
			logger.info(logPrefix + "クラス実行テーブル更新処理を終了します。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
	}

	/**
	 * 1件INSERT<br>
	 * @param tbExecClassModel 登録するmodel
	 * @param logPrefix ログ接頭語
	 * @throws Exception
	 */
	@Transactional
	public void insert(TbExecClass tbExecClass, String logPrefix) throws Exception {
		try {
			logger.info(logPrefix + "クラス実行テーブル登録処理を開始します。");
			SqlSession session = sqlSessionFactory.openSession();
			// 設定ファイルに定義したmapperクラスをget
			TbExecClassMapper mapper = session.getMapper(TbExecClassMapper.class);
			mapper.insert(tbExecClass);
			session.commit();
			logger.info(logPrefix + "クラス実行テーブル登録処理を終了します。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
	}

	/**
	 * 全件取得<br>
	 * @return List<TbExecClass>
	 * @throws Exception 
	 */
	public List<TbExecClass> selectAll() throws Exception {
		List<TbExecClass> tbExecClassList = new ArrayList<TbExecClass>();
		try {
			SqlSession session = sqlSessionFactory.openSession();
			TbExecClassMapper mapper = session.getMapper(TbExecClassMapper.class);
			tbExecClassList = mapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
		return tbExecClassList;
	}
}
