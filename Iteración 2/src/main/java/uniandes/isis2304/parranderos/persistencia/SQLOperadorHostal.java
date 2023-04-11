package uniandes.isis2304.parranderos.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


public class SQLOperadorHostal {

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
	public SQLOperadorHostal (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarOperadorHostal(PersistenceManager pm, long identificacion, int registroCamara, int registroSuperintendencia, String nombre, String ubicacion, String horaApertura, String horaCierre, String usuario) 
	{   
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOperadorHostal () + " (identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, horaApertura, horaCierre, usuario) values (?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(identificacion, registroCamara, registroSuperintendencia, nombre, ubicacion, horaApertura, horaCierre, usuario);
        return (long) q.executeUnique();
	}
	
	public String verificarUsuario(PersistenceManager pm, String usuarioPa) 
	{
        Query q = pm.newQuery(SQL, "SELECT usuario FROM " + pp.darTablaOperadorHostal () + " WHERE usuario = ?");
        q.setParameters(usuarioPa);
        return (String) q.executeUnique();
	}
}
