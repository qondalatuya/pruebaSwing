package ingre.view.users;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import ingre.dao.DepartmentDao;
import ingre.dao.UserDao;
import ingre.model.Department;
import ingre.model.User;

public class UsersManage extends JPanel {	
	private static final long serialVersionUID = -8104795210887305316L;
	UserDao dao = UserDao.getInstance();
	DepartmentDao daoDep = DepartmentDao.getInstance();
	JTable table;
	DefaultTableModel model;
	List<User> users;
	List<Department> deps;
	JPanel newUserPanel,usersPanel;
	
	public UsersManage(){
		this.constructLeftPanel();
		this.constructCenterPanel();
		this.init();
	}
	
	protected void constructLeftPanel(){
		newUserPanel= new JPanel();
		newUserPanel.setLayout(new BoxLayout(newUserPanel, BoxLayout.Y_AXIS));
		UserEditPanel userEditPanel = new UserEditPanel();
		
		JButton savebtn;
		savebtn = new JButton("Agregar Usuario");
		savebtn.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				User newUser = new User(userEditPanel.getUserName(), userEditPanel.getRealName());
				newUser.setDepartment(userEditPanel.getDepartment());
				dao.save(newUser);
				fillTable();
			}
		});
		
		newUserPanel.add(userEditPanel);
		newUserPanel.add(savebtn);
//				
		
	}
	
	protected void constructCenterPanel(){
		usersPanel = new JPanel();		
		usersPanel.setLayout(new BorderLayout());
		
		JScrollPane tablePanel = new JScrollPane();
		model = new DefaultTableModel()
			{
			private static final long serialVersionUID = 279157351021069600L;
			@Override
			public boolean isCellEditable(int fila, int columna){
				return false;//pareceria que se puede definir algun tipo de logica que returne V/F seg�n si la celda de la tabla es editable o no.
			}// en este caso returna falso, para cualquier combinacion de fila/columna
		};
		table = new JTable(model);
		table.setRowSorter( new TableRowSorter<DefaultTableModel>(model));//Le decimos que la tabla se pueda ordenar (Haciendo clic en las columnas).
		model.addColumn("Nombre usuario");
		model.addColumn("Nombre real");
		model.addColumn("Departamento");
		
		JButton editbtn= new JButton("Editar");
		editbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()!=-1){
//					model.getValueAt(table.getSelectedRow(), 1);
					UserEdit userEdit = new UserEdit(users.get(table.getSelectedRow()));
					userEdit.setVisible(true);
					fillTable();
				}	
			}
		});
		JButton rembtn = new JButton("Eliminar");
		rembtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()!=-1){
					dao.delete(users.get(table.getSelectedRow()));
					fillTable();
				}
				
			}
		});
		
		tablePanel.setViewportView(table);
		this.fillTable();
		
		usersPanel.add(tablePanel,BorderLayout.CENTER);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(rembtn);
		buttonsPanel.add(editbtn);
		usersPanel.add(buttonsPanel,BorderLayout.SOUTH);
		
	}
	
	
	protected void init(){
		this.setLayout(new BorderLayout());
		this.add(usersPanel,BorderLayout.CENTER);
		this.add(newUserPanel, BorderLayout.WEST);
	
	}
	
	protected void fillTable(){
		try{					
			model.setRowCount(0);
			users = dao.getAll(); 
			for (User user:users){
				Object[] o = {user.getUserName(),user.getRealName(),user.getDepartment()}; 
				model.addRow(o);
			}
			table.updateUI();
		}
		catch (Exception e) {
			
		}
	}
	
}
