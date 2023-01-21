package com.javapractice.app.enums;

/**
 * テーブル名を取得するためのenum
 * @author tatsuya
 *
 */
public enum TableNamePullDown {
	TB_DIARY("tb_diary"),
	TB_DIARY_AK("tb_diary_ak"),
	TB_EXEC_CLASS("tb_exec_class");

	/**
	 * コンストラクタ
	 * @param tableName
	 */
	TableNamePullDown(String tableName) {
		this.tableName = tableName;
	}

	/** テーブル名 */
	private String tableName;

	public String getTableName() {
		return tableName;
	}
}
