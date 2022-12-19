package com.javapractice.app.dto;

/**
 * 日誌登録のレスポンス
 * @author tatsuya
 *
 */
public class ResponseDiaryDto {

	/** 登録した日誌番号 */
	private String registDiaryId;

	/** 処理判定 */
	private boolean processFlg;

	/** エラーメッセージ */
	private String errorMessage;

	/**
	 * コンストラクタ<br>
	 * 初期値：<br>
	 * errorMessage = 空文字<br>
	 * processFlg = false
	 */
	public ResponseDiaryDto() {
		this.errorMessage = "";
		this.processFlg = false;
	}

	public String getRegistDiaryId() {
		return registDiaryId;
	}

	public void setRegistDiaryId(String registDiaryId) {
		this.registDiaryId = registDiaryId;
	}

	public boolean isProcessFlg() {
		return processFlg;
	}

	public void setProcessFlg(boolean processFlg) {
		this.processFlg = processFlg;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
