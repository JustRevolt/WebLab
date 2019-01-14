import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class HibernateUtil {
//        private static final String URL = "jdbc:oracle:thin:@localhost:1521:orbis";
//        private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//        private static final String USER = "s243855";
//        private static final String PASSWORD = "yaj783";
//        private static final SessionFactory sessionFactory;

//        static {
////            Properties properties = new Properties();
////            properties.setProperty("hibernate.connection.url", URL);
////            properties.setProperty("hibernate.connection.driver_class", DRIVER);
////            properties.setProperty("hibernate.connection.username", USER);
////            properties.setProperty("hibernate.connection.password", PASSWORD);
////
////            sessionFactory = new Configuration().addProperties(properties).
////                    addAnnotatedClass(Checker.class).buildSessionFactory();
//        }

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