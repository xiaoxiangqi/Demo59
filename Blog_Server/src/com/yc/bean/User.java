package com.yc.bean;

import java.sql.Timestamp;

//ʹ�ð�װ���ඨ����������
//ע���ֶεĳ�������������Ҫƥ��
//Timestamp��Ӧmysql��datetime
//ʵ����Ҫʵ�����л��ӿ�
public class User implements java.io.Serializable{
	/**
	 * ���кŽӿ�Ҫ������л��汾����ֶ�
	 */
	private static final long serialVersionUID = 1L;
	/*������������û�п�ֵ
	�ð�װ������*/
	private Long id;
	private String name;
	private String account;
	private String pwd;
	private String tel;
	private String createBy;
	private String status;
	private String type;
	private Timestamp createDate; //����+ʱ��	java.sql.Date ������
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
