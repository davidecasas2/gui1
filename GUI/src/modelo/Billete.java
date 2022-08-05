package modelo;

import java.util.Objects;

public class Billete {
	private String nombre;
	private String apellidos;
	private int edad;
	private int tipoBillete;
	private String dni;
	private int numPasajeros;
	private boolean idayVuelta;
	
	public Billete() {
		this.nombre="";
		this.dni="";
		this.tipoBillete=1;
		this.idayVuelta=false;
		this.numPasajeros=1;
	}

	public Billete(String nombre, String apellidos, int edad, int tipoBillete,
			String dni, int numPasajeros, boolean idayVuelta) {
		this.nombre = nombre;
		this.apellidos=apellidos;
		this.edad = edad;
		this.tipoBillete = tipoBillete;
		this.dni = dni;
		this.numPasajeros = numPasajeros;
		this.idayVuelta = idayVuelta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getTipoBillete() {
		return tipoBillete;
	}

	public void setTipoBillete(int tipoBillete) {
		this.tipoBillete = tipoBillete;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public boolean isIdayVuelta() {
		return idayVuelta;
	}

	public void setIdayVuelta(boolean idayVuelta) {
		this.idayVuelta = idayVuelta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billete other = (Billete) obj;
		return Objects.equals(dni, other.dni);
	}

	
	
	@Override
	public String toString() {
		return "Billete [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", tipoBillete="
				+ tipoBillete + ", dni=" + dni + ", numPasajeros=" + numPasajeros + ", idayVuelta=" + idayVuelta + "]";
	}

	public double getImporteTotal() {
		double precio=30;
		if (this.tipoBillete==2) {
			precio= precio-precio*0.20;
		} else if (this.tipoBillete==3) {
			precio= precio-precio*0.35;
		} else {
			if (this.idayVuelta) {
				precio=precio-precio*0.15;
			}
		}
		if (this.idayVuelta) {
			precio=precio*2;
		}
		return precio*this.numPasajeros;
	}
	
	
	

}