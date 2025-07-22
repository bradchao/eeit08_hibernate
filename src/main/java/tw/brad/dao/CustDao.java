package tw.brad.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.entity.Cust;
import tw.brad.entity.Order;
import tw.brad.hi1.HibernateUtil;

public class CustDao {
	public void save(Cust cust) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(cust);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	public void delete(Cust cust) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.remove(cust);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	public void update(Cust cust) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.merge(cust);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public Cust getById(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Cust cust = session.get(Cust.class, id); 
			//Hibernate.initialize(cust.getOrders());
			
			return cust;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public Order getOrderById(int id) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Order.class, id);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	public void removeOrderFromCust(long custId, long orderId) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Cust cust = session.get(Cust.class, custId);
			Order delOrder = null;
			for (Order order : cust.getOrders()) {
				if (order.getId() == orderId) {
					delOrder = order;
					break;
				}
			}
			
			if (delOrder != null) {
				cust.delOrder(delOrder);
			}
			
			session.merge(cust);
			
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

}
