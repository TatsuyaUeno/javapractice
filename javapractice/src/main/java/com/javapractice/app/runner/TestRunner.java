package com.javapractice.app.runner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * クラス実行テストRunner<br>
 * @author tatsuya
 *
 */
public class TestRunner {

	/** ログ */
	private static final Log logger = LogFactory.getLog(TestRunner.class);

	public void execEvent(String arg) {
		logger.info("ここに行いたい処理を書けば良い感じかも");
	}
}
