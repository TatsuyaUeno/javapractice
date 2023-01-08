package com.javapractice.app.dto;

/**
 * ExecClassControllerでinsert処理のレスポンス用<br>
 * @author tatsuya
 *
 */
public class ResponseExecClassDto {

	/** クラス名 */
	private String className;

	/** エラーメッセージ(空=成功) */
	private String errorMessage;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
