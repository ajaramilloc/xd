package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.OfertasAlojamiento;

public class SQLOfertasAlojamiento {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaAlohAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaAlohAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLOfertasAlojamiento (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarOfertaAlojamiento(PersistenceManager pm, long id, String tipo, String operador) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOfertasAlojamiento () + " (id, tipoOferta, operador) values (?, ?, ?)");
        q.setParameters(id, tipo, operador);
        return (long) q.executeUnique();
	}
	
	
	public List<OfertasAlojamiento> darOfertasAlojamientoOperador(PersistenceManager pm, String operador) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertasAlojamiento() + " WHERE operador = ?");
		q.setResultClass(OfertasAlojamiento.class);
		q.setParameters(operador);
		return (List<OfertasAlojamiento>) q.executeList();
	}
	
	
	public List<OfertasAlojamiento> darOfertasAlojamientoDisponibles(PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertasAlojamiento());
		q.setResultClass(OfertasAlojamiento.class);
		return (List<OfertasAlojamiento>) q.executeList();
	}
	
	
	public OfertasAlojamiento eliminarOfertaAlojamiento(PersistenceManager pm, long id) 
	{
		Query p = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertasAlojamiento() + " WHERE id = ?");
		p.setResultClass(OfertasAlojamiento.class);
		p.setParameters(id);
		
		OfertasAlojamiento oferta = (OfertasAlojamiento) p.executeUnique();
		
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertasAlojamiento() + " WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
		
		return oferta;
	}
}
