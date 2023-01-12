/**
 * 日誌関連
 */

// 定数をまとめる方法が分からず下記を他jsファイルにコピペで定数を定義する
const constants = {
	URL_PATH: "localhost:8080"
}

const tb_diary = {
	diaryId: "diaryId",
	subjectType: "subjectType",
	title: "title",
	content1: "content1",
	content2: "content2",
	content3: "content3",
	registDate: "registDate",
	remarks: "remarks"
}

/** ------------登録画面--------------- */
const registInputDiary = function() {
	// 値取得とリクエスト用Map作成
	const requestMap = getRequestMap();
	console.log(requestMap);
	// API通信
	fetch("/regist/diary/insertDiary",
		{method: "POST", headers: {"Content-Type": "application/json"},
		body: JSON.stringify(requestMap)
		}
	).then((res) => {
		// 非同期通信ステータスチェック
		if (!res.ok) {
			console.log("サーバーエラー：非同期通信に失敗しました。");
			
		}
		// 成功時の処理
		return res.json();
	}
	).then(data => {
		// レスポンス処理
		/**
		response = {registDiaryId: 値, processFlg: 値, errorMessage: 値};
		 */
		 if (!data["processFlg"]) {
			// 失敗の処理
			alert(data[errorMessage]);
		} else {
			alert("日誌番号【" + data["registDiaryId"] + "】登録に成功しました。");
		}
	}
	).catch(error => {
		console.log("非同期通信に失敗しました。", error);
	});
}

/**
画面情報を取得
日誌検索リクエストMap作成
 */
function getRequestMap() {
	var requestMap = {};
	requestMap[tb_diary.subjectType] = document.getElementById("subject_title").value;
	requestMap[tb_diary.title] = document.getElementById("title").value;
	requestMap[tb_diary.content1] = document.getElementById("content1").value;
	requestMap[tb_diary.content2] = document.getElementById("content2").value;
	requestMap[tb_diary.content3] = document.getElementById("content3").value;
	requestMap[tb_diary.remarks] = document.getElementById("remarks").value;
	return requestMap;
}


/** ------------表示画面------------------ */
function viewDiarySearch() {
	// プルダウンの値取得
	const selects = document.form1.prefecture;
	const idx = selects.selectedIndex;
	const subjectType = selects.options[idx].value;
	// チェックボックスの値取得
	const archiveFlg = document.getElementsByName("archiveFlg")[0].checked;

	console.log(subjectType);
	console.log(archiveFlg);
	
	var requestMap = {};
	requestMap["subjectType"] = subjectType;
	requestMap["tbDiaryAkFlg"] = archiveFlg;
	console.log(requestMap);

	fetch("/view/diary/search",
		{method: "POST", headers: {"Content-Type": "application/json"},
		body: JSON.stringify(requestMap)
		}
	).then((res) => {
		// 非同期通信ステータスチェック
		if (!res.ok) {
			console.log("サーバーエラー：非同期通信に失敗しました。");
			
		}
		return res.text();
	}
	).then(data => {
		// レスポンス処理
		// 本当はだめだけどhtmlを書き換える形になっちゃった
		document.getElementById("changeView").innerHTML = data;
	}
	).catch(error => {
		console.log("非同期通信に失敗しました。", error);
	});
}
