
package uniandes.isis2304.parranderos.negocio;

import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import com.google.gson.JsonObject;
import uniandes.isis2304.parranderos.persistencia.PersistenciaAlohAndes;


public class AlohAndes 
{
	private static Logger log = Logger.getLogger(AlohAndes.class.getName());
	
	private PersistenciaAlohAndes pp;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public AlohAndes ()
	{
		pp = PersistenciaAlohAndes.getInstance ();
	}
	
	/**
	 * El constructor que recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public AlohAndes (JsonObject tableConfig)
	{
		pp = PersistenciaAlohAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	
	
	
	/* ****************************************************************
	 * 			Métodos de registro e ingreso
	 *****************************************************************/
	
	
	public boolean verificarIdentidad(String usuario, String contrasena, boolean esOperador) {
		
		return pp.verificarIdentidad(usuario, contrasena, esOperador);
	}
	
	
	public String determinarTipoOperador(String usuario) {
   
    	return pp.determinarTipoOperador(usuario);
    }
	
	
	public void registrarPersona(String usuario, String contrasena, int carnetUniandes, String vinculacion, String esOperador) {
		pp.registrarPersona(usuario, contrasena, carnetUniandes, vinculacion, esOperador);
	}
	
	
	public void registrarPersonaOperador(String usuario, String contrasena, int carnetUniandes, String vinculacion, String esOperador) {
		pp.registrarPersonaOperador(usuario, contrasena, carnetUniandes, vinculacion, esOperador);
	}
	
	
	public void registrarOperadorHotel(int registroCamara, int registroSuperintendencia, String nombre, String ubicacion, String usuario, String contrasena) {
		pp.registrarOperadorHotel(registroCamara, registroSuperintendencia, nombre, ubicacion, usuario, contrasena);
	}
	
	public void registrarOperadorHostal(int registroCamara, int registroSuperintendencia, String nombre, String ubicacion, String horaApertura, String horaCierre, String usuario, String contrasena) {
		pp.registrarOperadorHostal(registroCamara, registroSuperintendencia, nombre, ubicacion, horaApertura, horaCierre, usuario, contrasena);
	}
	
	public void registrarOperadorEmpresaVivienda(int registroCamara, int registroSuperintendencia, String nombre, int nit, String usuario, String contrasena) {
		pp.registrarOperadorEmpresaVivienda(registroCamara, registroSuperintendencia, nombre, nit, usuario, contrasena);
	}
	
	
	public void registrarOfertaViviendaComunidad(int costo, int numHabitaciones, String ubicacion, String menaje, int seguroArrendamiento, String fechaInicio, String fechaFin, int capacidad, String usuario) {
    	
		pp.registrarOfertaViviendaComunidad(costo, numHabitaciones, ubicacion, menaje, seguroArrendamiento, fechaInicio, fechaFin, capacidad, usuario);
    }
	
	public void registrarOfertaViviendaPropia(int costo, String comidas, String accesoCocina, String banoPrivado, String habIndividual, int costoServicios, String esquema, String fechaInicio, String fechaFin, int capacidad, String usuario) {
    	
    	pp.registrarOfertaViviendaPropia(costo, comidas, accesoCocina, banoPrivado, habIndividual, costoServicios, esquema, fechaInicio, fechaFin, capacidad, usuario);
    }
	
	
	public void registrarApartamento(int numero, String conjunto, String direccion, String amoblado, String dueno) {
    	
    	pp.registrarApartamento(numero, conjunto, direccion, amoblado, dueno);
    }
	
	
	public void registrarOfertaApartamento(int costo, String serviciosIncluidos, String tv, String internet, String administracion, int capacidad, int numeroApartamento, String conjuntoApartamento, String direccionApartamento, String fechaInicio, String fechaFin, String usuario) {
    	
		pp.registrarOfertaApartamento(costo, serviciosIncluidos, tv, internet, administracion, capacidad, numeroApartamento, conjuntoApartamento, direccionApartamento, fechaInicio, fechaFin, usuario);
    }
	
	
	public void registrarOfertaHabitacion(int costo, String tipo, String tamano, int piso, String categoria, String fechaInicio, String fechaFin, String menaje, int capacidad, String usuario) {
    	
		pp.registrarOfertaHabitacion(costo, tipo, tamano, piso, categoria, fechaInicio, fechaFin, menaje, capacidad, usuario);
    }
	
	
	public List<OfertasAlojamiento> obtenerOfertasActuales(String operador) {
			
		return pp.obtenerOfertasActuales(operador);
	}
	 
	public boolean eliminarOfertaAlojamiento(long id) {
		return pp.eliminarOfertaAlojamiento(id);
	}
	
	
	public List<OfertasAlojamiento> obtenerOfertasDisponibles(){
		return pp.obtenerOfertasDisponibles();
	}
	
	
	public List<OfertaHabitacion> obtenerOfertashabitacionFiltradas(int costo, String tipoHabitacion, String categoria){
		return pp.obtenerOfertashabitacionFiltradas(costo, tipoHabitacion, categoria);
	}
	
	
	public List<OfertaApartamento> obtenerOfertasApartamentoFiltradas(String servicios, String tv, String internet, String administracion){
		
		return pp.obtenerOfertasApartamentoFiltradas(servicios, tv, internet, administracion);
	}
	
	
	public List<OfertaViviendaPropia> obtenerOfertasViviendaPropiaFiltradas(String comidas, String accesoCocina, String banoPrivado, String habIndividual){
		
		return pp.obtenerOfertasViviendaPropiaFiltradas(comidas, accesoCocina, banoPrivado, habIndividual);
	}
	
	
	public List<OfertaViviendaComunidad> obtenerOfertasViviendaComunidadFiltradas(int costo, int numHabitaciones){
		
		return pp.obtenerOfertasViviendaComunidadFiltradas(costo, numHabitaciones);
	}
	
	
	public void registrarReserva(Long idOferta, String fechaInicio, String cliente, int duracion, int ocupacion) {
		
		pp.registrarReserva(idOferta, fechaInicio, cliente, duracion, ocupacion);
	}
	
	
	public List<Reserva> darReservasActivas(String cliente){
		
		return pp.darReservasActivas(cliente);
	}
	
	
	public void eliminarReserva(long id) {
			
		try {
			pp.eliminarReserva(id);
		} catch (Exception e) {
	    	System.out.println(e);
	    }
	}
	

	public HashMap<String, Integer> darOfertasIndice(){
		try {
			return pp.obtenerIndiceOcupacionOfertasDisponibles();
		} catch (Exception e) {
	    	System.out.println(e);
	    }
		return null;
	}

	public List<Reserva> obtenerReservas(){
		try {
			return pp.darReservas();
		} catch (Exception e) {
	    	System.out.println(e);
	    }
		return null;
	}
	
	

	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/
	
	public long [] limpiarAlohAndes ()
	{
        log.info ("Limpiando la BD de AlohAndes");
        long [] borrrados = pp.limpiarAlohAndes();	
        log.info ("Limpiando la BD de AlohAndes: Listo!");
        return borrrados;
	}
}
