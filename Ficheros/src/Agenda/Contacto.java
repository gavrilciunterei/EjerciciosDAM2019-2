package Agenda;

public class Contacto {

	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private double salario;
	private String correo;

	public final int TOTAL_NOMBRE = 25;
	public final int TOTAL_APELLIDO = 55;
	public final int TOTAL_CORREO_LOCAL = 64;
	public final int TOTAL_CORREO_DOMINIO = 255;
	public final int TOTAL_FECHA= 8;

	
	public Contacto() {}
	public Contacto(String nombre, String apellido, String fechaNacimiento, double salario, String correo) {

		setNombre(nombre);
		setApellido(apellido);
		setFechaNacimiento(fechaNacimiento);
		setSalario(salario);
		setCorreo(correo);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		for (int i = nombre.length(); i < TOTAL_NOMBRE; i++) {
			nombre += " ";
		}

		this.nombre = nombre.substring(0, TOTAL_NOMBRE);

	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		for (int i = apellido.length(); i < TOTAL_APELLIDO; i++) {
			apellido += " ";
		}
		this.apellido = apellido.substring(0, TOTAL_APELLIDO);

	}

	public String getFechaNacimiento() {

		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {

		String correoFinal = "";

		String[] parte = correo.split("@");
		String correoLocal = parte[0];
		String correoDominio = parte[1];

		try {
			if (correoLocal.length() <= TOTAL_CORREO_LOCAL) {
				correoFinal += correoLocal;
			} else {
				correoFinal += correoLocal.substring(0, TOTAL_CORREO_LOCAL);
			}
			if (correoDominio.length() <= TOTAL_CORREO_DOMINIO) {
				correoFinal += "@" + correoDominio;
			} else {
				correoFinal += "@" + correoDominio.substring(0, TOTAL_CORREO_DOMINIO);
			}
		} catch (Exception e) {
			System.out.println("Correo erroneo");
		}

		for (int i = correoFinal.length(); i < (TOTAL_CORREO_LOCAL + TOTAL_CORREO_DOMINIO + 1); i++) {

			correoFinal += " ";
		}

		this.correo = correoFinal;

	}
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre.trim()+ ", apellido=" + apellido.trim() + ", fechaNacimiento=" + fechaNacimiento
				+ ", salario=" + salario + ", correo=" + correo.trim() + "]";
	}

}
