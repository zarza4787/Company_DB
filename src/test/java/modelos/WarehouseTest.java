package modelos;

import static org.junit.Assert.*;

import org.junit.Test;

import excepciones.DatoIncorrrectoException;

public class WarehouseTest {

	@Test
	public void testConstructorWarehouse() throws DatoIncorrrectoException {
		Warehouse wh = new Warehouse(1, 10, "Almacen Central");
		assertEquals(1, wh.getWareHouseId());
		assertEquals(10, wh.getLocationID());
		assertEquals("Almacen Central", wh.getNameWareHouse());
	}

	@Test
	public void testConstructorWarehouseActualizar() throws DatoIncorrrectoException {
		Warehouse wh = new Warehouse(10, "Almacen Secundario");
		assertEquals(10, wh.getLocationID());
		assertEquals("Almacen Secundario", wh.getNameWareHouse());
	}

	@Test
	public void testConstructorWarehouseEliminar() throws DatoIncorrrectoException {
		Warehouse wh = new Warehouse(5);
		assertEquals(5, wh.getWareHouseId());
	}

	@Test
	public void testGetWareHouseId() throws DatoIncorrrectoException {
		Warehouse wh = new Warehouse(2, 20, "Almacen");
		assertEquals(2, wh.getWareHouseId());
	}

	@Test
	public void testGetLocationID() throws DatoIncorrrectoException {
		Warehouse wh = new Warehouse(2, 20, "Almacen");
		assertEquals(20, wh.getLocationID());
	}

	@Test
	public void testGetNameWareHouse() throws DatoIncorrrectoException {
		Warehouse wh = new Warehouse(2, 20, "Almacen");
		assertEquals("Almacen", wh.getNameWareHouse());
	}

	@Test
	public void testToString() throws DatoIncorrrectoException {
		Warehouse wh = new Warehouse(2, 20, "Almacen");
		String expected = "Almacen [WAREHOUSE_ID=2, LOCATION_ID=20, WAREHOUSE_NAME=Almacen]";
		assertEquals(expected, wh.toString());
	}
}
