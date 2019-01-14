import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class PointDaoImp  implements PointDao {


    @Override
    public void addPoint(Points point) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(point);
        tx1.commit();
        session.close();
    }

    @Override
    public List getAllPoint() {
        List<Points> points = (List<Points>)  HibernateUtil.getSessionFactory().openSession().createQuery("From " +
                "Points").list();
        return points;
    }

    @Override
    public void deletePoint(Points point){
        Session session = null;

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(point);
            session.getTransaction().commit();

    }
}