package interfaz.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.controller.OrdersController;
import excepciones.DataAccessException;
import modelos.Order;
import modelos.OrderItems;
import utils.Utils;

public class PedidosClienteVistaDetalle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textIdCliente;
	private JTextField textNombreCliente;
	private JTable table;
	private DefaultTableModel tableModel;
	private OrdersController ordersController;

	public static void main(String[] args) {
		try {
			PedidosClienteVistaDetalle dialog = new PedidosClienteVistaDetalle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PedidosClienteVistaDetalle() {
		setResizable(false);
		setTitle("Pedidos de un cliente y vista detalle");
		setSize(600, 600);
		setLocation((Utils.AnchoPantalla() - this.getWidth()) / 2, (Utils.AltoPantalla() - this.getHeight()) / 2);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		ordersController = new OrdersController();

		// Label y campo ID cliente
		JLabel lblIdCliente = new JLabel("ID del Cliente");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdCliente.setBounds(80, 30, 137, 30);
		contentPanel.add(lblIdCliente);

		textIdCliente = new JTextField();
		textIdCliente.setBounds(370, 30, 137, 36);
		contentPanel.add(textIdCliente);
		textIdCliente.setColumns(10);

		// Label y campo nombre cliente
		JLabel lblNombreCliente = new JLabel("Nombre del cliente");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreCliente.setBounds(80, 100, 137, 30);
		contentPanel.add(lblNombreCliente);

		textNombreCliente = new JTextField();
		textNombreCliente.setColumns(10);
		textNombreCliente.setBounds(370, 100, 137, 36);
		contentPanel.add(textNombreCliente);

		// Tabla con modelo
		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Order ID", "Customer ID", "Status", "Salesman ID", "Order Date" });
		table = new JTable(tableModel);

		// ScrollPane para que se vean las columnas
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 172, 564, 290);
		contentPanel.add(scrollPane);

		// Botón de buscar pedidos
		JButton btnBuscarPedidos = new JButton("Buscar Pedidos");
		btnBuscarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String idTexto = textIdCliente.getText().trim();
					String nombreTexto = textNombreCliente.getText().trim();

					if (!idTexto.isEmpty()) {
						long customerId = Long.parseLong(idTexto);
						cargarPedidosPorId(customerId);
					} else if (!nombreTexto.isEmpty()) {
						cargarPedidosPorNombre(nombreTexto);
					} else {
						JOptionPane.showMessageDialog(null, "Introduce un ID o un nombre de cliente", "Aviso",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "El ID que has introducido no es valido", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al cargar los pedidos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnBuscarPedidos.setBounds(112, 494, 150, 23);
		contentPanel.add(btnBuscarPedidos);

		JButton btnDetalles = new JButton("Detalles");
		btnDetalles.setEnabled(false);
		btnDetalles.setBounds(10, 494, 89, 23);
		contentPanel.add(btnDetalles);

		// Panel de botones (OK / Cancel)
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

	public void cargarPedidosPorId(long customerId) throws ClassNotFoundException, DataAccessException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		tableModel.setRowCount(0);

		List<Order> pedidos = ordersController.obtenerPedidosPorCliente(customerId);

		for (Order o : pedidos) {
			String fecha = o.getOrderDate() != null ? sdf.format(o.getOrderDate()) : "Sin fecha";
			tableModel.addRow(
					new Object[] { o.getOrderId(), o.getCustomerId(), o.getStatus(), o.getSalesmanId(), fecha });
		}
	}

	public void cargarPedidosPorNombre(String nombreCliente) throws ClassNotFoundException, DataAccessException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		tableModel.setRowCount(0);

		List<Order> pedidos = ordersController.obtenerPedidosPorClienteNombre(nombreCliente);

		for (Order o : pedidos) {
			String fecha = o.getOrderDate() != null ? sdf.format(o.getOrderDate()) : "Sin fecha";
			tableModel.addRow(
					new Object[] { o.getOrderId(), o.getCustomerId(), o.getStatus(), o.getSalesmanId(), fecha });
		}
	}

}
