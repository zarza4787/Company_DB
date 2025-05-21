package dao.modelos;

import java.util.List;

import excepciones.DataAccessException;
import modelos.OrderItems;
import modelos.Order;

public interface DaoPedidos {

	List<Order> obtenerPedidosPorClienteID(long customerId) throws DataAccessException, ClassNotFoundException;

	List<OrderItems> obtenerDetallePedido(long orderId) throws DataAccessException, ClassNotFoundException;

	List<Order> obtenerPedidosPorClienteNombre(String name) throws DataAccessException, ClassNotFoundException;

}
