package com.javapractice.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javapractice.app.dto.RequestViewDiarySearchDto;
import com.javapractice.app.dto.ResponseRegistDiaryDto;
import com.javapractice.app.dto.ResponseViewDairyDto;
import com.javapractice.app.logic.TbDiaryAkLogic;
import com.javapractice.app.logic.TbDiaryLogic;
import com.javapractice.app.mybatis.model.TbDiary;
import com.javapractice.app.mybatis.model.TbDiaryAk;
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

	/** ロジッククラス */
	@Autowired
	private TbDiaryLogic tbDiaryLogic;
	@Autowired
	private TbDiaryAkLogic tbDiaryAkLogic;
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
	 * 日誌検索画面<br>
	 * 初期表示は日誌テーブル(tb_diary)のみ表示する<br>
	 * 検索機能で内容種別の選択と日誌アーカイブテーブル(tb_diary_ak)の表示・非表示を選択できるようにする<br>
	 * ※検索ボタン押下後、検索用の別画面にいく<br>
	 * @param model JSP表示用
	 * @return
	 */
	@GetMapping("/view/diary")
	public String viewDiary(Model model) {
		// ログの接頭語
		String logPrefix = "【日誌検索画面】";

		// プルダウンリスト
		List<String> pullDownList = null;
		// DB表示で使用する値
		List<TbDiary> tbDiaryList = null;
		List<TbDiaryAk> tbDairyAkList = null;
		String errorMessage = "";

		try {
			logger.info(logPrefix + "内容種別のプルダウンを取得します。");
			// 内容種別プルダウンの取得し、jspで使えるようにセットする
			pullDownList = viewDiaryService.getPullDown();
			model.addAttribute("pullDownList", pullDownList);

			// DB検索する
			logger.info(logPrefix + "日誌テーブル検索をします。");
			tbDiaryList = tbDiaryLogic.selectAll();
			model.addAttribute("tbDiaryList", tbDiaryList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			errorMessage = e.getMessage();
		}
		model.addAttribute("errorMessage", errorMessage);
		return "viewDiary";
	}

	/**
	 * 日誌表示、検索後画面<br>
	 * 画面から受け取った値で結果を表示する<br>
	 * @param model JSP表示用
	 * @param requestDto JavaScriptから送られてくるリクエストボディ
	 * @return
	 */
	@PostMapping("/view/diary/search")
	public String viewDiarySearch(Model model, @RequestBody RequestViewDiarySearchDto requestDto) {
		// エラーメッセージ
		List<String> errorMessageList = new ArrayList<String>();
		// プルダウン用の値
		List<String> pullDownList = null;
		// DB表示で使用する値
		List<TbDiary> tbDiaryList = null;
		List<TbDiaryAk> tbDiaryAkList = null;

		// 画面から受け取った内容種別
		String subjectType = requestDto.getSubjectType();
		// 内容種別に値が含まれているかどうかの判定
		boolean selectSubjectTypeFlg = Objects.isNull(subjectType) || subjectType == "";

		try {
			// 内容種別プルダウンの取得し、jspで使えるようにセットする
			pullDownList = viewDiaryService.getPullDown();
			// プルダウンが取得できなかった場合、エラーメッセージに値をセット
			if (Objects.isNull(pullDownList)) {
				errorMessageList.add("プルダウンが取得できませんでした。");
			}

			// 日誌テーブル検索(内容種別に値が含まれていれば検索条件に使い、空の場合全件取得)
			if (selectSubjectTypeFlg) {
				// 全件取得
				tbDiaryList = tbDiaryLogic.selectAll();
			} else {
				// 条件検索
				tbDiaryList = tbDiaryLogic.selectSubjectTyp(subjectType);
			}

			// 日誌アーカイブテーブル検索(検索するしないを画面から受け取る)
			if (requestDto.isTbDiaryAkFlg()) {
				if (selectSubjectTypeFlg) {
					// 全件取得
					tbDiaryAkList = tbDiaryAkLogic.selectAll();
				} else {
					// 条件検索
					tbDiaryAkList = tbDiaryAkLogic.selectSubjectTyp(subjectType);
				}
			}
		} catch (Exception e) {
			errorMessageList.add(e.getMessage());
		}

		// 1件も取得できなかった場合、エラーメッセージにセット
		if (tbDiaryList.isEmpty() && tbDiaryAkList.isEmpty()) {
			errorMessageList.add("検索条件に該当するレコードを1件も取得できませんでした。");
		}

		// JSPで使用する値をセット
		model.addAttribute("pullDownList", pullDownList);
		model.addAttribute("errorMessageList", errorMessageList);
		model.addAttribute("tbDiaryList", tbDiaryList);
		model.addAttribute("tbDiaryAkList", tbDiaryAkList);
		return "viewDiarySearch";
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
