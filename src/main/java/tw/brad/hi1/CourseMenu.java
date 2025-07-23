package tw.brad.hi1;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import tw.brad.dao.SCDao;
import tw.brad.entity.Course;

public class CourseMenu extends JComboBox<String>{
	private MyModel model;
	private List<Course> courses;

	public CourseMenu() {
		
		courses = new SCDao().getAllCourses();
		
		model = new MyModel();
		setModel(model);
		
	}
	
	private class MyModel extends DefaultComboBoxModel<String> {

		@Override
		public int getSize() {
			return courses.size();
		}

		@Override
		public String getElementAt(int index) {
			return courses.get(index).getCname();
		}
		
	}
	
}
