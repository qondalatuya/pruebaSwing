package pruebaSwing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PruebaTable {

	public static void main(String[] args) {

	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            UsersAdmin gui = new UsersAdmin();
//	            JFrame frame = new JFrame("Administración de Usuarios");
//	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	            frame.getContentPane().add(gui);
//	            frame.pack();
//	            frame.setVisible(true);
	            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            gui.pack();
	            gui.setVisible(true);
	        }
	    });

	}

}
