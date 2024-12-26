
package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;


public class LibroRepository implements GenericRepository<Libro>{
    
    private ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    @Override
    public void save(Libro entitiy) {
        controlPersis.save(entitiy);
    }

    @Override
    public void update(Libro entity) {
        controlPersis.update(entity);
    }

    @Override
    public void delete(Libro entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Libro findById(long id) {
        return controlPersis.findByID(id);
    }

    @Override
    public List<Libro> findAll() {
        return controlPersis.findAll();
    }
    
}
