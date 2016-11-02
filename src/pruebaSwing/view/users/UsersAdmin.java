package pruebaSwing.view.users;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import pruebaSwing.dao.VirtualUserDao;
import pruebaSwing.model.User;

public class UsersAdmin extends JFrame {
	private static final long serialVersionUID = 6152605591867146795L;
	VirtualUserDao dao = new VirtualUserDao();
	JTable table;
	DefaultTableModel model;
	List<User> users;
	JPanel newUserPanel,buttonsPanel;
	JScrollPane usersPanel;

	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				UsersAdmin window = new UsersAdmin();
				window.setVisible(true);				
			}
		});
	}
	
	public UsersAdmin(){
		this.constructLeftPanel();
		this.constructCenterPanel();
		this.constructSouthPanel();
		this.init();
	}
	
	protected void constructLeftPanel(){
		newUserPanel = new JPanel();
		
		JLabel userNameLabel,realNameLabel;
		JTextField userNameField,realNameField;
		userNameLabel = new JLabel("Usuario");
		realNameLabel = new JLabel("Nombre");
		userNameField = new JTextField();
		realNameField = new JTextField();
		userNameField.setPreferredSize(new Dimension(120, 24));
		realNameField.setPreferredSize(new Dimension(120, 24));
		
		JButton savebtn;
		savebtn = new JButton("Guardar");
		savebtn.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				User newUser = new User(userNameField.getText(), realNameField.getText());
				dao.save(newUser);
				fillTable();
			}
		});
		
		newUserPanel.add(userNameLabel);
		newUserPanel.add(userNameField);
		newUserPanel.add(realNameLabel);
		newUserPanel.add(realNameField);
		newUserPanel.add(savebtn);
		getRootPane().setDefaultButton(savebtn);//agrega el boton como "enter por defecto" para el Jframe. Al presionar la tecla se invoca al actionPermormed del Jbutton		
		
	}
	
	protected void constructCenterPanel(){
		usersPanel = new JScrollPane();
		model = new DefaultTableModel()
			{
			private static final long serialVersionUID = 279157351021069600L;
			@Override
			public boolean isCellEditable(int fila, int columna){
				return false;
			}
		};
		table = new JTable(model);
		table.setRowSorter( new TableRowSorter<DefaultTableModel>(model));//Le decimos que la tabla se pueda ordenar (Haciendo clic en las columnas)
		model.addColumn("Nombre usuario");
		model.addColumn("Nombre real");
		this.fillTable();
		
	}
	
	protected void constructSouthPanel(){
		buttonsPanel = new JPanel();
		JButton editbtn= new JButton("Editar");
		editbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()!=-1){
					model.getValueAt(table.getSelectedRow(), 1);
					UserEdit userEdit = new UserEdit(users.get(table.getSelectedRow()));
					userEdit.setVisible(true);
					fillTable();
				}
				
			}
		});
		
		buttonsPanel.add(editbtn);
	}
	
	protected void init(){
		this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		this.setTitle("Administración de Usuarios");
		this.add(usersPanel,BorderLayout.CENTER);
		this.add(newUserPanel, BorderLayout.WEST);
		this.add(buttonsPanel,BorderLayout.SOUTH);
		this.pack();
		
	
	}
	
	protected void fillTable(){
		try{					
			model.setRowCount(0);
			users = dao.getAll(); 
			for (User user:users){
				Object[] o = {user.getUserName(),user.getRealName()}; 
				model.addRow(o);
				usersPanel.setViewportView(table);
			}
			table.updateUI();
		}
		catch (Exception e) {
			
		}
	}
	
}
