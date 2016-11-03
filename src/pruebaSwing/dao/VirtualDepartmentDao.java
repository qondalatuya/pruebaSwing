package pruebaSwing.dao;

import java.util.ArrayList;
import java.util.List;

import pruebaSwing.model.Department;

public class VirtualDepartmentDao {
	List<Department> list= new ArrayList<Department>();
	
	public VirtualDepartmentDao(){
		init();		
	}
	
	public List<Department> getAll(){
		return list;
	}
	
	public void init(){
		list.add(new Department("Prestaciones"));
		list.add(new Department("Finanzas"));
		list.add(new Department("Beneficiarios"));
	}
	
}
