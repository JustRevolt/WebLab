
import java.sql.SQLException;
import java.util.LinkedList;

public class Checker {
    private LinkedList points = new LinkedList<>();
    private float x = (float) 1.0;
    private float y = (float) 2.0;
    private float r = (float) 3.0;
    private int ischeck;

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

    public void newPoint() throws SQLException {
        Points p = new Points(getR(), getX(), getY(), getIsCheck());
            Factory.getInstance().getPointDao().addPoint(p);
            setPoint(p);

    }

    private void setPoint(Points p){
       points.add(p);
    }

    public LinkedList<Points> getPoints() throws SQLException {
      points = Factory.getInstance().getPointDao().getAllPoint();
        return points;
    }

}
