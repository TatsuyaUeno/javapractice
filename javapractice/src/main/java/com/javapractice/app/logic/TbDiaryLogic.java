package com.javapractice.app.logic;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.javapractice.app.dto.ResponseDiaryDto;
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

	/** 
	 * コンストラクタ<br>
	 * SQL操作を行うためのSqlSessionをmybatis-config(設定ファイル)から読み込む
	 * @throws IOException 
	 */
	public TbDiaryLogic() throws IOException {
		this.sqlSessionFactory = SqlSessionUtil.getSqlSession();
	}

	private static final String ERROR_MESSAGE = "DB操作で予期せぬエラーが発生しました。";

	/** SqlSessionFactory */
	private SqlSessionFactory sqlSessionFactory;

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
			System.out.println(e);
			throw new Exception();
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
			logger.warn(ERROR_MESSAGE, e);
			throw new Exception(ERROR_MESSAGE);
		}
	}

	@Transactional
	public void insertDiary(TbDiary tbDiaryEntity, ResponseDiaryDto responseDto, String logPrefix) throws Exception {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			TbDiaryMapper mapper = session.getMapper(TbDiaryMapper.class);
			int insertCnt = mapper.insert(tbDiaryEntity);
			logger.info(logPrefix + "日誌番号: " + tbDiaryEntity.getDiaryId() + ", 処理件数: " + insertCnt);
			session.commit();
		} catch (Exception e) {
			logger.warn(ERROR_MESSAGE, e);
			throw new Exception(ERROR_MESSAGE);
		}
		// 正常終了の場合、レスポンスDtoに日誌番号をsetし、プロセスフラグをtrueに
		responseDto.setRegistDiaryId(tbDiaryEntity.getDiaryId());
		responseDto.setProcessFlg(true);
	}

}
