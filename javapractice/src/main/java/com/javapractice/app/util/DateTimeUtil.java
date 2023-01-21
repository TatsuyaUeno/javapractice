package com.javapractice.app.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日時に関するユーティリティ
 * @author tatsuya
 *
 */
public class DateTimeUtil {

	/**
	 * 現在の日時を取得<br>
	 * @return yyyy/MM/dd HH:mm:ss:SSS
	 */
	public static Timestamp getCurrentDateAndTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 今日の日付をyyyyMMddの文字列で返す
	 * @return yyyyMMdd(例：20220901)
	 */
	public static String getNowDate_yyyyMMdd() {
		// 現在の時間を取得
		LocalDateTime nowDate = LocalDateTime.now();

		// フォーマットを指定
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");

		// フォーマット指定した文字列を返す
		return nowDate.format(format);
	}

	/**
	 * 現在の日時をyyyyMMddhhmmssの文字列で返す<br>
	 * @return nowDate
	 */
	public static String getNowDate_yyyyMMddhhmmss() {
		// 現在の時間を取得
		LocalDateTime nowDate = LocalDateTime.now();

		// フォーマットを指定
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");

		// フォーマット指定した文字列を返す
		return nowDate.format(format);
	}
}
