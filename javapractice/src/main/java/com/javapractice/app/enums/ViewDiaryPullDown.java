package com.javapractice.app.enums;

/**
 * 日誌検索画面の内容種別検索用プルダウン<br>
 * 内容種別を増やす場合、こちらに追加してください<br>
 * @author tatsuya
 *
 */
public enum ViewDiaryPullDown {
	NO_TEXT(""), // 検索条件で指定しなかった場合
	JAVA("Java"),
	DIARY("日誌"),
	BUSINESS("業務"),
	VUE_JS("Vue");

	/** プルダウンの項目名 */
	private String pullDownName;

	ViewDiaryPullDown(String pullDownName) {
		this.pullDownName = pullDownName;
	}

	public String getPullDownName() {
		return this.pullDownName;
	}
}
