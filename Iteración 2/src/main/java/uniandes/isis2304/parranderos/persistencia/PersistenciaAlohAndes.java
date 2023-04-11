package uniandes.isis2304.parranderos.persistencia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.parranderos.negocio.OfertaApartamento;
import uniandes.isis2304.parranderos.negocio.OfertaHabitacion;
import uniandes.isis2304.parranderos.negocio.OfertaViviendaComunidad;
import uniandes.isis2304.parranderos.negocio.OfertaViviendaPropia;
import uniandes.isis2304.parranderos.negocio.OfertasAlojamiento;
import uniandes.isis2304.parranderos.negocio.Reserva;


/**
 * Clase para el manejador de persistencia del proyecto Parranderos
 * Traduce la información entre objetos Java y tuplas de la base de datos, en ambos sentidos
 * Sigue un patrón SINGLETON (Sólo puede haber UN objeto de esta clase) para comunicarse de manera correcta
 * con la base de datos
 * Se apoya en las clases SQLBar, SQLBebedor, SQLBebida, SQLGustan, SQLSirven, SQLTipoBebida y SQLVisitan, que son 
 * las que realizan el acceso a la base de datos
 * 
 * @author Germán Bravo
 */
public class PersistenciaAlohAndes 
{
	private static Logger log = Logger.getLogger(PersistenciaAlohAndes.class.getName());
	
	public final static String SQL = "javax.jdo.query.SQL";

	private static PersistenciaAlohAndes instance;
	
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	private SQLUtil sqlUtil;
	
