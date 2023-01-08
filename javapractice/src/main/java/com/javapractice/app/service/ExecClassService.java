package com.javapractice.app.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapractice.app.constants.Constants;
import com.javapractice.app.logic.TbExecClassLogic;
import com.javapractice.app.mybatis.model.TbExecClass;
import com.javapractice.app.util.DateTimeUtil;

/**
 * クラス実行画面のServiceクラス
 * @author tatsuya
 *
 */
@Service
public class ExecClassService {

	/** ロジッククラス */
	@Autowired
	private TbExecClassLogic tbExecClassLogic;

	/** ログ */
	private static final Log logger = LogFactory.getLog(ExecClassService.class);

	/**
	 * クラス実行テーブルINSERT処理<br>
	 * 登録日時を取得し、ロジッククラスに渡す<br>
	 * @param logPrefix ログ接頭語
	 * @throws Exception 
	 */
	public void insertClassName(String className, String logPrefix) throws Exception {
		// INSERTのmodelクラス
		TbExecClass tbExecClass = new TbExecClass();
		tbExecClass.setClassName(className);
		tbExecClass.setExecFlg(Constants.STOP_EXEC_FLG);

		// 登録日時の取得する
		try {
			logger.info(logPrefix + "登録日時を取得します。");
			tbExecClass.setRegistDate(DateTimeUtil.getCurrentDateAndTime());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception("登録日時の取得に失敗しました。");
		}

		// DB登録処理
		tbExecClassLogic.insert(tbExecClass, logPrefix);
	}
}
