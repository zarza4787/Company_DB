package dao;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.modelos.DaoPedidos;
import excepciones.DataAccessException;
import modelos.Order;
import modelos.OrderItems;
import utils.DBUtils;

/**
 * Clase DAO para acceder y gestionar pedidos y sus detalles en la base de datos.
 * 
 * Obtener pedidos por ID de cliente
 * Obtener pedidos por nombre de cliente
 * Obtener detalles de un pedido (items asociados)
 * 
 */

public class OrdersDAO implements DaoPedidos {

	private final String QUERY_OBTENER_PEDIDOS_POR_CLIENTE = "SELECT * FROM ORDERS WHERE CUSTOMER_ID = ?";
	private final String QUERY_OBTENER_DETALLES_PEDIDOS_POR_ORDERID = "SELECT * FROM ORDER_ITEMS WHERE ORDER_ID = ?";
	private final String QUERY_OBTENER_PEDIDOS_POR_NOMBRE_CLIENTE = "SELECT * FROM ORDERS o JOIN CUSTOMERS c ON O.CUSTOMER_ID = c.customer_id WHERE LOWER(c.name) LIKE LOWER(?)";
		
	/**
	 * Obtiene la lista de pedidos de un cliente por su ID
	 * 
	 * @param customerID (id del cliente)
	 * @return Lista de objetos que son del cliente
	 * @throws DataAccessException Si ocurre un error en la base de datos		
	 */
	@Override
	public List<Order> obtenerPedidosPorClienteID(long customerId) throws DataAccessException, ClassNotFoundException {
		List<Order> orderList = new ArrayList<>();

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_PEDIDOS_POR_CLIENTE);
			ps.setLong(1, customerId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long orderId = rs.getLong("ORDER_ID");
				long customerID = rs.getLong("CUSTOMER_ID");
				String status = rs.getString("STATUS");
				long salesmanId = rs.getLong("SALESMAN_ID");
				

				Order order = new Order(orderId, customerID, status, salesmanId);
				orderList.add(order);
			}

		} catch (SQLException sql) {
			throw new DataAccessException("Error de base de datos", sql);
		}
		return orderList;
	}
	/**
	 * Obtiene lista de pedidos de un cliente por el nombre 
	 * 
	 * @param name Nombre del cliente
	 * @return Lista de objetos que le corresponde al cliente
	 * @throws DataAccessException Si ocurre un error en la base de datos.
	 */
	@Override
	public List<Order> obtenerPedidosPorClienteNombre(String name) throws DataAccessException, ClassNotFoundException {
		List<Order> orderList = new ArrayList<>();

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_PEDIDOS_POR_NOMBRE_CLIENTE);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long orderId = rs.getLong("ORDER_ID");
				long customerID = rs.getLong("CUSTOMER_ID");
				String status = rs.getString("STATUS");
				long salesmanId = rs.getLong("SALESMAN_ID");
				

				Order order = new Order(orderId, customerID, status, salesmanId);
				orderList.add(order);
			}

		} catch (SQLException sql) {
			throw new DataAccessException("Error de base de datos", sql);
		}
		return orderList;
	}

	
	/**
	 * Obtiene los detalles de un pedido a traves de una id del pedido
	 * 
	 * @param orderId Id del pedido
	 * @return Lista de objetos que contienen los productos del pedido
	 * @throws DataAccessException Si ocurre un error en la base de datos.
	 */
	@Override
	public List<OrderItems> obtenerDetallePedido(long orderId) throws DataAccessException, ClassNotFoundException {
		List<OrderItems> orderItemsList = new ArrayList<>();

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_DETALLES_PEDIDOS_POR_ORDERID);
			ps.setLong(1, orderId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long orderID = rs.getLong("ORDER_ID");
				long itemId = rs.getLong("ITEM_ID");
				long productId = rs.getLong("PRODUCT_ID");
				double quantity = rs.getDouble("QUANTITY");
				BigDecimal unitPrice = rs.getBigDecimal("UNIT_PRICE");

				OrderItems order = new OrderItems(orderID, itemId, productId, quantity, unitPrice);
				orderItemsList.add(order);
			}

		} catch (SQLException sql) {
			throw new DataAccessException("Error de base de datos", sql);
		}
		return orderItemsList;
	}

}
