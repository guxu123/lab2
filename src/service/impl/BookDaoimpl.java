package service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mysql.fabric.xmlrpc.base.Array;

import db.MyHibernateSessionFactory;
import entity.author;
import entity.book;
import service.BookDAO;

public class BookDaoimpl implements BookDAO{
	SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
	public List<book> querryAllBook() {
		// TODO Auto-generated method stub
		
		
		List<book> list = new ArrayList<book>();
		Long count = (long) 0;
		String hql = "from book book";
		Session session = factory.openSession();
		try{
			
			
			session.beginTransaction();
			count = (Long) session.createQuery("select count(*) from Students stu").iterate().next();
			session.getTransaction().commit();
			Query q=session.createQuery(hql);
			list = q.list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			
		}finally{
			session.close();
		}
		
		System.out.println(count);
		Iterator<book> iterator=list.iterator();
		
		while(iterator.hasNext()){
			book students=iterator.next();
			System.out.println(students.toString());
		}
		
		return list;
	}

	
	
	
	public author querryAuthorByID(int sid) {
		Session session=null;
		author au = null;
		try {
			SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
			session=factory.openSession();
			session.beginTransaction();
			au=(author) session.get(author.class, sid);
			session.getTransaction().commit();
			return au;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return au;
		}finally{
			session.close();
		}
		
	}

	public boolean delBookBySid(int sid) {
		Session session=null;
		try {
			SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
			session=factory.openSession();
			session.beginTransaction();
			book s=(book) session.get(book.class, sid);
			session.delete(s);
			
			
			session.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}

	public boolean addBook(book book) {
		Session session=null;
		try {
			SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
			session=factory.openSession();
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}finally{
			session.close();
		}
	}

	public boolean updateBook(book book) {
		Session session=null;
		try {
			SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
			session=factory.openSession();
			session.beginTransaction();
			session.update(book);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}finally{
			session.close();
		}
		
	}

	public List<book> queryBookByAuthorID(int AuthorID) {
		Session session=null;
		String hql = "from book where AuthorID=:authorid";
		List<book> list = new ArrayList<book>();
		try {
			SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
			session=factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("authorid", AuthorID);
			
			list = query.list();
			session.getTransaction().commit();
			return list;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return list;
		}finally{
			session.close();
		}
	}

	public author queryAuthorByName(String Name) {
		Session session=null;
		String hql = "from author where Name=:name";
		List<author> list = new ArrayList<author>();
		author au = null;
		try {
			SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
			session=factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("name", Name);
			
			list = query.list();
			au = (author)list.get(0);
			session.getTransaction().commit();
			return au;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return au;
		}finally{
			session.close();
		}
	}




	public book queryBookByID(int id) {
		Session session=null;
		book au = null;
		try {
			SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
			session=factory.openSession();
			session.beginTransaction();
			au=(book) session.get(book.class, id);
			session.getTransaction().commit();
			return au;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return au;
		}finally{
			session.close();
		}
		
	}




	public boolean Author_is_in(int AuthorID) {
		Session session=null;
		String hql = "from author where AuthorID=:id";
		List<author> list = new ArrayList<author>();
		
		try {
			SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
			session=factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("id", AuthorID);
			
			list = query.list();
			session.getTransaction().commit();
			if(list.size()>0 && list != null){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}




	public boolean addAuthor(author author) {
		Session session=null;
		try {
			SessionFactory factory=MyHibernateSessionFactory.getSessionFactory();
			session=factory.openSession();
			session.beginTransaction();
			session.save(author);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}finally{
			session.close();
		}
	}
	

}
