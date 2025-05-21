package dao.controller;

import java.util.List;

import dao.OrdersDAO;
import excepciones.DataAccessException;
import modelos.Order;
import modelos.OrderItems;

public class OrdersController {

	private OrdersDAO ordersDAO;

	public OrdersController() {
		this.ordersDAO = new OrdersDAO();
	}
	
	public List<Order> obtenerPedidosPorCliente(long customerId) throws DataAccessException, ClassNotFoundException {
		try {
			return ordersDAO.obtenerPedidosPorClienteID(customerId);
		} catch (DataAccessException e) {
			throw new DataAccessException("Error al obtener los pedidos", e);
		}
	}
	
	public List<Order> obtenerPedidosPorClienteNombre(String name) throws DataAccessException, ClassNotFoundException {
		try {
			return ordersDAO.obtenerPedidosPorClienteNombre(name);
		} catch (DataAccessException e) {
			throw new DataAccessException("Error al obtener los pedidos", e);
		}
	}
	
	public List<OrderItems> obtenerDetallePedido(long orderId)  throws DataAccessException, ClassNotFoundException {
		try {
			return ordersDAO.obtenerDetallePedido(orderId);
		} catch (DataAccessException e) {
			throw new DataAccessException("Error al obtener el detalle del pedido", e);
		}
	}
	
	
}
