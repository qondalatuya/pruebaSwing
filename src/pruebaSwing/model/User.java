package pruebaSwing.model;

public class User {
	private String userName;
	private String realName;
	private Department department;
	
	public User(String userName, String realName) {
		super();
		this.userName = userName;
		this.realName = realName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", realName=" + realName + "]";
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
