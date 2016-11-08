package ingre.model;

public class Department {
	private int id;
	private String name;
	private User boss;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getBoss() {
		return boss;
	}

	public void setBoss(User boss) {
		this.boss = boss;
	}

	public Department(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
