package uniandes.isis2304.parranderos.interfazApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FLogin extends JFrame{

	private InterfazAlohAndesApp interfaz;
	private FPrincipal principal;
	
	public FLogin(InterfazAlohAndesApp interfazPa, FPrincipal principalPa) {
		
		this.interfaz = interfazPa;
		this.principal = principalPa;
		setSize(300, 220);
		setLayout(null);
		
		JLabel txtUsuario = new JLabel("Usuario: ");
		JLabel txtPassword = new JLabel("Contraseña: ");
		
		JTextField cuadroUsuario = new JTextField();
		JPasswordField cuadroPassword = new JPasswordField();
		
		JCheckBox btnOperador = new JCheckBox("Soy operador");
		
		JButton btnIngresar = new JButton("Ingresar");
		
		btnIngresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				verificarRegistrado(cuadroUsuario, cuadroPassword, btnOperador, interfaz);
				cuadroUsuario.setText("");
				cuadroPassword.setText("");
				btnOperador.setSelected(false);
			}
		});
		
		txtUsuario.setBounds(20, 20, 100, 20);
		txtPassword.setBounds(20, 60, 100, 20);
		
		cuadroUsuario.setBounds(100, 20, 150, 20);
		cuadroPassword.setBounds(100, 60, 150, 20);
		
		btnOperador.setBounds(15, 100, 150, 20);
		btnIngresar.setBounds(100, 140, 110, 30);
		
		add(txtUsuario);
		add(cuadroUsuario);
		add(txtPassword);
		add(cuadroPassword);
		add(btnOperador);
		add(btnIngresar);
	}
	
	
	public void verificarRegistrado(JTextField cuadroUsuario, JPasswordField cuadroPassword, JCheckBox btnOperador, InterfazAlohAndesApp inter) {
		
		String nombre = cuadroUsuario.getText();
		
		@SuppressWarnings("deprecation")
		String contrasena = cuadroPassword.getText();
		
		Boolean esOperador = btnOperador.isSelected();
		Boolean registrado = inter.verificarIdentidad(nombre, contrasena, esOperador);
		
		if(registrado) {
			
			this.principal.asignarUsuarioActual(nombre, esOperador);
			
			if(esOperador) {
				this.principal.mostrarDashboardOperador(this.principal.getInterfaz().determinarTipoOperador(nombre));
			} else {
				this.principal.mostrarDashboardPersona();
			}
			
		} else {
			JFrame ventanaError = new JFrame();
			ventanaError.setSize(100, 250);
			JLabel txtError = new JLabel("Usuario no registrado");
			ventanaError.add(txtError);
			ventanaError.setVisible(true);
		}
	}
}