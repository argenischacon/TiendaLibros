
package persistencia;

import java.util.List;
import logica.Libro;


public class ControladoraPersistencia {
    private LibroJpaController libroJpaCon = new LibroJpaController();
    
    public List<Libro> findAll() {
        return libroJpaCon.findAllLibros();
    }

    public void save(Libro entitiy) {
        libroJpaCon.create(entitiy);
    }

    public void update(Libro entity) {
        libroJpaCon.edit(entity);
    }

    public Libro findByID(long id) {
        return libroJpaCon.findLibro(id);
    }

    public void delete(Libro entity) {
        libroJpaCon.delete(entity.getId());
    }

    public List<Libro> findByCriteria(String criterio) {
        return libroJpaCon.findByCriteria(criterio);
    }
    
}
