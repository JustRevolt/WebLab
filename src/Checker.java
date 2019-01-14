
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Checker {
    private List points = new LinkedList<>();
    private float x = (float) 1.0;
    private float y = (float) 2.0;
    private float r = (float) 3.0;
    private int ischeck;
    private int id = 0;

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
    public Integer getId() {
        return id;
    }
    public  void setId(Integer id ){
        this.id = id;
    }

    private void setIscheck(){
        float X = x;
        float Y = y;
        float R = r;
        if(X<=0 && Y<=0 && X*X+Y*Y<=(R/2)*(R/2)){
            ischeck = 1;
            return;
        }
        if(X>=0 && Y>=0 && Y<=(-1*X+0.5*R)){
            ischeck = 1;
            return;
        }
        if(X>=0 && Y<=0 && X<=R && Y>=-R){
            ischeck = 1;
            return;
        }
        ischeck = 0;
    }

    private int getIsCheck() {
        setIscheck();
        return ischeck;
    }

    public void newPoint()  {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Points p = new Points(getR(), getX(), getY(), getIsCheck());
        setPoint(p);
        session.save(p);
//        session.getTransaction().commit();
    }

    private void setPoint(Points p){
       points.add(p);
    }

    public List<Points> getPoints() throws SQLException {
        return points;
    }

}
