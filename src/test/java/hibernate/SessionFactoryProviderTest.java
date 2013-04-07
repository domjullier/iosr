package hibernate;

import org.hibernate.SessionFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionFactoryProviderTest {

  @Test
  public void getSessionFactory() {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    
    Assert.assertNotNull(sessionFactory);
  }
}
