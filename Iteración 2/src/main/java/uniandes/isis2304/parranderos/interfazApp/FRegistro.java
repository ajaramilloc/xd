package uniandes.isis2304.parranderos.interfazApp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class FRegistro extends JFrame{
	
	private FPrincipal principal;

	public FRegistro(FPrincipal principalPa) {
		
		this.principal = principalPa;
		setLayout(new BorderLayout());
		setSize(400, 650);
		
		JPanel barra = new JPanel();
		barra.setLayout(new GridLayout(1,2));
		
		JButton btnPersona = new JButton("Persona");
		JButton btnOperador = new JButton("Operador");

		barra.add(btnPersona);
		barra.add(btnOperador);
		
		add(barra, BorderLayout.NORTH);
		
		
		
		JPanel dashboardPersona = new JPanel();
		dashboardPersona.setLayout(null);
		dashboardPersona.setBounds(20, 20, 400, 400);
		
		JLabel txtUsuario = new JLabel("Usuario: ");
		txtUsuario.setBounds(20, 20, 100, 20);
		JLabel txtPassword = new JLabel("Contraseña: ");
		txtPassword.setBounds(20, 60, 100, 20);
		JLabel txtCarnet = new JLabel("Carnet Uniandes: ");
		txtCarnet.setBounds(20, 100, 100, 20);
		JLabel txtVinculacion = new JLabel("Vinculación: ");
		txtVinculacion.setBounds(20, 140, 100, 20);
		
		JTextField cuadroUsuario = new JTextField();
		cuadroUsuario.setBounds(100, 20, 170, 20);
		JTextField cuadroPassword = new JTextField();
		cuadroPassword.setBounds(100, 60, 170, 20);
		JTextField cuadroCarnet = new JTextField();
		cuadroCarnet.setBounds(130, 100, 170, 20);
		
		String vinculaciones[] = { "Estudiante", "Profesor", "Empleado", "Egresado", "AsistenteEvento", "Pariente", "ProfesorVisitante"};
		JComboBox vinculacion = new JComboBox(vinculaciones);
		vinculacion.setBounds(100, 140, 120, 20);
		
		JCheckBox esOperador = new JCheckBox("Soy operador");
		esOperador.setBounds(20, 180, 120, 20);
		
		JButton btnRegistro = new JButton("Registrarme");
		btnRegistro.setBounds(100, 220, 120, 30);
		
		dashboardPersona.add(txtUsuario);
		dashboardPersona.add(cuadroUsuario);
		dashboardPersona.add(txtPassword);
		dashboardPersona.add(cuadroPassword);
		dashboardPersona.add(txtCarnet);
		dashboardPersona.add(cuadroCarnet);
		dashboardPersona.add(txtVinculacion);
		dashboardPersona.add(vinculacion);
		dashboardPersona.add(esOperador);
		dashboardPersona.add(btnRegistro);
		
		add(dashboardPersona);
		dashboardPersona.setVisible(false);
		
		
		
		JPanel dashboardOperador = new JPanel();
		dashboardOperador.setLayout(null);
		dashboardOperador.setBounds(25, 25, 400, 400);
		
		JLabel txtUsuarioO = new JLabel("Usuario: ");
		txtUsuarioO.setBounds(20, 20, 100, 20);
		JLabel txtPasswordO = new JLabel("Contraseña: ");
		txtPasswordO.setBounds(20, 60, 100, 20);
		JLabel txtTipoOperador= new JLabel("Tipo de operador: ");
		txtTipoOperador.setBounds(20, 100, 120, 20);
		JLabel txtNombre = new JLabel("Nombre: ");
		txtNombre.setBounds(20, 140, 100, 20);
		JLabel txtRegistroCamara = new JLabel("Registro Cámara: ");
		txtRegistroCamara.setBounds(20, 180, 130, 20);
		JLabel txtRegistroSuperintendencia= new JLabel("Registro Superintendencia: ");
		txtRegistroSuperintendencia.setBounds(20, 220, 170, 20);
		JLabel txtUbicacion = new JLabel("Ubicación: ");
		txtUbicacion.setBounds(20, 260, 100, 20);
		JLabel txtNit = new JLabel("NIT: ");
		txtNit.setBounds(20, 260, 130, 20);
		JLabel txtHoraApertura= new JLabel("Hora de apertura: ");
		txtHoraApertura.setBounds(20, 300, 170, 20);
		JLabel txtHoraCierre= new JLabel("Hora de cierre: ");
		txtHoraCierre.setBounds(20, 340, 170, 20);
		
		txtUbicacion.setVisible(false);
		txtNit.setVisible(false);
		txtHoraApertura.setVisible(false);
		txtHoraCierre.setVisible(false);
		
		JTextField cuadroUsuarioO = new JTextField();
		cuadroUsuarioO.setBounds(80, 20, 170, 20);
		JTextField cuadroPasswordO = new JTextField();
		cuadroPasswordO.setBounds(100, 60, 170, 20);
		JTextField cuadroNombre = new JTextField();
		cuadroNombre.setBounds(80, 140, 170, 20);
		JTextField cuadroRegistroCamara = new JTextField();
		cuadroRegistroCamara.setBounds(130, 180, 170, 20);
		JTextField cuadroRegistroSuperintendencia = new JTextField();
		cuadroRegistroSuperintendencia.setBounds(180, 220, 170, 20);
		JTextField cuadroUbicacion = new JTextField();
		cuadroUbicacion.setBounds(100, 260, 170, 20);
		JTextField cuadroNit= new JTextField();
		cuadroNit.setBounds(50, 260, 170, 20);
		JTextField cuadroHoraApertura = new JTextField();
		cuadroHoraApertura.setBounds(130, 300, 170, 20);
		JTextField cuadroHoraCierre = new JTextField();
		cuadroHoraCierre.setBounds(130, 340, 170, 20);
		
		cuadroUbicacion.setVisible(false);
		cuadroNit.setVisible(false);
		cuadroHoraApertura.setVisible(false);
		cuadroHoraCierre.setVisible(false);
		
		String operadores[] = { "Hotel", "Hostal", "EmpresaVivienda"};
		JComboBox tipoOperador = new JComboBox(operadores);
		tipoOperador.setBounds(140, 100, 170, 20);
		
		
		//INICIO Servicios prestados
		JLabel txtServiciosIncluidos = new JLabel("Seleccione los servicios que ofrece: ");
		txtServiciosIncluidos.setBounds(20, 380, 250, 20);
		
		JPanel matrizServiciosIncluidos = new JPanel();
		matrizServiciosIncluidos.setLayout(new GridLayout(3, 3));
		matrizServiciosIncluidos.setBounds(20, 420, 300, 100);
		
		JCheckBox cajaRestaurante = new JCheckBox("Restaurante");
		JCheckBox cajaPiscina = new JCheckBox("Piscina");
		JCheckBox cajaParqueadero = new JCheckBox("Parqueadero");
		JCheckBox cajaWifi = new JCheckBox("Wifi");
		JCheckBox cajaRecepcion= new JCheckBox("Recepción 24h");
		JCheckBox cajaTvCable = new JCheckBox("TV cable");
		
		matrizServiciosIncluidos.add(cajaRestaurante);
		matrizServiciosIncluidos.add(cajaPiscina);
		matrizServiciosIncluidos.add(cajaParqueadero);
		matrizServiciosIncluidos.add(cajaWifi);
		matrizServiciosIncluidos.add(cajaRecepcion);
		matrizServiciosIncluidos.add(cajaTvCable);
				
		
		tipoOperador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String operadorSeleccionado = tipoOperador.getSelectedItem().toString();
				
				if(operadorSeleccionado == "Hotel") {
					txtUbicacion.setVisible(true);
					txtNit.setVisible(false);
					txtHoraApertura.setVisible(false);
					txtHoraCierre.setVisible(false);
					cuadroUbicacion.setVisible(true);
					cuadroNit.setVisible(false);
					cuadroHoraApertura.setVisible(false);
					cuadroHoraCierre.setVisible(false);
					
				} else if(operadorSeleccionado == "Hostal") {
					txtUbicacion.setVisible(true);
					txtNit.setVisible(false);
					txtHoraApertura.setVisible(true);
					txtHoraCierre.setVisible(true);
					cuadroUbicacion.setVisible(true);
					cuadroNit.setVisible(false);
					cuadroHoraApertura.setVisible(true);
					cuadroHoraCierre.setVisible(true);
					
				} else if(operadorSeleccionado == "EmpresaVivienda") {
					txtUbicacion.setVisible(false);
					txtNit.setVisible(true);
					txtHoraApertura.setVisible(false);
					txtHoraCierre.setVisible(false);
					cuadroUbicacion.setVisible(false);
					cuadroNit.setVisible(true);
					cuadroHoraApertura.setVisible(false);
					cuadroHoraCierre.setVisible(false);
				}
			}
		});
		
		JButton btnRegistroOperador = new JButton("Registrarme");
		btnRegistroOperador.setBounds(135, 540, 120, 30);
		
		dashboardOperador.add(txtUsuarioO);
		dashboardOperador.add(cuadroUsuarioO);
		dashboardOperador.add(txtPasswordO);
		dashboardOperador.add(cuadroPasswordO);
		dashboardOperador.add(txtTipoOperador);
		dashboardOperador.add(tipoOperador);
		dashboardOperador.add(txtRegistroCamara);
		dashboardOperador.add(cuadroRegistroCamara);
		dashboardOperador.add(txtRegistroSuperintendencia);
		dashboardOperador.add(cuadroRegistroSuperintendencia);
		dashboardOperador.add(btnRegistroOperador);
		dashboardOperador.add(txtUbicacion);
		dashboardOperador.add(txtNit);
		dashboardOperador.add(txtHoraApertura);
		dashboardOperador.add(txtHoraCierre);
		dashboardOperador.add(cuadroUbicacion);
		dashboardOperador.add(cuadroNit);
		dashboardOperador.add(cuadroHoraApertura);
		dashboardOperador.add(cuadroHoraCierre);
		dashboardOperador.add(txtNombre);
		dashboardOperador.add(cuadroNombre);
		dashboardOperador.add(txtServiciosIncluidos);
		dashboardOperador.add(matrizServiciosIncluidos);
		
		add(dashboardOperador);
		dashboardOperador.setVisible(false);
		
		vinculacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String comando = vinculacion.getSelectedItem().toString();
				System.out.println(comando);
			}
		});
		
		btnPersona.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dashboardPersona.setVisible(true);
				dashboardOperador.setVisible(false);
			}
		});
		
		
		btnOperador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dashboardPersona.setVisible(false);
				dashboardOperador.setVisible(true);
			}
		});
		
		
		btnRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String operador = "false";
				
				if(esOperador.isSelected()) {
					operador = "true";
					principal.registrarPersonaOperador(cuadroUsuario.getText(), cuadroPassword.getText(), Integer.parseInt(cuadroCarnet.getText()), vinculacion.getSelectedItem().toString(), operador);
					
				} else {
					principal.registrarPersona(cuadroUsuario.getText(), cuadroPassword.getText(), Integer.parseInt(cuadroCarnet.getText()), vinculacion.getSelectedItem().toString(), operador);
					
				}
				cuadroUsuario.setText("");
				cuadroPassword.setText("");
				cuadroCarnet.setText("");
				esOperador.setSelected(false);
			}
		});
		
		
		btnRegistroOperador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tipoOperadorFinal = tipoOperador.getSelectedItem().toString();
				
				if(tipoOperadorFinal == "Hotel") {
					principal.registrarOperadorHotel(Integer.parseInt(cuadroRegistroCamara.getText()), Integer.parseInt(cuadroRegistroSuperintendencia.getText()), cuadroNombre.getText(), cuadroUbicacion.getText(), cuadroUsuarioO.getText(), cuadroPasswordO.getText());
				} else if(tipoOperadorFinal == "Hostal") {
					principal.registrarOperadorHostal(Integer.parseInt(cuadroRegistroCamara.getText()), Integer.parseInt(cuadroRegistroSuperintendencia.getText()), cuadroNombre.getText(), cuadroUbicacion.getText(), cuadroHoraApertura.getText(), cuadroHoraCierre.getText(), cuadroUsuarioO.getText(), cuadroPasswordO.getText());
				} else if(tipoOperadorFinal == "EmpresaVivienda") {
					principal.registrarOperadorEmpresaVivienda(Integer.parseInt(cuadroRegistroCamara.getText()), Integer.parseInt(cuadroRegistroSuperintendencia.getText()), cuadroNombre.getText(), Integer.parseInt(cuadroNit.getText()), cuadroUsuarioO.getText(), cuadroPasswordO.getText());
				}
				
				cuadroRegistroCamara.setText("");
				cuadroRegistroSuperintendencia.setText("");
				cuadroNombre.setText("");
				cuadroUbicacion.setText("");
				cuadroNit.setText("");
				cuadroHoraApertura.setText("");
				cuadroHoraCierre.setText("");
				cuadroUsuarioO.setText("");
				cuadroPasswordO.setText("");
			}
		});

	}
}