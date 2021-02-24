package ua.lviv.lgs;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Application {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Item item1 = new Item("aaa");
//		session.persist(item1);
		Item item2 = new Item("bbb");
//		session.persist(item2);
		Item item3 = new Item("ccc");
//		session.persist(item3);
		Item item4 = new Item("ddd");
//		session.persist(item4);
								
		Cart cart1 = new Cart("a1", "name1");
		cart1.setItems(new HashSet<>(Arrays.asList(item1, item2)));
		session.persist(cart1);
		
		Cart cart2 = new Cart("b2", "name2");
		cart2.setItems(new HashSet<>(Arrays.asList(item3, item4)));
		session.persist(cart2);
		
		transaction.commit();
		session.close();

	}
}
