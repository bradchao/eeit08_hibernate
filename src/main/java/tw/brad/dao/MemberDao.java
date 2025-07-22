package tw.brad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.entity.Member;
import tw.brad.hi1.HibernateUtil;

public class MemberDao {
	public void save(Member member) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(member);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	public void delete(Member member) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.remove(member);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	public void update(Member member) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.merge(member);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	public Member getById(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Member.class, id);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<Member> getAll() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// SQL(db) => HQL(entity)
			String hql = "FROM Member";
			return session.createQuery(hql, Member.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
}
