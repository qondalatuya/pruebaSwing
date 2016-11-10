package ingre.dao;

import ingre.model.User;

//angau

public class UserDao extends Dao<User> {
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance(){
		return instance;
	}
	
	private UserDao() {
		
	}
	
	@Override
	protected void init(){
		list.add(new User("jaina", "Jaina"));
		list.add(new User("igor", "Igor"));
		list.add(new User("leonidas", "Leonidas"));
		list.add(new User("yukon", "Yukon"));
	}
	

	
}
