package com.javapractice.app.logic;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.javapractice.app.constants.Constants;
import com.javapractice.app.dto.ResponseRegistDiaryDto;
import com.javapractice.app.mybatis.client.TbDiaryMapper;
import com.javapractice.app.mybatis.model.TbDiary;
import com.javapractice.app.util.SqlSessionUtil;

/**
 * tb_diary(日誌テーブル)のロジッククラス<br>
 * Spring起動時、コンストラクタインジェクションが実行される
 * @author tatsuya
 *
 */
@Component
public class TbDiaryLogic {

	/** SqlSessionFactory */
	private SqlSessionFactory sqlSessionFactory;
	
	/** 
	 * コンストラクタ<br>
	 * SQL操作を行うためのSqlSessionをmybatis-config(設定ファイル)から読み込む
	 * @throws IOException 
	 */
	public TbDiaryLogic() throws IOException {
		this.sqlSessionFactory = SqlSessionUtil.getSqlSession();
	}

	/** ログ */
	private static final Log logger = LogFactory.getLog(TbDiaryLogic.class);

	/**
	 * レコード全権取得
	 * @return
	 * @throws Exception
	 */
	public List<TbDiary> selectAll() throws Exception {
		List<TbDiary> result = null;
		
		try {
			SqlSession session = sqlSessionFactory.openSession();
			// 設定ファイルに定義したmapperクラスをget
			TbDiaryMapper mapper = session.getMapper(TbDiaryMapper.class);
			
			result = mapper.selectAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
		return result;
	}

	/**
	 * 日誌番号の連番生成のためレコード数を検索<br>
	 * @param 現在日時yyyyMMdd形式(日誌番号に含まれるもの)
	 * @param ログ接頭語
	 * @return レコード数
	 * @throws Exception 
	 */
	public int countRecordForDiaryId(String date, String logPrefix) throws Exception {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			// 設定ファイルに定義したmapperクラスをget
			TbDiaryMapper mapper = session.getMapper(TbDiaryMapper.class);
			
			return mapper.countRecord(date);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
	}

	@Transactional
	public void insertDiary(TbDiary tbDiaryEntity, ResponseRegistDiaryDto responseDto, String logPrefix) throws Exception {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			TbDiaryMapper mapper = session.getMapper(TbDiaryMapper.class);
			int insertCnt = mapper.insert(tbDiaryEntity);
			logger.info(logPrefix + "日誌番号: " + tbDiaryEntity.getDiaryId() + ", 処理件数: " + insertCnt);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
		// 正常終了の場合、レスポンスDtoに日誌番号をsetし、プロセスフラグをtrueに
		responseDto.setRegistDiaryId(tbDiaryEntity.getDiaryId());
		responseDto.setProcessFlg(true);
	}

	/**
	 * 日時を受け取り、それより以前に登録されたレコードを削除する<br>
	 * @param houseKeepDate 登録日時比較用(現在日時の1ヵ月前の日時)
	 * @param logPrefx
	 * @throws Exception 
	 */
	@Transactional
	public void deleteHouseKeep(Timestamp houseKeepDate, String logPrefx) throws Exception {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			TbDiaryMapper mapper = session.getMapper(TbDiaryMapper.class);
			int deleteCnt = mapper.deleteHouseKeep(houseKeepDate);
			session.commit();
			logger.info(logPrefx + "登録日時=「" + houseKeepDate + "」以前のレコードを削除しました。" + "削除件数=「" + deleteCnt + "」");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
	}

	/**
	 * 内容種別で検索する<br>
	 * @param subjectType 内容種別
	 * @return
	 * @throws Exception 
	 */
	public List<TbDiary> selectSubjectTyp(String subjectType) throws Exception {
		List<TbDiary> resList = null;
		try {
			SqlSession session = sqlSessionFactory.openSession();
			TbDiaryMapper mapper = session.getMapper(TbDiaryMapper.class);
			resList = mapper.selectSubjectType(subjectType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Constants.DB_ERROR_MESSAGE);
		}
		return resList;
	}

}
