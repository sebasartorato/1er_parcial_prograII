
package sartorato.sebastian.Base;
import sartorato.sebastian.Exceptions.NombreInvalidoException;
import sartorato.sebastian.Exceptions.GeneroMusicalInvalido;
/**
 *
 * @author sebas
 */
public class Artista {
    private String nombre;
    private String generoMusical;

    public Artista(String nombre, String generoMusical) throws NombreInvalidoException, GeneroMusicalInvalido {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NombreInvalidoException("El nombre del artista no puede estar vacío.");
        }
        if (generoMusical == null || generoMusical.trim().isEmpty()) {
            throw new GeneroMusicalInvalido("El género musical no puede estar vacío.");
        }
        this.nombre = nombre;
        this.generoMusical = generoMusical;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }
    
    public static boolean sonIguales(Artista artista1, Artista artista2){
        return artista1.getNombre().equals(artista2.getNombre()) &&
                (artista2.getGeneroMusical().equals(artista2.getGeneroMusical()));
    }
    
    public String getNombreGenero(){
        return getNombre() + ":"+getGeneroMusical();
    }
    
    
}
