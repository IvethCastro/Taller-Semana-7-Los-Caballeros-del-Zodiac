import java.util.ArrayList;

public class GestionCaballeros {
    private ArrayList<Caballero> listaCaballeros;
    public GestionCaballeros() {
        listaCaballeros = new ArrayList<>();
    }

    public boolean registrarCaballero(Caballero caballero) {
        if (caballero == null) {
            throw new IllegalArgumentException(
                    "El caballero no puede ser nulo."
            );
        }

        if (existeId(caballero.getIdCaballero())) {
            return false;
        }

        listaCaballeros.add(caballero);
        return true;
    }

    public boolean existeId(int id) {
        return buscarCaballero(id) != null;
    }

    public Caballero buscarCaballero(int id) {
        for (int i = 0; i < listaCaballeros.size(); i++) {
            Caballero c = listaCaballeros.get(i);   // get(i) es O(1)

            if (c.getIdCaballero() == id) {
                return c;
            }
        }

        return null;
    }

    public boolean modificarCaballero(int id, String nombre, String rango, String constelacion, int nivelPoder) {

        Caballero caballero = buscarCaballero(id);

        if (caballero == null) {
            return false;
        }

        new Caballero(id, nombre, rango, constelacion, nivelPoder);

        caballero.setNombre(nombre);
        caballero.setRango(rango);
        caballero.setConstelacion(constelacion);
        caballero.setNivelPoder(nivelPoder);

        return true;
    }

    public ArrayList<Caballero> listarCaballeros() {
        return new ArrayList<>(listaCaballeros);
    }

    public boolean estaVacia() {
        return listaCaballeros.isEmpty();
    }

    public int cantidad() {
        return listaCaballeros.size();
    }
}
