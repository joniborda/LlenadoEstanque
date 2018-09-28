package unlam;

import java.io.FileNotFoundException;

import org.junit.Test;

public class VertederoTest {

	@Test
	public void UnEstanque() throws FileNotFoundException {
		Vertederos vertederos = Archivo.leerArchivo("src/archivos/entrada/caso1.in");
		vertederos.llenar();
		
		
		Archivo.escribirArchivo("src/archivos/salida/procesada/caso1.out", vertederos);
	}
	
	@Test
	public void DosEstanque() throws FileNotFoundException {
		Vertederos vertederos = Archivo.leerArchivo("src/archivos/entrada/caso2.in");
		vertederos.llenar();
		
		
		Archivo.escribirArchivo("src/archivos/salida/procesada/caso2.out", vertederos);
	}
}
