package com.javapractice.app.runner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * テストHOGERunner<br>
 * @author tatsuya
 *
 */
public class HogePrintRunner {

	private static final Log logger = LogFactory.getLog(HogePrintRunner.class);

	public void execEvent(String arg) {
		logger.info("HOGE");
	}
}
