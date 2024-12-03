
package sartorato.sebastian.TypesDisco;

import sartorato.sebastian.Base.Disco;
import sartorato.sebastian.Enums.FormatoEnum;
import sartorato.sebastian.Exceptions.GeneroMusicalInvalido;
import sartorato.sebastian.Exceptions.NombreInvalidoException;
import sartorato.sebastian.Exceptions.PrecioInvalidoException;
import sartorato.sebastian.Base.Artista;
/**
 *
 * @author sebas
 */
public class CD extends Disco {
    private FormatoEnum formato;

    public CD(String titulo, float precio, Artista artista, FormatoEnum formato)throws PrecioInvalidoException, NombreInvalidoException {
        super(titulo, precio, artista);
        validarFormato(formato);
        this.formato = formato;
    }

    public CD(String titulo, float precio, String nombre, String generoMusical, FormatoEnum formato)throws PrecioInvalidoException, NombreInvalidoException, GeneroMusicalInvalido {
        super(titulo, precio, nombre, generoMusical);
        validarFormato(formato);
        this.formato = formato;
    }
    
    private void validarFormato(FormatoEnum formato) {
        if (formato == null) {
            throw new IllegalArgumentException("El formato no puede ser nulo.");
        }
    }
    
    @Override
    public String toString() {
        return "CD{" + "formato=" + formato + '}' + super.toString();
    }
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CD otroCD = (CD) obj;

        boolean sonDiscosIguales = sonIguales(this, otroCD);

        return sonDiscosIguales && this.formato == otroCD.formato;
    }
    
}
