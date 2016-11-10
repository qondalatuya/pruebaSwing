package ingre.dao;

import ingre.model.Department;

public class DepartmentDao extends Dao<Department> {
	private static DepartmentDao instance = new DepartmentDao();
	
	public static DepartmentDao getInstance(){
		return instance;
	}
	
	private DepartmentDao(){
		
	}
	
	public void init(){
		list.add(new Department("Oficina de Destruccion"));
		list.add(new Department("Mantenimiento de pozos"));
		list.add(new Department("Direccion de Meadas"));
		list.add(new Department("Molestias en General"));
	}
	
}
