package model;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class IndexTest {
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	@BeforeMethod
	protected void setUp() {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	@AfterMethod
	protected void tearDown() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	@Test
	public void testSaveAndQuery() {
		Index index = new Index();
		index.setId("WIG");
		index.setCurrentValue(new BigDecimal("1515.15"));
		index.setCurrency("PLN");

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(index);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		List<Index> result = session
				.createQuery("from Index i where i.id = :id")
				.setParameter("id", index.getId()).list();
		session.getTransaction().commit();
		session.close();

		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(result.get(0).getId(), index.getId());
		Assert.assertEquals(result.get(0).getCurrentValue(), index.getCurrentValue());
		Assert.assertEquals(result.get(0).getCurrency(), index.getCurrency());
	}
}
