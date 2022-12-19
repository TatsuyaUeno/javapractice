package com.javapractice.app.util;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	/**
	 * SQLセッションファクトリーがnullの場合、設定ファイルを読み込む
	 * @return
	 * @throws IOException
	 */
	public static SqlSessionFactory getSqlSession() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		return ssf;
	}
}
