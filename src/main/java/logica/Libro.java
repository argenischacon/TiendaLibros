
package logica;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Libro {
    @Id
    private long id;
    private String titulo;
    private String autor;
    private double precio;
    @Column(name = "cat_libro")
    private CategoriasLibro categoria;
    private Date fechaPublicacion;

    public Libro() {
    }

    public Libro(long id, String titulo, String autor, double precio, CategoriasLibro categoria, Date fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaPublicacion = fechaPublicacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CategoriasLibro getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasLibro categoria) {
        this.categoria = categoria;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
  
}
