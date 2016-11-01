package pruebaSwing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import pruebaSwing.dao.UserDao;
import pruebaSwing.model.User;

public class UsersAdmin extends JFrame {
	JTable table;
	DefaultTableModel model;
	ArrayList<User> users = new UserDao().getAll();
	JPanel newUserPanel;
	JScrollPane usersPanel;
	JButton savebtn;
	JLabel userNameLabel,realNameLabel;
	JTextField userNameField,realNameField;
	
	public UsersAdmin(){
		this.constructLeftPanel();
		this.constructCenterPanel();
		this.init();
	}
	
	public void constructLeftPanel(){
		newUserPanel = new JPanel();
		
		userNameLabel = new JLabel("Usuario");
		realNameLabel = new JLabel("Nombre");
		userNameField = new JTextField();
		realNameField = new JTextField();
		userNameField.setPreferredSize(new Dimension(120, 24));
		realNameField.setPreferredSize(new Dimension(120, 24));
		
		savebtn = new JButton("Guardar");
		savebtn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				User newUser = new User(userNameField.getText(), realNameField.getText());
				users.add(newUser);
				fillTable();
				
				System.out.println(table.getSelectedRow());
//				JOptionPane.showMessageDialog(null, "Hubo una accion en el boton.");			
			}
		});
		
		newUserPanel.add(userNameLabel);
		newUserPanel.add(userNameField);
		newUserPanel.add(realNameLabel);
		newUserPanel.add(realNameField);
		newUserPanel.add(savebtn);
		getRootPane().setDefaultButton(savebtn);//agrega el boton como "enter por defecto" para el Jframe. Al presionar la tecla se invoca al actionPermormed del Jbutton		
		
	}
	
	public void constructCenterPanel(){
		usersPanel = new JScrollPane();
		model = new DefaultTableModel()
			{
			@Override
			public boolean isCellEditable(int fila, int columna){
				return false;
			}
		};
		table = new JTable(model);
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
//		table.getSelectionModel().addListSelectionListener(x);
		model.addColumn("Nombre usuario");
		model.addColumn("Nombre real");
		this.fillTable();
		
	}
	
	public void init(){
		this.setLayout(new BorderLayout());
		this.setTitle("Administración de Usuarios");
		this.add(usersPanel,BorderLayout.CENTER);
		this.add(newUserPanel, BorderLayout.WEST);
		
	
	}
	
	public void fillTable(){
		try{					
			model.setRowCount(0);			
			for (User user:users){
				Object[] o = {user.getUserName(),user.getRealName()}; 
				model.addRow(o);
				usersPanel.setViewportView(table);
			}
		}
		catch (Exception e) {
			
		}
	}
	
}
