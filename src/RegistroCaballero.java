import java.util.ArrayList;

public class RegistroCaballero {

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

    public boolean registrarCaballero(
            GestionCaballeros gestion,
            Caballero caballero) {

        if (gestion == null || caballero == null) {
            throw new IllegalArgumentException(
                    "Los datos del registro no son válidos."
            );
        }

        return gestion.registrarCaballero(caballero);
    }
}
