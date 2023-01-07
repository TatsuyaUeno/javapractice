package com.javapractice.app.dto;

import java.util.List;

import com.javapractice.app.mybatis.model.TbDiary;

/**
 * 画面表示のレスポンス用Dto
 * @author tatsuya
 *
 */
public class ResponseViewDairyDto {

	/** tb_diaryテーブル表示用List */
	private List<TbDiary> tbDiaryList;

	/** エラーメッセージ(正常=空文字) */
	private String errorMessage;

	/**
	 * コンストラクタ<br>
	 * tbDiaryList Javaでnull判定<br>
	 * errorMessage JavaScriptで空文字判定<br>
	 */
	public ResponseViewDairyDto() {
		this.tbDiaryList = null;
		this.errorMessage = "";
	}

	public void setTbDiaryList(List<TbDiary> tbDiaryList) {
		this.tbDiaryList = tbDiaryList;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<TbDiary> getTbDiaryList() {
		return tbDiaryList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
