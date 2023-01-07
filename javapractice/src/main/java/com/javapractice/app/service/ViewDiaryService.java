package com.javapractice.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.javapractice.app.dto.ResponseViewDairyDto;
import com.javapractice.app.mybatis.model.TbDiary;

/**
 * 日誌表示のServiceクラス
 * @author tatsuya
 *
 */
@Service
public class ViewDiaryService {

	/**
	 * 入力された年月で検索する
	 * @param responseViewDairyDto 画面に返す値(List<TbDiary>, errorMessage)
	 * @param requstMap <year and month, 値>
	 * @return DB取得データ
	 */
	public List<TbDiary> selectRecord(Map<String, String> requestMap, ResponseViewDairyDto responseViewDairyDto) {
		return null;
	}
}
