package pruebaSwing.dao;

import java.util.ArrayList;

import pruebaSwing.model.User;

//angau

public class VirtualUserDao {
	ArrayList<User> lista = new ArrayList<User>();
	
	public VirtualUserDao(){
		init();
	}
	
	public ArrayList<User> getAll(){		
		return lista;
	}
	
	public void save (User u){
		lista.add(u);
	}
	
	public void update (User U){
		
	}
	
	//este metodo es una mentira
	public void delete(User u){
		lista.remove(u);
	}
	
	private void init(){
		lista.add(new User("vallejosl", "Vallejos Lucas"));
		lista.add(new User("poncemi", "Ponce Milton"));
		lista.add(new User("arandar", "Aranda Romina"));
	}
	
}
