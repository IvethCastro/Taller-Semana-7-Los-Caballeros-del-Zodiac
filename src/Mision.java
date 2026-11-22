public class Mision {

    // Atributos
    private String descripcion;
    private int nivelDificultad;
    private double recompensaMision;

    // Constructor vacío
    public Mision() {
    }

    // Constructor con parámetros
    public Mision(String descripcion, int nivelDificultad,
                  double recompensaMision) {

        setDescripcion(descripcion);
        setNivelDificultad(nivelDificultad);
        setRecompensaMision(recompensaMision);
    }

    // Getter y Setter de descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripción de la misión no puede estar vacía."
            );
        }

        this.descripcion = descripcion.trim();
    }

    // Getter y Setter de nivelDificultad
    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        if (nivelDificultad < 1 || nivelDificultad > 5) {
            throw new IllegalArgumentException(
                    "La dificultad debe estar entre 1 y 5."
            );
        }

        this.nivelDificultad = nivelDificultad;
    }

    // Getter y Setter de recompensaMision
    public double getRecompensaMision() {
        return recompensaMision;
    }

    public void setRecompensaMision(double recompensaMision) {
        if (!Double.isFinite(recompensaMision)
                || recompensaMision < 0) {
            throw new IllegalArgumentException(
                    "La recompensa debe ser un número válido y no negativo."
            );
        }

        this.recompensaMision = recompensaMision;
    }

    // Mostrar información de la misión
    @Override
    public String toString() {
        return "Descripción: " + descripcion
                + "\nDificultad: " + nivelDificultad
                + "\nRecompensa: " + recompensaMision
                + " monedas doradas";
    }
}
