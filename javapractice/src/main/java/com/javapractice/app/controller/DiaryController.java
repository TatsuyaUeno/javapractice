package com.javapractice.app.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javapractice.app.dto.ResponseDiaryDto;
import com.javapractice.app.logic.TbDiaryLogic;
import com.javapractice.app.mybatis.model.TbDiary;
import com.javapractice.app.service.RegistDiaryService;

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

	/** ロジッククラス */
	@Autowired
	private TbDiaryLogic tbDiaryLogic;

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
	@PostMapping("regist/diary/insertDiary")
	public ResponseDiaryDto insertDiary(@RequestBody HashMap<String, String> requestMap) {
		// レスポンス用Dto
		ResponseDiaryDto responseDto = new ResponseDiaryDto();

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
	 * 画面表示お試し用
	 * @return
	 */
	@ResponseBody
	@PostMapping("/view/diary/selectAll")
	public List<TbDiary> selectAll() {
		// TODO お試しなので後で消すかも

		// 画面に送る値
		List<TbDiary> tbDiaryList = null;
		try {
			tbDiaryList = tbDiaryLogic.selectAll();
		} catch (Exception e) {
			System.out.println("DB接続でエラーが発生しました。");
			e.printStackTrace();
		}
		return tbDiaryList;
	}
}
