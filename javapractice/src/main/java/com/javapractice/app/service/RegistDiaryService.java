package com.javapractice.app.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapractice.app.dto.ResponseRegistDiaryDto;
import com.javapractice.app.enums.RequestDiary;
import com.javapractice.app.logic.TbDiaryLogic;
import com.javapractice.app.mybatis.model.TbDiary;
import com.javapractice.app.util.AppUtil;
import com.javapractice.app.util.DateTimeUtil;
import com.javapractice.app.util.ValidationUtil;

/**
 * 日誌登録のServiceクラス
 * @author tatsuya
 *
 */
@Service
public class RegistDiaryService {

	/** ロジッククラス */
	@Autowired
	private TbDiaryLogic tbDiaryLogic;

	/** 日誌番号の接頭語 */
	private static final String DIARY_ID_PREFIX_N = "N";

	/** ログ */
	private static final Log logger = LogFactory.getLog(RegistDiaryService.class);

	/**
	 * 画面から値を受け取りDB登録を行う本処理
	 * @param requestMap
	 * @param responseDto 
	 * @return
	 */
	public ResponseRegistDiaryDto insertDiary(Map<String, String> requestMap, ResponseRegistDiaryDto responseDto, String logPrefix) throws Exception {
		// リクエストボディから値をEntityクラスに詰める
		TbDiary tbDiaryEntity = new TbDiary();
		tbDiaryEntity.setSubjectType(requestMap.get(RequestDiary.SUBJECT_TYPE.getKey()));
		tbDiaryEntity.setTitle(requestMap.get(RequestDiary.TITLE.getKey()));
		tbDiaryEntity.setContent1(requestMap.get(RequestDiary.CONTENT_1.getKey()));
		tbDiaryEntity.setContent2(requestMap.get(RequestDiary.CONTENT_2.getKey()));
		tbDiaryEntity.setContent3(requestMap.get(RequestDiary.CONTENT_3.getKey()));
		tbDiaryEntity.setRemarks(requestMap.get(RequestDiary.REMARKS.getKey()));

		// 必須項目チェック処理（引っかかってしまった場合→ValidationError)
		if (!(ValidationUtil.checkRequiedFiled(tbDiaryEntity.getSubjectType(), RequestDiary.SUBJECT_TYPE.isRequiedFiled())
				&& ValidationUtil.checkRequiedFiled(tbDiaryEntity.getTitle(), RequestDiary.TITLE.isRequiedFiled())
				&& ValidationUtil.checkRequiedFiled(tbDiaryEntity.getContent1(), RequestDiary.CONTENT_1.isRequiedFiled())
				&& ValidationUtil.checkRequiedFiled(tbDiaryEntity.getContent2(), RequestDiary.CONTENT_2.isRequiedFiled())
				&& ValidationUtil.checkRequiedFiled(tbDiaryEntity.getContent3(), RequestDiary.CONTENT_3.isRequiedFiled())
				&& ValidationUtil.checkRequiedFiled(tbDiaryEntity.getRemarks(), RequestDiary.REMARKS.isRequiedFiled())
				)) {
			throw new IllegalArgumentException("必須項目が入力されていません。");
		}
		logger.info(logPrefix + "必須項目チェックが完了しました。");

		// 日誌管理番号の生成
		tbDiaryEntity.setDiaryId(this.getDiaryId(logPrefix));

		// 登録日時の取得
		tbDiaryEntity.setRegistDate(DateTimeUtil.getCurrentDateAndTime());
		logger.info(logPrefix + "日誌番号・登録日時を取得しました。"
				+ "日誌番号: " + tbDiaryEntity.getDiaryId());

		// データベース登録
		logger.info(logPrefix + "DB登録処理を開始します。");
		tbDiaryLogic.insertDiary(tbDiaryEntity, responseDto, logPrefix);
		logger.info(logPrefix + "DB登録処理を終了します。");
		return responseDto;
	}

	/**
	 * 日誌管理.日誌番号の発行<br>
	 * 例：N20220901_1(N年月日_連番)
	 * @param ログ接頭語
	 * @return diaryId(日誌番号)
	 * @throws Exception 
	 */
	private String getDiaryId(String logPrefix) throws Exception {
		logger.info(logPrefix + "日誌番号生成処理");
		// 年月日の取得
		String yyyyMMdd = DateTimeUtil.getNowDate_yyyyMMdd();

		// 連番を決定、0件なら1なので+1(上記yyyyMMddが日誌番号に含まれるレコード数)
		int seriralNum = tbDiaryLogic.countRecordForDiaryId(yyyyMMdd, logPrefix) + 1;
		String seriralNumStr = String.valueOf(seriralNum);
		
		// 日誌番号の形式に文字列を連結
		String diaryId = AppUtil.conectStrToUnderscore(DIARY_ID_PREFIX_N, yyyyMMdd, seriralNumStr);
		return diaryId;
	}
}
