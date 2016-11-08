package ingre.dao;

import ingre.model.User;

//angau

public class VirtualUserDao extends VirtualDao<User> {
	private static VirtualUserDao instance = new VirtualUserDao();
	
	public static VirtualUserDao getInstance(){
		return instance;
	}
	
	private VirtualUserDao() {
		
	}
	
	@Override
	protected void init(){
		list.add(new User("jaina", "Jaina"));
		list.add(new User("igor", "Igor"));
		list.add(new User("leonidas", "Leonidas"));
		list.add(new User("yukon", "Yukon"));
	}
	

	
}
