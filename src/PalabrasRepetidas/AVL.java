package PalabrasRepetidas;

public class AVL {
	private Nodo raiz;
	public int contador = 0, cantidad= 0;

	public AVL() {
		this.raiz = null;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public void insertar(String palabra) {
		raiz = insertar(palabra, raiz);
		contador++;
		
	}

	private Nodo insertar(String palabra, Nodo nodo) {
		if (nodo == null) {
			nodo = new Nodo(palabra);
			nodo.getCont();
			cantidad++;
		} else if (nodo.getPalabra().equals(palabra)) {
			nodo.incrementoContador();
		}

		else {
			if (palabra.compareTo(nodo.getPalabra()) < 0)
				nodo.izquierdo = insertar(palabra, nodo.izquierdo);

			if (altura(nodo.izquierdo) - altura(nodo.derecho) == 2) {
				if (palabra.compareTo(nodo.izquierdo.getPalabra()) < 0)
					nodo = rotacionDerecha(nodo);

				else
					nodo = rotacionIzquierdaDerecha(nodo);
			}

			else if (palabra.compareTo(nodo.getPalabra()) > 0)
				nodo.derecho = insertar(palabra, nodo.derecho);

			if (altura(nodo.derecho) - altura(nodo.izquierdo) == 2) {
				if (palabra.compareTo(nodo.derecho.getPalabra()) > 0)
					nodo = rotacionIzquierda(nodo);

				else
					nodo = rotacionDerechaIzquierda(nodo);
			}
		}

		nodo.altura = Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1;
		return nodo;
	}

	private Nodo rotacionDerecha(Nodo raiz) {
		Nodo nuevaRaiz = raiz.izquierdo;
		raiz.izquierdo = nuevaRaiz.derecho;
		nuevaRaiz.derecho = raiz;

		raiz.altura = Math.max(altura(raiz.izquierdo), altura(raiz.derecho)) + 1;
		nuevaRaiz.altura = Math.max(altura(nuevaRaiz.izquierdo), altura(nuevaRaiz.derecho)) + 1;
		return nuevaRaiz;
	}

	private Nodo rotacionDerechaIzquierda(Nodo raiz) {
		raiz.derecho = rotacionDerecha(raiz.derecho);
		return rotacionIzquierda(raiz);
	}

	private Nodo rotacionIzquierda(Nodo raiz) {
		Nodo nuevaRaiz = raiz.derecho;
		raiz.derecho = nuevaRaiz.izquierdo;
		nuevaRaiz.izquierdo = raiz;

		raiz.altura = Math.max(altura(raiz.izquierdo), altura(raiz.derecho)) + 1;
		nuevaRaiz.altura = Math.max(altura(nuevaRaiz.izquierdo), altura(nuevaRaiz.derecho)) + 1;
		return nuevaRaiz;
	}

	private Nodo rotacionIzquierdaDerecha(Nodo raiz) {
		raiz.izquierdo = rotacionIzquierda(raiz.izquierdo);
		return rotacionDerecha(raiz);
	}

	public int altura() {
		return altura(raiz);
	}

	public int altura(Nodo nodo) {
		if (nodo == null)
			return -1;

		return nodo.altura;
	}

	public void Enorden() {
		Enorden(raiz);
	}

	public void Enorden(Nodo nodo) {
		if (nodo != null) {
			Enorden(nodo.izquierdo);
			System.out.println(" " + nodo.getPalabra() + " --- " + " Repetida: " + nodo.getCont());
			Enorden(nodo.derecho);
		}
	}

	public void insertarEnMonticulo(Monticulo monticulo) {
		raiz(raiz, monticulo);
	}

	private void raiz(Nodo nodo, Monticulo monticulo) {
		if (nodo != null) {
			raiz(nodo.izquierdo, monticulo);
			if(!nodo.getPalabra().equals("")){
				monticulo.insertar(nodo.getCont(), nodo.getPalabra());
				raiz(nodo.derecho, monticulo);
			}
		}
	}
	
	public void cantidad(){
		System.out.println("Cantidad de nodos en el arbol:"+cantidad);
	}
}
