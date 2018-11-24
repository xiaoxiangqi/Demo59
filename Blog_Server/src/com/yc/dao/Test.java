package com.yc.dao;

import com.yc.bean.Columns;
import com.yc.bean.User;
import com.yc.dao.DBHelper;

public class Test {
	public static void main(String[] args) {
		//DBHelper helper = new DBHelper();
		/*System.out.println(DBHelper.select("select * from columns"));

		System.out.println(DBHelper.select("select * from columns where aliasName=?","web"));
		
		Columns col = DBHelper.unique("select * from columns where aliasName=?", Columns.class,"web");
		
		System.out.println(col);
		System.out.println("===========");*/
		User col1 = DBHelper.unique("select * from user where account=?", User.class,"zhangsan");
		System.out.println(col1);
	}

}
