package com.javapractice.app.runner;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javapractice.app.logic.TbDiaryLogic;
import com.javapractice.app.util.DateTimeUtil;

/**
 * クラス実行画面から実行する<br>
 * 本クラス起動日時から30日以前に登録されたレコードを削除する<br>
 * 登録日時から対象レコードを決定する<br>
 * @author tatsuya
 *
 */
public class HouseKeepTbDiaryRunner {

	/** ログ */
	private static final Log logger = LogFactory.getLog(HouseKeepTbDiaryRunner.class);

	/** ハウスキープ保存期間(1ヵ月) */
	private static final int HOUSE_KEEP_MONTH = -1;

	/**
	 * クラス実行テーブル監視スレッドから最初に呼ばれるメソッド<br>
	 * @param arg 使用しない
	 */
	public void execEvent(String arg) {
		// ログ接頭語
		String logPrefix = "【ハウスキープ処理：日誌テーブル】";
		try {
			logger.info(logPrefix + "処理を開始します。");
			// 本処理
			this.houseKeep(logPrefix);
		} catch (Exception e) {
			logger.error(logPrefix + e.getMessage());
		}
		logger.info(logPrefix + "処理を終了します。");
	}

	/**
	 * 本処理
	 * @param logPrefix ログ接頭語
	 * @throws Exception 
	 */
	@SuppressWarnings("deprecation")
	private void houseKeep(String logPrefx) throws Exception {
		try {
			// 現在日時を取得し、1ヵ月前の値をセットする
			Timestamp houseKeepDate = DateTimeUtil.getCurrentDateAndTime();
			houseKeepDate.setMonth(HOUSE_KEEP_MONTH);

			// スレッド起動で呼び出されたため、本クラスはDI管理されていない
			// よってアノテーションが使えないので、下記のような形でコンテナからコンポーネントを取得して使用する
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			TbDiaryLogic tbDiaryLogic = ctx.getBean(TbDiaryLogic.class);
			
			// 1ヵ月前に登録されたレコードを削除する
			tbDiaryLogic.deleteHouseKeep(houseKeepDate, logPrefx);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("houseKeepメソッドで例外が発生しました。");
		}
	}
}
