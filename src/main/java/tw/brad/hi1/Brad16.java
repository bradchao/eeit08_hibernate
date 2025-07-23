package tw.brad.hi1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import tw.brad.dao.SCDao;
import tw.brad.entity.Student;

public class Brad16 extends JFrame{
	private SCDao dao;
	private Student s;
	private JButton add;
	private JLabel name;
	private CourseMenu menu;
	
	public Brad16() {
		super("選課");
		
		dao = new SCDao();
		s = dao.getById((long)5);
		
		setLayout(new FlowLayout());
		name = new JLabel(s.getSname());
		menu = new CourseMenu();
		add = new JButton("選課");
		
		add(name);add(menu);add(add);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Brad16();
	}

}
