package app.modelo;

public class Contador {
	public Integer numero;
	public String id;

	public Contador(String id, Integer numero) {
		this.id = id;
		this.numero = numero;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
