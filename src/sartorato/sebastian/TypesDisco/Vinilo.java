
package sartorato.sebastian.TypesDisco;

import sartorato.sebastian.Base.Disco;
import sartorato.sebastian.Enums.VelocidadEnum;
import sartorato.sebastian.Exceptions.GeneroMusicalInvalido;
import sartorato.sebastian.Exceptions.NombreInvalidoException;
import sartorato.sebastian.Exceptions.PrecioInvalidoException;
import sartorato.sebastian.Base.Artista;

/**
 *
 * @author sebas
 */
public class Vinilo extends Disco{
    private VelocidadEnum velocidad;

    public Vinilo(String titulo, float precio, Artista artista, VelocidadEnum velocidad) throws PrecioInvalidoException, NombreInvalidoException{
        super(titulo, precio, artista);
        validarVelocidad(velocidad);
        this.velocidad = velocidad;
    }

    public Vinilo(String titulo, float precio, String nombre, String generoMusical, VelocidadEnum velocidad)
        throws PrecioInvalidoException, NombreInvalidoException, GeneroMusicalInvalido {
        super(titulo, precio, nombre, generoMusical);
        validarVelocidad(velocidad);
        this.velocidad = velocidad;
    }

    public VelocidadEnum getVelocidad() {
        return velocidad;
    }
    
    private void validarVelocidad(VelocidadEnum velocidad) {
        if (velocidad == null) {
            throw new IllegalArgumentException("La velocidad no puede ser nula.");
        }
    }
    
    @Override
    public String toString() {
        return "Vinilo{" + "velocidad=" + velocidad + '}' + super.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vinilo otroVinilo = (Vinilo) obj;
        boolean sonDiscosIguales = sonIguales(this, otroVinilo);

        return sonDiscosIguales && this.velocidad == otroVinilo.velocidad;
    }
       
    
    
}
