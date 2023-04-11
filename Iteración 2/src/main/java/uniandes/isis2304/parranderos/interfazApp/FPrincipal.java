package uniandes.isis2304.parranderos.interfazApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class FPrincipal extends JFrame{
	
	private InterfazAlohAndesApp interfaz;

	public FPrincipal(InterfazAlohAndesApp interfazPa) {
		
		this.interfaz = interfazPa;
		this.setLayout(null);
		
		JButton botonInicio = new JButton("Iniciar Sesión");
		JButton botonRegistro = new JButton("Registrarse");
		
		botonInicio.setBounds(70, 50, 150, 50);
		botonRegistro.setBounds(70, 150, 150, 50);
		
		add(botonInicio);
		add(botonRegistro);
		
		botonInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				inicioSesion(interfaz);
			}
		});
		
		
		botonRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				registro();
			}
		});
		
		this.setSize(300, 300);
		this.setTitle("¡Bienvenido!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		//FPrincipal Fprincipal = new FPrincipal();
		//Fprincipal.setVisible(true);
	}
	
	
	public void inicioSesion(InterfazAlohAndesApp inter) {
		
		FLogin ventanaLogin = new FLogin(inter, this);
		ventanaLogin.setVisible(true);
	}
	
	
	public void registro() {
		FRegistro ventanaRegistro = new FRegistro(this);
		ventanaRegistro.setVisible(true);
	}
	
	
	public InterfazAlohAndesApp getInterfaz() {
		return this.interfaz;
	}
	
	
	public void registrarPersona(String usuario, String contrasena, int carnetUniandes, String vinculacion, String esOperador) {
		interfaz.registrarPersona(usuario, contrasena, carnetUniandes, vinculacion, esOperador);
	}
	
	
	public void registrarPersonaOperador(String usuario, String contrasena, int carnetUniandes, String vinculacion, String esOperador) {
		interfaz.registrarPersonaOperador(usuario, contrasena, carnetUniandes, vinculacion, esOperador);
	}
	
	
	public void registrarOperadorHotel(int registroCamara, int registroSuperintendencia, String nombre, String ubicacion, String usuario, String contrasena) {
		interfaz.registrarOperadorHotel(registroCamara, registroSuperintendencia, nombre, ubicacion, usuario, contrasena);
	}
	
	
	public void registrarOperadorHostal(int registroCamara, int registroSuperintendencia, String nombre, String ubicacion, String horaApertura, String horaCierre, String usuario, String contrasena) {
		interfaz.registrarOperadorHostal(registroCamara, registroSuperintendencia, nombre, ubicacion, horaApertura, horaCierre, usuario, contrasena);
	}
	
	
	public void registrarOperadorEmpresaVivienda(int registroCamara, int registroSuperintendencia, String nombre, int nit, String usuario, String contrasena) {
		interfaz.registrarOperadorEmpresaVivienda(registroCamara, registroSuperintendencia, nombre, nit, usuario, contrasena);
	}
	
	
	public void asignarUsuarioActual(String usuario, boolean esOperador) {
		interfaz.asignarUsuarioActual(usuario, esOperador);
	}
	
	public void mostrarDashboardOperador(String tipoOperador) {
		FOperador ventanaOperador = new FOperador(interfaz, tipoOperador);
		ventanaOperador.setVisible(true);
	}
	
	public void mostrarDashboardPersona() {
		FPersona ventanaPersona = new FPersona(interfaz);
		ventanaPersona.setVisible(true);
	}
}
