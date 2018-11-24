package com.yc.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.bean.User;
import com.yc.dao.DBHelper;

public class UserBiz {
	/**
	 * 登录方法
	 * @param username
	 * @param username
	 * @return 返回登录成功的用户对象
	 */
	public User login(String username,String userpwd) throws BizException{
		
		if(username == null || username.trim().isEmpty()) {
			throw new BizException("请填写用户名！");
		}
		if(userpwd == null || userpwd.trim().isEmpty()) {
			throw new BizException("请填写密码！");
		}
		//DBHelper dbHelper = new DBHelper();
		//List<Object> params = new ArrayList<Object>();
		//params.add(username);
		//params.add(userpwd);
		String sql = "select * from user where account = ? and pwd = ?";
		//Map<String, String> user = dbHelper.findMap(sql, params);
		return DBHelper.unique(sql, User.class,username,userpwd);
		//return user;
	}
	
	public List<User> findAll() {
		return DBHelper.select("select * from user", User.class);
	}
	public void add(User user) throws BizException {
		if(user.getName() == null || user.getName().trim().isEmpty()) {
			throw new BizException("请填写用户名！");
		}
		if(user.getAccount() == null || user.getAccount().trim().isEmpty()) {
			throw new BizException("请填写账户名！");
		}
		if(user.getPwd() == null || user.getPwd().trim().isEmpty()) {
			throw new BizException("请填写密码!");
		}
		String sql = "insert into user (name,account,tel,pwd) values(?,?,?,?)";
		DBHelper.insert(sql, user.getName(),user.getAccount(),user.getTel(),user.getPwd());
	}

	public Object find(User user) {
		String sql = "select * from user where 1=1";
		ArrayList<Object> params = new ArrayList<Object>();
		if(user.getName() != null && user.getName().trim().isEmpty() == false) {
			sql += " and name like concat('%',?,'%')";
			params.add(user.getName());
		}
		if(user.getAccount() != null && user.getAccount().trim().isEmpty() == false){
			sql += " and account like ? ";
			params.add("%"+user.getAccount()+"%");
		}
		if(user.getPwd() != null && user.getPwd().trim().isEmpty() == false) {
			sql += " and tel like ? ";
			params.add("%"+user.getTel()+"%");
		}
		return DBHelper.select(sql, params);
	}

	public User findById(String id) {
		return DBHelper.unique("select * from user where id=?", User.class,id);
	}

	public void save(User user) throws BizException {
		if(user.getAccount() == null || user.getAccount().trim().isEmpty()) {
			throw new BizException("请填写用户名！");
		}
		if(user.getName() == null || user.getName().trim().isEmpty()) {
			throw new BizException("请填写姓名！");
		}
		DBHelper.update("update user set name=?,account=?,tel=? where id=?", 
				user.getName(),user.getAccount(),user.getTel(),user.getId());
	}

	
}
