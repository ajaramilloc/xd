
package uniandes.isis2304.parranderos.negocio;

public class OfertaHabitacion implements VOOfertaHabitacion
{
	private long id;
	private int costo;
	private String tipo;
	private String tamano;
	private int piso;
	private String categoria;
	private String fechaInicio;
	private String fechaFin;
	private String menaje;
	private String operador;
	private int capacidad;

	public OfertaHabitacion() 
	{
		this.id = 0;
		this.costo = 0;
		this.tipo = "";
		this.tamano = "";
		this.piso = 0;
		this.categoria = "";
		this.fechaInicio = "";
		this.fechaFin = "";
		this.menaje = "";
		this.operador = "";
		this.capacidad = 0;
	}

	public OfertaHabitacion(long id, int costo, String tipo, String tamano, int piso, String categoria, String fechaInicio, String fechaFin, String menaje, String operador, int capacidad) 
	{
		this.id = id;
		this.costo = costo;
		this.tipo = tipo;
		this.tamano = tamano;
		this.piso = piso;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.menaje = menaje;
		this.operador = operador;
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
	
	
	public String getTipo() 
	{
		return tipo;
	}
	
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	
	
	public String getTamano() 
	{
		return tamano;
	}
	
	
	public void setTamano(String tamano) 
	{
		this.tamano = tamano;
	}
	
	
	public int getPiso() 
	{
		return piso;
	}
	
	
	public void setPiso(int piso) 
	{
		this.piso = piso;
	}
	
	
	public String getCategoria() 
	{
		return categoria;
	}
	
	public void setCategoria(String categoria) 
	{
		this.categoria = categoria;
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
	
	
	public String getMenaje() 
	{
		return menaje;
	}
	
	public void setMenaje(String menaje) 
	{
		this.menaje = menaje;
	}
	
	public int getCapacidad() 
	{
		return capacidad;
	}
	
	
	public void setCapacidad(int capacidad) 
	{
		this.capacidad = capacidad;
	}
	
	
	public String getOperador() 
	{
		return operador;
	}
	
	
	public void setOperador(String operador) 
	{
		this.operador = operador;
	}

	

	@Override
	public String toString() 
	{
		return "OfertaHabitacion [id=" + id + ", costo=" + costo + ", tipo=" + tipo + ", tamano=" + tamano + ", piso=" + piso + ", categoria=" + categoria + ", fechaInicio=" + fechaInicio + ", fechaFin" + fechaFin + ", menaje=" + menaje + ", operador=" + operador + ", capacidad=" + capacidad +"]";
	}

}
