package com.yc.bean;

import java.sql.Timestamp;

//使用包装器类定义属性类型
//注意字段的长度与属性类型要匹配
//Timestamp对应mysql的datetime
//实体类要实现序列化接口
public class User implements java.io.Serializable{
	/**
	 * 序列号接口要求的序列化版本编号字段
	 */
	private static final long serialVersionUID = 1L;
	/*基本数据类型没有空值
	用包装器类型*/
	private Long id;
	private String name;
	private String account;
	private String pwd;
	private String tel;
	private String createBy;
	private String status;
	private String type;
	private Timestamp createDate; //日期+时间	java.sql.Date 纯日期
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}
