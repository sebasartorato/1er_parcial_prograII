
package sartorato.sebastian.Base;
import java.util.Random;
import sartorato.sebastian.Exceptions.GeneroMusicalInvalido;
import sartorato.sebastian.Exceptions.NombreInvalidoException;
import sartorato.sebastian.Exceptions.PrecioInvalidoException;
/**
 *
 * @author sebas
 */
public class Disco {
    protected Artista artista;
    protected int anioLanzamiento;
    protected String titulo;
    protected float precio;
    protected static Random generadorDeAnio;
    
    static{
        generadorDeAnio = new Random();
    }
    
    public Disco(String titulo, float precio, Artista artista)throws NombreInvalidoException, PrecioInvalidoException{
        validarTitulo(titulo);
        validarPrecio(precio);
        this.titulo = titulo;
        this.precio = precio;
        this.artista = artista;
        this.anioLanzamiento = generadorDeAnio.nextInt(2024-1950+1)+1950;
        
    }
    
    public Disco(String titulo, float precio, String nombre, String generoMusical)
        throws NombreInvalidoException, PrecioInvalidoException, GeneroMusicalInvalido{
        validarTitulo(titulo);
        validarPrecio(precio);
        this.titulo = titulo;
        this.precio = precio;
        this.artista = new Artista(nombre, generoMusical);
        this.anioLanzamiento = generadorDeAnio.nextInt(2024-1950+1)+1950;
        
    }
    
    private void validarTitulo(String titulo) throws NombreInvalidoException {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new NombreInvalidoException("El titulo del disco no puede estar vacío.");
        }
    }

    private void validarPrecio(float precio) throws PrecioInvalidoException {
        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio del disco debe ser mayor a cero.");
        }
    }
    
        
    public int getAnioLanzamiento(){
        if (this.anioLanzamiento == 0){
          this.anioLanzamiento = generadorDeAnio.nextInt(2024 - 1950 + 1) + 1950;  
        }
        
        return this.anioLanzamiento;
    }
        
    public float getPrecio(){
        return this.precio;
    }

    public String getTitulo() {
        return titulo;
    }
    
    private String mostrarDisco(Disco disco){
        return toString();
    }

    public static boolean sonIguales(Disco d1, Disco d2) {
        if (d1.titulo.equals(d2.titulo) && d1.artista.equals(d2.artista)) {
                return true;
           }
        return false;
    }
    
    @Override
    public String toString() {
        return "Disco{" + "artista=" + artista + ", anioLanzamiento=" + anioLanzamiento + ", titulo=" + titulo + ", precio=" + precio + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Disco otroDisco = (Disco) obj;
        
        return sonIguales(this, otroDisco);
    }
    
}
