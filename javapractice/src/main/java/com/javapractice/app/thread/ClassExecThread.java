package com.javapractice.app.thread;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javapractice.app.constants.Constants;
import com.javapractice.app.logic.TbExecClassLogic;

/**
 * Spring起動時に起動するThread<br>
 * クラス実行テーブルを監視するスレッド<br>
 * ※Runner(画面から実行したいクラス)を新しく実装する場合、下記パッケージ配下に作成すること<br>
 * com.javapractice.app.runner<br>
 * ※Runnerには、execEvent(String arg)メソッドを用意すること<br>
 * @author tatsuya
 *
 */
@Component
public class ClassExecThread extends Thread {

	/** ロジッククラス */
	@Autowired
	private TbExecClassLogic tbExecClassLogic;

	/** ログ */
	private static final Log logger = LogFactory.getLog(ClassExecThread.class);

	/** ログ接頭語 */
	private static final String logPrefix = "【クラス実行テーブル監視スレッド】";

	/** runnerパッケージパス */
	private static final String RUNNER_PACKAGE = "com.javapractice.app.runner.";

	/** Runnerの呼出しメソッド */
	private static final String METHOD_NAME = "execEvent";

	/**
	 * クラス実行テーブルの監視
	 */
	@SuppressWarnings("deprecation")
	public void run() {
		boolean flg = true;
		while (flg) {
			logger.info(logPrefix + "監視中...");
			List<String> classNameList = null;

			// 実行フラグ = 1で実行フラグテーブルを検索
			try {
				classNameList = tbExecClassLogic.selectActiveExecFlg();
				// 取得したクラス名分クラスを起動させる
				for (String className: classNameList) {
					// リフレクション(文字列のクラス名からメソッド起動)
					try {
						Class<?> c = Class.forName(RUNNER_PACKAGE + className);
						Object obj = c.newInstance();
						Method m = c.getMethod(METHOD_NAME, String.class);
						m.invoke(obj, "");

						logger.info(logPrefix + "クラス名=[" + className + "]を起動に成功しました。");
					} catch (ClassNotFoundException cnfe) {
						// クラスが存在しない場合、クラス名をログに表示する
						logger.warn(logPrefix + "クラスが存在しません。クラス名=[" + className + "]");
					} finally {
						// テスト用Hogeは実行フラグを落とさない
						if (!className.equals("HogePrintRunner")) {
							tbExecClassLogic.updateExecFlg(className, Constants.STOP_EXEC_FLG, logPrefix);
							logger.info(logPrefix + "クラス名=[" + className + "]の実行フラグを落としました。");
						}
					}
				}
				// 30秒ごとに監視するため、スレッドを30秒停止
				Thread.sleep(30000);
			} catch (InterruptedException ie) {
				logger.info(logPrefix + "Thread.sleepに失敗しました。");
			} catch (Exception e) {
				logger.error(logPrefix + e);
				e.printStackTrace();
				logger.error(logPrefix + "エラーが発生したため、監視を停止します。");
				flg = false;
			}
		}
	}
}
