package com.javapractice.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * メニュー画面のコントローラー
 * @author tatsuya
 *
 */
@Controller
@CrossOrigin(origins = "*")
public class MenuController {

	@GetMapping("/menu")
	public String index() {
		return "menu";
	}
}
