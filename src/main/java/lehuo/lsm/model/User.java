package lehuo.lsm.model;

public class User {
	short id;
	String username;
	String password;
	String email;
	int age;
	
	public User(){}
	
	public User(String name,String pwd,String email,int age,char sex){
		this.username = name;
		this.password = pwd;
		this.email = email;
		this.age = age;
		this.sex = sex;
	}
	
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	char sex;
}
