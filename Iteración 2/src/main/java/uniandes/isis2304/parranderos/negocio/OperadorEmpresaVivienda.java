
package uniandes.isis2304.parranderos.negocio;

public class OperadorEmpresaVivienda implements VOOperadorEmpresaVivienda
{
	
	private int identificacion;
	
	private int registroCamara;
	
	private int registroSuperintendencia;
	
	private String nombre;
	
	private int nit;

	private String usuario;
	

	public OperadorEmpresaVivienda() 
	{
		this.identificacion = 0;
		this.registroCamara = 0;
		this.registroSuperintendencia = 0;
		this.nombre = "";
		this.nit = 0;
		this.usuario = "";
	}

	public OperadorEmpresaVivienda(int identificacionPa, int registroCamaraPa, int registroSuperintendenciaPa, String nombrePa, int nitPa, String usuarioPa)
	{
		this.identificacion = identificacionPa;
		this.registroCamara = registroCamaraPa;
		this.registroSuperintendencia = registroSuperintendenciaPa;
		this.nombre = nombrePa;
		this.nit = nitPa;
		this.usuario = usuarioPa;
	}


	public int getIdentificacion() 
	{
		return identificacion;
	}

	public void setIdentificacion(int identificacionPa) 
	{
		this.identificacion = identificacionPa;
	}
	
	public int getRegistroCamara() 
	{
		return registroCamara;
	}

	public void setRegistroCamara(int registroPa) 
	{
		this.registroCamara = registroPa;
	}
	
	public int getRegistroSuperintendencia() 
	{
		return registroSuperintendencia;
	}

	public void setRegistroSuperintendencia(int registroPa) 
	{
		this.registroSuperintendencia = registroPa;
	}
	
	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombrePa) 
	{
		this.nombre = nombrePa;
	}
	
	public int getNit() 
	{
		return nit;
	}

	public void setNit(int nitPa) 
	{
		this.nit = nitPa;
	}
	
	public String getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}
	

	@Override
	public String toString() 
	{
		return "OperadorHotel [identificacion=" + identificacion + ", registroCamara=" + registroCamara + ", registroSuperintendencia=" + registroSuperintendencia + ", nombre=" + nombre + ", nit=" + nit + ", usuario=" + usuario + "]";
	}
}
