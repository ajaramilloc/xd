/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.parranderos.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.parranderos.negocio.Reserva;
import uniandes.isis2304.parranderos.negocio.AlohAndes;
import uniandes.isis2304.parranderos.negocio.OfertaApartamento;
import uniandes.isis2304.parranderos.negocio.OfertaHabitacion;
import uniandes.isis2304.parranderos.negocio.OfertaViviendaComunidad;
import uniandes.isis2304.parranderos.negocio.OfertaViviendaPropia;
import uniandes.isis2304.parranderos.negocio.OfertasAlojamiento;


@SuppressWarnings("serial")

public class InterfazAlohAndesApp extends JFrame implements ActionListener
{
	
	private static Logger log = Logger.getLogger(InterfazAlohAndesApp.class.getName());
	
	private static final String CONFIG_INTERFAZ_General = "./src/main/resources/config/interfaceConfigAppAdmin.json"; 
	
	
	//private static final String CONFIG_INTERFAZ_Admin = "./src/main/resources/config/interfaceConfigAppAdmin.json"; 
	//private static final String CONFIG_INTERFAZ_Gerente = "./src/main/resources/config/interfaceConfigAppGerente.json";
	//private static final String CONFIG_INTERFAZ_Operador= "./src/main/resources/config/interfaceConfigAppOperador.json";
	//private static final String CONFIG_INTERFAZ_GerenteGeneral= "./src/main/resources/config/interfaceConfigAppGerenteG.json";
	//private static final String CONFIG_INTERFAZ_Cajero= "./src/main/resources/config/interfaceConfigAppCajero.json";
	//private static final String CONFIG_INTERFAZ_Cliente= "./src/main/resources/config/interfaceConfigAppCliente.json";
	
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 
	
    private JsonObject tableConfig;
    
    private AlohAndes superAndes;
    private AlohAndes alohAndes;
    
    private JsonObject guiConfig;
    
    private PanelDatos panelDatos;
    
    private JMenuBar menuBar;
    
