import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

public class Checker {
    private List points;
    private float x = (float) 1.0;
    private float y = (float) 2.0;
    private float r = (float) 3.0;
    private int check;


    public void setR(float r) {
        this.r = r;
    }
    public float getR() {
        return r;
    }

    public void setX(float x) {
        this.x = x;
    }
    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }
    public float getY() {
        return y;
    }


    private void setIscheck(){
        float X = x;
        float Y = y;
        float R = r;
        if(X<=0 && Y<=0 && X*X+Y*Y<=(R/2)*(R/2)){
            check = 1;
            return;
        }
        if(X>=0 && Y>=0 && Y<=(-1*X+0.5*R)){
            check = 1;
            return;
        }
        if(X>=0 && Y<=0 && X<=R && Y>=-R){
            check = 1;
            return;
        }
        check = 0;
    }

    private int getIsCheck() {
        setIscheck();
        return check;
    }

    public void newPoint()  {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if (points == null) points = new LinkedList<Points>();
        Points p = new Points(getR(), getX(), getY(), getIsCheck());
        setPoint(p);
        session.save(p);
        session.getTransaction().commit();
    }




    private void setPoint(Points p){
       points.add(p);
    }

//    public List<Points> getPoints()  {
//        return points;
//    }

    public List<Points> getPoints() {
        Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Points");
            points = (List<Points>) query.list();

        session.getTransaction().commit();
        return points;
    }

}
