
package uniandes.isis2304.parranderos.negocio;

public class Reserva implements VOReserva
{
	private long id;
	private String fechaInicio;
	private String cliente;
	private long ofertaAsociada;
	private int duracion;
	private String fechaRegistro;
	private int ocupacion;

	public Reserva() 
	{
		this.id = 0;
		this.fechaInicio = "";
		this.cliente = "";
		this.ofertaAsociada = 0;
		this.duracion = 0;
		this.fechaRegistro = "";
		this.ocupacion = 0;
	}

	public Reserva(long id, String fechaInicio, String cliente, long ofertaAsociada, int duracion, String fechaRegistro, int ocupacion) 
	{
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.cliente = cliente;
		this.ofertaAsociada = ofertaAsociada;
		this.duracion = duracion;
		this.fechaRegistro = fechaRegistro;
		this.ocupacion = ocupacion;
	}


	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}
	
	public String getFechaInicio() 
	{
		return fechaInicio;
	}
	
	public void setFechaInicio(String fecha) 
	{
		this.fechaInicio = fecha;
	}

	public String getCliente() 
	{
		return cliente;
	}
	
	public void setCliente(String cliente) 
	{
		this.cliente = cliente;
	}
	
	public long getOfertaAsociada() 
	{
		return ofertaAsociada;
	}
	
	public void setOfertaAsociada(long id) 
	{
		this.ofertaAsociada = id;
	}
	
	public int getDuracion() 
	{
		return duracion;
	}
	
	public void setDuracion(int duracion) 
	{
		this.duracion = duracion;
	}
	
	public String getFechaRegistro() 
	{
		return fechaRegistro;
	}
	
	public void setFechaRegistro(String fechaRegistro) 
	{
		this.fechaRegistro = fechaRegistro;
	}
	
	public int getOcupacion() 
	{
		return ocupacion;
	}
	
	public void setOcupacion(int ocupacion) 
	{
		this.ocupacion = ocupacion;
	}
	

	

	@Override
	public String toString() 
	{
		return "Reserva [id=" + id + ", fechaInicio=" + fechaInicio + ", cliente=" + cliente + ", ofertaAsociada=" + ofertaAsociada + ", duracion=" + duracion + ", fechaRegistro=" + fechaRegistro + ", ocupacion=" + ocupacion + "]";
	}
}
