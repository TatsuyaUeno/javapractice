package com.javapractice.app.service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapractice.app.constants.Constants;
import com.javapractice.app.logic.TbDiaryAkLogic;
import com.javapractice.app.logic.TbDiaryLogic;
import com.javapractice.app.logic.TbExecClassLogic;
import com.javapractice.app.mybatis.model.TbDiary;
import com.javapractice.app.mybatis.model.TbDiaryAk;
import com.javapractice.app.mybatis.model.TbExecClass;
import com.javapractice.app.util.DateTimeUtil;

/**
 * csvダウンロードのServiceクラス
 * @author tatsuya
 *
 */
@Service
public class CsvDownloadService {

	/** ロジッククラス */
	@Autowired
	private TbDiaryLogic tbDiaryLogic;
	@Autowired
	private TbDiaryAkLogic tbDiaryAkLogic;
	@Autowired
	private TbExecClassLogic tbExecClassLogic;

	/**
	 * 受け取ったテーブル名から全レコードを取得<br>
	 * 取得レコードからcsvを作成する<br>
	 * @param response 
	 * @param request 
	 * @param tableName テーブル名
	 * @return csv csv出力用文字列
	 */
	public void makeCsv(HttpServletRequest request, HttpServletResponse response, String tableName) {
		// 戻り値
		String csv = null;

		try {
			// ファイル名の現在日時を取得
			String nowDate = DateTimeUtil.getNowDate_yyyyMMddhhmmss();

			// レスポンスの設定
			response.setHeader("Content-Type", "text/csv; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(tableName + Constants.UNDER_SCORE + nowDate + ".csv", "UTF-8") + "\"");

			// csv作成用の文字列取得
			csv = this.getCsv(tableName);

			// BOMの付与
			ServletOutputStream outputStream = this.addBom(response.getOutputStream());

			// csv書き込む
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
			outputStreamWriter.write(csv);
			outputStreamWriter.flush();
			outputStreamWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * テーブルごとに出力用のデータを作成する<br>
	 * テーブル追加する場合はこちらに追加してください<br>
	 * @param tableName
	 * @return
	 */
	private String getCsv(String tableName) {
		// 戻り値
		String csvData = null;
		// csv作成用
		StringBuilder csv = new StringBuilder();

		try {
			switch(tableName) {
			case "tb_diary":
				// ヘッダーを設定する
				csv.append(Constants.TB_DIARY_HEADER);
				csv.append(Constants.RETURN_LF);
	
				// テーブルから取得したレコードをつめる
				List<TbDiary> tbDiaryList = tbDiaryLogic.selectAll();
				for (TbDiary recode: tbDiaryList) {
					csv.append(this.getDoubleQuoteString(recode.getDiaryId()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getSubjectType()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getTitle()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getContent1()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getContent2()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getContent3()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getRegistDate().toString()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getRemarks()));
					csv.append(Constants.RETURN_LF);
				}
				break;
			case "tb_diary_ak":
				// ヘッダーを設定する
				csv.append(Constants.TB_DIARY_AK_HEADER);
				csv.append(Constants.RETURN_LF);

				// テーブルから取得したレコードをつめる
				List<TbDiaryAk> tbDiaryAkList = tbDiaryAkLogic.selectAll();
				for (TbDiaryAk recode: tbDiaryAkList) {
					csv.append(this.getDoubleQuoteString(recode.getDiaryId()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getSubjectType()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getTitle()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getContent1()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getContent2()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getContent3()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getRegistDate().toString()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getRemarks()));
					csv.append(Constants.RETURN_LF);
				}
				break;
			case "tb_exec_class":
				// ヘッダーを設定する
				csv.append(Constants.TB_EXEC_CLASS_HEADER);
				csv.append(Constants.RETURN_LF);

				// テーブルから取得したレコードをつめる
				List<TbExecClass> tbExecClassList = tbExecClassLogic.selectAll();
				for (TbExecClass recode: tbExecClassList) {
					csv.append(this.getDoubleQuoteString(recode.getClassName()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getExecFlg()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getRegistDate().toGMTString()));
					csv.append(Constants.CSV_SPLITTER);
					csv.append(this.getDoubleQuoteString(recode.getRemarks()));
					csv.append(Constants.RETURN_LF);
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		csvData = csv.toString();
		return csvData;
	}

	/**
	 * 受け取った値をダブルクォーテーションで囲む<br>
	 * @param text 値
	 * @return
	 */
	private String getDoubleQuoteString(String text) {
		if (Objects.isNull(text) || text.isEmpty()) {
			return "\"" + "\"";
		}
		// 文字列に"があった場合、""に変換する
		text = text.replaceAll("\"", "\"\"");
		// 改行コードの除去
		text = text.replaceAll("\n", "");
		text = text.replaceAll("\r", "");
		return "\"" + text + "\"";
	}

	/**
	 * BOMを付与する<br>
	 * プログラムがテキストデータを読み込む際の数バイト設定<br>
	 * @param outputStream
	 * @return
	 * @throws IOException
	 */
	private ServletOutputStream addBom(ServletOutputStream outputStream) throws IOException {
		outputStream.write(0xef);
		outputStream.write(0xbb);
		outputStream.write(0xbf);
		return outputStream;
	}
}
