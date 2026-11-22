import java.util.ArrayList;

public class GestionRecompensas {

    // Porcentaje que se descuenta para el Fondo del Santuario
    private static final double PORCENTAJE_SANTUARIO = 0.10;

    // Suma las recompensas de todas las misiones del caballero (R)
    public double calcularRecompensaAnual(Caballero caballero) {
        if (caballero == null) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un caballero."
            );
        }

        double total = 0;
        ArrayList<Mision> misiones = caballero.getMisiones();

        for (Mision mision : misiones) {
            total = total + mision.getRecompensaMision();
        }

        return total;
    }

    // Aporte al Fondo del Santuario: R x 0.10
    public double calcularAporteSantuario(double recompensaAnual) {
        validarRecompensa(recompensaAnual);

        return recompensaAnual * PORCENTAJE_SANTUARIO;
    }

    // Impuesto del Reino de Atena según el rango de R
    public double calcularImpuesto(double recompensaAnual) {
        validarRecompensa(recompensaAnual);

        double impuesto;

        if (recompensaAnual <= 100000) {
            impuesto = 0;
        } else if (recompensaAnual <= 200000) {
            impuesto = 0.12 * (recompensaAnual - 100000);
        } else if (recompensaAnual <= 400000) {
            impuesto = 0.25 * (recompensaAnual - 200000);
        } else {
            impuesto = 0.35 * (recompensaAnual - 400000);
        }

        return impuesto;
    }

    // Recompensa neta: R - aporte - impuesto
    public double calcularRecompensaNeta(double recompensaAnual) {
        double aporte = calcularAporteSantuario(recompensaAnual);
        double impuesto = calcularImpuesto(recompensaAnual);

        return recompensaAnual - aporte - impuesto;
    }

    // Informe con los datos del caballero, sus misiones y los cálculos
    public String generarInforme(Caballero caballero) {
        if (caballero == null) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un caballero."
            );
        }

        double recompensaAnual = calcularRecompensaAnual(caballero);
        double aporte = calcularAporteSantuario(recompensaAnual);
        double impuesto = calcularImpuesto(recompensaAnual);
        double neta = calcularRecompensaNeta(recompensaAnual);

        String informe = "        INFORME DEL CABALLERO        \n\n";

        // Datos personales
        informe = informe + "DATOS PERSONALES\n";
        informe = informe + "ID: " + caballero.getIdCaballero() + "\n";
        informe = informe + "Nombre: " + caballero.getNombre() + "\n";
        informe = informe + "Rango: " + caballero.getRango() + "\n";
        informe = informe + "Constelación: " + caballero.getConstelacion() + "\n";
        informe = informe + "Nivel de poder: " + caballero.getNivelPoder() + "\n\n";

        // Misiones
        informe = informe + "MISIONES ASIGNADAS\n";
        ArrayList<Mision> misiones = caballero.getMisiones();

        if (misiones.isEmpty()) {
            informe = informe + "No tiene misiones registradas.\n";
        } else {
            int numero = 1;
            for (Mision mision : misiones) {
                informe = informe + numero + ". " + mision.getDescripcion()
                        + " | Dificultad: " + mision.getNivelDificultad()
                        + " | Recompensa: " + mision.getRecompensaMision() + "\n";
                numero++;
            }
        }

        // Resultados económicos
        informe = informe + "\nRESULTADOS ECONÓMICOS\n";
        informe = informe + "Recompensa anual: " + recompensaAnual + "\n";
        informe = informe + "Aporte al Fondo del Santuario (10%): " + aporte + "\n";
        informe = informe + "Impuesto del Reino de Atena: " + impuesto + "\n";
        informe = informe + "Recompensa neta anual: " + neta + "\n";

        return informe;
    }

    // Comprueba que la recompensa sea válida (no negativa)
    private void validarRecompensa(double recompensaAnual) {
        if (recompensaAnual < 0) {
            throw new IllegalArgumentException(
                    "La recompensa anual no puede ser negativa."
            );
        }
    }
}