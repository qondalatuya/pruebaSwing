package ingre.dao;

import java.util.ArrayList;
import java.util.List;

//las clases que heredan de esta deben implementar el método getCurrentInstance() init() y declarar el atribuyo instance

public class VirtualDao <T>{
	protected List<T> list;
	
	protected VirtualDao(){
		list = new ArrayList<T>();
		init();
	}
	
	protected void init(){	}
	
	public List<T> getAll(){
		return list;
	}
	
	public void save(T t){
		list.add(t);
	}
	
	public void update (T t){
	}
	
	public void delete (T t){
		list.remove(t);
	}
	
	public T getById(int i){
		return list.get(i);
	}
		
}
