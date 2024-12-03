
package sartorato.sebastian.Base;
import sartorato.sebastian.TypesDisco.CD;
import sartorato.sebastian.TypesDisco.Vinilo;
import sartorato.sebastian.Base.Disco;
import java.util.ArrayList;
import sartorato.sebastian.Enums.TipoDiscoEnum;
/**
 *
 * @author sebas
 */
public class TiendaMusica {
    private int capacidadMaxima;
    private ArrayList <Disco> listaDiscos;

    private TiendaMusica() {
        this.capacidadMaxima = 5;
        this.listaDiscos = new ArrayList<>();
    }
    
    public TiendaMusica(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima; 
        this.listaDiscos = new ArrayList<>(); 
    }
    
    public boolean sonIguales(Disco disco) {
        for (Disco d : listaDiscos) {
            if (Disco.sonIguales(d, disco)) {
                return true; 
            }
        }
        return false; 
    }
    
    public void agregarDisco (Disco disco) {
        if (listaDiscos.size() < capacidadMaxima) {
            if (!sonIguales(disco)) {
                listaDiscos.add(disco);
            } else {
                System.out.println("El disco ya está en la tienda.");
            }
        } else {
            System.out.println("No hay capacidad para agregar más discos.");
        }
    }
    private float getPrecio(TipoDiscoEnum tipoDisco) {
        float totalPrecio = 0.0f; // Acumulador para el precio total

        for (Disco disco : listaDiscos) {
            if (tipoDisco == TipoDiscoEnum.CDS && disco instanceof CD) {
                totalPrecio += disco.getPrecio(); 
            } else if (tipoDisco == TipoDiscoEnum.VINILOS && disco instanceof Vinilo) {
                totalPrecio += disco.getPrecio();
            } else if (tipoDisco == TipoDiscoEnum.TODOS) {
                totalPrecio += disco.getPrecio(); 
            }
        }
        return totalPrecio; // Retorna el precio total
    }
    
     public double getPrecioDeVinilos() {
        return getPrecio(TipoDiscoEnum.VINILOS); 
    }

    public double getPrecioDeCDs() {
        return getPrecio(TipoDiscoEnum.CDS); 
    }

    public double getPrecioTotal() {
        return getPrecio(TipoDiscoEnum.TODOS); 
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public ArrayList<Disco> getListaDiscos() {
        return listaDiscos;
    }
    
    public static String mostrar(TiendaMusica tienda) {
        if (tienda == null) {
            throw new IllegalArgumentException("La tienda no puede ser nula.");
        }
        return tienda.toString(); 
    }
    
    @Override
    public String toString() {
        String result = "Tienda de Musica\n";
        result += "Capacidad: " + capacidadMaxima + "\n";
        result += "Discos: \n";
        for (Disco disco : listaDiscos) {
            result += "- " + disco.toString()+ "\n"; 
        }
        
        result += "Precio total de CDs: $" + getPrecioDeCDs() + "\n"; 
        result += "Precio total de Vinilos: $" + getPrecioDeVinilos() + "\n";
        result += "Precio total de la tienda: $" + getPrecioTotal() + "\n"; 
        return result;
    }
    
}
