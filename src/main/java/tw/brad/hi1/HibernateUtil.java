package tw.brad.hi1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tw.brad.entity.Gift;
import tw.brad.entity.Member;
import tw.brad.entity.MemberInfo;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			config.addAnnotatedClass(Member.class);
			config.addAnnotatedClass(MemberInfo.class);
			config.addAnnotatedClass(Gift.class);
			
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}
	
}
