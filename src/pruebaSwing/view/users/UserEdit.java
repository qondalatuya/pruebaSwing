package pruebaSwing.view.users;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		JButton savebtn = new JButton("Guardar");
		savebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user.setRealName(realNameField.getText());
				user.setUserName(userNameField.getText());
				dispose();
			}			
		});
		
		this.setLayout(new FlowLayout());
		this.add(userNameLabel);
		this.add(userNameField);
		this.add(realNameLabel);
		this.add(realNameField);
		this.add(savebtn);
		
		
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
	}
}
