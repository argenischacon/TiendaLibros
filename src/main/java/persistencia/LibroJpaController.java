package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import logica.Libro;

public class LibroJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public LibroJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TiendaLibrosPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear un nuevo libro
    public void create(Libro libro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Buscar un libro por su ID
    public Libro findLibro(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todos los libros
    public List<Libro> findAllLibros() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l ORDER BY l.id ASC", Libro.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Libro> findByCriteria(String criterio){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE LOWER(l.autor) LIKE LOWER(:criterio) "
                    + "OR LOWER(l.titulo) LIKE LOWER(:criterio) "
                    + "OR LOWER(l.categoria) LIKE LOWER(:criterio) ORDER BY l.id ASC", Libro.class);
            query.setParameter("criterio", "%"+criterio+"%");
            return query.getResultList();
        }finally{
           em.close();
        }
    }
    
    
    

    // Actualizar un libro existente
    public void edit(Libro libro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Eliminar un libro por su ID
    public void delete(Long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro = em.find(Libro.class, id);
            if (libro != null) {
                em.remove(libro);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
