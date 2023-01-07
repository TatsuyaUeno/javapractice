package com.javapractice.app.logic;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.javapractice.app.constants.Constants;
import com.javapractice.app.mybatis.client.TbExecClassMapper;
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
			logger.error(Constants.DB_ERROR_MESSAGE, e);
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
		return result;
	}

	/**
	 * 引数の値にDB更新を行う<br>
	 * @param className クラス名(プライマリーキー)
	 * @param execFlg　実行フラグ
	 * @throws Exception
	 */
	@Transactional
	public void updateExecFlg(String className, String execFlg) throws Exception {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			// 設定ファイルに定義したmapperクラスをget
			TbExecClassMapper mapper = session.getMapper(TbExecClassMapper.class);
			mapper.updateExecFlg(className, execFlg);
			session.commit();
		} catch (Exception e) {
			logger.error(Constants.DB_ERROR_MESSAGE);
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
	}
}
