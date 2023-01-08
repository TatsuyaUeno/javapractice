package com.javapractice.app.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.javapractice.app.constants.Constants;
import com.javapractice.app.dto.ResponseExecClassDto;
import com.javapractice.app.logic.TbExecClassLogic;
import com.javapractice.app.mybatis.model.TbExecClass;
import com.javapractice.app.service.ExecClassService;

/**
 * クラス実行画面のコントローラー<br>
 * @author tatsuya
 *
 */
@Controller
@CrossOrigin(origins = "*")
public class ExecClassController {

	/** サービスクラス */
	@Autowired
	private ExecClassService execClassService;

	/** ロジッククラス */
	@Autowired
	private TbExecClassLogic tbExecClassLogic;

	/** ログ */
	private static final Log logger = LogFactory.getLog(ExecClassController.class);

	/**
	 * 画面初期表示<br>
	 * @return
	 */
	@GetMapping("/exec/class")
	public String execClass(Model model) {
		List<TbExecClass> tbExecClassList = new ArrayList<TbExecClass>();
		// エラーメッセージ
		String errorMessage = "";

		// DB検索
		try {
			tbExecClassList = tbExecClassLogic.selectAll();
			// 1件も取得できなかった場合、エラーメッセージ
			if (tbExecClassList.isEmpty()) {
				errorMessage = "レコードを1件も取得できませんでした。";
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			errorMessage = e.getMessage();
		}

		// 画面で使う値をmodelにセット
		model.addAttribute("tbExecClassList", tbExecClassList);
		model.addAttribute("errorMessage", errorMessage);
		return "execClass";
	}

	/**
	 * 登録ボタン押下後<br>
	 * 画面で入力されたクラス名をDBに登録する<br>
	 * 実行フラグは初期値をDBで設定済(初期値 = 0)<br>
	 * 登録日時は取得し登録<br>
	 * 備考は直接DBで入れればいいや<br>
	 * @param className
	 * @return Dto = className, errorMessage
	 */
	@ResponseBody
	@PostMapping("/insert/class")
	public ResponseExecClassDto insertClassName(@RequestBody String className) {
		String logPrefix = "【クラス名INSERT処理】";

		// レスポンスDto
		ResponseExecClassDto resDto = new ResponseExecClassDto();

		// 例外処理はココで行い、catchに入ればエラー文を入れる
		try {
			logger.info(logPrefix + "処理を開始します。");
			execClassService.insertClassName(className, logPrefix);
			// 成功した場合、空文字をセットする
			resDto.setErrorMessage(Constants.EMPTY_CHAR);
		} catch (Exception e) {
			logger.error(e.getMessage());
			resDto.setErrorMessage(e.getMessage());
		}

		resDto.setClassName(className);
		logger.info(logPrefix + "処理を終了します。");
		return resDto;
	}

	/**
	 * 実行ボタン押下後<br>
	 * 画面で入力されたクラス名から実行フラグを1に更新する<br>
	 * @param className
	 * @return Dto = className, errorMessage
	 */
	@ResponseBody
	@PostMapping("/update/flg")
	public ResponseExecClassDto updateExecFlg(@RequestBody String className) {
		String logPrefix = "【実行フラグ更新処理】";

		// レスポンスDto
		ResponseExecClassDto resDto = new ResponseExecClassDto();

		// 例外処理はココで行い、catchに入ればエラー文を入れる
		try {
			logger.info(logPrefix + "処理を開始します。");
			tbExecClassLogic.updateExecFlg(className, Constants.START_EXEC_FLG, logPrefix);
			// 成功した場合、空文字をセットする
			resDto.setErrorMessage(Constants.EMPTY_CHAR);
		} catch (Exception e) {
			logger.error(e.getMessage());
			resDto.setErrorMessage(e.getMessage());
		}

		resDto.setClassName(className);
		logger.info(logPrefix + "処理を終了します。");
		return resDto;
	}
}
