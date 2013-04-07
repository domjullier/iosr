package model;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class IndexTest {
	private SessionFactory sessionFactory;

	@BeforeMethod
	protected void setUp() {
		// A SessionFactory is set up once for an application
		sessionFactory = new Configuration().configure() // configures settings
															// from
															// hibernate.cfg.xml
				.buildSessionFactory();
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
