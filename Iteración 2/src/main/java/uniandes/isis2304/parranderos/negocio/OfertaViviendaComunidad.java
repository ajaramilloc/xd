
package uniandes.isis2304.parranderos.negocio;

public class OfertaViviendaComunidad implements VOOfertaViviendaComunidad
{
	private long id;
	private int costo;
	private int numHabitaciones;
	private String ubicacion;
	private int seguroArrendamiento;
	private String menaje;
	private String operador;
	private String fechaInicio;
	private String fechaFin;
	private int capacidad;

	public OfertaViviendaComunidad() 
	{
		this.id = 0;
		this.costo = 0;
		this.numHabitaciones = 0;
		this.ubicacion = "";
		this.seguroArrendamiento = 0;
		this.menaje = "";
		this.operador = "";
		this.fechaInicio = "";
		this.fechaFin = "";
		this.capacidad = 0;
	}

	public OfertaViviendaComunidad(long id, int costo, int numHabitaciones, String ubicacion, String menaje, int seguroArrendamiento, String operador, String fechaInicio, String fechaFin, int capacidad) 
	{
		this.id = id;
		this.costo = costo;
		this.numHabitaciones = numHabitaciones;
		this.ubicacion = ubicacion;
		this.seguroArrendamiento = seguroArrendamiento;
		this.menaje = menaje;
		this.operador = operador;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.capacidad = capacidad;
	}


	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}
	
	
	public int getCosto() 
	{
		return costo;
	}
	
	
	public void setCosto(int costo) 
	{
		this.costo = costo;
	}
	
	public int getNumHabitaciones() 
	{
		return numHabitaciones;
	}
	
	public void setNumHabitaciones(int numHabitaciones) 
	{
		this.numHabitaciones = numHabitaciones;
	}
	
	
	public String getUbicacion() 
	{
		return ubicacion;
	}
	
	
	public void setUbicacion(String ubicacion) 
	{
		this.ubicacion = ubicacion;
	}
	
	
	public String getMenaje() 
	{
		return menaje;
	}
	
	public void setMenaje(String menaje) 
	{
		this.menaje = menaje;
	}
	
	
	public int getSeguroArrendamiento() 
	{
		return seguroArrendamiento;
	}
	
	public void setSeguroArrendamiento(int seguro) 
	{
		this.seguroArrendamiento = seguro;
	}
	
	
	public String getOperador() 
	{
		return operador;
	}
	
	
	public void setOperador(String operador) 
	{
		this.operador = operador;
	}

	
	public String getFechaInicio() 
	{
		return fechaInicio;
	}
	
	
	public void setFechaInicio(String fechaInicio) 
	{
		this.fechaInicio = fechaInicio;
	}
	
	
	public String getFechaFin() 
	{
		return fechaFin;
	}
	
	
	public void setFechaFin(String fechaFin) 
	{
		this.fechaFin = fechaFin;
	}
	
	
	public int getCapacidad() 
	{
		return capacidad;
	}
	
	
	public void setCapacidad(int capacidad) 
	{
		this.capacidad = capacidad;
	}
	
	
	

	@Override
	public String toString() 
	{
		return "OfertaViviendaComunidad [id=" + id + ", costo=" + costo + ", numHabitaciones=" + numHabitaciones + ", ubicacion=" + ubicacion + ", menaje=" + menaje + ", seguroArrendamiento=" + seguroArrendamiento + ", operador=" + operador + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", capacidad=" + capacidad + "]";
	}
}
