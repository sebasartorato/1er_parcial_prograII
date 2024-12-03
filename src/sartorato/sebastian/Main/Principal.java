
package sartorato.sebastian.Main;
import sartorato.sebastian.Base.Artista;
import sartorato.sebastian.Base.TiendaMusica;
import sartorato.sebastian.TypesDisco.CD;
import sartorato.sebastian.TypesDisco.Vinilo;
import sartorato.sebastian.Enums.FormatoEnum;
import sartorato.sebastian.Enums.VelocidadEnum;
import sartorato.sebastian.Enums.TipoDiscoEnum;
import sartorato.sebastian.Exceptions.GeneroMusicalInvalido;
import sartorato.sebastian.Exceptions.NombreInvalidoException;
import sartorato.sebastian.Exceptions.PrecioInvalidoException;
/**
 *
 * @author sebas
 */
public class Principal {
    
    public static void main(String[] args) {
        try{    
            TiendaMusica miTienda = new TiendaMusica(7);
            Artista a = new Artista("The Beatles", "Rock");
            Artista b = new Artista("Michael Jackson", "Pop");
            Vinilo v1 = new Vinilo("Abbey Road", 50f, "The Beatles", "Rock", VelocidadEnum.RPM_33);
            CD c1 = new CD("Thriller", 30f, b, FormatoEnum.ESTANDAR);
            Vinilo v2 = new Vinilo("Let It Be", 45f, "The Beatles", "Rock", VelocidadEnum.RPM_45);
            CD c2 = new CD("Bad", 28f, b, FormatoEnum.REMASTERIZADO);
            CD c3 = new CD("Dangerous", 32f, b, FormatoEnum.DOBLE);

            CD c4 = new CD("Off The Wall", 25f, "Michael Jackson", "Pop", FormatoEnum.ESTANDAR);
            miTienda.agregarDisco(v1);
            //YA INGRESADO
            miTienda.agregarDisco(v1);
            miTienda.agregarDisco(c1);
            miTienda.agregarDisco(v2);
            miTienda.agregarDisco(c2);
            miTienda.agregarDisco(c3);
            //SIN LUGAR
            miTienda.agregarDisco(c4);
            System.out.println("");
            //TRUE
            System.out.println(v1.equals(v1));
            //FALSE
            System.out.println(v1.equals("The Beatles"));
            //FALSE
            System.out.println(v1.equals(v2));
            //TRUE
            System.out.println(c1.equals(c1));
            //FALSE
            System.out.println(c1.equals(c2));
            //FALSE
            System.out.println(c1.equals(c4));
            System.out.println("");
            System.out.println(TiendaMusica.mostrar(miTienda));
        }catch(GeneroMusicalInvalido | NombreInvalidoException | PrecioInvalidoException e){
                System.err.println("Error: "+ e.getMessage());
        }   

    }
}
