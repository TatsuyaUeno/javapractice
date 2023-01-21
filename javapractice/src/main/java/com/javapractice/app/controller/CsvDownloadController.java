package com.javapractice.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javapractice.app.enums.TableNamePullDown;
import com.javapractice.app.service.CsvDownloadService;

/**
 * csvダウンロード画面のコントローラー
 * @author tatsuya
 *
 */
@Controller
@CrossOrigin(origins = "*")
public class CsvDownloadController {

	@Autowired
	private CsvDownloadService csvDownloadService;

	/**
	 * 初期表示<br>
	 * 初期表示からgetメソッドでRequestParamでエラーが出ないために呼び出す<br>
	 * リンク＝/csv/download?tableName=<br>
	 * @return
	 */
	@GetMapping("/csv/download")
	public String index(HttpServletRequest request, HttpServletResponse response, @RequestParam("tableName") String tableName, Model model) {
		// テーブル名をプルダウンで表示するために取得する
		List<String> pullDownList = new ArrayList<String>();
		for (TableNamePullDown tableNamePullDown: TableNamePullDown.values()) {
			pullDownList.add(tableNamePullDown.getTableName());
		}

		// Modelに設定する
		model.addAttribute("pullDownList", pullDownList);

		/** 初期表示→プルダウン選択とダウンロードボタン押下後用 */
		// RequestParamが空文字の場合、初期遷移になるのでskip
		if (!(Objects.isNull(tableName) || tableName == "")) {
			// csvを作成する
			csvDownloadService.makeCsv(request, response, tableName);
		}

		return "csvDownload";
	}
}
