package com.javapractice.app.logic;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.javapractice.app.constants.Constants;
import com.javapractice.app.mybatis.client.TbDiaryAkMapper;
import com.javapractice.app.mybatis.model.TbDiaryAk;
import com.javapractice.app.util.SqlSessionUtil;

/**
 * 日誌アーカイブテーブルのロジッククラス<br>
 * @author tatsuya
 *
 */
@Component
public class TbDiaryAkLogic {

	/** SqlSessionFactory */
	private SqlSessionFactory sqlSessionFactory;
	
	/** 
	 * コンストラクタ<br>
	 * SQL操作を行うためのSqlSessionをmybatis-config(設定ファイル)から読み込む
	 * @throws IOException 
	 */
	public TbDiaryAkLogic() throws IOException {
		this.sqlSessionFactory = SqlSessionUtil.getSqlSession();
	}

	/** ログ */
	private static final Log logger = LogFactory.getLog(TbDiaryAkLogic.class);

	/**
	 * レコード全権取得
	 * @return
	 * @throws Exception
	 */
	public List<TbDiaryAk> selectAll() throws Exception {
		List<TbDiaryAk> result = null;
		
		try {
			SqlSession session = sqlSessionFactory.openSession();
			// 設定ファイルに定義したmapperクラスをget
			TbDiaryAkMapper mapper = session.getMapper(TbDiaryAkMapper.class);
			
			result = mapper.selectAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
		return result;
	}

	/**
	 * 内容種別で検索する<br>
	 * @param subjectType 内容種別
	 * @return
	 * @throws Exception 
	 */
	public List<TbDiaryAk> selectSubjectTyp(String subjectType) throws Exception {
		List<TbDiaryAk> resList = null;
		try {
			SqlSession session = sqlSessionFactory.openSession();
			TbDiaryAkMapper mapper = session.getMapper(TbDiaryAkMapper.class);
			resList = mapper.selectSubjectType(subjectType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
		return resList;
	}
}
