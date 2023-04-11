
package uniandes.isis2304.parranderos.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


class SQLUtil
{
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
	public SQLUtil (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqAlohAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}

	/**
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarAlohAndes (PersistenceManager pm)
	{
        Query qOfertaApartamento = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaApartamento ());          
        Query qOfertaViviendaComunidad = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaViviendaComunidad ());
        Query qOfertaViviendaPropia = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaViviendaPropia ());
        Query qEmpresaVivienda = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOperadorEmpresaVivienda ());
        Query qOperadorHostal = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOperadorHostal ());
        Query qOperadorHotel= pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOperadorHotel ());
        Query qReserva = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva ());
        Query qUsuarioOperador = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuarioOperador ());          
        Query qUsuarioPersona = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuarioPersona ());
        Query qOfertasAlojamiento= pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertasAlojamiento ());
        Query qOfertaHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaHabitacion ());

        long ofertasApartamentoEliminadas = (long) qOfertaApartamento.executeUnique ();
        long ofertasViviendaComunidadEliminadas = (long) qOfertaViviendaComunidad.executeUnique ();
        long ofertasViviendaPropiaEliminadas = (long) qOfertaViviendaPropia.executeUnique ();
        long empresasViviendaEliminadas = (long) qEmpresaVivienda.executeUnique ();
        long operadoresHostalEliminadas = (long) qOperadorHostal.executeUnique ();
        long operadoresHotelEliminados = (long) qOperadorHotel.executeUnique ();
        long reservasEliminados = (long) qReserva.executeUnique ();
        long usuariosOperadorEliminados = (long) qUsuarioOperador.executeUnique ();
        long usuariosPersonaEliminados = (long) qUsuarioPersona.executeUnique ();
        long ofertasAlojamientoEliminadas = (long) qOfertasAlojamiento.executeUnique ();
        long ofertasHabitacionEliminadas = (long) qOfertaHabitacion.executeUnique ();
        return new long[] {ofertasApartamentoEliminadas, ofertasViviendaComunidadEliminadas, ofertasViviendaPropiaEliminadas, empresasViviendaEliminadas, 
        		operadoresHostalEliminadas, operadoresHotelEliminados, reservasEliminados, usuariosOperadorEliminados, usuariosPersonaEliminados, ofertasAlojamientoEliminadas, ofertasHabitacionEliminadas};
	}

}
