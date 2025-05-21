package dao.controller;

import java.util.List;

import dao.OrdersDAO;
import excepciones.DataAccessException;
import modelos.Order;
import modelos.OrderItems;

/**
 * Controlador para gestionar las operaciones con pedidos
 */
public class OrdersController {

	private OrdersDAO ordersDAO;

	/**
	 * Constructor que inicializa el DAO de pedidos.
	 */
	public OrdersController() {
		this.ordersDAO = new OrdersDAO();
	}
	
	/**
	 * Obtiene todos los pedidos realizados por un cliente atraves de la ID
	 * 
	 * @param customerId id del cliente
	 * @return Lista de objetos Order asociados al cliente
	 * @throws DataAccessException si ocurre un error al acceder a la base de datos
	 */
	public List<Order> obtenerPedidosPorCliente(long customerId) throws DataAccessException, ClassNotFoundException {
		try {
			return ordersDAO.obtenerPedidosPorClienteID(customerId);
		} catch (DataAccessException e) {
			throw new DataAccessException("Error al obtener los pedidos", e);
		}
	}
	
	/**
	 * Obtiene todos los pedidos realizados por un cliente según su nombre.
	 * 
	 * @param name nombre del cliente
	 * @return Lista de objetos order asociados al cliente
	 * @throws DataAccessException si ocurre un error al acceder a la base de datos
	 */
	public List<Order> obtenerPedidosPorClienteNombre(String name) throws DataAccessException, ClassNotFoundException {
		try {
			return ordersDAO.obtenerPedidosPorClienteNombre(name);
		} catch (DataAccessException e) {
			throw new DataAccessException("Error al obtener los pedidos", e);
		}
	}
	
	/**
	 * Obtiene el detalle de un pedido especifico incluyendo los productos asociados
	 * 
	 * @param orderId id del pedido.
	 * @return Lista de objetos OrderItems que son los productos del pedido.
	 * @throws DataAccessException si ocurre un error al acceder a la base de datos.
	 */
	public List<OrderItems> obtenerDetallePedido(long orderId)  throws DataAccessException, ClassNotFoundException {
		try {
			return ordersDAO.obtenerDetallePedido(orderId);
		} catch (DataAccessException e) {
			throw new DataAccessException("Error al obtener el detalle del pedido", e);
		}
	}
	
	
}
