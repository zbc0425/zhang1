package smbms.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private Integer id; // id
	@NotEmpty(message = "请输入登陆账户")
	private String usercode; // 用户编码
	private String username; // 用户名称
	@NotEmpty(message = "请输入密码")
	@Length(min = 6, max = 12, message = "密码长度在6~12位之间")
	private String userpassword; // 用户密码
	private Integer gender; // 性别
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday; // 出生日期
	private String phone; // 电话
	private String address; // 地址
	private Integer userrole; // 用户角色
	private Integer createdby; // 创建者
	private Date creationdate; // 创建时间
	private Integer modifyby; // 更新者
	private Date modifydate; // 更新时间

	private Integer age;// 年龄
	private String roleName; // 用户角色名称
	private String idpicpath;
	
	public Integer getAge() {
		/*long time = System.currentTimeMillis()-birthday.getTime();
		Integer age = Long.valueOf(time/365/24/60/60/1000).IntegerValue();*/
		Date date = new Date();
		Integer age = date.getYear()-birthday.getYear();
		return age;
	}


	public User() {
	}

	public User(Integer id, String usercode, String username,
			String userpassword, Integer gender, Date birthday, String phone,
			String address, Integer userrole, Integer createdby,
			Date creationdate, Integer modifyby, Date modifydate,
			String idpicpath) {
		this.id = id;
		this.usercode = usercode;
		this.username = username;
		this.userpassword = userpassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userrole = userrole;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
		this.idpicpath = idpicpath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserrole() {
		return userrole;
	}

	public void setUserrole(Integer userrole) {
		this.userrole = userrole;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Integer getModifyby() {
		return modifyby;
	}

	public void setModifyby(Integer modifyby) {
		this.modifyby = modifyby;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	

	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getIdpicpath() {
		return idpicpath;
	}

	public void setIdpicpath(String idpicpath) {
		this.idpicpath = idpicpath;
	}

}
