
package logica;

import java.util.List;


public interface GenericRepository<T> {
    void save(T entitiy);
    void update(T entity);
    void delete(T entity);
    T findById(long id);
    List<T> findAll();
}
