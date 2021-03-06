package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import server.Initializer;

/**
 * Singleton, which provides SessionFactory configured with settings from configuration file <code>hibernate.cfg.xml</code>
 */
public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    private static final String INITIALIZER_PROPERTY_NAME = "initializer";

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        try {
            String initializerName = configuration.getProperty(INITIALIZER_PROPERTY_NAME);
            if (initializerName != null) {
                Initializer initializer = (Initializer) Class.forName(initializerName).newInstance();
                initializer.initialize();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    /**
     * Provides <code>SessionFactory</code>
     * @return configured <code>SessionFactory</code>
     * @throws HibernateException
     */
    public static SessionFactory getSessionFactory() throws HibernateException {
        return sessionFactory;
    }

}
