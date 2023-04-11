package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Reserva;

public class SQLReserva {

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
	public SQLReserva (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarReserva(PersistenceManager pm, long id, String fechaInicio, String cliente, long ofertaAsociada, int duracion, int ocupacion) 
	{
		Query a = pm.newQuery(SQL, "SELECT to_char (sysdate, 'YY') FROM dual");
        String anio = (String) a.executeUnique();
        
        Query m = pm.newQuery(SQL, "SELECT to_char (sysdate, 'MM') FROM dual");
        String mes = (String) m.executeUnique();
        
        Query d = pm.newQuery(SQL, "SELECT to_char (sysdate, 'DD') FROM dual");
        String dia = (String) d.executeUnique();
		
		String fechaRegistro = dia + "/" + mes + "/" + anio;
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReserva () + " (id, fechaInicio, cliente, ofertaAsociada, duracion, fechaRegistro, ocupacion) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, fechaInicio, cliente, ofertaAsociada, duracion, fechaRegistro, ocupacion);
        return (long) q.executeUnique();
	}
	
	public List<Reserva> darReservasActivas(PersistenceManager pm, String cliente){
		
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva() + " WHERE cliente = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(cliente);
		return (List<Reserva>) q.executeList();
	}
	
	public void eliminarReserva(PersistenceManager pm, long id){
		
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva() + " WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
	}
	
	public boolean verificarOfertaReserva(PersistenceManager pm, long id){
		
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva() + " WHERE ofertaAsociada = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(id);
		List<Reserva> reservas = (List<Reserva>) q.executeList();
		
		if(reservas.size() != 0) {
			return true;
		}
		return false;
	}

	public List<Reserva> obtenerReservas(PersistenceManager pm){
		
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva());
		q.setResultClass(Reserva.class);
		return (List<Reserva>) q.executeList();
	}
}
