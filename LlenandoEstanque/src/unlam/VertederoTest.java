package unlam;

import org.junit.Assert;
import org.junit.Test;

public class VertederoTest {

	@Test
	public void UnEstanque() {
		
		// superficie, profundidad, profundidad compuerta
		Vertedero vertedero = new Vertedero(4, 6, 2);
		
		vertedero.llenar(4);
		
		Assert.assertEquals(4, vertedero.litrosLlenados());
		
		Assert.assertEquals(1, vertedero.nivel());
		
		vertedero.llenar(16);
		// mas de 16 no puede llenar
		Assert.assertEquals(16, vertedero.litrosLlenados());
		
		Assert.assertEquals(4, vertedero.nivel());
		
	}
	
	@Test
	public void DosEstanqueHastaPrimerCañeria() {
		System.out.println("DosEstanqueHastaPrimerCañeria");
		// superficie, profundidad, profundidad compuerta
		Vertedero vertedero = new Vertedero(4, 6, 2);
		Vertedero vertedero2 = new Vertedero(5, 7);
		Vertederos vertederos = new Vertederos();
		vertederos.add(vertedero);
		vertederos.add(vertedero2);
		
		vertederos.llenar(41);
		
		Assert.assertEquals(16, vertedero.litrosLlenados());
		
		Assert.assertEquals(4, vertedero.nivel());
		
		Assert.assertEquals(25, vertedero2.litrosLlenados());
		
		Assert.assertEquals(5, vertedero2.nivel());
	}
	
	@Test
	public void DosVertedoresUsados() {
		System.out.println("DosVertedoresUsados");
		Vertederos vertederos = new Vertederos();
		vertederos.add(new Vertedero(4, 6, 2));
		vertederos.add(new Vertedero(5, 7));
		
		vertederos.llenar(41);
		
		Assert.assertEquals(2, vertederos.getVertedoresUsados());
	}
	
	@Test
	public void NoTieneQueLlenarElTercero() {
		System.out.println("NoTieneQueLlenarElTercero");
		Vertederos vertederos = new Vertederos();
		vertederos.add(new Vertedero(4, 6, 3));
		vertederos.add(new Vertedero(5, 7, 2));
		vertederos.add(new Vertedero(5, 7));
		
		vertederos.llenar(41);
		
		Assert.assertEquals(2, vertederos.getVertedoresUsados());
	}
}
