package pruebaSwing.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import pruebaSwing.view.users.UsersAdmin;

public class GeneralManage extends JFrame {
	private static final long serialVersionUID = 2403686788652812408L;

	public static void main (String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GeneralManage().setVisible(true);				
			}
		});
	}
	
	public GeneralManage(){
		init();
	}
	
	public void init(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Administración");
		JTabbedPane tabbedpane = new JTabbedPane();
		tabbedpane.addTab("Usuarios", new UsersAdmin());
		this.add(tabbedpane);
		this.pack();
	}
}
