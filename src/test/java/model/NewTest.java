package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class NewTest {
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
	public void f() {
		Assert.assertEquals(1 + 1, 2);
	}
}
