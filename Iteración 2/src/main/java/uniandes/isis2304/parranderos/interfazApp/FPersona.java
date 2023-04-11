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

import uniandes.isis2304.parranderos.negocio.OfertaApartamento;
import uniandes.isis2304.parranderos.negocio.OfertaHabitacion;
import uniandes.isis2304.parranderos.negocio.OfertaViviendaComunidad;
import uniandes.isis2304.parranderos.negocio.OfertaViviendaPropia;
import uniandes.isis2304.parranderos.negocio.OfertasAlojamiento;
import uniandes.isis2304.parranderos.negocio.Reserva;

@SuppressWarnings("serial")
public class FPersona extends JFrame{

	private InterfazAlohAndesApp interfaz;
	private FPrincipal principal;

	public FPersona(InterfazAlohAndesApp interfazPa) {
		
		this.interfaz = interfazPa;
		
		this.setSize(520, 650);
		this.setLayout(new BorderLayout());
		
		
		//INICIO Menú superior
		JPanel barra = new JPanel();
		barra.setLayout(new GridLayout(1,3));
		
		JButton btnRealizarReservar = new JButton("Realizar reservas");
		JButton btnCancelarReserva = new JButton("Cancelar reservas");
		JButton btnConsultas = new JButton("Consultas");
		
		barra.add(btnRealizarReservar);
		barra.add(btnCancelarReserva);
		barra.add(btnConsultas);
		
		add(barra, BorderLayout.NORTH);
		//FIN Menú superior
		
		
		//INICIO Dashboard Realizar Reservas
		JPanel dashboardRealizarReservas = new JPanel();
		dashboardRealizarReservas.setLayout(null);
		dashboardRealizarReservas.setVisible(false);
		dashboardRealizarReservas.setBounds(20, 20, 520, 650);
		
		JLabel txtOfertasDisponibles = new JLabel("Ofertas de alojamiento disponibles: ");
		txtOfertasDisponibles.setBounds(20, 20, 250, 20);
		
		ArrayList<Long> idsOfertasDisponibles = darIdsOfertasDisponibles();
		JComboBox cajaOfertasDisponibles = new JComboBox();
		cajaOfertasDisponibles.setBounds(270, 20, 130, 20);
		
		for(Long idOferta : idsOfertasDisponibles) {
			cajaOfertasDisponibles.addItem(idOferta);
		}
		
		JLabel txtFiltros = new JLabel("Filtros de búsqueda");
		txtFiltros.setBounds(180, 60, 150, 20);
		
		JLabel txtTipoOferta = new JLabel("Seleccione el tipo de oferta que desea: ");
		txtTipoOferta.setBounds(20, 100, 250, 20);
		
		String[] tiposOferta = {"Habitación", "Apartamento", "Vivienda comunidad", "Vivienda propia"};
		JComboBox cajaTiposOferta = new JComboBox(tiposOferta);
		cajaTiposOferta.setBounds(260, 100, 180, 20);
		
		JLabel txtPreferenciasOferta = new JLabel("Escoja sus preferencias para la oferta: ");
		txtPreferenciasOferta.setBounds(20, 140, 250, 20);
		txtPreferenciasOferta.setVisible(false);
		
		JLabel txtCostoOferta = new JLabel("Costo menor a: ");
		txtCostoOferta.setBounds(20, 140, 150, 20);
		JTextField cuadroCostoOferta = new JTextField();
		cuadroCostoOferta.setBounds(125, 140, 100, 20);
		
		JPanel matrizOpcionesPropia = new JPanel();
		matrizOpcionesPropia.setLayout(new GridLayout(3, 3));
		matrizOpcionesPropia.setBounds(50, 210, 300, 100);
		matrizOpcionesPropia.setVisible(false);
		
		JPanel matrizOpcionesApartamento = new JPanel();
		matrizOpcionesApartamento.setLayout(new GridLayout(3, 3));
		matrizOpcionesApartamento.setBounds(50, 210, 300, 100);
		matrizOpcionesApartamento.setVisible(false);
		
		//INICIO opciones oferta vivienda propia
		JLabel txtServiciosIncluidos = new JLabel("Seleccione los servicios que debe incluir: ");
		txtServiciosIncluidos.setBounds(20, 180, 280, 20);
		txtServiciosIncluidos.setVisible(false);
		
		JCheckBox cajaComidas = new JCheckBox("Comidas");
		JCheckBox cajaAccesoCocina = new JCheckBox("Acceso a cocina");
		JCheckBox cajaBanoPrivado = new JCheckBox("Baño privado");
		JCheckBox cajaHabIndividual = new JCheckBox("Habitación Individual");
		
		matrizOpcionesPropia.add(cajaComidas);
		matrizOpcionesPropia.add(cajaAccesoCocina);
		matrizOpcionesPropia.add(cajaBanoPrivado);
		matrizOpcionesPropia.add(cajaHabIndividual);
		//FIN opciones oferta vivienda propia
		
		//INICIO opciones oferta apartamento
		JCheckBox cajaServicios = new JCheckBox("Servicios pagados");
		JCheckBox cajaTv = new JCheckBox("Tv");
		JCheckBox cajaInternet = new JCheckBox("Internet");
		JCheckBox cajaAdministracion = new JCheckBox("Administración");
		
		matrizOpcionesApartamento.add(cajaServicios);
		matrizOpcionesApartamento.add(cajaTv);
		matrizOpcionesApartamento.add(cajaInternet);
		matrizOpcionesApartamento.add(cajaAdministracion);
		//FIN opciones oferta apartamento
		
		//INICIO opciones oferta habitación
		JLabel txtTipo = new JLabel("Seleccione el tipo de habitación: ");
		txtTipo.setBounds(20, 180, 220, 20);
		txtTipo.setVisible(false);
		
		String[] tiposHabitacion = { "Estandar", "Suite", "Semisuite"};
		JComboBox cajaTipoHabitacion = new JComboBox(tiposHabitacion);
		cajaTipoHabitacion.setBounds(220, 180, 100, 20);
		cajaTipoHabitacion.setVisible(false);
		
		JLabel txtCategoriaHabitacion = new JLabel("Categoria: ");
		txtCategoriaHabitacion.setBounds(20, 220, 70, 20);
		txtCategoriaHabitacion.setVisible(false);
		
		String[] categoriasHabitacion = { "Hotel", "Hostal", "Empresa Vivienda"};
		JComboBox cajaCategoriaHabitacion = new JComboBox(categoriasHabitacion);
		cajaCategoriaHabitacion.setBounds(100, 220, 150, 20);
		cajaCategoriaHabitacion.setVisible(false);
		//FIN opciones oferta habitación
		
		
		//INICIO opciones oferta Vivienda Comunidad
		JLabel txtNumHabitaciones = new JLabel("Número de habitaciones: ");
		txtNumHabitaciones.setBounds(20, 180, 170, 20);
		txtNumHabitaciones.setVisible(false);
		
		JTextField cuadroNumHabitaciones= new JTextField();
		cuadroNumHabitaciones.setBounds(180, 180, 50, 20);
		cuadroNumHabitaciones.setVisible(false);
		//FIN opciones oferta Vivienda Comunidad
		
		
		cajaTiposOferta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dashboardRealizarReservas.setVisible(true);
				
				if(cajaTiposOferta.getSelectedItem() == "Vivienda propia") {
					
					matrizOpcionesPropia.setVisible(true);
					matrizOpcionesApartamento.setVisible(false);
					txtTipo.setVisible(false);
					cajaTipoHabitacion.setVisible(false);
					txtCategoriaHabitacion.setVisible(false);
					cajaCategoriaHabitacion.setVisible(false);
					txtNumHabitaciones.setVisible(false);
					cuadroNumHabitaciones.setVisible(false);
					txtServiciosIncluidos.setVisible(true);
					
				} else if(cajaTiposOferta.getSelectedItem() == "Apartamento") {
					
					matrizOpcionesPropia.setVisible(false);
					matrizOpcionesApartamento.setVisible(true);
					txtTipo.setVisible(false);
					cajaTipoHabitacion.setVisible(false);
					txtCategoriaHabitacion.setVisible(false);
					cajaCategoriaHabitacion.setVisible(false);
					txtNumHabitaciones.setVisible(false);
					cuadroNumHabitaciones.setVisible(false);
					txtServiciosIncluidos.setVisible(true);
					
				} else if(cajaTiposOferta.getSelectedItem() == "Habitación") {
					
					matrizOpcionesPropia.setVisible(false);
					matrizOpcionesApartamento.setVisible(false);
					txtTipo.setVisible(true);
					cajaTipoHabitacion.setVisible(true);
					txtCategoriaHabitacion.setVisible(true);
					cajaCategoriaHabitacion.setVisible(true);
					txtNumHabitaciones.setVisible(false);
					cuadroNumHabitaciones.setVisible(false);
					txtServiciosIncluidos.setVisible(false);
					
				} else if(cajaTiposOferta.getSelectedItem() == "Vivienda comunidad") {
					
					matrizOpcionesPropia.setVisible(false);
					matrizOpcionesApartamento.setVisible(false);
					txtTipo.setVisible(false);
					cajaTipoHabitacion.setVisible(false);
					txtCategoriaHabitacion.setVisible(false);
					cajaCategoriaHabitacion.setVisible(false);
					txtNumHabitaciones.setVisible(true);
					cuadroNumHabitaciones.setVisible(true);
					txtServiciosIncluidos.setVisible(false);
				}
			}
		});
		
		JButton btnAplicarFiltros = new JButton("Aplicar filtros");
		btnAplicarFiltros.setBounds(185, 310, 130, 30);
		
		btnAplicarFiltros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(cajaTiposOferta.getSelectedItem().toString() == "Habitación") {
					
					List<OfertaHabitacion> ofertasHabitacion = obtenerOfertashabitacionFiltradas(Integer.parseInt(cuadroCostoOferta.getText()), cajaTipoHabitacion.getSelectedItem().toString(), cajaCategoriaHabitacion.getSelectedItem().toString());
					cajaOfertasDisponibles.removeAllItems();
					
					for(OfertaHabitacion oferta : ofertasHabitacion) {

						cajaOfertasDisponibles.addItem(oferta.getId());
					}
					cuadroCostoOferta.setText("");
					
				} else if(cajaTiposOferta.getSelectedItem().toString() == "Apartamento") {
					
					String servicios = "false";
					String tv = "false";
					String internet = "false";
					String administracion = "false";
					
					if(cajaServicios.isSelected()) {
						servicios = "true";
					}
					
					if(cajaTv.isSelected()) {
						tv = "true";
					}
					
					if(cajaInternet.isSelected()) {
						internet = "true";
					}
					
					if(cajaAdministracion.isSelected()) {
						administracion = "true";
					}
					List<OfertaApartamento> ofertasApartamento = obtenerOfertasApartamentoFiltradas(servicios, tv, internet, administracion);
					
					cajaOfertasDisponibles.removeAllItems();
					for(OfertaApartamento oferta : ofertasApartamento) {
						cajaOfertasDisponibles.addItem(oferta.getId());
					}
					cuadroCostoOferta.setText("");
					cajaServicios.setSelected(false);
					cajaTv.setSelected(false);
					cajaInternet.setSelected(false);
					cajaAdministracion.setSelected(false);
				
				} else if(cajaTiposOferta.getSelectedItem().toString() == "Vivienda propia") {
					
					String comidas = "false";
					String accesoCocina = "false";
					String banoPrivado = "false";
					String habIndividual = "false";
					
					if(cajaComidas.isSelected()) {
						comidas = "true";
					}
					
					if(cajaAccesoCocina.isSelected()) {
						accesoCocina = "true";
					}
					
					if(cajaBanoPrivado.isSelected()) {
						banoPrivado = "true";
					}
					
					if(cajaHabIndividual.isSelected()) {
						habIndividual = "true";
					}
					List<OfertaViviendaPropia> ofertasViviendaPropia = obtenerOfertasViviendaPropiaFiltradas(comidas, accesoCocina, banoPrivado, habIndividual);
					
					cajaOfertasDisponibles.removeAllItems();
					for(OfertaViviendaPropia oferta : ofertasViviendaPropia) {
						cajaOfertasDisponibles.addItem(oferta.getId());
					}
					cuadroCostoOferta.setText("");
					cajaComidas.setSelected(false);
					cajaAccesoCocina.setSelected(false);
					cajaBanoPrivado.setSelected(false);
					cajaHabIndividual.setSelected(false);
					
				} else if(cajaTiposOferta.getSelectedItem().toString() == "Vivienda comunidad") {
					
					List<OfertaViviendaComunidad> ofertasViviendaComunidad = obtenerOfertasViviendaComunidadFiltradas(Integer.parseInt(cuadroCostoOferta.getText()), Integer.parseInt(cuadroNumHabitaciones.getText()));
					
					cajaOfertasDisponibles.removeAllItems();
					for(OfertaViviendaComunidad oferta : ofertasViviendaComunidad) {
						cajaOfertasDisponibles.addItem(oferta.getId());
					}
					cuadroCostoOferta.setText("");
					cuadroNumHabitaciones.setText("");
				}
			}
		});
		
		JLabel txtInfoReserva = new JLabel("Información de la reserva");
		txtInfoReserva.setBounds(175, 380, 180, 20);
		
		JLabel txtFechaInicio = new JLabel("Fecha de inicio: ");
		txtFechaInicio.setBounds(20, 420, 120, 20);
		
		JTextField cuadroFechaInicio = new JTextField();
		cuadroFechaInicio.setBounds(120, 420, 100, 20);
		
		JLabel txtDuracion = new JLabel("Duración (en días): ");
		txtDuracion.setBounds(20, 460, 180, 20);
		
		JTextField cuadroDuracion = new JTextField();
		cuadroDuracion.setBounds(140, 460, 70, 20);
		
		JLabel txtOcupacion = new JLabel("Ocupación: ");
		txtOcupacion.setBounds(20, 500, 70, 20);
		
		JTextField cuadroOcupacion = new JTextField();
		cuadroOcupacion.setBounds(100, 500, 70, 20);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(200, 540, 100, 30);
		
		btnReservar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Long idOferta = Long.parseLong(cajaOfertasDisponibles.getSelectedItem().toString());
				registrarReserva(idOferta, cuadroFechaInicio.getText(), Integer.parseInt(cuadroDuracion.getText()), Integer.parseInt(cuadroOcupacion.getText()));
				
				cuadroFechaInicio.setText("");
				cuadroDuracion.setText("");
				cuadroOcupacion.setText("");
			}
		});
		
		dashboardRealizarReservas.add(txtOfertasDisponibles);
		dashboardRealizarReservas.add(cajaOfertasDisponibles);
		dashboardRealizarReservas.add(txtFiltros);
		dashboardRealizarReservas.add(txtTipoOferta);
		dashboardRealizarReservas.add(cajaTiposOferta);
		//dashboardRealizarReservas.add(txtPreferenciasOferta);
		dashboardRealizarReservas.add(txtCostoOferta);
		dashboardRealizarReservas.add(cuadroCostoOferta);
		dashboardRealizarReservas.add(matrizOpcionesPropia);
		dashboardRealizarReservas.add(matrizOpcionesApartamento);
		dashboardRealizarReservas.add(txtTipo);
		dashboardRealizarReservas.add(cajaTipoHabitacion);
		dashboardRealizarReservas.add(txtCategoriaHabitacion);
		dashboardRealizarReservas.add(cajaCategoriaHabitacion);
		dashboardRealizarReservas.add(txtNumHabitaciones);
		dashboardRealizarReservas.add(cuadroNumHabitaciones);
		dashboardRealizarReservas.add(txtServiciosIncluidos);
		dashboardRealizarReservas.add(btnAplicarFiltros);
		dashboardRealizarReservas.add(txtInfoReserva);
		dashboardRealizarReservas.add(txtFechaInicio);
		dashboardRealizarReservas.add(cuadroFechaInicio);
		dashboardRealizarReservas.add(txtDuracion);
		dashboardRealizarReservas.add(cuadroDuracion);
		dashboardRealizarReservas.add(txtOcupacion);
		dashboardRealizarReservas.add(cuadroOcupacion);
		dashboardRealizarReservas.add(btnReservar);
		
		add(dashboardRealizarReservas);
		//FIN Dashboard Realizar Reservas
		
		
		
		//INICIO Dashboard Cancelar Reservas
		JPanel dashboardCancelarReserva = new JPanel();
		dashboardCancelarReserva.setLayout(null);
		dashboardCancelarReserva.setVisible(false);
		dashboardCancelarReserva.setBounds(20, 20, 520, 650);
				
		JLabel txtSusReservas = new JLabel("Sus reservas activas: ");
		txtSusReservas.setBounds(20, 20, 150, 20);
				
		ArrayList<Long> idsReservasActivas = darIdsReservasActivas();
		JComboBox cajaReservasActivas = new JComboBox();
		cajaReservasActivas.setBounds(180, 20, 130, 20);
				
		for(Long id : idsReservasActivas) {
			cajaReservasActivas.addItem(id);
		}
				
		JButton btnEliminarReserva = new JButton("Cancelar reserva");
		btnEliminarReserva.setBounds(200, 540, 180, 30);
				
		btnEliminarReserva.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
						
				eliminarReserva(Long.parseLong(cajaReservasActivas.getSelectedItem().toString()));
				ArrayList<Long> idsReservasActivas = darIdsReservasActivas();
				
				cajaReservasActivas.removeAllItems();
				
				for(Long idReserva : idsReservasActivas) {
					cajaReservasActivas.addItem(idReserva);
				}
			}
		});
				
		dashboardCancelarReserva.add(txtSusReservas);
		dashboardCancelarReserva.add(cajaReservasActivas);
		dashboardCancelarReserva.add(btnEliminarReserva);
				
		add(dashboardCancelarReserva);
		//FIN Dashboard Cancelar Reservas
		
		
		
		//INICIO Dashboard Consultas
		
		//FIN Dashboard Consultas
		
		
		btnRealizarReservar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dashboardRealizarReservas.setVisible(true);
				dashboardCancelarReserva.setVisible(false);
			}
		});
		
		
		btnCancelarReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dashboardRealizarReservas.setVisible(false);
				dashboardCancelarReserva.setVisible(true);
				
				ArrayList<Long> idsReservasActivas = darIdsReservasActivas();
				
				cajaReservasActivas.removeAllItems();
				
				for(Long idReserva : idsReservasActivas) {
					cajaReservasActivas.addItem(idReserva);
				}
			}
		});
		
		
		btnConsultas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
				dashboardRealizarReservas.setVisible(false);
				dashboardCancelarReserva.setVisible(false);
				mostrarDashboardConsultas();
			}
		});
	}
	
	
	public ArrayList<Long> darIdsOfertasDisponibles(){
		
		ArrayList<Long> ids = new ArrayList<Long>();
		
		List<OfertasAlojamiento> ofertasRecuperadas = this.interfaz.obtenerOfertasDisponibles();
		
		for(OfertasAlojamiento oferta : ofertasRecuperadas) {
			ids.add(oferta.getId());
		}
		return ids;
	}
	
	
	public List<OfertaHabitacion> obtenerOfertashabitacionFiltradas(int costo, String tipoHabitacion, String categoria){
		
		return this.interfaz.obtenerOfertashabitacionFiltradas(costo, tipoHabitacion, categoria);
	}
	
	
	public List<OfertaApartamento> obtenerOfertasApartamentoFiltradas(String servicios, String tv, String internet, String administracion){
		
		return this.interfaz.obtenerOfertasApartamentoFiltradas(servicios, tv, internet, administracion);
	}
	
	
	public List<OfertaViviendaPropia> obtenerOfertasViviendaPropiaFiltradas(String comidas, String accesoCocina, String banoPrivado, String habIndividual){
		
		return this.interfaz.obtenerOfertasViviendaPropiaFiltradas(comidas, accesoCocina, banoPrivado, habIndividual);
	}
	
	
	public List<OfertaViviendaComunidad> obtenerOfertasViviendaComunidadFiltradas(int costo, int numHabitaciones){
		
		return this.interfaz.obtenerOfertasViviendaComunidadFiltradas(costo, numHabitaciones);
	}
	
	
	public void registrarReserva(Long idOferta, String fechaInicio, int duracion, int ocupacion) {
		
		this.interfaz.registrarReserva(idOferta, fechaInicio, this.interfaz.getUsuarioActual(), duracion, ocupacion);
	}
	
	
	public ArrayList<Long> darIdsReservasActivas(){
		
		ArrayList<Long> listaIds = new ArrayList<Long>();
		
		List<Reserva> reservasActivas = this.interfaz.darReservasActivas();
		
		for(Reserva reserva : reservasActivas) {
			listaIds.add(reserva.getId());
		}
				
		return listaIds;
	}
	
	
	public void eliminarReserva(long id) {
		
		this.interfaz.eliminarReserva(id);
	}
	
	public void mostrarDashboardConsultas() {
		FConsultas ventanaConsultas = new FConsultas(interfaz);
		ventanaConsultas.setVisible(true);
	}
	
	
}
