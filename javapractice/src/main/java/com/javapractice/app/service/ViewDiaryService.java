package com.javapractice.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.javapractice.app.dto.ResponseViewDairyDto;
import com.javapractice.app.enums.ViewDiaryPullDown;
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

	/**
	 * 日誌検索画面初期表示用<br>
	 * プルダウンを
	 * @param logPrefix ログ接頭語
	 * @return List<プルダウン項目>
	 */
	public List<String> getPullDown() {
		List<String> pullDownList = new ArrayList<String>();
		for (ViewDiaryPullDown pullDownEnum: ViewDiaryPullDown.values()) {
			pullDownList.add(pullDownEnum.getPullDownName());
		}
		return pullDownList;
	}
}
