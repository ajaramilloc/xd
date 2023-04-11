
package uniandes.isis2304.parranderos.negocio;

public class Apartamento implements VOApartamento
{
	private int numero;

	private String conjunto;
	
	private String direccion;
	
	private String amoblado;
	
	private String dueno;
	

	public Apartamento() 
	{
		this.numero = 0;
		this.conjunto = "";
		this.direccion = "";
		this.amoblado = "";
		this.dueno = "";
	}

	public Apartamento(int numero, String conjunto, String direccion, String amoblado, String dueno) 
	{
		this.numero = numero;
		this.conjunto = conjunto;
		this.direccion = direccion;
		this.amoblado = amoblado;
		this.dueno = dueno;
	}


	public int getNumero() 
	{
		return numero;
	}

	public void setNumero(int numero) 
	{
		this.numero = numero;
	}


	public String getConjunto() 
	{
		return conjunto;
	}

	public void setConjunto(String conjunto) 
	{
		this.conjunto = conjunto;
	}
	
	
	public String getDireccion() 
	{
		return direccion;
	}

	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}
	
	
	public String getAmoblado() 
	{
		return amoblado;
	}

	public void setAmoblado(String amoblado) 
	{
		this.amoblado = amoblado;
	}
	
	public String getDueno() 
	{
		return dueno;
	}

	public void setDueno(String dueno) 
	{
		this.dueno = dueno;
	}
	

	@Override
	public String toString() 
	{
		return "Apartamento [numero=" + numero + ", conjunto=" + conjunto + ", direccion=" + direccion + ", amoblado= "+ amoblado + ", dueno=" +dueno + "]";
	}
}
