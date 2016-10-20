package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MyHibernateSessionFactory {
	
	private static SessionFactory sessionFactory;
	
	
	private MyHibernateSessionFactory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			Configuration cfg=new Configuration().configure();
			StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder()
			.applySettings(cfg.getProperties());
			ServiceRegistry serviceRegistry=ssrb.build();
			
			sessionFactory=cfg.buildSessionFactory(serviceRegistry);
		}
		
		return sessionFactory;
	}

}
