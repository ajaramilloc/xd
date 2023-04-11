
package uniandes.isis2304.parranderos.negocio;

public class OfertaViviendaPropia implements VOOfertaViviendaPropia
{
	private long id;
	private int costo;
	private String comidas;
	private String accesoCocina;
	private String banoPrivado;
	private String habIndividual;
	private int costoServicios;
	private String esquema;
	private String operador;
	private String fechaInicio;
	private String fechaFin;
	private int capacidad;

	public OfertaViviendaPropia() 
	{
		this.id = 0;
		this.costo = 0;
		this.comidas = "";
		this.accesoCocina = "";
		this.banoPrivado = "";
		this.habIndividual = "";
		this.costoServicios = 0;
		this.esquema = "";
		this.operador = "";
		this.fechaInicio = "";
		this.fechaFin = "";
		this.capacidad = 0;
	}

	public OfertaViviendaPropia(long id, int costo, String comidas, String accesoCocina, String banoPrivado, String habIndividual, int costoServicios, String esquema, String operador, String fechaInicio, String fechaFin, int capacidad) 
	{
		this.id = id;
		this.costo = costo;
		this.comidas = comidas;
		this.accesoCocina = accesoCocina;
		this.banoPrivado = banoPrivado;
		this.habIndividual = habIndividual;
		this.costoServicios = costoServicios;
		this.esquema = esquema;
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
	
	public String getComidas() 
	{
		return comidas;
	}
	
	public void setComidas(String comidas) 
	{
		this.comidas = comidas;
	}
	
	public String getAccesoCocina() 
	{
		return accesoCocina;
	}
	
	public void setAccesoCocina(String acceso) 
	{
		this.accesoCocina = acceso;
	}
	
	public String getBanoPrivado() 
	{
		return banoPrivado;
	}
	
	
	public void setBanoPrivado(String bano) 
	{
		this.banoPrivado = bano;
	}
	
	public String getHabIndividual() 
	{
		return habIndividual;
	}
	
	public void setHabIndividual(String hab) 
	{
		this.habIndividual = hab;
	}
	
	public int getCostoServicios() 
	{
		return costoServicios;
	}
	
	public void setCostoServicios(int costoServ) 
	{
		this.costoServicios = costoServ;
	}

	public String getEsquema() 
	{
		return esquema;
	}
	
	public void setEsquema(String acceso) 
	{
		this.accesoCocina = acceso;
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
	
	public void setFechaInicio(String fecha) 
	{
		this.fechaInicio = fecha;
	}
	
	public String getFechaFin() 
	{
		return fechaFin;
	}
	
	public void setFechaFin(String fecha) 
	{
		this.fechaFin = fecha;
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
		return "OfertaViviendaPropia [id=" + id + ", costo=" + costo + ", comidas=" + comidas + ", accesoCocina=" + accesoCocina + ", banoPrivado=" + banoPrivado + ", habIndividual=" + habIndividual + ", costoServicios=" + costoServicios + ", esquema=" + esquema + ", operador=" + operador + ", fechaInicio=" + fechaInicio +", fechaFin=" + fechaFin + ", capacidad=" + capacidad + "]";
	}
}
