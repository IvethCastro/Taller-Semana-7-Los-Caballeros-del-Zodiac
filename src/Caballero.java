
import java.util.ArrayList;

public class Caballero {

    private int idCaballero;
    private String nombre;
    private String rango;
    private String constelacion;
    private int nivelPoder;

    
    private ArrayList<Mision> misiones;

    public Caballero() {
        misiones = new ArrayList<>();
    }

    public Caballero(int idCaballero, String nombre,
                     String rango, String constelacion,
                     int nivelPoder) {

        this();

        setIdCaballero(idCaballero);
        setNombre(nombre);
        setRango(rango);
        setConstelacion(constelacion);
        setNivelPoder(nivelPoder);
    }

    public Caballero(int idCaballero, String nombre,
                     String rango, String constelacion,
                     int nivelPoder, ArrayList<Mision> misiones) {

        this(idCaballero, nombre, rango, constelacion, nivelPoder);
        setMisiones(misiones);
    }

    public int getIdCaballero() {
        return idCaballero;
    }

    public void setIdCaballero(int idCaballero) {
        if (idCaballero <= 0) {
            throw new IllegalArgumentException(
                    "El ID debe ser un número positivo."
            );
        }

        this.idCaballero = idCaballero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        this.nombre = nombre.trim();
    }

        public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        if (rango == null || rango.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El rango no puede estar vacío."
            );
        }

        String rangoValidado = rango.trim();

        if (!rangoValidado.equalsIgnoreCase("Bronce")
                && !rangoValidado.equalsIgnoreCase("Plata")
                && !rangoValidado.equalsIgnoreCase("Oro")) {

            throw new IllegalArgumentException(
                    "El rango debe ser Bronce, Plata u Oro."
            );
        }

        this.rango = rangoValidado;
    }

      public String getConstelacion() {
        return constelacion;
    }

    public void setConstelacion(String constelacion) {
        if (constelacion == null
                || constelacion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La constelación no puede estar vacía."
            );
        }

        this.constelacion = constelacion.trim();
    }

       public int getNivelPoder() {
        return nivelPoder;
    }

    public void setNivelPoder(int nivelPoder) {
        if (nivelPoder < 1 || nivelPoder > 10) {
            throw new IllegalArgumentException(
                    "El nivel de poder debe estar entre 1 y 10."
            );
        }

        this.nivelPoder = nivelPoder;
    }

     public ArrayList<Mision> getMisiones() {
        return new ArrayList<>(misiones);
    }

        public void setMisiones(ArrayList<Mision> misiones) {
        if (misiones == null) {
            throw new IllegalArgumentException(
                    "La lista de misiones no puede ser nula."
            );
        }

        for (Mision mision : misiones) {
            if (mision == null) {
                throw new IllegalArgumentException(
                        "La lista no puede contener misiones nulas."
                );
            }
        }

        this.misiones = new ArrayList<>(misiones);
    }

     public void agregarMision(Mision mision) {
        if (mision == null) {
            throw new IllegalArgumentException(
                    "La misión no puede ser nula."
            );
        }

        misiones.add(mision);
    }

        public int getCantidadMisiones() {
        return misiones.size();
    }

    // Mostrar información del caballero
    @Override
    public String toString() {

        return "ID: " + idCaballero
                + "\nNombre: " + nombre
                + "\nRango: " + rango
                + "\nConstelación: " + constelacion
                + "\nNivel de poder: " + nivelPoder
                + "\nCantidad de misiones: " + misiones.size();
    }
}
