package PalabrasRepetidas;

public class Monticulo {
	private Nodo[] arbol;
	private int N;

	public Monticulo(int tamaño) {
		arbol = new Nodo[tamaño];
		N = 0;
	}

	public Nodo[] getArbol() {
		return arbol;
	}

	public void setArbol(Nodo[] arbol) {
		this.arbol = arbol;
	}

	private int hizq(int pos) {
		int h = 2 * pos + 1;
		if (h < N)
			return h;
		return -1;
	}

	private int hder(int pos) {
		int h = 2 * (pos + 1);
		if (h < N)
			return h;
		return -1;
	}

	public void insertar(int tamaño, String palabra) {
		Nodo auxiliar = new Nodo(palabra);
		auxiliar.setCont(tamaño);

		arbol[N] = auxiliar;

		elevar(N);
		N++;
	}

	public void elevar(int indice) {
		while ((indice > 0) && menor((indice - 1) / 2, indice)) {
			intercambiar((indice - 1) / 2, indice);
			indice = (indice - 1) / 2;
		}
	}

	private void intercambiar(int indice, int posicion) {
		Nodo aux = arbol[indice];
		arbol[indice] = arbol[posicion];
		arbol[posicion] = aux;
	}

	private boolean menor(int indice, int posicion) {
		return arbol[indice].getCont() < arbol[posicion].getCont();
	}

	public Nodo extraer() {
		Nodo aux = new Nodo(arbol[0].getPalabra());
		if (N > 0) {
			aux = arbol[0];
			N--;
			arbol[0] = arbol[N];
			descender(0);
			return aux;
		}
		return null;

	}

	private void descender(int pos) {
		while (pos < (N / 2)) {
			int hizq = hizq(pos);
			int hder = hder(pos);
			int mayor;

			if (hder > 0)
				mayor = (arbol[hizq].getCont() > arbol[hder].getCont()) ? hizq : hder;
			else
				mayor = hizq;

			if (arbol[pos].getCont() < arbol[mayor].getCont()) {
				Nodo aux = arbol[pos];
				arbol[pos] = arbol[mayor];
				arbol[mayor] = aux;
			}

			pos = mayor;
		}
	}

	public void imprimirMonticulo() {
		for (int i = 0; i < N; i++) {
			System.out.println("Palabra: " + arbol[i].getPalabra() + " - "+ "Repetida: " + arbol[i].getCont());
		}
	}
}
