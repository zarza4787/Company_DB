package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.modelos.DaoRegion;
import excepciones.DataAccessException;
import modelos.Countries;
import modelos.Location;
import modelos.Region;
import utils.DBUtils;

/**
 * Clase DAO para gestionar el acceso a datos relacionados con regiones, países
 * y ubicaciones Implementa al DaoRegion
 * 
 * Obtener todas las regiones Obtener todos los paises que pertenecen a una
 * region Obtener todas la ubicaciones que pertenecen a un pais
 */
public class RegionDAO implements DaoRegion {

	private final String QUERY_OBTENER_REGIONES = "SELECT * FROM REGIONS";
	private final String QUERY_OBTENER_PAIS_POR_REGION = "SELECT * FROM COUNTRIES WHERE REGION_ID = ?";
	private final String QUERY_OBTENER_UBICACIONES_POR_PAIS = "SELECT * FROM LOCATIONS WHERE COUNTRY_ID = ?";

	/**
	 * Recupera todas las regiones disponibles en la base de datos.
	 * 
	 * @return Lista de objetos de regiones
	 * @throws DataAccessException si ocurre un error de acceso a la base de datos.
	 */
	@Override
	public List<Region> obtenerRegiones() throws DataAccessException, ClassNotFoundException {
		List<Region> regionesList = new ArrayList<>();

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_REGIONES);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long regionId = rs.getLong("REGION_ID");
				String regionName = rs.getString("REGION_NAME");

				Region region = new Region(regionId, regionName);
				regionesList.add(region);
			}

		} catch (SQLException sql) {
			throw new DataAccessException("Error de base de datos", sql);
		}
		return regionesList;

	}

	/**
	 * Recupera todas los paises disponibles en la base de datos.
	 * 
	 * @param regionID
	 * @return Lista de objetos de ciudades que pertenecen a la region
	 * @throws DataAccessException si ocurre un error de acceso a la base de datos
	 */
	@Override
	public List<Countries> obtenerPaisesPorRegion(int regionId) throws DataAccessException, ClassNotFoundException {
		List<Countries> paisesList = new ArrayList<Countries>();

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_PAIS_POR_REGION);

			ps.setInt(1, regionId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String countryId = rs.getString("COUNTRY_ID");
				String countryName = rs.getString("COUNTRY_NAME");
				long regionID = rs.getLong("REGION_ID");

				Countries countries = new Countries(countryId, countryName, regionID);
				paisesList.add(countries);
			}

		} catch (SQLException sql) {
			throw new DataAccessException("Error de base de datos", sql);
		}

		return paisesList;
	}

	/**
	 * Recupera todas las ubicaciones geográficas asociadas a un pais especifico
	 * 
	 * @param countryId
	 * @return Lista de objetos de locations que pertenecen al pais
	 * @throws DataAccessException si ocurre un error de acceso a la base de datos
	 */

	@Override
	public List<Location> obtenerUbicacionesPorPais(String countryId)
			throws DataAccessException, ClassNotFoundException {
		List<Location> locationsList = new ArrayList<Location>();

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(QUERY_OBTENER_UBICACIONES_POR_PAIS);

			ps.setString(1, countryId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long locationId = rs.getLong("LOCATION_ID");
				String address = rs.getString("ADDRESS");
				String postalCode = rs.getString("POSTAL_CODE");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String regionId = rs.getString("COUNTRY_ID");

				Location locations = new Location(locationId, address, postalCode, city, state, regionId);
				locationsList.add(locations);
			}

		} catch (SQLException sql) {
			throw new DataAccessException("Error de base de datos", sql);
		}

		return locationsList;
	}

}
