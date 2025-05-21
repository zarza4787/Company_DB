package modelos;

import excepciones.DatoIncorrrectoException;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WarehouseTest {

    @Test
    public void testWarehouseLongLongString() throws DatoIncorrrectoException {
        Warehouse wh = new Warehouse(1, 10, "Almacen Sevilla");

        assertThat(wh.getWareHouseId(), is(1L));
        assertThat(wh.getLocationID(), is(10L));
        assertThat(wh.getNameWareHouse(), is("Almacen Sevilla"));
    }

    @Test
    public void testWarehouseLongString() throws DatoIncorrrectoException {
        Warehouse wh = new Warehouse(10, "Almacen Huelva");

        assertThat(wh.getLocationID(), is(10L));
        assertThat(wh.getNameWareHouse(), is("Almacen Huelva"));
        assertThat(wh.getWareHouseId(), is(0L)); 
    }

    @Test
    public void testWarehouseLong() throws DatoIncorrrectoException {
        Warehouse wh = new Warehouse(5);

        assertThat(wh.getWareHouseId(), is(5L));
    }

    @Test
    public void testToString() throws DatoIncorrrectoException {
        Warehouse wh = new Warehouse(2, 20, "Almacen");

        assertThat(wh.toString(), is("Almacen [WAREHOUSE_ID=2, LOCATION_ID=20, WAREHOUSE_NAME=Almacen]"));
    }

   
}
