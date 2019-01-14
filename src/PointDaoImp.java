import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.LinkedList;

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
    public void updatePoint(Points point)throws SQLException {
        Session session = null;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(point);
            session.getTransaction().commit();


    }


        @Override
    public Points getPointById(Long id) throws SQLException {
        Session session = null;
        Points point = null;

            session = HibernateUtil.getSessionFactory().openSession();
            point =  session.load(Points.class, id);

        return point;
    }

    @Override
    public LinkedList getAllPoint() {
        LinkedList<Points> point = new LinkedList<Points>();
        Session session = HibernateUtil.getSessionFactory().openSession();
           point = (LinkedList<Points>) session.createCriteria(Points.class).list();

        return point;
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