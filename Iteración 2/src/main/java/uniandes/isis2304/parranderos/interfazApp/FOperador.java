package uniandes.isis2304.parranderos.interfazApp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.isis2304.parranderos.negocio.OfertasAlojamiento;

@SuppressWarnings("serial")
public class FOperador extends JFrame{
	
	private InterfazAlohAndesApp interfaz;
	private String tipoOperadorActual;

	public FOperador(InterfazAlohAndesApp interfazPa, String tipoOperadorActualPa) {
		
		this.interfaz = interfazPa;
		this.tipoOperadorActual = tipoOperadorActualPa;
		this.setSize(520, 650);
		this.setLayout(new BorderLayout());
		
		
		JPanel dashboardCrear = new JPanel();
		dashboardCrear.setLayout(null);
		dashboardCrear.setSize(300, 650);
		dashboardCrear.setBounds(20, 20, 560, 680);
		
		JLabel txtTipoOferta = new JLabel("Seleccione el tipo de oferta que desea crear: ");
		txtTipoOferta.setBounds(20, 30, 280, 20);
		
		JComboBox opcionesOferta;
	
		if(tipoOperadorActual == "Hotel") {
			String[] opcionesValidas = {"OfertaHabitacion"};
			opcionesOferta = new JComboBox(opcionesValidas);
		}
		else if(tipoOperadorActual == "Hostal") {
			String[] opcionesValidas = {"OfertaHabitacion"};
			opcionesOferta = new JComboBox(opcionesValidas);
		}
		else if(tipoOperadorActual == "EmpresaVivienda") {
			String[] opcionesValidas = {"OfertaApartamento", "OfertaHabitacion"};
			opcionesOferta = new JComboBox(opcionesValidas);
		}
		else if(tipoOperadorActual == "Persona") {
			String[] opcionesValidas = {"OfertaApartamento", "OfertaViviendaComunidad", "OfertaViviendaPropia", "OfertaHabitacion"};
			opcionesOferta = new JComboBox(opcionesValidas);
		} else {
			opcionesOferta = new JComboBox();
		}
		
		opcionesOferta.setBounds(300, 30, 180, 30);
		
		JLabel txtCosto = new JLabel("Ingrese el costo de la oferta: ");
		txtCosto.setBounds(20, 70, 200, 30);
		
		JTextField cuadroCosto = new JTextField();
		cuadroCosto.setBounds(200, 75, 150, 20);
		
		JLabel txtFechaInicio = new JLabel("Ingrese la fecha de inicio: ");
		txtFechaInicio.setBounds(20, 110, 200, 30);
		
		JTextField cuadroFechaInicio = new JTextField();
		cuadroFechaInicio.setBounds(180, 110, 100, 20);
		
		JLabel txtFechaFin = new JLabel("Ingrese la fecha en que termina: ");
		txtFechaFin.setBounds(20, 150, 250, 30);
		
		JTextField cuadroFechaFin = new JTextField();
		cuadroFechaFin.setBounds(220, 155, 100, 20);
		
		JLabel txtCapacidad = new JLabel("Ingrese la capacidad: ");
		txtCapacidad.setBounds(20, 190, 250, 30);
		
		JTextField cuadroCapacidad = new JTextField();
		cuadroCapacidad.setBounds(150, 195, 150, 20);
		
		txtTipoOferta.setVisible(false);
		opcionesOferta.setVisible(false);
		txtCosto.setVisible(false);
		cuadroCosto.setVisible(false);
		txtFechaInicio.setVisible(false);
		cuadroFechaInicio.setVisible(false);
		txtFechaFin.setVisible(false);
		cuadroFechaFin.setVisible(false);
		txtCapacidad.setVisible(false);
		cuadroCapacidad.setVisible(false);
		
		//Inicio Oferta Vivienda Comunidad
		JLabel txtNumHabitaciones = new JLabel("Ingrese el número de habitaciones: ");
		txtNumHabitaciones.setBounds(20, 230, 250, 30);
		
		JTextField cuadroNumHabitaciones = new JTextField();
		cuadroNumHabitaciones.setBounds(230, 235, 50, 20);
		
		JLabel txtUbicacion = new JLabel("Ingrese la ubicación: ");
		txtUbicacion.setBounds(20, 270, 250, 30);
		
		JTextField cuadroUbicacion = new JTextField();
		cuadroUbicacion.setBounds(150, 275, 150, 20);
		
		JLabel txtMenaje = new JLabel("Ingrese el menaje: ");
		txtMenaje.setBounds(20, 310, 250, 30);
		
		JTextField cuadroMenaje = new JTextField();
		cuadroMenaje.setBounds(135, 315, 150, 20);
		
		JLabel txtSeguroArrendamiento = new JLabel("Ingrese el código del seguro de arrendamiento: ");
		txtSeguroArrendamiento.setBounds(20, 350, 300, 30);
		
		JTextField cuadroSeguroArrendamiento = new JTextField();
		cuadroSeguroArrendamiento.setBounds(300, 355, 150, 20);
		
		JButton btnRegistrarComunidad = new JButton("Crear C");
		btnRegistrarComunidad.setBounds(200, 420, 100, 30);
		
		txtNumHabitaciones.setVisible(false);
		cuadroNumHabitaciones.setVisible(false);
		txtUbicacion.setVisible(false);
		cuadroUbicacion.setVisible(false);
		txtMenaje.setVisible(false);
		cuadroMenaje.setVisible(false);
		txtSeguroArrendamiento.setVisible(false);
		cuadroSeguroArrendamiento.setVisible(false);
		btnRegistrarComunidad.setVisible(false);
		// FIN Oferta Vivienda Comunidad
		
		//INICIO Oferta Vivienda Propia
		
		JLabel txtServiciosIncluidos = new JLabel("Seleccione los servicios que incluye:");
		txtServiciosIncluidos.setBounds(20, 230, 250, 20);
		
		JPanel mallaServicios = new JPanel();
		mallaServicios.setLayout(new GridLayout(3,3));
		mallaServicios.setBounds(20, 270, 280, 60);
		
		JCheckBox cajaComidas = new JCheckBox("Comidas");
		JCheckBox cajaAccesoCocina = new JCheckBox("Acceso a cocina");
		JCheckBox cajaBanoPrivado = new JCheckBox("Baño privado");
		JCheckBox cajaHabIndividual = new JCheckBox("HabitaciónIndividual");
		
		mallaServicios.add(cajaComidas);
		mallaServicios.add(cajaAccesoCocina);
		mallaServicios.add(cajaBanoPrivado);
		mallaServicios.add(cajaHabIndividual);
		
		JLabel txtCostoServicios = new JLabel("Ingrese el costo de los servicios: ");
		txtCostoServicios.setBounds(20, 330, 200, 20);
		
		JTextField cuadroCostoServicios = new JTextField();
		cuadroCostoServicios.setBounds(220, 330, 150, 20);
		
		JLabel txtEsquema = new JLabel("Ingrese el esquema: ");
		txtEsquema.setBounds(20, 370, 120, 20);
		
		JTextField cuadroEsquema = new JTextField();
		cuadroEsquema.setBounds(150, 370, 150, 20);
		
		JButton btnRegistrarPropia = new JButton("Crear P");
		btnRegistrarPropia.setBounds(200, 430, 100, 30);
		
		txtServiciosIncluidos.setVisible(false);
		mallaServicios.setVisible(false);
		txtCostoServicios.setVisible(false);
		cuadroCostoServicios.setVisible(false);
		txtEsquema.setVisible(false);
		cuadroEsquema.setVisible(false);
		btnRegistrarPropia.setVisible(false);
		//FIN Oferta Vivienda Propia
		
		
		//INICIO Oferta Apartamento
		JLabel txtApartamento = new JLabel("Información del apartamento");
		txtApartamento.setBounds(170, 230, 190, 20);
		
		JLabel txtNumeroApartamento = new JLabel("Ingrese el número de apartamento: ");
		txtNumeroApartamento.setBounds(20, 270, 250, 20);
		
		JTextField cuadroNumeroApartamento = new JTextField();
		cuadroNumeroApartamento.setBounds(250, 270, 150, 20);
		
		JLabel txtConjuntoApartamento = new JLabel("Ingrese el conjunto del apartamento: ");
		txtConjuntoApartamento.setBounds(20, 310, 280, 20);
		
		JTextField cuadroConjuntoApartamento = new JTextField();
		cuadroConjuntoApartamento.setBounds(250, 310, 150, 20);
		
		JLabel txtDireccionApartamento = new JLabel("Ingrese la dirección del apartamento: ");
		txtDireccionApartamento.setBounds(20, 350, 300, 20);
		
		JTextField cuadroDireccionApartamento = new JTextField();
		cuadroDireccionApartamento.setBounds(250, 350, 150, 20);
		
		JCheckBox cajaAmoblado = new JCheckBox("Está amoblado");
		cajaAmoblado.setBounds(20, 390, 170, 20);
		
		JLabel txtServiciosIncluidosApto = new JLabel("Seleccione los servicios que incluye:");
		txtServiciosIncluidosApto.setBounds(20, 430, 250, 20);
		
		JPanel mallaServiciosApto = new JPanel();
		mallaServiciosApto.setLayout(new GridLayout(3,3));
		mallaServiciosApto.setBounds(20, 470, 280, 60);
		
		JCheckBox cajaServicios = new JCheckBox("Servicios pagados");
		JCheckBox cajaTv = new JCheckBox("Tv");
		JCheckBox cajaInternet = new JCheckBox("Internet");
		JCheckBox cajaAdministracion = new JCheckBox("Administración");
		
		mallaServiciosApto.add(cajaServicios);
		mallaServiciosApto.add(cajaTv);
		mallaServiciosApto.add(cajaInternet);
		mallaServiciosApto.add(cajaAdministracion);
		
		JButton btnRegistrarApartamento = new JButton("Crear A");
		btnRegistrarApartamento.setBounds(200, 540, 100, 30);
		
		txtApartamento.setVisible(false);
		txtNumeroApartamento.setVisible(false);
		cuadroNumeroApartamento.setVisible(false);
		txtConjuntoApartamento.setVisible(false);
		cuadroConjuntoApartamento.setVisible(false);
		txtDireccionApartamento.setVisible(false);
		cuadroDireccionApartamento.setVisible(false);
		cajaAmoblado.setVisible(false);
		txtServiciosIncluidosApto.setVisible(false);
		mallaServiciosApto.setVisible(false);
		btnRegistrarApartamento.setVisible(false);
		//FIN Oferta Apartamento
		
		
		//INICIO Oferta Habitacion
		JLabel txtTipo = new JLabel("Seleccione el tipo de habitación: ");
		txtTipo.setBounds(20, 230, 200, 20);
		
		String[] tiposHabitacion = { "Estandar", "Suite", "Semisuite"};
		JComboBox cajaTipo = new JComboBox(tiposHabitacion);
		cajaTipo.setBounds(210, 230, 100, 20);
		
		JLabel txtTamano = new JLabel("Ingrese el tamaño de la habitación: ");
		txtTamano.setBounds(20, 270, 200, 20);
		
		JTextField cuadroTamano = new JTextField();
		cuadroTamano.setBounds(230, 270, 100, 20);
		
		JLabel txtPiso = new JLabel("Ingrese el piso de la habitación: ");
		txtPiso.setBounds(20, 310, 200, 20);
		
		JTextField cuadroPiso = new JTextField();
		cuadroPiso.setBounds(210, 310, 50, 20);
		
		JLabel txtCategoria = new JLabel("Seleccione la categoría de la habitación: ");
		txtCategoria.setBounds(20, 350, 250, 20);
		
		String[] categoriasHabitacion = { "Hotel", "Hostal", "ViviendaPropia", "EmpresaViviendaUniversitaria"};
		JComboBox cajaCategoria = new JComboBox(categoriasHabitacion);
		cajaCategoria.setBounds(260, 350, 100, 20);
		
		JLabel txtMenajeHabitacion = new JLabel("Ingrese el menaje: ");
		txtMenajeHabitacion.setBounds(20, 390, 150, 20);
		
		JTextField cuadroMenajeHabitacion = new JTextField();
		cuadroMenajeHabitacion.setBounds(140, 390, 120, 20);
		
		JButton btnRegistrarHabitacion = new JButton("Crear H");
		btnRegistrarHabitacion.setBounds(200, 450, 100, 30);
		
		txtTipo.setVisible(false);
		cajaTipo.setVisible(false);
		txtTamano.setVisible(false);
		cuadroTamano.setVisible(false);
		txtPiso.setVisible(false);
		cuadroPiso.setVisible(false);
		txtCategoria.setVisible(false);
		cajaCategoria.setVisible(false);
		txtMenajeHabitacion.setVisible(false);
		cuadroMenajeHabitacion.setVisible(false);
		btnRegistrarHabitacion.setVisible(false);
		//FIN Oferta Habitacion
		
		
		
		//INICIO Retirar Oferta
		JLabel txtOfertasOperador = new JLabel("Sus ofertas activas: ");
		txtOfertasOperador.setBounds(20, 60, 150, 20);
		txtOfertasOperador.setVisible(false);
		
		ArrayList<String> ofertasOperador = obtenerOfertasActuales();
		JComboBox ofertasDisponibles = new JComboBox();
		ofertasDisponibles.setBounds(20, 100, 300, 20);
		ofertasDisponibles.setVisible(false);
		
		for(String info : ofertasOperador) {
			ofertasDisponibles.addItem(info);
		}
		
		JButton btnRetirar = new JButton("Retirar Oferta");
		btnRetirar.setBounds(150, 200, 150, 30);
		btnRetirar.setVisible(false);
		//FIN Retirar Oferta
		
		
		dashboardCrear.add(txtTipoOferta);
		dashboardCrear.add(opcionesOferta);
		dashboardCrear.add(txtCosto);
		dashboardCrear.add(cuadroCosto);
		dashboardCrear.add(txtFechaInicio);
		dashboardCrear.add(cuadroFechaInicio);
		dashboardCrear.add(txtFechaFin);
		dashboardCrear.add(cuadroFechaFin);
		
		dashboardCrear.add(txtNumHabitaciones);
		dashboardCrear.add(cuadroNumHabitaciones);
		dashboardCrear.add(txtUbicacion);
		dashboardCrear.add(cuadroUbicacion);
		dashboardCrear.add(txtMenaje);
		dashboardCrear.add(cuadroMenaje);
		dashboardCrear.add(txtSeguroArrendamiento);
		dashboardCrear.add(cuadroSeguroArrendamiento);
		dashboardCrear.add(txtCapacidad);
		dashboardCrear.add(cuadroCapacidad);
		dashboardCrear.add(btnRegistrarComunidad);
		
		dashboardCrear.add(txtServiciosIncluidos);
		dashboardCrear.add(mallaServicios);
		dashboardCrear.add(txtCostoServicios);
		dashboardCrear.add(cuadroCostoServicios);
		dashboardCrear.add(txtEsquema);
		dashboardCrear.add(cuadroEsquema);
		dashboardCrear.add(btnRegistrarPropia);
		
		dashboardCrear.add(txtApartamento);
		dashboardCrear.add(txtNumeroApartamento);
		dashboardCrear.add(cuadroNumeroApartamento);
		dashboardCrear.add(txtConjuntoApartamento);
		dashboardCrear.add(cuadroConjuntoApartamento);
		dashboardCrear.add(txtDireccionApartamento);
		dashboardCrear.add(cuadroDireccionApartamento);
		dashboardCrear.add(cajaAmoblado);
		dashboardCrear.add(txtServiciosIncluidosApto);
		dashboardCrear.add(mallaServiciosApto);
		dashboardCrear.add(btnRegistrarApartamento);
		
		dashboardCrear.add(txtTipo);
		dashboardCrear.add(cajaTipo);
		dashboardCrear.add(txtTamano);
		dashboardCrear.add(cuadroTamano);
		dashboardCrear.add(txtPiso);
		dashboardCrear.add(cuadroPiso);
		dashboardCrear.add(txtCategoria);
		dashboardCrear.add(cajaCategoria);
		dashboardCrear.add(txtMenajeHabitacion);
		dashboardCrear.add(cuadroMenajeHabitacion);
		dashboardCrear.add(btnRegistrarHabitacion);
		
		dashboardCrear.add(txtOfertasOperador);
		dashboardCrear.add(ofertasDisponibles);
		dashboardCrear.add(btnRetirar);
		
		
		JPanel barra = new JPanel();
		barra.setLayout(new GridLayout(1,3));
		
		JButton btnCrearOferta = new JButton("Crear oferta de alojamiento");
		JButton btnRetirarOferta = new JButton("Retirar oferta de alojamiento");
		JButton btnConsultas = new JButton("Consultas");
		
		btnCrearOferta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtTipoOferta.setVisible(true);
				opcionesOferta.setVisible(true);
				txtCosto.setVisible(true);
				cuadroCosto.setVisible(true);
				txtFechaInicio.setVisible(true);
				cuadroFechaInicio.setVisible(true);
				txtFechaFin.setVisible(true);
				cuadroFechaFin.setVisible(true);
				txtCapacidad.setVisible(true);
				cuadroCapacidad.setVisible(true);
				txtOfertasOperador.setVisible(false);
				ofertasDisponibles.setVisible(false);
				btnRetirar.setVisible(false);
			}
		});
		
		btnRetirarOferta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtTipoOferta.setVisible(false);
				opcionesOferta.setVisible(false);
				txtCosto.setVisible(false);
				cuadroCosto.setVisible(false);
				txtFechaInicio.setVisible(false);
				cuadroFechaInicio.setVisible(false);
				txtFechaFin.setVisible(false);
				cuadroFechaFin.setVisible(false);
				txtCapacidad.setVisible(false);
				cuadroCapacidad.setVisible(false);
				
				txtNumHabitaciones.setVisible(false);
				cuadroNumHabitaciones.setVisible(false);
				txtUbicacion.setVisible(false);
				cuadroUbicacion.setVisible(false);
				txtMenaje.setVisible(false);
				cuadroMenaje.setVisible(false);
				txtSeguroArrendamiento.setVisible(false);
				cuadroSeguroArrendamiento.setVisible(false);
				btnRegistrarComunidad.setVisible(false);
				
				txtServiciosIncluidos.setVisible(false);
				mallaServicios.setVisible(false);
				txtCostoServicios.setVisible(false);
				cuadroCostoServicios.setVisible(false);
				txtEsquema.setVisible(false);
				cuadroEsquema.setVisible(false);
				btnRegistrarPropia.setVisible(false);
				
				txtApartamento.setVisible(false);
				txtNumeroApartamento.setVisible(false);
				cuadroNumeroApartamento.setVisible(false);
				txtConjuntoApartamento.setVisible(false);
				cuadroConjuntoApartamento.setVisible(false);
				txtDireccionApartamento.setVisible(false);
				cuadroDireccionApartamento.setVisible(false);
				cajaAmoblado.setVisible(false);
				txtServiciosIncluidosApto.setVisible(false);
				mallaServiciosApto.setVisible(false);
				btnRegistrarApartamento.setVisible(false);
				
				txtTipo.setVisible(false);
				cajaTipo.setVisible(false);
				txtTamano.setVisible(false);
				cuadroTamano.setVisible(false);
				txtPiso.setVisible(false);
				cuadroPiso.setVisible(false);
				txtCategoria.setVisible(false);
				cajaCategoria.setVisible(false);
				txtMenajeHabitacion.setVisible(false);
				cuadroMenajeHabitacion.setVisible(false);
				btnRegistrarHabitacion.setVisible(false);
				
				txtOfertasOperador.setVisible(true);
				ofertasDisponibles.setVisible(true);
				btnRetirar.setVisible(true);
				
				ArrayList<String> ofertasOperador = obtenerOfertasActuales();
				ofertasDisponibles.removeAllItems();
				for(String oferta : ofertasOperador) {
					ofertasDisponibles.addItem(oferta);
				}
			}
		});
		
		btnConsultas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtTipoOferta.setVisible(false);
				opcionesOferta.setVisible(false);
				txtCosto.setVisible(false);
				cuadroCosto.setVisible(false);
				txtFechaInicio.setVisible(false);
				cuadroFechaInicio.setVisible(false);
				txtFechaFin.setVisible(false);
				cuadroFechaFin.setVisible(false);
				txtCapacidad.setVisible(false);
				cuadroCapacidad.setVisible(false);
				
				txtNumHabitaciones.setVisible(false);
				cuadroNumHabitaciones.setVisible(false);
				txtUbicacion.setVisible(false);
				cuadroUbicacion.setVisible(false);
				txtMenaje.setVisible(false);
				cuadroMenaje.setVisible(false);
				txtSeguroArrendamiento.setVisible(false);
				cuadroSeguroArrendamiento.setVisible(false);
				btnRegistrarComunidad.setVisible(false);
				
				txtServiciosIncluidos.setVisible(false);
				mallaServicios.setVisible(false);
				txtCostoServicios.setVisible(false);
				cuadroCostoServicios.setVisible(false);
				txtEsquema.setVisible(false);
				cuadroEsquema.setVisible(false);
				btnRegistrarPropia.setVisible(false);
				
				txtApartamento.setVisible(false);
				txtNumeroApartamento.setVisible(false);
				cuadroNumeroApartamento.setVisible(false);
				txtConjuntoApartamento.setVisible(false);
				cuadroConjuntoApartamento.setVisible(false);
				txtDireccionApartamento.setVisible(false);
				cuadroDireccionApartamento.setVisible(false);
				cajaAmoblado.setVisible(false);
				txtServiciosIncluidosApto.setVisible(false);
				mallaServiciosApto.setVisible(false);
				btnRegistrarApartamento.setVisible(false);
				
				txtTipo.setVisible(false);
				cajaTipo.setVisible(false);
				txtTamano.setVisible(false);
				cuadroTamano.setVisible(false);
				txtPiso.setVisible(false);
				cuadroPiso.setVisible(false);
				txtCategoria.setVisible(false);
				cajaCategoria.setVisible(false);
				txtMenajeHabitacion.setVisible(false);
				cuadroMenajeHabitacion.setVisible(false);
				btnRegistrarHabitacion.setVisible(false);
				
				txtOfertasOperador.setVisible(false);
				ofertasDisponibles.setVisible(false);
				btnRetirar.setVisible(false);
			}
		});
		
		opcionesOferta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tipo = opcionesOferta.getSelectedItem().toString();
				
				if(tipo == "OfertaApartamento") {
					
					txtNumHabitaciones.setVisible(false);
					cuadroNumHabitaciones.setVisible(false);
					txtUbicacion.setVisible(false);
					cuadroUbicacion.setVisible(false);
					txtMenaje.setVisible(false);
					cuadroMenaje.setVisible(false);
					txtSeguroArrendamiento.setVisible(false);
					cuadroSeguroArrendamiento.setVisible(false);
					btnRegistrarComunidad.setVisible(false);
					
					txtServiciosIncluidos.setVisible(false);
					mallaServicios.setVisible(false);
					txtCostoServicios.setVisible(false);
					cuadroCostoServicios.setVisible(false);
					txtEsquema.setVisible(false);
					cuadroEsquema.setVisible(false);
					btnRegistrarPropia.setVisible(false);
					
					txtApartamento.setVisible(true);
					txtNumeroApartamento.setVisible(true);
					cuadroNumeroApartamento.setVisible(true);
					txtConjuntoApartamento.setVisible(true);
					cuadroConjuntoApartamento.setVisible(true);
					txtDireccionApartamento.setVisible(true);
					cuadroDireccionApartamento.setVisible(true);
					cajaAmoblado.setVisible(true);
					txtServiciosIncluidosApto.setVisible(true);
					mallaServiciosApto.setVisible(true);
					btnRegistrarApartamento.setVisible(true);
					
					txtTipo.setVisible(false);
					cajaTipo.setVisible(false);
					txtTamano.setVisible(false);
					cuadroTamano.setVisible(false);
					txtPiso.setVisible(false);
					cuadroPiso.setVisible(false);
					txtCategoria.setVisible(false);
					cajaCategoria.setVisible(false);
					txtMenajeHabitacion.setVisible(false);
					cuadroMenajeHabitacion.setVisible(false);
					btnRegistrarHabitacion.setVisible(false);
					
				} else if(tipo == "OfertaViviendaPropia") {
					
					txtNumHabitaciones.setVisible(false);
					cuadroNumHabitaciones.setVisible(false);
					txtUbicacion.setVisible(false);
					cuadroUbicacion.setVisible(false);
					txtMenaje.setVisible(false);
					cuadroMenaje.setVisible(false);
					txtSeguroArrendamiento.setVisible(false);
					cuadroSeguroArrendamiento.setVisible(false);
					btnRegistrarComunidad.setVisible(false);
					
					txtServiciosIncluidos.setVisible(true);
					mallaServicios.setVisible(true);
					txtCostoServicios.setVisible(true);
					cuadroCostoServicios.setVisible(true);
					txtEsquema.setVisible(true);
					cuadroEsquema.setVisible(true);
					btnRegistrarPropia.setVisible(true);
					
					txtApartamento.setVisible(false);
					txtNumeroApartamento.setVisible(false);
					cuadroNumeroApartamento.setVisible(false);
					txtConjuntoApartamento.setVisible(false);
					cuadroConjuntoApartamento.setVisible(false);
					txtDireccionApartamento.setVisible(false);
					cuadroDireccionApartamento.setVisible(false);
					cajaAmoblado.setVisible(false);
					txtServiciosIncluidosApto.setVisible(false);
					mallaServiciosApto.setVisible(false);
					btnRegistrarApartamento.setVisible(false);
					
					txtTipo.setVisible(false);
					cajaTipo.setVisible(false);
					txtTamano.setVisible(false);
					cuadroTamano.setVisible(false);
					txtPiso.setVisible(false);
					cuadroPiso.setVisible(false);
					txtCategoria.setVisible(false);
					cajaCategoria.setVisible(false);
					txtMenajeHabitacion.setVisible(false);
					cuadroMenajeHabitacion.setVisible(false);
					btnRegistrarHabitacion.setVisible(false);
					
				} else if(tipo == "OfertaViviendaComunidad") {
					
					txtNumHabitaciones.setVisible(true);
					cuadroNumHabitaciones.setVisible(true);
					txtUbicacion.setVisible(true);
					cuadroUbicacion.setVisible(true);
					txtMenaje.setVisible(true);
					cuadroMenaje.setVisible(true);
					txtSeguroArrendamiento.setVisible(true);
					cuadroSeguroArrendamiento.setVisible(true);
					btnRegistrarComunidad.setVisible(true);
					
					txtServiciosIncluidos.setVisible(false);
					mallaServicios.setVisible(false);
					txtCostoServicios.setVisible(false);
					cuadroCostoServicios.setVisible(false);
					txtEsquema.setVisible(false);
					cuadroEsquema.setVisible(false);
					btnRegistrarPropia.setVisible(false);
					
					txtApartamento.setVisible(false);
					txtNumeroApartamento.setVisible(false);
					cuadroNumeroApartamento.setVisible(false);
					txtConjuntoApartamento.setVisible(false);
					cuadroConjuntoApartamento.setVisible(false);
					txtDireccionApartamento.setVisible(false);
					cuadroDireccionApartamento.setVisible(false);
					cajaAmoblado.setVisible(false);
					txtServiciosIncluidosApto.setVisible(false);
					mallaServiciosApto.setVisible(false);
					btnRegistrarApartamento.setVisible(false);
					
					txtTipo.setVisible(false);
					cajaTipo.setVisible(false);
					txtTamano.setVisible(false);
					cuadroTamano.setVisible(false);
					txtPiso.setVisible(false);
					cuadroPiso.setVisible(false);
					txtCategoria.setVisible(false);
					cajaCategoria.setVisible(false);
					txtMenajeHabitacion.setVisible(false);
					cuadroMenajeHabitacion.setVisible(false);
					btnRegistrarHabitacion.setVisible(false);
					
				} else if(tipo == "OfertaHabitacion") {
				
					txtNumHabitaciones.setVisible(false);
					cuadroNumHabitaciones.setVisible(false);
					txtUbicacion.setVisible(false);
					cuadroUbicacion.setVisible(false);
					txtMenaje.setVisible(false);
					cuadroMenaje.setVisible(false);
					txtSeguroArrendamiento.setVisible(false);
					cuadroSeguroArrendamiento.setVisible(false);
					btnRegistrarComunidad.setVisible(false);
					
					txtServiciosIncluidos.setVisible(false);
					mallaServicios.setVisible(false);
					txtCostoServicios.setVisible(false);
					cuadroCostoServicios.setVisible(false);
					txtEsquema.setVisible(false);
					cuadroEsquema.setVisible(false);
					btnRegistrarPropia.setVisible(false);
					
					txtApartamento.setVisible(false);
					txtNumeroApartamento.setVisible(false);
					cuadroNumeroApartamento.setVisible(false);
					txtConjuntoApartamento.setVisible(false);
					cuadroConjuntoApartamento.setVisible(false);
					txtDireccionApartamento.setVisible(false);
					cuadroDireccionApartamento.setVisible(false);
					cajaAmoblado.setVisible(false);
					txtServiciosIncluidosApto.setVisible(false);
					mallaServiciosApto.setVisible(false);
					btnRegistrarApartamento.setVisible(false);
					
					txtTipo.setVisible(true);
					cajaTipo.setVisible(true);
					txtTamano.setVisible(true);
					cuadroTamano.setVisible(true);
					txtPiso.setVisible(true);
					cuadroPiso.setVisible(true);
					txtCategoria.setVisible(true);
					cajaCategoria.setVisible(true);
					txtMenajeHabitacion.setVisible(true);
					cuadroMenajeHabitacion.setVisible(true);
					btnRegistrarHabitacion.setVisible(true);
				}
			}
		});
		
		btnRegistrarComunidad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				registrarOfertaComunidad(cuadroCosto, cuadroNumHabitaciones, cuadroUbicacion, cuadroMenaje, cuadroSeguroArrendamiento, cuadroFechaInicio, cuadroFechaFin, cuadroCapacidad);
				cuadroCosto.setText("");
				cuadroFechaInicio.setText("");
				cuadroFechaFin.setText("");
				cuadroCapacidad.setText("");
				cuadroNumHabitaciones.setText("");
				cuadroUbicacion.setText("");
				cuadroMenaje.setText("");
				cuadroSeguroArrendamiento.setText("");
			}
		});
		
		btnRegistrarPropia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				registrarOfertaPropia(cuadroCosto, cajaComidas, cajaAccesoCocina, cajaBanoPrivado, cajaHabIndividual, cuadroCostoServicios, cuadroEsquema, cuadroFechaInicio, cuadroFechaFin, cuadroCapacidad);
				cuadroCosto.setText("");
				cuadroFechaInicio.setText("");
				cuadroFechaFin.setText("");
				cuadroCapacidad.setText("");
				cuadroCostoServicios.setText("");
				cuadroEsquema.setText("");
				cajaComidas.setSelected(false);
				cajaAccesoCocina.setSelected(false);
				cajaBanoPrivado.setSelected(false);
				cajaHabIndividual.setSelected(false);
			}
		});
		
		btnRegistrarApartamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				registrarOfertaApartamento(cuadroCosto, cajaServicios, cajaTv, cajaInternet, cajaAdministracion, cuadroCapacidad, cuadroNumeroApartamento, cuadroConjuntoApartamento, cuadroDireccionApartamento, cajaAmoblado, cuadroFechaInicio, cuadroFechaFin);
				cuadroCosto.setText("");
				cuadroFechaInicio.setText("");
				cuadroFechaFin.setText("");
				cuadroCapacidad.setText("");
				cuadroNumeroApartamento.setText("");
				cuadroConjuntoApartamento.setText("");
				cuadroDireccionApartamento.setText("");
				cajaAmoblado.setVisible(false);
				cajaServicios.setSelected(false);
				cajaTv.setSelected(false);
				cajaInternet.setSelected(false);
				cajaAdministracion.setSelected(false);
			}
		});
		
		btnRegistrarHabitacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				registrarOfertaHabitacion(cuadroCosto, cajaTipo, cuadroTamano, cuadroPiso, cajaCategoria, cuadroFechaInicio, cuadroFechaFin, cuadroCapacidad, cuadroMenajeHabitacion);
				cuadroCosto.setText("");
				cuadroFechaInicio.setText("");
				cuadroFechaFin.setText("");
				cuadroCapacidad.setText("");
				cuadroPiso.setText("");
				cuadroTamano.setText("");
				cuadroMenajeHabitacion.setText("");
			}
		});
		
		btnRetirar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				long idOferta = Long.parseLong(ofertasDisponibles.getSelectedItem().toString());
				boolean enReserva = eliminarOferta(idOferta);
				
				if(enReserva) {
					JFrame ventanaErrorEliminarOferta = new JFrame();
					ventanaErrorEliminarOferta.setSize(400, 150);
					
					JLabel errorEliminarOferta = new JLabel("No fue posible eliminar la oferta porque está en reserva");
					ventanaErrorEliminarOferta.add(errorEliminarOferta);
					ventanaErrorEliminarOferta.setVisible(true);
					
				} else {
					ArrayList<String> ofertasOperador = obtenerOfertasActuales();
					ofertasDisponibles.removeAllItems();
					for(String oferta : ofertasOperador) {
						ofertasDisponibles.addItem(oferta);
					}
				}
			}
		});
		
		barra.add(btnCrearOferta);
		barra.add(btnRetirarOferta);
		barra.add(btnConsultas);
		
		add(barra, BorderLayout.NORTH);
		add(dashboardCrear);
	}
	
	
	public void registrarOfertaComunidad(JTextField costo, JTextField numHabitaciones, JTextField ubicacion, JTextField menaje, JTextField seguroArrendamiento, JTextField fechaInicio, JTextField fechaFin, JTextField capacidad) {
		
		this.interfaz.registrarOfertaViviendaComunidad(Integer.parseInt(costo.getText()), Integer.parseInt(numHabitaciones.getText()), ubicacion.getText(), menaje.getText(), Integer.parseInt(seguroArrendamiento.getText()), fechaInicio.getText(), fechaFin.getText(), Integer.parseInt(capacidad.getText()));
	}
	
	public void registrarOfertaPropia(JTextField costo, JCheckBox comidas, JCheckBox accesoCocina, JCheckBox banoPrivado, JCheckBox habIndividual, JTextField costoServicios, JTextField esquema, JTextField fechaInicio, JTextField fechaFin, JTextField capacidad) {
		
		String valorComidas = "false";
		String valorAccesoCocina = "false";
		String valorBanoPrivado = "false";
		String valorHabIndividual = "false";
		
		if(comidas.isSelected()) {
			valorComidas = "true";
		}
		if(accesoCocina.isSelected()) {
			valorAccesoCocina = "true";
		}
		if(banoPrivado.isSelected()) {
			valorBanoPrivado = "true";
		}
		if(habIndividual.isSelected()) {
			valorHabIndividual = "true";
		}
		
		this.interfaz.registrarOfertaPropia(Integer.parseInt(costo.getText()), valorComidas, valorAccesoCocina, valorBanoPrivado, valorHabIndividual, Integer.parseInt(costoServicios.getText()), esquema.getText(), fechaInicio.getText(), fechaFin.getText(), Integer.parseInt(capacidad.getText()));
	}
	
	public void registrarOfertaApartamento(JTextField costo, JCheckBox serviciosIncluidos, JCheckBox cajaTv, JCheckBox cajaInternet, JCheckBox cajaAdministracion, JTextField capacidad, JTextField cuadroNumeroApartamento, JTextField cuadroConjuntoApartamento, JTextField cuadroDireccionApartamento, JCheckBox cajaAmoblado, JTextField fechaInicio, JTextField fechaFin) {
		
		String valorServicios = "false";
		String valorTv = "false";
		String valorInternet = "false";
		String valorAdministracion = "false";
		String amoblado = "false";
		
		if(serviciosIncluidos.isSelected()) {
			valorServicios = "true";
		}
		if(cajaTv.isSelected()) {
			valorTv = "true";
		}
		if(cajaInternet.isSelected()) {
			valorInternet = "true";
		}
		if(cajaAdministracion.isSelected()) {
			valorAdministracion = "true";
		}
		if(cajaAmoblado.isSelected()) {
			amoblado = "true";
		}
		this.interfaz.registrarApartamento(Integer.parseInt(cuadroNumeroApartamento.getText()), cuadroConjuntoApartamento.getText(), cuadroDireccionApartamento.getText(), valorAdministracion, amoblado);
		this.interfaz.registrarOfertaApartamento(Integer.parseInt(costo.getText()), valorServicios, valorTv, valorInternet, valorAdministracion, Integer.parseInt(capacidad.getText()), Integer.parseInt( cuadroNumeroApartamento.getText()), cuadroConjuntoApartamento.getText(), cuadroDireccionApartamento.getText(), fechaInicio.getText(), fechaFin.getText());
	}
	
	public void registrarOfertaHabitacion(JTextField cuadroCosto, JComboBox cajaTipo, JTextField cuadroTamano, JTextField cuadroPiso, JComboBox cajaCategoria, JTextField cuadroFechaInicio, JTextField cuadroFechaFin, JTextField cuadroCapacidad, JTextField cuadroMenajeHabitacion) {
		
		this.interfaz.registrarOfertaHabitacion(Integer.parseInt(cuadroCosto.getText()), cajaTipo.getSelectedItem().toString(), cuadroTamano.getText(), Integer.parseInt(cuadroPiso.getText()), cajaCategoria.getSelectedItem().toString(), cuadroFechaInicio.getText(), cuadroFechaFin.getText(), cuadroMenajeHabitacion.getText(), Integer.parseInt(cuadroCapacidad.getText()));
	}
	
	public ArrayList<String> obtenerOfertasActuales() {
		
		ArrayList<String> ofertas= new ArrayList<String>();
		List<OfertasAlojamiento> ofertasOperador = this.interfaz.obtenerOfertasActuales(this.interfaz.getUsuarioActual());
		
		for(OfertasAlojamiento oferta : ofertasOperador) {
			
			//String informacion = "Id: "+ oferta.getId() + ", Tipo oferta: " + oferta.getTipoOferta() + ", Operador: " + oferta.getOperador();
			ofertas.add(""+oferta.getId());
		}
		return ofertas;
	}
	
	public boolean eliminarOferta(long id) {
		return this.interfaz.eliminarOferta(id);
	}
}
