package dao.modelos;

import java.util.List;

import excepciones.DataAccessException;
import modelos.DetallesPedido;

public interface DaoOrderItem {

	List<DetallesPedido> obtenerDetallePedido(int orderId) throws DataAccessException;

	double obtenerTotalPedido(int orderId) throws DataAccessException;

}
