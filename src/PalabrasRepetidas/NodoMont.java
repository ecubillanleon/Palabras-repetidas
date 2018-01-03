package PalabrasRepetidas;

public class NodoMont {
	private String clave;
	public int cont;

	public NodoMont(String palabra) {
		this.cont = 1;
		this.clave = palabra;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public void incrementoContador() {
		cont++;
	}
}