package pruebaSwing.view.users;

import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pruebaSwing.dao.VirtualDepartmentDao;
import pruebaSwing.model.Department;
import pruebaSwing.model.User;
/*
 * Este panel contiene fields y labels para edicion de usario (posteriormente también lista desplegable con departamento)
 * No contiente botones de acciones. Dificulta mucho (a mi entender) el manejo de los eventos generados por los botones, 
 * los cuales deben generan cambios en listeners ubicados en otras clases.
 * Contiene geters para todas las inputs
 */

public class UserEditPanel extends JPanel {
	private static final long serialVersionUID = 4882132895376327167L;
	private JLabel userNameLabel,realNameLabel,departmentLabel;
	private JTextField userNameField,realNameField;
	private JComboBox<Department> depcombobox;
	private List<Department> deps;
	private VirtualDepartmentDao daoDep = new VirtualDepartmentDao();
	
	public UserEditPanel(){
		init();
		depcombobox.setSelectedItem(null);
	}
	
	public UserEditPanel(User user){
		init();
		userNameField.setText(user.getUserName());
		realNameField.setText(user.getRealName());
		depcombobox.setSelectedItem(user.getDepartment());
	}
	
	public void init(){
		userNameLabel = new JLabel("Nombre Usuario");
		realNameLabel = new JLabel("Nombre real");
		departmentLabel = new JLabel("Departamento");
		userNameField = new JTextField();
		realNameField = new JTextField();
		
		depcombobox= new JComboBox<Department>();
		
		userNameField.setPreferredSize(new Dimension(120, 24));
		realNameField.setPreferredSize(new Dimension(120, 24));
		userNameLabel.setPreferredSize(new Dimension(120, 24));
		realNameLabel.setPreferredSize(new Dimension(120, 24));
		departmentLabel.setPreferredSize(new Dimension(120, 24));
		depcombobox.setPreferredSize(new Dimension(120, 24));
		
		deps = daoDep.getAll();
		for(Department d : deps){
			depcombobox.addItem(d);
		}		
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(userNameLabel)
							.addComponent(realNameLabel)
							.addComponent(departmentLabel)
							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(userNameField)
							.addComponent(realNameField)
							.addComponent(depcombobox)
							)
				);
				
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(userNameLabel)
							.addComponent(userNameField)
							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(realNameLabel)
							.addComponent(realNameField)
							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(departmentLabel)
							.addComponent(depcombobox)
							)
					);

	}
		
	public String getUserName(){
		return userNameField.getText();
	}
	
	public String getRealName(){
		return realNameField.getText();
	}
	
	public Department getDepartment(){
		return (Department) depcombobox.getSelectedItem();
	}
}
