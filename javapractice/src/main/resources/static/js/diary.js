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
		body: JSON.stringify(requestMap)}
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
			alert("日誌番号【" + data["registDiaryId"] + "】登録処理に成功しました。");
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

const selectAll = function() {
    fetch("/view/diary/selectAll", 
    	{method: "POST", headers: {'Content-Type': 'application/json'}}
    	)
    // Stringの場合はtext()を使う（型によって変更する必要がある）
    .then(res => {
	// 通信失敗か判定
		if (!res.ok) {
		console.log("サーバーエラー：非同期通信に失敗しました。")
		}
		// 成功時の処理
		return res.json();
	}
	).then(
      data => {
        console.log(data);
        var res = data[0];
        console.log(res);

        document.getElementById("diary_id").innerHTML = res[tb_diary.diaryId];
        document.getElementById("subject_type").innerHTML = res[tb_diary.subjectType];
        document.getElementById("title").innerHTML = res[tb_diary.title];
        document.getElementById("content1").innerHTML = res[tb_diary.content1];
        document.getElementById("content2").innerHTML = res[tb_diary.content2];
        document.getElementById("content3").innerHTML = res[tb_diary.content3];
        document.getElementById("regist_date").innerHTML = res[tb_diary.registDate];
        document.getElementById("remarks").innerHTML = res[tb_diary.remarks];
      }
    )
}