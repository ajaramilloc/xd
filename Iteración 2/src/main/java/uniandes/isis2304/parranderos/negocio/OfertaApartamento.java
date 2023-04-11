
package uniandes.isis2304.parranderos.negocio;

public class OfertaApartamento implements VOOfertaApartamento
{
	private long id;
	private int costo;
	private String serviciosIncluidos;
	private String tv;
	private String internet;
	private String administracion;
	private int capacidad;
	private int numeroApartamento;
	private String conjuntoApartamento;
	private String direccionApartamento;
	private String operador;
	private String fechaInicio;
	private String fechaFin;

	public OfertaApartamento() 
	{
		this.id = 0;
		this.costo = 0;
		this.serviciosIncluidos = "";
		this.tv = "";
		this.internet = "";
		this.administracion = "";
		this.capacidad = 0;
		this.numeroApartamento = 0;
		this.conjuntoApartamento = "";
		this.direccionApartamento = "";
		this.operador = "";
		this.fechaInicio = "";
		this.fechaFin = "";
	}

	public OfertaApartamento(long id, int costo, String serviciosIncluidos, String tv, String internet, String administracion, int capacidad, int numeroApartamento, String conjuntoApartamento, String direccionApartamento, String operador, String fechaInicio, String fechaFin) 
	{
		this.id = id;
		this.costo = costo;
		this.serviciosIncluidos = serviciosIncluidos;
		this.tv = tv;
		this.internet = internet;
		this.administracion = administracion;
		this.capacidad = capacidad;
		this.numeroApartamento = numeroApartamento;
		this.conjuntoApartamento = conjuntoApartamento;
		this.direccionApartamento = direccionApartamento;
		this.operador = operador;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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
	
	
	public String getServiciosIncluidos() 
	{
		return serviciosIncluidos;
	}
	
	public void setServiciosIncluidos(String servicios) 
	{
		this.serviciosIncluidos = servicios;
	}
	
	
	public String getTv() 
	{
		return tv;
	}
	
	public void setTv(String tv) 
	{
		this.tv = tv;
	}
	
	
	public String getInternet() 
	{
		return internet;
	}
	
	public void setInternet(String internet) 
	{
		this.internet = internet;
	}
	
	
	public String getAdministracion() 
	{
		return administracion;
	}
	
	public void setAdministracion(String administracion) 
	{
		this.administracion = administracion;
	}
	
	
	public int getCapacidad() 
	{
		return capacidad;
	}
	
	
	public void setCapacidad(int capacidad) 
	{
		this.capacidad = capacidad;
	}
	
	
	public int getNumeroApartamento() 
	{
		return numeroApartamento;
	}
	
	
	public void setNumeroApartamento(int numero) 
	{
		this.numeroApartamento = numero;
	}
	
	
	public String getConjuntoApartamento() 
	{
		return conjuntoApartamento;
	}
	
	public void setConjuntoApartamento(String conjunto) 
	{
		this.conjuntoApartamento = conjunto;
	}
	
	
	public String getDireccionApartamento() 
	{
		return direccionApartamento;
	}
	
	public void setDireccionApartamento(String direccion) 
	{
		this.direccionApartamento = direccion;
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
	
	
	

	@Override
	public String toString() 
	{
		return "OfertaApartamento [id=" + id + ", costo=" + costo + ", serviciosIncluidos=" + serviciosIncluidos + ", tv=" + tv + ", internet=" + internet + ", administracion=" + administracion + ", capacidad=" + capacidad + ", numeroApartamento=" + numeroApartamento + ", conjuntoApartamento=" + conjuntoApartamento + ", direccionApartamento=" + direccionApartamento + ", operador=" + operador + ", fechaInicio=" + fechaInicio + ", fechaFin" + fechaFin +"]";
	}

}
