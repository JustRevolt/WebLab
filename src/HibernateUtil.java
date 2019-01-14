import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class HibernateUtil {


        private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();



         static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }