import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class HibernateUtil {


        private static final SessionFactory sessionFactory;

        static {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (ExceptionInInitializerError ex) {
                System.err.println("Initial SessionFactory creation failed: " + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }


         static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }