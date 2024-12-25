
package logica;


public enum CategoriasLibro {
   
    FICCION("Ficcion"),
    CIENCIA("Ciencia"),
    HISTORIA("Historia"),
    TECNOLOGIA("Tecnologia");
    
    private String nombre;
   
    private CategoriasLibro(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
}
