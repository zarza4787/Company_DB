package interfaz.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import utils.Utils;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.controller.EmpleadoController;
import modelos.Employee;

import java.util.List;

public class EliminarEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private JTable table;
	private EmpleadoController empleadoController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EliminarEmpleado dialog = new EliminarEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cargarEmpleadosEnTabla() {
		try {
			List<Employee> empleados = empleadoController.obtenerTodosEmpleados();

			model.setRowCount(0);

			for (Employee emp : empleados) {
				model.addRow(new Object[] { emp.getEmployeeID(), emp.getName(), emp.getLastName(), emp.getEmail(),
						emp.getPhone(), emp.getHireDate(), emp.getManagerId(), emp.getJobTitle() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error al cargar empleados: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the dialog.
	 */
	public EliminarEmpleado() {
		empleadoController = new EmpleadoController();

		setResizable(false);
		setTitle("Eliminar empleado");
		setSize(950, 600);
		setLocation((Utils.AnchoPantalla() - this.getWidth()) / 2, (Utils.AltoPantalla() - this.getHeight()) / 2);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		model = new DefaultTableModel();
		table = new JTable(model);
		model.setColumnIdentifiers(new String[] { "ID", "Nombre", "Apellidos", "Email", "Teléfono", "Fecha de alta",
				"ID Manager", "Puesto" });

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 914, 319);
		contentPanel.add(scrollPane);

		cargarEmpleadosEnTabla();

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton eliminarEmpleado = new JButton("Eliminar empleado");
		eliminarEmpleado.addActionListener(e -> {
			int filaSeleccionada = table.getSelectedRow();

			if (filaSeleccionada == -1) {
				JOptionPane.showMessageDialog(null, "Por favor selecciona una fila.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(null, "Esta operación no se podrá deshacer, ¿estás seguro?",
					"Confirmar eliminación", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				try {
					Object id = table.getValueAt(filaSeleccionada, 0);

					long employeeId = Long.parseLong(id.toString());

					empleadoController.eliminarEmpleado(employeeId);

					cargarEmpleadosEnTabla();

					JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonPane.add(eliminarEmpleado);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(e -> dispose());
		buttonPane.add(cancelButton);
	}

}