	private SQLOfertaApartamento sqlOfertaApartamento;
	private SQLOfertaViviendaComunidad sqlOfertaViviendaComunidad;
	private SQLOfertaViviendaPropia sqlOfertaViviendaPropia;
	private SQLOperadorEmpresaVivienda sqlOperadorEmpresaVivienda;
	private SQLOperadorHostal sqlOperadorHostal;
	private SQLOperadorHotel sqlOperadorHotel;
	private SQLUsuarioOperador sqlUsuarioOperador;
	private SQLUsuarioPersona sqlUsuarioPersona;
	private SQLReserva sqlReserva;
	private SQLOfertasAlojamiento sqlOfertasAlojamiento;
	private SQLApartamento sqlApartamento;
	private SQLOfertaHabitacion sqlOfertaHabitacion;
	
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	private PersistenciaAlohAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("superandes_sequence");
		tablas.add ("OFERTA_APARTAMENTO");
		tablas.add ("OFERTA_VIVIENDA_COMUNIDAD");
		tablas.add ("OFERTA_VIVIENDA_PROPIA");
		tablas.add ("OPERADOR_EMPRESA_VIVIENDA");
		tablas.add ("OPERADOR_HOSTAL");
		tablas.add ("OPERADOR_HOTEL");
		tablas.add ("RESERVA");
		tablas.add ("USUARIO_OPERADOR");
		tablas.add ("USUARIO_PERSONA");
		tablas.add ("OFERTAS_ALOJAMIENTO");
		tablas.add ("APARTAMENTO");
		tablas.add ("OFERTA_HABITACION");
	}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaAlohAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaAlohAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaAlohAndes ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaAlohAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaAlohAndes (tableConfig);
		}
		return instance;
	}


	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlOfertaApartamento = new SQLOfertaApartamento(this);
		sqlOfertaViviendaComunidad = new SQLOfertaViviendaComunidad(this);
		sqlOfertaViviendaPropia = new SQLOfertaViviendaPropia(this);
		sqlOperadorEmpresaVivienda = new SQLOperadorEmpresaVivienda(this);
		sqlOperadorHostal = new SQLOperadorHostal(this);
		sqlOperadorHotel = new SQLOperadorHotel(this);
		sqlUsuarioOperador = new SQLUsuarioOperador(this);;
		sqlUsuarioPersona = new SQLUsuarioPersona(this);
		sqlReserva = new SQLReserva(this);
		sqlOfertasAlojamiento = new SQLOfertasAlojamiento(this);
		sqlApartamento = new SQLApartamento(this);
		sqlOfertaHabitacion = new SQLOfertaHabitacion(this);
		
		sqlUtil = new SQLUtil(this);
	}


	public String darSeqAlohAndes ()
	{
		return tablas.get (0);
	}

	public String darTablaOfertaApartamento ()
	{
		return tablas.get (1);
	}
	public String darTablaOfertaViviendaComunidad ()
	{
		return tablas.get (2);
	}

	public String darTablaOfertaViviendaPropia ()
	{
		return tablas.get (3);
	}

	public String darTablaOperadorEmpresaVivienda ()
	{
		return tablas.get (4);
	}

	public String darTablaOperadorHostal ()
	{
		return tablas.get (5);
	}
	
	public String darTablaOperadorHotel()
	{
		return tablas.get (6);
	}

	public String darTablaReserva ()
	{
		return tablas.get (7);
	}

	public String darTablaUsuarioOperador ()
	{
		return tablas.get (8);
	}
	
	public String darTablaUsuarioPersona ()
	{
		return tablas.get (9);
	}
	
	public String darTablaOfertasAlojamiento ()
	{
		return tablas.get (10);
	}
	
	public String darTablaApartamento ()
	{
		return tablas.get (11);
	}
	
	public String darTablaOfertaHabitacion() {
		
		return tablas.get (12);
	}
	
	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	
	
	
	
	
	
	/* ****************************************************************
	 * 			Métodos para manejar ingreso y registro
	 *****************************************************************/
	
	public boolean verificarIdentidad(String usuario, String contrasena, boolean esOperador) {
		
		if(esOperador) {
			return sqlUsuarioOperador.verificarIdentidad(pmf.getPersistenceManager(), usuario, contrasena);
			
		} else {
			return sqlUsuarioPersona.verificarIdentidad(pmf.getPersistenceManager(), usuario, contrasena);
		}
	}
	
	
	public String determinarTipoOperador(String usuario) {
    	
    	PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        String tipo = "";
               
        try
        {
            tx.begin();
        	
        	if(sqlOperadorHotel.verificarUsuario(pm, usuario) != null) {
        		return "Hotel";
        		
        	} else if(sqlOperadorHostal.verificarUsuario(pm, usuario) != null) {
        		return "Hostal";
        		
        	} else if(sqlOperadorEmpresaVivienda.verificarUsuario(pm, usuario) != null) {
        		return "EmpresaVivienda";
      
        	} else if(sqlUsuarioPersona.verificarUsuario(pm, usuario) != null) {
        		return "Persona";
        	}
            tx.commit();
            
            log.trace ("Tipo operador no identificado");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return tipo;
    }
	
	
	public void registrarPersona(String usuario, String contrasena, int carnetUniandes, String vinculacion, String esOperador) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
               
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlUsuarioPersona.adicionarUsuarioPersona(pm, usuario, contrasena, carnetUniandes, vinculacion, esOperador);
    		tx.commit();
            
            log.trace ("Usuario " + usuario + " añadido: " + tuplasInsertadas + " tuplas insertadas");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public void registrarPersonaOperador(String usuario, String contrasena, int carnetUniandes, String vinculacion, String esOperador) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        System.out.println("Está entrando");
        
        try
        {
            tx.begin();
            long tuplasInsertadasOperador = sqlUsuarioOperador.adicionarUsuarioOperador(pm, usuario, contrasena);
            long tuplasInsertadas = sqlUsuarioPersona.adicionarUsuarioPersona(pm, usuario, contrasena, carnetUniandes, vinculacion, esOperador);
    		tx.commit();
            
            log.trace ("Usuario " + usuario + " añadido: " + tuplasInsertadas + " tuplas insertadas");
            log.trace ("Usuario " + usuario + " añadido: " + tuplasInsertadasOperador + " tuplas insertadas");
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public void registrarOperadorHotel(int registroCamara, int registroSuperintendencia, String nombre, String ubicacion, String usuario, String contrasena) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long tuplasUsuario = sqlUsuarioOperador.adicionarUsuarioOperador(pm, usuario, contrasena);
            log.trace ("Usuario " + usuario + " añadido: " + tuplasUsuario + " tuplas insertadas");
            
            long idOperador = nextval ();
            long tuplasInsertadas = sqlOperadorHotel.adicionarOperadorHotel(pm, idOperador, registroCamara, registroSuperintendencia, nombre, ubicacion, usuario);
    		tx.commit();
            
            log.trace ("Operador " + usuario + " añadido: " + tuplasInsertadas + " tuplas insertadas");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public void registrarOperadorHostal(int registroCamara, int registroSuperintendencia, String nombre, String ubicacion, String horaApertura, String horaCierre, String usuario, String contrasena) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long tuplasUsuario = sqlUsuarioOperador.adicionarUsuarioOperador(pm, usuario, contrasena);
            log.trace ("Usuario " + usuario + " añadido: " + tuplasUsuario + " tuplas insertadas");
            
            long idOperador = nextval ();
            long tuplasInsertadas = sqlOperadorHostal.adicionarOperadorHostal(pm, idOperador, registroCamara, registroSuperintendencia, nombre, ubicacion, horaApertura, horaCierre, usuario);
    		tx.commit();
            
            log.trace ("Operador " + usuario + " añadido: " + tuplasInsertadas + " tuplas insertadas");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public void registrarOperadorEmpresaVivienda(int registroCamara, int registroSuperintendencia, String nombre, int nit, String usuario, String contrasena) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long tuplasUsuario = sqlUsuarioOperador.adicionarUsuarioOperador(pm, usuario, contrasena);
            log.trace ("Usuario " + usuario + " añadido: " + tuplasUsuario + " tuplas insertadas");
            
            long idOperador = nextval ();
            long tuplasInsertadas = sqlOperadorEmpresaVivienda.adicionarOperadorEmpresaVivienda(pm, idOperador, registroCamara, registroSuperintendencia, nombre, nit, usuario);
    		tx.commit();
            
            log.trace ("Operador " + usuario + " añadido: " + tuplasInsertadas + " tuplas insertadas");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public void registrarOfertaViviendaComunidad(int costo, int numHabitaciones, String ubicacion, String menaje, int seguroArrendamiento, String fechaInicio, String fechaFin, int capacidad, String usuario) {
    	
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idOferta = nextval ();
            long tuplasInsertadasOfertas = sqlOfertasAlojamiento.adicionarOfertaAlojamiento(pm, idOferta, "OfertaViviendaComunidad", usuario);
            long tuplasInsertadas = sqlOfertaViviendaComunidad.adicionarOfertaViviendaComunidad(pm, idOferta, costo, numHabitaciones, ubicacion, menaje, seguroArrendamiento, usuario, capacidad, fechaInicio, fechaFin);
    		tx.commit();
    		
    		log.trace ("Inserción de Oferta: " + idOferta + ": " + tuplasInsertadasOfertas + " tuplas insertadas");    
            log.trace ("Inserción de Oferta Comunidad: " + idOferta + ": " + tuplasInsertadas + " tuplas insertadas");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public void registrarOfertaViviendaPropia(int costo, String comidas, String accesoCocina, String banoPrivado, String habIndividual, int costoServicios, String esquema, String fechaInicio, String fechaFin, int capacidad, String usuario) {
    	
    	PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idOferta = nextval ();
            long tuplasInsertadasOfertas = sqlOfertasAlojamiento.adicionarOfertaAlojamiento(pm, idOferta, "OfertaViviendaPropia", usuario);
            long tuplasInsertadas = sqlOfertaViviendaPropia.adicionarOfertaViviendaPropia(pm, idOferta, costo, comidas, accesoCocina, banoPrivado, habIndividual, costoServicios, esquema, fechaInicio, fechaFin, capacidad, usuario);
            tx.commit();
    		
    		log.trace ("Inserción de Oferta: " + idOferta + ": " + tuplasInsertadasOfertas + " tuplas insertadas");    
            log.trace ("Inserción de Oferta Propia: " + idOferta + ": " + tuplasInsertadas + " tuplas insertadas");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public void registrarApartamento(int numero, String conjunto, String direccion, String amoblado, String dueno) {
    	
    	PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlApartamento.adicionarApartamento(pm, numero, conjunto, direccion, amoblado, dueno);
            tx.commit();
    		
    		log.trace ("Inserción de apartamento " + numero + ": " + tuplasInsertadas+ " tuplas insertadas");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
	
	public void registrarOfertaApartamento(int costo, String serviciosIncluidos, String tv, String internet, String administracion, int capacidad, int numeroApartamento, String conjuntoApartamento, String direccionApartamento, String fechaInicio, String fechaFin, String usuario) {
    	
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idOferta = nextval ();
            long tuplasInsertadasOfertas = sqlOfertasAlojamiento.adicionarOfertaAlojamiento(pm, idOferta, "OfertaApartamento", usuario);
            long tuplasInsertadas = sqlOfertaApartamento.adicionarOfertaApartamento(pm, idOferta, costo, serviciosIncluidos, tv, internet, administracion, capacidad, numeroApartamento, conjuntoApartamento, direccionApartamento, fechaInicio, fechaFin, usuario);
            tx.commit();
    		
    		log.trace ("Inserción de Oferta: " + idOferta + ": " + tuplasInsertadasOfertas + " tuplas insertadas");    
            log.trace ("Inserción de Oferta Apartamento: " + idOferta + ": " + tuplasInsertadas + " tuplas insertadas");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public void registrarOfertaHabitacion(int costo, String tipo, String tamano, int piso, String categoria, String fechaInicio, String fechaFin, String menaje, int capacidad, String usuario) {
    	
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idOferta = nextval ();
            long tuplasInsertadasOfertas = sqlOfertasAlojamiento.adicionarOfertaAlojamiento(pm, idOferta, "OfertaHabitacion", usuario);
            long tuplasInsertadas = sqlOfertaHabitacion.adicionarOfertaHabitacion(pm, idOferta, costo, tipo, tamano, piso, categoria, fechaInicio, fechaFin, menaje, capacidad, usuario);
            tx.commit();
    		
    		log.trace ("Inserción de Oferta: " + idOferta + ": " + tuplasInsertadasOfertas + " tuplas insertadas");    
            log.trace ("Inserción de Oferta Apartamento: " + idOferta + ": " + tuplasInsertadas + " tuplas insertadas");    
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public List<OfertasAlojamiento> obtenerOfertasActuales(String operador) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            List<OfertasAlojamiento> ofertas = sqlOfertasAlojamiento.darOfertasAlojamientoOperador(pm, operador);
            tx.commit();
    		
    		log.trace ("Ofertas recuperadas");    
    		return ofertas;
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return null;
	}
	
	
	public boolean eliminarOfertaAlojamiento(long id) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            boolean enReserva = sqlReserva.verificarOfertaReserva(pm, id);
            if(enReserva) {
            	return true;
            }
            OfertasAlojamiento tipoOferta = sqlOfertasAlojamiento.eliminarOfertaAlojamiento(pm, id);
            
            if(tipoOferta.getTipoOferta().equals("OfertaViviendaComunidad")) {
            	sqlOfertaViviendaComunidad.eliminarOferta(pm, id);
            	
            } else if(tipoOferta.getTipoOferta().equals("OfertaViviendaComunidad")) {
            	sqlOfertaViviendaPropia.eliminarOferta(pm, id);
            	
            } else if(tipoOferta.getTipoOferta().equals("OfertaApartamento")) {
            	sqlOfertaApartamento.eliminarOferta(pm, id);
            	
            } else if(tipoOferta.getTipoOferta().equals("OfertaHabitacion")) {
            	sqlOfertaHabitacion.eliminarOferta(pm, id);
            } 
            tx.commit();
    		
    		log.trace ("Oferta con id " + id + " eliminada");   
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return false;
	}
	
	
public List<OfertasAlojamiento> obtenerOfertasDisponibles() {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            List<OfertasAlojamiento> ofertasRecuperadas = sqlOfertasAlojamiento.darOfertasAlojamientoDisponibles(pm);
            tx.commit();
    		
    		log.trace ("Ofertas recuperadas");   
    		return ofertasRecuperadas;
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return null;
	}


	public List<OfertaHabitacion> obtenerOfertashabitacionFiltradas(int costo, String tipoHabitacion, String categoria){
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            List<OfertaHabitacion> ofertasRecuperadas = sqlOfertaHabitacion.darOfertasHabitacionFiltrada(pm, costo, tipoHabitacion, categoria);
            tx.commit();
    		
    		log.trace ("Ofertas recuperadas");   
    		return ofertasRecuperadas;
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return null;
	}
	
	
	public List<OfertaApartamento> obtenerOfertasApartamentoFiltradas(String servicios, String tv, String internet, String administracion){
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            List<OfertaApartamento> ofertasRecuperadas = sqlOfertaApartamento.darOfertasApartamentoFiltrada(pm, servicios, tv, internet, administracion);
            tx.commit();
    		
    		log.trace ("Ofertas recuperadas");   
    		return ofertasRecuperadas;
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return null;
	}
	
	
	public List<OfertaViviendaPropia> obtenerOfertasViviendaPropiaFiltradas(String comidas, String accesoCocina, String banoPrivado, String habIndividual){
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            List<OfertaViviendaPropia> ofertasRecuperadas = sqlOfertaViviendaPropia.darOfertasViviendaPropiaFiltrada(pm, comidas, accesoCocina, banoPrivado, habIndividual);
            tx.commit();
    		
    		log.trace ("Ofertas recuperadas");   
    		return ofertasRecuperadas;
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return null;
	}
	

	public List<OfertaViviendaComunidad> obtenerOfertasViviendaComunidadFiltradas(int costo, int numHabitaciones){
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            List<OfertaViviendaComunidad> ofertasRecuperadas = sqlOfertaViviendaComunidad.darOfertasViviendaComunidadFiltrada(pm, costo, numHabitaciones);
            tx.commit();
    		
    		log.trace ("Ofertas recuperadas");   
    		return ofertasRecuperadas;
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return null;
	}


	public void registrarReserva(Long idOferta, String fechaInicio, String cliente, int duracion, int ocupacion) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idReserva = nextval ();
            long reserva = sqlReserva.adicionarReserva(pm, idReserva, fechaInicio, cliente, idOferta, duracion, ocupacion);
            tx.commit();
    		
    		log.trace ("Reserva con id:" + idReserva + " registrada con éxito. Info: " + reserva);   
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public List<Reserva> darReservasActivas(String cliente){
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            List<Reserva> reservasActivas = sqlReserva.darReservasActivas(pm, cliente);
            tx.commit();
    		
    		log.trace ("Reservas activas del cliente con usuario: " + cliente + " recuperadas"); 
    		return reservasActivas;
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return null;
	}
	
	
	public void eliminarReserva(long id){
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            sqlReserva.eliminarReserva(pm, id);
            tx.commit();
    		
    		log.trace ("Reserva con id: " + id + " eliminada con éxito"); 
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


    public HashMap<String, Integer> obtenerIndiceOcupacionOfertasDisponibles() {
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();

            List<OfertaViviendaComunidad> ofertasViviendaComunidad = sqlOfertaViviendaComunidad.darOfertaViviendaComunidad(pm);
            List<OfertaViviendaPropia> ofertasViviendaPropia = sqlOfertaViviendaPropia.darOfertaViviendaPropia(pm);
            List<OfertaHabitacion> ofertasHabitacion = sqlOfertaHabitacion.darOfertaHabitacion(pm);
            List<OfertaApartamento> ofertasApartamento = sqlOfertaApartamento.darOfertaApartamento(pm);

            HashMap<String, Integer> indiceOcupacion = new HashMap<String, Integer>();

            for(OfertaViviendaComunidad oferta : ofertasViviendaComunidad){ 
            	indiceOcupacion.put(oferta.getId() + "-" + oferta.getOperador(), oferta.getCapacidad());
            }

            for(OfertaViviendaPropia oferta : ofertasViviendaPropia){
            	indiceOcupacion.put(oferta.getId() + "-" + oferta.getOperador(), oferta.getCapacidad());
            }

            for(OfertaHabitacion oferta : ofertasHabitacion){
            	indiceOcupacion.put(oferta.getId() + "-" + oferta.getOperador(), oferta.getCapacidad());
            }

            for(OfertaApartamento oferta : ofertasApartamento){
            	indiceOcupacion.put(oferta.getId() + "-" + oferta.getOperador(), oferta.getCapacidad());
            }

            tx.commit();

            log.trace ("Se recuperaron " + indiceOcupacion.size() + " ofertas");
            return indiceOcupacion;
                	
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println(e);
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return null;
	}

    public List<Reserva> darReservas(){
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();

        try{
            tx.begin();
            List<Reserva> reservas = sqlReserva.obtenerReservas(pm);
            tx.commit();

            log.trace ("Se recuperaron " + reservas.size() + " reservas");
            return reservas;
        }
        catch (Exception e){
            log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            System.out.println(e);
        }
        finally{
            if (tx.isActive()){
                tx.rollback();
            }
            pm.close();
        }
        return null;
    }

	public long [] limpiarAlohAndes ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarAlohAndes(pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	

 }
