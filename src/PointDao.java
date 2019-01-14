import java.sql.SQLException;
import java.util.LinkedList;

public interface PointDao {
     void addPoint(Points point) throws SQLException;
    public void updatePoint(Points point) throws SQLException;
    public Points getPointById(Long id) throws SQLException;
     LinkedList getAllPoint() throws SQLException;
    void deletePoint(Points point) throws SQLException;
}
