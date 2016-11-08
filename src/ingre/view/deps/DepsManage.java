package ingre.view.deps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import ingre.dao.VirtualDepartmentDao;
import ingre.model.Department;

public class DepsManage extends JPanel{
	private static final long serialVersionUID = 2465363188216532877L;
	private VirtualDepartmentDao daoDep = VirtualDepartmentDao.getInstance();
	private JPanel newDepPanel,depsPanel;
	private JTable table;
	private DefaultTableModel model;
	

	public static void main (String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DepsManage().setVisible(true);
			}
		}); 
	}
	
	public DepsManage(){
		createLeftPanel();
		createCenterPanel();
		init();
	}
	
	private void init(){
		this.setLayout(new BorderLayout());
		this.add(newDepPanel,BorderLayout.WEST);
	}
	
	private void createLeftPanel(){
		newDepPanel = new JPanel();
		newDepPanel.setLayout(new BoxLayout(newDepPanel, BoxLayout.Y_AXIS));
		DepEditPanel panelDep = new DepEditPanel();
		newDepPanel.add(panelDep);
		
		JButton addDepButton = new JButton("Agregar Departamento");
		addDepButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Department newDep = new Department(panelDep.getDepName());
				newDep.setBoss(panelDep.getSelectedBoss());
				daoDep.save(newDep);
				
			}
		});
		newDepPanel.add(addDepButton);
	}
	
	private void createCenterPanel(){
		depsPanel= new JPanel();
		model=new DefaultTableModel();
		model.addColumn("Departamento");
		model.addColumn("Jefe");
		
		
	}
}
