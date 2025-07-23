package tw.brad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.entity.Course;
import tw.brad.entity.Student;
import tw.brad.hi1.HibernateUtil;

public class SCDao {
	public void save(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(student);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	public void save(Course course) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(course);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void delete(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.remove(student);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	
	public Student update(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.merge(student);
			transaction.commit();
			return getById(student.getId());
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		}
	}	
	
	public Student getById(Long studentId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Student.class, studentId);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;		
	}
	
	public Course getCourseById(Long courseId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Course.class, courseId);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;		
	}
	
	public List<Course> getAllCourses(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("FROM Course", Course.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;		
	}
	
	
	
	
	
	
	
	
	
}
