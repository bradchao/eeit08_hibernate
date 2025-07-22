package tw.brad.hi1;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import tw.brad.dao.SCDao;
import tw.brad.entity.Course;
import tw.brad.entity.Student;

public class Brad15 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Student s1 = dao.getById((long)4);
		if (s1 != null) {
			System.out.printf("Welcome, %s\n", s1.getSname());
			
			Scanner scanner = new Scanner(System.in);
			while(true) {
				List<Course> courses = dao.getAllCourses();
				for (Course course : courses) {
					if (!isExist(s1, course.getStudents())) {
						System.out.printf("%d. %s\n", course.getId(), course.getCname());
					}
				}				
				
				System.out.println("Which?");
				long cid = scanner.nextLong();
				if (cid == 0) break;
				s1.addCourse(dao.getCourseById(cid));
				
				dao.update(s1);
			}
			
			
		}else {
			System.out.println("Student NOT FOUND");
		}
	}

	private static boolean isExist(Student s, Set<Student> students) {
		boolean ret = false;
		for (Student student : students) {
			if (student.getId() == s.getId()) {
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	
	
	
}
