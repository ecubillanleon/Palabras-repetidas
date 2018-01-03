package PalabrasRepetidas;

public class Nodo {
	private String palabra;
	private int cont;
	public int altura;
	public Nodo derecho;
	public Nodo izquierdo;

	public Nodo(String palabra) {
		this.altura = 0;
		this.cont = 1;
		this.palabra = palabra;
		this.derecho = null;
		this.izquierdo = null;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Nodo getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo derecho) {
		this.derecho = derecho;
	}

	public Nodo getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}

	public void incrementoContador() {
		cont++;
	}
}