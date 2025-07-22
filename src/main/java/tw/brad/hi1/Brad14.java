package tw.brad.hi1;

import tw.brad.dao.SCDao;
import tw.brad.entity.Course;

public class Brad14 {

	public static void main(String[] args) {
		Course c1 = new Course("Java");
		Course c2 = new Course("JDBC");
		Course c3 = new Course("Servlet");
		Course c4 = new Course("JSP");
		Course c5 = new Course("Hibernate");
		Course c6 = new Course("Spring");
		
		SCDao dao = new SCDao();
		dao.save(c1);dao.save(c2);dao.save(c3);
		dao.save(c4);dao.save(c5);dao.save(c6);
		
	}

}
