package com.javapractice.app.constants;

/**
 * 文字列のコンスタント
 * @author tatsuya
 *
 */
public class Constants {

	/** 文字列 */
	public static final String UNDER_SCORE = "_";
	public static final String EMPTY_CHAR = "";

	/** メッセージ */
	public static final String DB_ERROR_MESSAGE = "DB接続でエラーが発生しました。";

	/** クラス実行テーブル.処理フラグ */
	public static final String STOP_EXEC_FLG = "0";
	public static final String START_EXEC_FLG = "1";

	/** csv出力のためのheader */
	public static final String TB_DIARY_HEADER = "\"日誌番号\",\"内容種別\",\"タイトル\",\"内容1\",\"内容2\",\"内容3\",\"登録日時\",\"備考\"";
	public static final String TB_DIARY_AK_HEADER = "\"日誌番号\",\"内容種別\",\"タイトル\",\"内容1\",\"内容2\",\"内容3\",\"登録日時\",\"備考\"";
	public static final String TB_EXEC_CLASS_HEADER = "\"クラス名\",\"実行フラグ\",\"登録日時\",\"備考\"";

	/** csv関連定数 */
	public static final String RETURN_LF = "\n";
	public static final String CSV_SPLITTER = ",";
}
