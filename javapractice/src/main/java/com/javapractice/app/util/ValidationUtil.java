package com.javapractice.app.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.ObjectUtils;

/**
 * チェック処理のユーティリティ
 * （本当は、文字列の正規表現とかでチェックを行う）
 * @author tatsuya
 *
 */
public class ValidationUtil {

	/**
	 * APIで入力された値(リクエストパラメータ)のバリデーションチェック<br>
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

	/**
	 * 数字が1～12か判定する
	 * @param num 数字
	 * @return 一致すればtrue, しなければfalse
	 */
	public static boolean checkMonth(String num) {
		Pattern pattern = Pattern.compile("[1-9]|1[0-2]");
		Matcher matcher = pattern.matcher(num);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
}
