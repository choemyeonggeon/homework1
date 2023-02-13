package com.greedy.member.model.dto;

public class MemberDTO {

	private int no;
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String emeil;
	private String phone;
	private String address;
	private int age;
	
	
public MemberDTO() {}


public int getNo() {
	return no;
}


public String getId() {
	return id;
}


public String getPwd() {
	return pwd;
}


public String getName() {
	return name;
}


public String getGender() {
	return gender;
}


public String getEmeil() {
	return emeil;
}


public String getPhone() {
	return phone;
}


public String getAddress() {
	return address;
}


public int getAge() {
	return age;
}


public void setNo(int no) {
	this.no = no;
}


public void setId(String id) {
	this.id = id;
}


public void setPwd(String pwd) {
	this.pwd = pwd;
}


public void setName(String name) {
	this.name = name;
}


public void setGender(String gender) {
	this.gender = gender;
}


public void setEmeil(String emeil) {
	this.emeil = emeil;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public void setAddress(String address) {
	this.address = address;
}


public void setAge(int age) {
	this.age = age;
}


@Override
public String toString() {
	return "MemberDTO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", emeil="
			+ emeil + ", phone=" + phone + ", address=" + address + ", age=" + age + "]";
}


public MemberDTO(int no, String id, String pwd, String name, String gender, String emeil, String phone, String address,
		int age) {
	super();
	this.no = no;
	this.id = id;
	this.pwd = pwd;
	this.name = name;
	this.gender = gender;
	this.emeil = emeil;
	this.phone = phone;
	this.address = address;
	this.age = age;
}



	
}
