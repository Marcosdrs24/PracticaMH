package app.modelo;

import java.util.List;

public class Wyvern {
	public String tipo;
	public String nombre;
	public Integer hostilidad;
	public Double tamaño;
	public String descripición;
	public List<String> materiales;
	public String notas;
	public Boolean cazado;
	public String id;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHostilidad() {
		return hostilidad;
	}

	public void setHostilidad(Integer hostilidad) {
		this.hostilidad = hostilidad;
	}

	public Double getTamaño() {
		return tamaño;
	}

	public void setTamaño(Double tamaño) {
		this.tamaño = tamaño;
	}

	public String getDescripición() {
		return descripición;
	}

	public void setDescripición(String descripición) {
		this.descripición = descripición;
	}

	public List<String> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<String> materiales) {
		this.materiales = materiales;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Boolean getCazado() {
		return cazado;
	}

	public void setCazado(Boolean cazado) {
		this.cazado = cazado;
	}

}
