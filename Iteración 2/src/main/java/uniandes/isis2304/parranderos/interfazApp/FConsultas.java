package uniandes.isis2304.parranderos.interfazApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.isis2304.parranderos.negocio.Reserva;

@SuppressWarnings("serial")
public class FConsultas extends JFrame{
    
    private InterfazAlohAndesApp interfaz;

    public FConsultas(InterfazAlohAndesApp interfazPa) {

        this.interfaz = interfazPa;
		this.setLayout(null);
		this.setSize(400, 500);

        JButton botonIndiceOfertas = new JButton("Consultar índice de ofertas");	
		JButton botonReservasCliente = new JButton("Consultar reservas por cliente");
        JButton botonInfoUsuario = new JButton("Consultar información por tipo usuario");
		
		botonIndiceOfertas.setBounds(70, 50, 150, 50);
		botonReservasCliente.setBounds(70, 150, 150, 50);
        botonInfoUsuario.setBounds(70, 250, 150, 50);
		
		add(botonIndiceOfertas);
		add(botonReservasCliente);
        add(botonInfoUsuario);

        //INICIO Dashboard ïndice de ofertas
		JPanel dashboardIndiceOfertas = new JPanel();
		dashboardIndiceOfertas.setLayout(null);
		dashboardIndiceOfertas.setVisible(false);
		dashboardIndiceOfertas.setBounds(60, 20, 520, 650);
	
		
		add(dashboardIndiceOfertas);
		
		JLabel txtOfertasDisponibles = new JLabel("Índices por ofertas: ");
		txtOfertasDisponibles.setBounds(20, 20, 350, 40);
		add(txtOfertasDisponibles);
		
		HashMap<String, Integer> indiceOfertas = darIndiceOfertas();
		JComboBox cajaOfertasDisponibles = new JComboBox();
		cajaOfertasDisponibles.setBounds(30, 40, 300, 20);
		
		for(String idOferta : indiceOfertas.keySet()) {
            String[] info = idOferta.split("-");
            String id = info[0];
            String operador = info[1];
			cajaOfertasDisponibles.addItem(operador + " oferta #" + id + " Índice: " + indiceOfertas.get(idOferta));
		}

        //INICIO Dashboard Init Reservas por cliente
        JPanel dashboardInitReservasCliente = new JPanel();
		dashboardInitReservasCliente.setLayout(null);
		dashboardInitReservasCliente.setVisible(false);
		dashboardInitReservasCliente.setBounds(20, 20, 520, 650);
		add(dashboardInitReservasCliente);


        JLabel txtUsuario = new JLabel("Usuario: ");
		txtUsuario.setBounds(20, 40, 250, 20);

        JTextField cuadroUsuario = new JTextField();
        cuadroUsuario.setBounds(80, 40, 250, 20);

        JButton botonReservasPorCliente = new JButton("Consultar reservas por cliente");
        botonReservasPorCliente.setBounds(70, 70, 300, 50);

        //INICIO Dashboard Reservas por cliente
		JPanel dashboardReservasCliente = new JPanel();
		dashboardReservasCliente.setLayout(null);
		dashboardReservasCliente.setVisible(false);
		dashboardReservasCliente.setBounds(20, 20, 520, 650);
		add(dashboardReservasCliente);
		
		//List<Reserva> reservas = darReservasCliente(cuadroUsuario.getText());
		JComboBox cajaReservas = new JComboBox();
		cajaReservas.setBounds(20, 40, 180, 20);
		
		//for (Reserva reservaUsuario : reservas) {
            //cajaReservas.addItem(reservaUsuario.getId() + " " + reservaUsuario.getDuracion());
        //}

        botonIndiceOfertas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

                botonIndiceOfertas.setVisible(false);;
		        botonReservasCliente.setVisible(false);
				dashboardIndiceOfertas.setVisible(true);
				
			}
		});

        dashboardIndiceOfertas.add(cajaOfertasDisponibles);

        //INICIO Dashboard Init Reservas por cliente
        JPanel dashboardInfoUsuario = new JPanel();
		dashboardInfoUsuario.setLayout(null);
		dashboardInfoUsuario.setVisible(false);
        dashboardInfoUsuario.setBounds(20, 20, 520, 650);
		add(dashboardInfoUsuario);

        JLabel txtInfoUsuarios = new JLabel("Información por usuarios: ");
		txtInfoUsuarios.setBounds(20, 20, 350, 40);
		add(txtInfoUsuarios);

        JComboBox cajaInformacionUsuarios = new JComboBox();
		cajaInformacionUsuarios.setBounds(30, 40, 300, 20);

        int cantidadReservas = darTotalReservas();
        int cantidadOfertas = darTotalOfertas();

        cajaInformacionUsuarios.addItem("Usuarios Personas/ Cantidad Reservas: " + cantidadReservas);
        cajaInformacionUsuarios.addItem("Usuarios Operadores/ Cantidad Ofertas: " + cantidadOfertas);

        botonReservasCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

                botonIndiceOfertas.setVisible(false);
		        botonReservasCliente.setVisible(false);
                botonInfoUsuario.setVisible(false);
				dashboardInitReservasCliente.setVisible(true);
			}
		});

        dashboardInitReservasCliente.add(txtUsuario);
        dashboardInitReservasCliente.add(cuadroUsuario);
        dashboardInitReservasCliente.add(botonReservasPorCliente);

        botonReservasPorCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

                dashboardInitReservasCliente.setVisible(false);
				dashboardReservasCliente.setVisible(true);
				
				List<Reserva> reservas = darReservasCliente(cuadroUsuario.getText());
				
				for (Reserva reservaUsuario : reservas) {
		            cajaReservas.addItem("Id: " + reservaUsuario.getId() + ", Duración: " + reservaUsuario.getDuracion() + " días.");
		        }
			}
		});

        dashboardReservasCliente.add(cajaReservas);

        botonInfoUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

                botonIndiceOfertas.setVisible(false);
		        botonReservasCliente.setVisible(false);
                botonInfoUsuario.setVisible(false);

				dashboardInfoUsuario.setVisible(true);
				
			}
		});

        dashboardInfoUsuario.add(cajaInformacionUsuarios);
    }

    public HashMap<String, Integer> darIndiceOfertas() {
        return interfaz.darOfertasIndice();
    }

    public List<Reserva> darReservasCliente(String cliente) {
        return interfaz.darReservasCliente(cliente);
    }

    public int darTotalReservas() {
        return interfaz.darReservas().size();
    }

    public int darTotalOfertas() {
        return interfaz.obtenerOfertasDisponibles().size();
    }
}
