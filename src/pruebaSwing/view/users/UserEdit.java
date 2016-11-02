package pruebaSwing.view.users;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import pruebaSwing.model.User;

public class UserEdit extends JDialog {
	private static final long serialVersionUID = 4852407853975781816L;
	private JLabel userNameLabel,realNameLabel;
	private JTextField userNameField,realNameField;
	
	public UserEdit(User user){
		userNameLabel = new JLabel("Nombre Usuario");
		realNameLabel = new JLabel("Nombre real");
		userNameField = new JTextField(user.getUserName());
		realNameField = new JTextField(user.getRealName());
		
		userNameField.setPreferredSize(new Dimension(120, 24));
		realNameField.setPreferredSize(new Dimension(120, 24));
		userNameLabel.setPreferredSize(new Dimension(120, 24));
		realNameLabel.setPreferredSize(new Dimension(120, 24));		
		
		
		JButton savebtn = new JButton("Guardar");
		savebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user.setRealName(realNameField.getText());
				user.setUserName(userNameField.getText());
				dispose();
			}			
		});
		
		GroupLayout layout = new GroupLayout(this.getContentPane());
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(userNameLabel)
						.addComponent(realNameLabel)));
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(userNameLabel)
				.addComponent(realNameLabel));
		
		//TODO  faltan agregar componentes
//		this.add(userNameLabel);
//		this.add(userNameField);
//		this.add(realNameLabel);
//		this.add(realNameField);
//		this.add(savebtn);
		
		
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
	}
}
