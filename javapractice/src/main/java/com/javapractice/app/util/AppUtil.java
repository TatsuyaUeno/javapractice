package com.javapractice.app.util;

import com.javapractice.app.constants.Constants;

/**
 * アプリのユーティリティ<br>
 * 共通処理を定義する
 * @author tatsuya
 *
 */
public class AppUtil {

	/**
	 * 引数の文字を「_」で連結する<br>
	 * [0]_[1]_[2]
	 * @param strs
	 * @return アンダースコアで連結した文字列
	 */
	public static String conectStrToUnderscore(String... strs) {
		// 戻り値
		StringBuilder strBuildser = new StringBuilder();
		for (String str: strs) {
			strBuildser.append(str);
			strBuildser.append(Constants.UNDER_SCORE);
		}
		// 末尾の不必要なアンダースコアを削除
		String res = strBuildser.toString();
		res = res.substring(0, res.length() - 1);
		
		return res;
	}
}
