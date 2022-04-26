package connection;

import java.sql.SQLException;
import java.util.List;

public interface Dao<E> {
    void save(E entity) throws SQLException;
    void update(E entity) throws SQLException;
    void delete(E entity) throws SQLException;
    E get(Integer primarykey) throws SQLException;
    List<E> getAll() throws SQLException;

}
