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

public class OrdersDAO implements DaoPedidos {

	private final String QUERY_OBTENER_PEDIDOS_POR_CLIENTE = "SELECT * FROM ORDERS WHERE CUSTOMER_ID = ?";
	private final String QUERY_OBTENER_DETALLES_PEDIDOS_POR_ORDERID = "SELECT * FROM ORDER_ITEMS WHERE ORDER_ID = ?";
	private final String QUERY_OBTENER_PEDIDOS_POR_NOMBRE_CLIENTE = "SELECT * FROM ORDERS o JOIN CUSTOMERS c ON O.CUSTOMER_ID = c.customer_id WHERE LOWER(c.name) LIKE LOWER(?)";
		
			
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
