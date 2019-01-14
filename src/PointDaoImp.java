import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.LinkedList;
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
        List<Points> results = new LinkedList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Points");
//            results = (List<Points>) query.list();
        return results;
    }

    @Override
    public void deletePoint(Points point){
       Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(point);
            session.getTransaction().commit();

    }
}