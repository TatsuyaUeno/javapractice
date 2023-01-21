/**
 * 
 */

function　csvDownload() {
	// プルダウンの値取得
	const selects = document.form2.tableName;
	const idx = selects.selectedIndex;
	const tableName = selects.options[idx].value;
	console.log(tableName);

	fetch("/csv/download/make",
		{method: "POST", headers: {"Content-Type": "application/json"},
		body: tableName
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

	}
	).catch(error => {
		console.log("非同期通信に失敗しました。", error);
	});
}