    private String usuarioActual;
    //private boolean esOperadorActual;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    
    public InterfazAlohAndesApp( )
    {
    	tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        superAndes = new AlohAndes (tableConfig);
        alohAndes = new AlohAndes (tableConfig);
        
    	//Aquí va lo cortado
    	
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_General);
    	
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame ( );
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
        
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );        
    }
    
	/* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/

    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
    

    private void configurarFrame(  )
    {
    	int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "Parranderos APP Default";
			alto = 300;
			ancho = 500;
    	}
    	else
    	{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
    	}
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );

        setTitle( titulo );
		setSize ( ancho, alto);        
    }

    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }
    
    
    
    /* ****************************************************************
	 * 			Funcionalidades
	 *****************************************************************/
    
    public String getUsuarioActual() {
    	return this.usuarioActual;
    }
    
    public void registrarPersona(String usuario, String contrasena, int carnetUniandes, String vinculacion, String esOperador) {
    	
    	try {
    		alohAndes.registrarPersona(usuario, contrasena, carnetUniandes, vinculacion, esOperador);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void registrarPersonaOperador(String usuario, String contrasena, int carnetUniandes, String vinculacion, String esOperador) {
    	
    	try {
    		alohAndes.registrarPersonaOperador(usuario, contrasena, carnetUniandes, vinculacion, esOperador);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void registrarOperadorHotel(int registroCamara, int registroSuperintendencia, String nombre, String ubicacion, String usuario, String contrasena) {
	
    	try {
    		alohAndes.registrarOperadorHotel(registroCamara, registroSuperintendencia, nombre, ubicacion, usuario, contrasena);
    	} catch(Exception e) {
    		
    	}
    }
    
    public void registrarOperadorHostal(int registroCamara, int registroSuperintendencia, String nombre, String ubicacion, String horaApertura, String horaCierre, String usuario, String contrasena) {
    	
    	try {
    		alohAndes.registrarOperadorHostal(registroCamara, registroSuperintendencia, nombre, ubicacion, horaApertura, horaCierre, usuario, contrasena);
    	} catch(Exception e) {
    		
    	}
    }
    
    public void registrarOperadorEmpresaVivienda(int registroCamara, int registroSuperintendencia, String nombre, int nit, String usuario, String contrasena) {
    	
    	try {
    		alohAndes.registrarOperadorEmpresaVivienda(registroCamara, registroSuperintendencia, nombre, nit, usuario, contrasena);
    	} catch(Exception e) {
    		
    	}
    }
    
    public boolean verificarIdentidad(String usuario, String contrasena, boolean esOperador) {
    	
    	boolean registrado = false;
    	try {
    		registrado =  alohAndes.verificarIdentidad(usuario, contrasena, esOperador);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return registrado;
    }
    
    public void asignarUsuarioActual(String usuario, boolean esOperador) {
    	
    	this.usuarioActual = usuario;
    	//this.esOperadorActual = esOperador;
    }
    
    public String determinarTipoOperador(String usuario) {
    	
    	try {
    		return alohAndes.determinarTipoOperador(usuario);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return "";
    }
    
    public void registrarOfertaViviendaComunidad(int costo, int numHabitaciones, String ubicacion, String menaje, int seguroArrendamiento, String fechaInicio, String fechaFin, int capacidad) {
    	
    	try {
    		alohAndes.registrarOfertaViviendaComunidad(costo, numHabitaciones, ubicacion, menaje, seguroArrendamiento, fechaInicio, fechaFin, capacidad, usuarioActual);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void registrarOfertaPropia(int costo, String comidas, String accesoCocina, String banoPrivado, String habIndividual, int costoServicios, String esquema, String fechaInicio, String fechaFin, int capacidad) {
    	
    	try {
    		alohAndes.registrarOfertaViviendaPropia(costo, comidas, accesoCocina, banoPrivado, habIndividual, costoServicios, esquema, fechaInicio, fechaFin, capacidad, usuarioActual);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void registrarApartamento(int numero, String conjunto, String direccion, String administracion, String amoblado) {
    	
    	try {
    		alohAndes.registrarApartamento(numero, conjunto, direccion, amoblado, usuarioActual);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void registrarOfertaApartamento(int costo, String serviciosIncluidos, String tv, String internet, String administracion, int capacidad, int numeroApartamento, String conjuntoApartamento, String direccionApartamento, String fechaInicio, String fechaFin) {
    	
    	try {
    		alohAndes.registrarOfertaApartamento(costo, serviciosIncluidos, tv, internet, administracion, capacidad, numeroApartamento, conjuntoApartamento, direccionApartamento, fechaInicio, fechaFin, usuarioActual);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void registrarOfertaHabitacion(int costo, String tipo, String tamano, int piso, String categoria, String fechaInicio, String fechaFin, String menaje, int capacidad) {
    	
    	try {
    		alohAndes.registrarOfertaHabitacion(costo, tipo, tamano, piso, categoria, fechaInicio, fechaFin, menaje, capacidad, usuarioActual);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
    public List<OfertasAlojamiento> obtenerOfertasActuales(String operador) {
		
		try {
			return alohAndes.obtenerOfertasActuales(operador);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
		return null;
	}
    
    public boolean eliminarOferta(long id) {
    	
    	try {
    		return alohAndes.eliminarOfertaAlojamiento(id);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return false;
	}
    
    
    public List<OfertasAlojamiento> obtenerOfertasDisponibles(){
    	
    	try {
    		return alohAndes.obtenerOfertasDisponibles();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return null;
    }
    
    
    public List<OfertaHabitacion> obtenerOfertashabitacionFiltradas(int costo, String tipoHabitacion, String categoria){
		try {
			return alohAndes.obtenerOfertashabitacionFiltradas(costo, tipoHabitacion, categoria);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return null;
	}
    
    
    public List<OfertaApartamento> obtenerOfertasApartamentoFiltradas(String servicios, String tv, String internet, String administracion){
		
		try {
			return alohAndes.obtenerOfertasApartamentoFiltradas(servicios, tv, internet, administracion);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return null;
	}
    
    
    public List<OfertaViviendaPropia> obtenerOfertasViviendaPropiaFiltradas(String comidas, String accesoCocina, String banoPrivado, String habIndividual){
		
		try {
			return alohAndes.obtenerOfertasViviendaPropiaFiltradas(comidas, accesoCocina, banoPrivado, habIndividual);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return null;
	}
    
    
    public List<OfertaViviendaComunidad> obtenerOfertasViviendaComunidadFiltradas(int costo, int numHabitaciones){
		
		try {
			return alohAndes.obtenerOfertasViviendaComunidadFiltradas(costo, numHabitaciones);
		} catch (Exception e) {
    		System.out.println(e);
    	}
    	return null;
	}
    
    
    public void registrarReserva(Long idOferta, String fechaInicio, String cliente, int duracion, int ocupacion) {
		
		try {
			alohAndes.registrarReserva(idOferta, fechaInicio, cliente, duracion, ocupacion);
		} catch (Exception e) {
    		System.out.println(e);
    	}
	}
    
    
    public List<Reserva> darReservasActivas(){
		
		try {
			return alohAndes.darReservasActivas(usuarioActual);
		} catch (Exception e) {
    		System.out.println(e);
    	}
		return null;
	}
    
  
    public void eliminarReserva(long id) {
		
		try {
			alohAndes.eliminarReserva(id);
		} catch (Exception e) {
    		System.out.println(e);
    	}
	}

	public HashMap<String, Integer> darOfertasIndice() {
		try {
			return alohAndes.darOfertasIndice();
		} catch (Exception e) {
    		System.out.println(e);
    	}
		return null;
	}

	public List<Reserva> darReservas() {
		try {
			return alohAndes.obtenerReservas();
		} catch (Exception e) {
    		System.out.println(e);
    	}
		return null;
	}

	public List<Reserva> darReservasCliente(String cliente) {
		try {
			return alohAndes.darReservasActivas(cliente);
		} catch (Exception e) {
    		System.out.println(e);
    	}
		return null;
	}
	    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	

	/* ****************************************************************
	 * 			Métodos administrativos
	 *****************************************************************/
	/**
	 * Muestra el log de Parranderos
	 */
	public void mostrarLogParranderos ()
	{
		mostrarArchivo ("parranderos.log");
	}
	
	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}
	
	/**
	 * Limpia el contenido del log de parranderos
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogParranderos ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("parranderos.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de parranderos ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia el contenido del log de datanucleus
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogDatanucleus ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia todas las tuplas de todas las tablas de la base de datos de parranderos
	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
	 */
	public void limpiarBD ()
	{
		try 
		{
    		// Ejecución de la demo y recolección de los resultados
			long eliminados [] = superAndes.limpiarAlohAndes();
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			resultado += eliminados [0] + " Gustan eliminados\n";
			resultado += eliminados [1] + " Sirven eliminados\n";
			resultado += eliminados [2] + " Visitan eliminados\n";
			resultado += eliminados [3] + " Bebidas eliminadas\n";
			resultado += eliminados [4] + " Tipos de bebida eliminados\n";
			resultado += eliminados [5] + " Bebedores eliminados\n";
			resultado += eliminados [6] + " Bares eliminados\n";
			resultado += "\nLimpieza terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	/**
	 * Muestra la presentación general del proyecto
	 */
	public void mostrarPresentacionGeneral ()
	{
		mostrarArchivo ("data/00-ST-ParranderosJDO.pdf");
	}
	
	/**
	 * Muestra el modelo conceptual de Parranderos
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/Modelo Conceptual Parranderos.pdf");
	}
	
	/**
	 * Muestra el esquema de la base de datos de Parranderos
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD Parranderos.pdf");
	}
	
	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaParranderos.sql");
	}
	
	/**
	 * Muestra la arquitectura de referencia para Parranderos
	 */
	public void mostrarArqRef ()
	{
		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
	}
	
	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	public void mostrarJavadoc ()
	{
		mostrarArchivo ("doc/index.html");
	}
	
	/**
     * Muestra la información acerca del desarrollo de esta apicación
     */
    public void acercaDe ()
    {
		String resultado = "\n\n ************************************\n\n";
		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
		resultado += " * Licenciado	bajo	el	esquema	Academic Free License versión 2.1\n";
		resultado += " * \n";		
		resultado += " * Curso: isis2304 - Sistemas Transaccionales\n";
		resultado += " * Proyecto: Parranderos Uniandes\n";
		resultado += " * @version 1.0\n";
		resultado += " * @author Germán Bravo\n";
		resultado += " * Julio de 2018\n";
		resultado += " * \n";
		resultado += " * Revisado por: Claudia Jiménez, Christian Ariza\n";
		resultado += "\n ************************************\n\n";

		panelDatos.actualizarInterfaz(resultado);		
    }
    

	/* ****************************************************************
	 * 			Métodos privados para la presentación de resultados y otras operaciones
	 *****************************************************************/

    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
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

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     * @param pEvento - El evento del usuario
     */
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = InterfazAlohAndesApp.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}
    
	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazAlohAndesApp interfaz = new InterfazAlohAndesApp( );
            interfaz.setVisible( true );
            
            FPrincipal dashboardInicio = new FPrincipal(interfaz);
            dashboardInicio.setVisible(true);
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
