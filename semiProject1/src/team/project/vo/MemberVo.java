package team.project.vo;

public class MemberVo {
	String id;
	String pwd;
	String pwd2;
	String name;
	String addr;
	int date_of_birth;


	int phone;
	String gender;
	String email;
	String regdate;
	String usertype;

	public MemberVo() {};
	
	public MemberVo(String id, String pwd, String name, String addr, 
					int date_of_birth,int phone, String gender, String email, 
					String regdate, String usertype) {
		super();
		this.id=id;
		this.pwd=pwd;
		this.name=name;
		this.addr=addr;
		this.date_of_birth= date_of_birth;
		this.phone=phone;
		this.gender=gender;
		this.email=email;
		this.regdate=regdate;
		this.usertype=usertype;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(int date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

//	@Override
	//public String toString() {
		//return "MemberVo [id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", name=" + name + ", addr=" + addr
			//	+ ", birth=" + birth + ", phone=" + phone + ", gender=" + gender + ", email=" + email + ", regdate="
				//+ regdate + "]";
	
	
}
