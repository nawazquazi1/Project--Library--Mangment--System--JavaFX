package com.example.libary.dao;

import com.example.libary.entity.Book;
import com.example.libary.entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * @author nawaz
 */
public class Dao {

	SessionFactory factory;
	
	public Dao(Book book) {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Book.class)
				.buildSessionFactory();
	}
	public Dao(Member member) {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Member.class)
				.buildSessionFactory();
	}
	
	
	private Session session;

	public boolean addBook(Book book) {
		session = factory.openSession();
		
		try {
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
		} catch (Exception e) {
			return false;
			// Rise an error message
			// Failed
		}
		return true;
	}

	public ObservableList<Book> getAllBooks() {
		session = factory.openSession();
		try {
			session.beginTransaction();
			return FXCollections.observableList(session.createQuery("FROM Book").getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FXCollections.observableArrayList();
	}	
	
	public boolean addMember(Member member) {
		session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(member);
			session.getTransaction().commit();
		} catch (Exception e) {
			return false;
			// Rise an error message
			// Failed
		}
		return true;
	}
	public ObservableList<Member> getAllMembers() {
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			return FXCollections.observableList(session.createQuery("FROM Member").getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FXCollections.observableArrayList();
	}
}
