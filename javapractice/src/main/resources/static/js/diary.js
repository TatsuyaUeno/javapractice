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

const selectDate = function() {
	var requestMap = {};
	requestMap["year"] = document.getElementById("year").value;
	requestMap["month"] = document.getElementById("month").value;
	// テーブル表示
    fetch("/view/diary/view", 
    	{method: "POST", headers: {'Content-Type': 'application/json'},
    	body: JSON.stringify(requestMap)
    	}
    // Stringの場合はtext()を使う（型によって変更する必要がある）
    ).then(res => {
	// 通信失敗か判定
		if (!res.ok) {
			alert("サーバーエラー：非同期通信に失敗しました。")
		}
		return res.json();
	}
	).then(data => {
		// response = {diaryId:値, subjectType:値, title:値, content1:値
		//             content2:値, content3:値, registDate:値, remarks:値}
		console.log(data);
		// ヘッダー表示用
		var view =
		"<tr>"
		+ "<th>日誌番号</th>"
		+ "<th>種別</th>"
		+ "<th>タイトル</th>"
		+ "<th>内容1</th>"
		+ "<th>内容2</th>"
		+ "<th>内容3</th>"
		+ "<th>登録日時</th>"
		+ "<th>備考</th>"
		+ "</tr>"
		;
		// テーブルの値を表示用
		for (var tbDiary of data) {
			view = view + "<tr>"
			view = view + "<td>" + tbDiary["diaryId"] + "</td>";
			view = view + "<td>" + tbDiary["subjectType"] + "</td>";
			view = view + "<td>" + tbDiary["title"] + "</td>";
			view = view + "<td>" + tbDiary["content1"] + "</td>";
			view = view + "<td>" + tbDiary["content2"] + "</td>";
			view = view + "<td>" + tbDiary["content3"] + "</td>";
			view = view + "<td>" + tbDiary["registDate"] + "</td>";
			view = view + "<td>" + tbDiary["remarks"] + "</td>";
			view = view + "</tr>"
		}
		console.log(view);
		// JSPのid=viewTableに表示する
		document.getElementById("viewTable").innerHTML = view;
		
	})
}

const hiddenDate = function() {
	document.getElementById("viewTable").innerHTML = "";
}