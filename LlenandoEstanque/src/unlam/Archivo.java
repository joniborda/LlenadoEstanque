package unlam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
	public static Vertederos leerArchivo(String ruta) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(ruta));
		Vertederos vertederos = new Vertederos();
		int cantidadDeVertederos = sc.nextInt();
		
		for(int i = 1; i < cantidadDeVertederos; i ++) {
			vertederos.add(new Vertedero(sc.nextInt(), sc.nextInt(), sc.nextInt()));			
		}
		
		vertederos.add(new Vertedero(sc.nextInt(), sc.nextInt()));

		//seteo al primer Vertedero el volumen total
		vertederos.volumenALlenar = sc.nextInt();
		
		sc.close();
		return vertederos;
	}
	
	public static void escribirArchivo(String ruta, Vertederos vertederos) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(ruta));
		pw.println(vertederos);
		pw.close();
	}
}