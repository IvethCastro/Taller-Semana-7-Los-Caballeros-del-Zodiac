import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal {
    private JPanel panelPrincipal;
    private JTabbedPane tabbedPane1;
    private JTextField txtId;
    private JTextField txtNombre;
    private JComboBox cmbRango;
    private JTextField txtConstelacion;
    private JTextField txtPoder;
    private JButton btnRegistrar;
    private JTextField txtIdMision;
    private JTextField txtDescripcion;
    private JTextField txtDificultad;
    private JTextField txtRecompensa;
    private JButton btnRegistrarMision;
    private JTextField txtBuscarId;
    private JTextField txtModNombre;
    private JComboBox cmbModRango;
    private JTextField txtModConstelacion;
    private JTextField txtModPoder;
    private JButton btnBuscar;
    private JButton btnModificar;
    private JButton btnListar;
    private JTable tablaCaballeros;
    private JTextField txtIdInforme;
    private JButton btnInforme;
    private JTextArea areaInforme;

    private GestionCaballeros gestion = new GestionCaballeros();
    private RegistroCaballero registro = new RegistroCaballero();
    private GestionRecompensas recompensas = new GestionRecompensas();
    private DefaultTableModel modelo;

    public VentanaPrincipal() {
        cmbRango.addItem("Bronce");
        cmbRango.addItem("Plata");
        cmbRango.addItem("Oro");
        cmbModRango.addItem("Bronce");
        cmbModRango.addItem("Plata");
        cmbModRango.addItem("Oro");

       
        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Rango", "Constelación", "Poder", "Misiones"}, 0);
        tablaCaballeros.setModel(modelo);

        btnRegistrar.addActionListener(e -> registrarCaballero());
        btnRegistrarMision.addActionListener(e -> registrarMision());
        btnBuscar.addActionListener(e -> buscarCaballero());
        btnModificar.addActionListener(e -> modificarCaballero());
        btnListar.addActionListener(e -> listarCaballeros());
        btnInforme.addActionListener(e -> generarInforme());
    }

    private void registrarCaballero() {
        try {
            int id = Integer.parseInt(txtId.getText());
            int poder = Integer.parseInt(txtPoder.getText());
            Caballero c = registro.crearCaballero(id, txtNombre.getText(),
                    cmbRango.getSelectedItem().toString(), txtConstelacion.getText(), poder);

            if (registro.registrarCaballero(gestion, c)) {
                JOptionPane.showMessageDialog(null, "Caballero registrado");
            } else {
                JOptionPane.showMessageDialog(null, "El ID ya existe");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El ID y el poder deben ser números enteros");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void registrarMision() {
        try {
            int id = Integer.parseInt(txtIdMision.getText());
            Caballero c = gestion.buscarCaballero(id);
            int dificultad = Integer.parseInt(txtDificultad.getText());
            double recompensa = Double.parseDouble(txtRecompensa.getText());

            registro.registrarMision(c, txtDescripcion.getText(), dificultad, recompensa);
            JOptionPane.showMessageDialog(null, "Misión registrada");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Revise los números ingresados");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void buscarCaballero() {
        try {
            int id = Integer.parseInt(txtBuscarId.getText());
            Caballero c = gestion.buscarCaballero(id);

            if (c == null) {
                JOptionPane.showMessageDialog(null, "Caballero no encontrado");
            } else {
                // Se muestran los datos actuales en los campos de modificación
                txtModNombre.setText(c.getNombre());
                cmbModRango.setSelectedItem(c.getRango());
                txtModConstelacion.setText(c.getConstelacion());
                txtModPoder.setText(String.valueOf(c.getNivelPoder()));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero");
        }
    }

    private void modificarCaballero() {
        try {
            int id = Integer.parseInt(txtBuscarId.getText());
            int poder = Integer.parseInt(txtModPoder.getText());

            if (gestion.modificarCaballero(id, txtModNombre.getText(),
                    cmbModRango.getSelectedItem().toString(), txtModConstelacion.getText(), poder)) {
                JOptionPane.showMessageDialog(null, "Caballero modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Caballero no encontrado");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El ID y el poder deben ser números enteros");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void listarCaballeros() {
        modelo.setRowCount(0);

        if (gestion.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay caballeros registrados");
            return;
        }

        for (Caballero c : gestion.listarCaballeros()) {
            modelo.addRow(new Object[]{c.getIdCaballero(), c.getNombre(), c.getRango(),
                    c.getConstelacion(), c.getNivelPoder(), c.getCantidadMisiones()});
        }
    }

    private void generarInforme() {
        try {
            int id = Integer.parseInt(txtIdInforme.getText());
            Caballero c = gestion.buscarCaballero(id);

            if (c == null) {
                JOptionPane.showMessageDialog(null, "Caballero no encontrado");
            } else {
                areaInforme.setText(recompensas.generarInforme(c));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero");
        }
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Santuario de Atena");
        ventana.setContentPane(new VentanaPrincipal().panelPrincipal);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
