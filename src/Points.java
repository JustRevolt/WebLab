
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name= "POINTS")

public class Points implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "R", nullable = false)
    private Float r;
    @Column(name = "X", nullable = false)
    private Float x;
    @Column(name = "Y", nullable = false)
    private Float y;
    @Column(name = "check", nullable = false)
    private Integer ischeck;

    Points(Float r, Float x, Float y, int ischeck){
        this.r = r;
        this.x = x;
        this.y = y;
        this.ischeck = ischeck;
    }

    public Points() {
    }


    public Float getR() {
        return r;
    }
    public void setR(Float r) {
        this.r = r;
    }

    public Float getX() {
        return x;
    }
    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }
    public void setY(Float y) {
        this.y = y;
    }

    public Integer getIsCheck() {
        return ischeck;
    }
    public void setIsCheck(Integer ischeck) {
        this.ischeck = ischeck;
    }

    public Integer getId() {
        return id;
    }
    public  void setId(Integer id ){
        this.id = id;
    }
}
