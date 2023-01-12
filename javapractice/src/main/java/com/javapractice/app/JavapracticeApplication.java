package com.javapractice.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.javapractice.app.thread.ClassExecThread;

@SpringBootApplication
public class JavapracticeApplication {

	/** Spring起動時に走らせるスレッドクラス */
	@Autowired
	private ClassExecThread classExecThread;

	public static void main(String[] args) {
//		SpringApplication.run(JavapracticeApplication.class, args);
        ConfigurableApplicationContext ctx = SpringApplication.run(JavapracticeApplication.class, args);
        JavapracticeApplication app = ctx.getBean(JavapracticeApplication.class);
        app.execStartup(args);
	}

	/**
	 * Spring起動時に実行するメソッド<br>
	 * 用途1:監視スレッド起動<br>
	 * @param args 使用しない
	 */
	public void execStartup(String[] args) {
		// クラス実行テーブル監視スレッド
		new Thread(classExecThread).start();
	}
}
