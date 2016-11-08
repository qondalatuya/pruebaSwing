package ingre.dao;

import ingre.model.Department;

public class VirtualDepartmentDao extends VirtualDao<Department> {
	private static VirtualDepartmentDao instance = new VirtualDepartmentDao();
	
	public static VirtualDepartmentDao getInstance(){
		return instance;
	}
	
	private VirtualDepartmentDao(){
		
	}
	
	public void init(){
		list.add(new Department("Oficina de Destruccion"));
		list.add(new Department("Mantenimiento de pozos"));
		list.add(new Department("Direccion de Meadas"));
		list.add(new Department("Molestias en General"));
	}
	
}
