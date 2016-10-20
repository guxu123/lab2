package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import service.BookDAO;
import service.impl.BookDaoimpl;

public class StudentsTest {
	Configuration cfg=new Configuration().configure();
	StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder()
	.applySettings(cfg.getProperties());
	ServiceRegistry serviceRegistry=ssrb.build();
	
	SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);
	
	
	public void createTable(){
		Configuration cfg=new Configuration().configure();
		
		SchemaExport se=new SchemaExport(cfg);
		
		se.create(true,true);
		
	}
	@Test
	public void addStudent(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		book book1 = new book(1,"安卓",123,"商务印书馆","lsdjk",23);
		book book2 = new book(2,"C#",121,"北京大学出版社","lsdjk",35);
		book book3 = new book(3,"C++",121,"上海出版社","lsdjk",34);
		book book4 = new book(4,"java",122,"哈工大出版社","lsdjk",120);
		book book5 = new book(5,"安徒生童话",123," qinghua ","lsdjk",300);
		author au1 = new author(123,"安徒生",23,"china");
		author au2 = new author(122,"顾旭",23,"china");
		author au3 = new author(121,"度量",23,"china");
		//System.out.println(s1.toString());
		session.save(book2);
		session.save(book3);
		session.save(book4);
		session.save(book1);
		session.save(book5);
		session.save(au1);
		session.save(au2);
		session.save(au3);
		tx.commit();
		sessionFactory.close();
	}

	
	@Test
	public void testquerybook(){
		BookDAO book = new BookDaoimpl();
		author a = new author();
		List<book> list = new ArrayList<book>();
		a= book.queryAuthorByName("安徒生");
		list = book.queryBookByAuthorID(a.getAuthorID());
		if(book.Author_is_in(1232323) == false){
			System.out.println("dsjfjdskjhfkjdshfjk");
		}
		//System.out.println(a);
		for(book i:list){
			System.out.println(i);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
