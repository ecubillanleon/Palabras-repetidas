package PalabrasRepetidas;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Archivo {

	public void leerArchivo(String nombreArchivo) throws FileNotFoundException {
		AVL arbol = new AVL();

		File f = new File(nombreArchivo);
		Scanner scanner = new Scanner(f);

		while (scanner.hasNext()) {
			String linea = scanner.nextLine();

			linea = linea.replaceAll("[\"|¡|!|¿|?|.|,|;|:|*|'|@|\\-|\\]|\\[|#|_|&|$|%|*|+|°|¬|—|^|~|{|}|=|/|(|)|«|»|<|>]","");
			linea = linea.replace("\\", "");
			linea = linea.replace("ï", "i");
			linea = linea.replace("\n", "");

			String[] cadena = linea.split(" ");

			for (int i = 0; i < cadena.length; i++) {
				arbol.insertar(cadena[i].toLowerCase());
			}
		}
		
		Monticulo monticulo = new Monticulo(arbol.getContador());
		//arbol.Enorden();
		scanner.close();

		arbol.insertarEnMonticulo(monticulo);
		Nodo aux;

		System.out.println("\n\n\t\t\t\t\t\t ------ Palabras Repetidas ------ ");
		for (int i = 0; i < 10; i++) {
			aux = monticulo.extraer();
			System.out.println("\t\t\t\t\t\t Palabra: "+aux.getPalabra()+" --- "+" Repetidas: "+aux.getCont());
		}
		System.out.println("\n\n");
	}
}
