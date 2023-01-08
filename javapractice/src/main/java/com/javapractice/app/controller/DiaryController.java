package com.javapractice.app.controller;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javapractice.app.dto.ResponseRegistDiaryDto;
import com.javapractice.app.dto.ResponseViewDairyDto;
import com.javapractice.app.service.RegistDiaryService;
import com.javapractice.app.service.ViewDiaryService;

/**
 * 日誌に関するコントローラー
 * @author tatsuya
 *
 */
@Controller
@CrossOrigin(origins = "*")
public class DiaryController {

	/** ログ */
	private static final Log logger = LogFactory.getLog(DiaryController.class);

	/** Serviceクラス */
	@Autowired
	private RegistDiaryService registDiaryService;
	@Autowired
	private ViewDiaryService viewDiaryService;

/** --------------------登録画面-------------------------- */

	/**
	 * 日誌登録画面
	 * @return
	 */
	@GetMapping("/regist/diary")
	public String registDiary() {
		return "registDiary";
	}

	/**
	 * 画面から入力値を受け取り、tb_diaryに登録する<br>
	 * ResponseBody はControllerでhtmlを参照しないようにするため
	 * @param requestMap 画面で入力された値
	 * @return errorMessageMap エラーがなければvalue="", あればvalue="エラー文"
	 */
	@ResponseBody
	@PostMapping("/regist/diary/insertDiary")
	public ResponseRegistDiaryDto insertDiary(@RequestBody HashMap<String, String> requestMap) {
		// レスポンス用Dto
		ResponseRegistDiaryDto responseDto = new ResponseRegistDiaryDto();

		// ログの頭文字
		String logPrefix = "【日誌登録処理】 ";

		logger.info(logPrefix + "処理を開始します。");

		try {
			// 本処理
			registDiaryService.insertDiary(requestMap, responseDto, logPrefix);
			logger.info(logPrefix + "処理を終了します。");
		} catch(IllegalArgumentException iae) {
			// 必須項目が入力されていなかった場合
			logger.warn(iae);
			responseDto.setErrorMessage(iae.getMessage());
		} catch(Exception e) {
			// その他システムのエラー
			String errorMessage = "予期せぬエラーが発生しました。";
			logger.warn(errorMessage, e);
			responseDto.setErrorMessage(errorMessage);
		}
		return responseDto;
	}

/** --------------------表示画面-------------------------- */

	/**
	 * 日誌表示画面
	 * @return
	 */
	@GetMapping("/view/diary")
	public String viewDiary() {
		return "viewDiary";
	}

	/**
	 * 画面表示用<br>
	 * 画面で入力された月のデータを返す<br>
	 * 0が入力された場合、その年のすべてのデータを返す<br>
	 * @param Map<String, String> (year or month, 値)
	 * @return tb_diaryの取得したレコード(DB身取得の場合、nullを返す)
	 */
	@ResponseBody
	@PostMapping("/view/diary/view")
	public ResponseViewDairyDto selectAll(@RequestBody HashMap<String, String> requestMap) {
		// 戻り値
		ResponseViewDairyDto responseViewDairyDto = new ResponseViewDairyDto();

		// requestMapに値がなければ即返す
		for (String key: requestMap.keySet()) {
			if (requestMap.get(key).isEmpty()) {
				responseViewDairyDto.setErrorMessage("年月を入力してください。");
				return responseViewDairyDto;
			}
		}

		try {
			viewDiaryService.selectRecord(requestMap, responseViewDairyDto);
		} catch (Exception e) {
			logger.warn("予期せぬエラーが発生しました。");
			responseViewDairyDto.setErrorMessage("予期せぬエラーが発生しました。");
			e.printStackTrace();
		}
		return responseViewDairyDto;
	}
}
