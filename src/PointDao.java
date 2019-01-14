import java.sql.SQLException;
import java.util.List;

public interface PointDao {
     void addPoint(Points point) throws SQLException;
     List getAllPoint() throws SQLException;
    void deletePoint(Points point) throws SQLException;
}
