package com.javapractice.app.test;

import java.util.List;

import com.javapractice.app.logic.TbDiaryLogic;
import com.javapractice.app.mybatis.model.TbDiary;

/**
 * mybatisのテストクラス
 * @author tatsuya
 *
 */
public class MybatisTest {

	public static void main(String[] args) throws Exception {

		TbDiaryLogic logic = new TbDiaryLogic();
		List<TbDiary> res = logic.selectAll();
		System.out.println(res.get(0).getDiaryId());
	}

}
