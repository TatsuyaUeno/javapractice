package com.javapractice.app.dto;

/**
 * 条件検索画面のリクエストボディDto<br>
 * @author tatsuya
 *
 */
public class RequestViewDiarySearchDto {

	/** 内容種別(プルダウン検索) */
	private String subjectType;

	/** 日誌アーカイブテーブル表示フラグ(表示：ture、非表示：false) */
	private boolean tbDiaryAkFlg;

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public boolean isTbDiaryAkFlg() {
		return tbDiaryAkFlg;
	}

	public void setTbDiaryAkFlg(boolean tbDiaryAkFlg) {
		this.tbDiaryAkFlg = tbDiaryAkFlg;
	}
}
