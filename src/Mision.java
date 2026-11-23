public class Mision {

    private String descripcion;
    private int nivelDificultad;
    private double recompensaMision;
    public Mision() {
    }

    public Mision(String descripcion, int nivelDificultad,
                  double recompensaMision) {

        setDescripcion(descripcion);
        setNivelDificultad(nivelDificultad);
        setRecompensaMision(recompensaMision);
    }

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

      @Override
    public String toString() {
        return "Descripción: " + descripcion
                + "\nDificultad: " + nivelDificultad
                + "\nRecompensa: " + recompensaMision
                + " monedas doradas";
    }
}
