/**
 * クラス実行画面用
 */

/** 登録ボタン押下 */
const insertClassName = function() {
	let reqClassName = document.getElementById("className").value;
	// API
	// request = String
	fetch("/insert/class",
		{
			method: "POST", headers: {"Content-Type": "application/json"},
			body: reqClassName
		}
	).then((res) => {
		return res.json();
	}).then(data => {
		// resDto = className, errorMessage
		const resClassName = data["className"];
		const resMessage = data["errorMessage"];
		if (data["message"]) {
			alert(resMessage);
		} else {
			alert("クラス名：「" + resClassName + "」の登録に成功しました。");
		}
	}).catch(error => {
		console.log("非同期通信に失敗しました。", error);
	})
}

/** 更新ボタン押下 */
const updateExecFlg = function() {
	let reqClassName = document.getElementById("className").value;
	// API
	// request = String
	fetch("/update/flg",
		{
			method: "POST", headers: {"Content-Type": "application/json"},
			body: reqClassName
		}
	).then((res) => {
		return res.json();
	}).then(data => {
		// resDto = className, errorMessage
		const resClassName = data["className"];
		const resMessage = data["errorMessage"];
		if (data["message"]) {
			alert(resMessage);
		} else {
			alert("クラス名：「" + resClassName + "」の実行フラグを1にしました。");
		}
	}).catch(error => {
		console.log("非同期通信に失敗しました。", error);
	})
}

const reload = function() {
	window.location.reload();
}