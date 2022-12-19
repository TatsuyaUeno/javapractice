package com.javapractice.app.util;

import org.springframework.util.ObjectUtils;

/**
 * チェック処理のユーティリティ
 * （本当は、文字列の正規表現とかでチェックを行う）
 * @author tatsuya
 *
 */
public class ValidationUtil {

	/**
	 * APIで入力された値のバリデーションチェック<br>
	 * 画面で入力された値とその項目が必須かどうかのboolean
	 * @param inputValue 画面の入力値
	 * @param isRequiedFiled リクエストenumに保持している必須項目かどうかのboolean
	 * @return true(必須でない or 必須かつ値が入っている), 違ければfalse(必須かつ値がない)
	 */
	public static boolean checkRequiedFiled(Object inputValue, boolean isRequiedFiled) {
		// 必須でなければ処理を返す
		if (!isRequiedFiled) {
			return true;
		}
		// 入力文字の空文字チェック
		if (!ObjectUtils.isEmpty(inputValue)) {
			return true;
		}

		// 必須で値がなかった場合
		return false;
	}
}
