package unlam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {
	public static List<Vertedero> leerArchivo(String ruta) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(ruta));
		List<Vertedero> Vertederos = new ArrayList<Vertedero>();
		int cantidadDeVertederos = sc.nextInt();
		
		for(int i = 1; i <= cantidadDeVertederos; i ++) {
			Vertederos.add(new Vertedero(sc.nextInt(), sc.nextInt(), sc.nextInt()));			
		}
		
		Vertederos.add(new Vertedero(sc.nextInt(), sc.nextInt()));

		//seteo al primer Vertedero el volumen total
		int aguaALlenar = sc.nextInt();
		
		sc.close();
		return Vertederos;
	}
	
	public static void escribirArchivo(String ruta, ArrayList<Vertedero> Vertederos) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(ruta));
		
		pw.close();
	}
}