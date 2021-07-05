package cl.inacap.registroAsistentesModel.dto;

public class Asistente {

	private String rut;
	private String nombre;
	private String apellido;
	private int edad;
	private String empresa;
	private String estado;
	private String region;
	private Asistente asistente;

	public Asistente getAsistente() {
		return asistente;
	}

	public void setAsistente(Asistente asistente) {
		this.asistente = asistente;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
