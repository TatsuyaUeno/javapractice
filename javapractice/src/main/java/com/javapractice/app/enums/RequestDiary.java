package com.javapractice.app.enums;

/**
 * RequestBodyのkeyと必須項目か定義する
 * @author tatsuya
 *
 */

public enum RequestDiary {
	SUBJECT_TYPE("subjectType", true),
	TITLE("title", true), 
	CONTENT_1("content1", true),
	CONTENT_2("content2", false),
	CONTENT_3("content3", false),
	REMARKS("remarks", false);

	/** リクエストボディ（Map<String, String>)のkey */
	private String key;

	/** 必須項目か(必須：true, 必須ではない:false) */
	private boolean isRequiedFiled;

	private RequestDiary(String key, boolean isRequiedFiled) {
		this.key = key;
		this.isRequiedFiled = isRequiedFiled;
	}

	public String getKey() {
		return key;
	}

	public boolean isRequiedFiled() {
		return isRequiedFiled;
	}
}
