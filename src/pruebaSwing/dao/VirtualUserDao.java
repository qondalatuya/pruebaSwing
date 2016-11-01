package pruebaSwing.dao;

import java.util.ArrayList;

import pruebaSwing.model.User;

//angau

public class VirtualUserDao {
	ArrayList<User> lista = new ArrayList<User>();
	
	public ArrayList<User> getAll(){
		
		
		lista.add(new User("vallejosl", "Vallejos Lucas"));
		lista.add(new User("poncemi", "Ponce Milton"));
		lista.add(new User("arandar", "Aranda Romina"));
		
		
		return lista;
	}
	
}
