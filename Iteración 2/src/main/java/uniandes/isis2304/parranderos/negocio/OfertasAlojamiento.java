
package uniandes.isis2304.parranderos.negocio;

public class OfertasAlojamiento implements VOOfertasAlojamiento
{
	private long id;

	private String tipoOferta;
	
	private String operador;

	public OfertasAlojamiento() 
	{
		this.id = 0;
		this.tipoOferta = "";
		this.operador = "";
	}

	public OfertasAlojamiento(long id, String tipoOferta, String operador) 
	{
		this.id = id;
		this.tipoOferta = tipoOferta;
		this.operador = operador;
	}


	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}


	public String getTipoOferta() 
	{
		return tipoOferta;
	}

	public void setTipoOferta(String tipoOferta) 
	{
		this.tipoOferta = tipoOferta;
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
		return "OfertaAlojamiento [id=" + id + ", tipoOferta=" + tipoOferta + ", operador=" + operador + "]";
	}
}
