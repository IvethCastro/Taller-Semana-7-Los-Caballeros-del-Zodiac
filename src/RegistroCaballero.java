import java.util.ArrayList;

public class RegistroCaballero {

    // Crear un caballero con sus datos personales
    public Caballero crearCaballero(
            int id,
            String nombre,
            String rango,
            String constelacion,
            int nivelPoder) {

        return new Caballero(
                id,
                nombre,
                rango,
                constelacion,
                nivelPoder
        );
    }

    // Crear un caballero con sus datos y sus misiones
    public Caballero crearCaballero(
            int id,
            String nombre,
            String rango,
            String constelacion,
            int nivelPoder,
            ArrayList<Mision> misiones) {

        return new Caballero(
                id,
                nombre,
                rango,
                constelacion,
                nivelPoder,
                misiones
        );
    }

    // Agregar una misión a un caballero
    public void registrarMision(
            Caballero caballero,
            String descripcion,
            int dificultad,
            double recompensa) {

        if (caballero == null) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un caballero."
            );
        }

        Mision nuevaMision = new Mision(
                descripcion,
                dificultad,
                recompensa
        );

        caballero.agregarMision(nuevaMision);
    }

    // Registrar el caballero en la colección general
    public boolean registrarCaballero(
            GestionCaballeros gestion,
            Caballero caballero) {

        if (gestion == null || caballero == null) {
            throw new IllegalArgumentException(
                    "Los datos del registro no son válidos."
            );
        }

        // La clase GestionCaballeros comprueba
        // que el ID no esté duplicado y almacena el objeto.
        return gestion.registrarCaballero(caballero);
    }
}
