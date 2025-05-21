package dao.modelos;

import java.util.List;

import excepciones.DataAccessException;
import modelos.OrderItems;
import modelos.Order;

/*
 * Interfaz que define las operaciones de acceso a datos relacionadas con los pedidos
 */
public interface DaoPedidos {

	/**
	 * Obtiene la lista de pedidos realizados por un cliente segun su ID
	 *
	 * @param customerId ID del cliente cuyos pedidos se desean obtener
	 * @return Lista de pedidos asociados al cliente
	 * @throws DataAccessException si ocurre un error durante el acceso a datos
	 */
	List<Order> obtenerPedidosPorClienteID(long customerId) throws DataAccessException, ClassNotFoundException;

	/**
	 * Obtiene el detalle de un pedido específico, incluyendo los productos
	 * contenidos en el
	 *
	 * @param orderId ID del pedido.
	 * @return Lista de ítems del pedido.
	 * @throws DataAccessException si ocurre un error durante el acceso a datos.
	 */
	List<OrderItems> obtenerDetallePedido(long orderId) throws DataAccessException, ClassNotFoundException;

	/**
	 * Obtiene la lista de pedidos realizados por un cliente segun su nombre
	 *
	 * @param name Nombre del cliente cuyos pedidos se desean obtener
	 * @return Lista de pedidos asociados al nombre del cliente
	 * @throws DataAccessException    si ocurre un error durante el acceso a datos
	 */
	List<Order> obtenerPedidosPorClienteNombre(String name) throws DataAccessException, ClassNotFoundException;

}
