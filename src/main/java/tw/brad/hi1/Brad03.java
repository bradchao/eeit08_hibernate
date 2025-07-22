package tw.brad.hi1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class Brad03 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction = session.beginTransaction();

			String sql = "SELECT * FROM member";
			NativeQuery query = session.createNativeQuery(sql);
			List list = query.getResultList();
			for (Object row : list) {
				Object[] data = (Object[])row;
				Integer id =  (Integer)data[0];
				String account =  (String)data[1];
				String passwd =  (String)data[2];
				String name =  (String)data[3];
				System.out.printf("%d:%s:%s:%s\n", id, account, name, passwd);
			}
			
			transaction.commit();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}		
	}
}
