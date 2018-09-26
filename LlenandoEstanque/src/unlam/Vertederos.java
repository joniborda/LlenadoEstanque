package unlam;

import java.util.ArrayList;

public class Vertederos {

	private ArrayList<Vertedero> vertederos;
	private int volumenALlenar;
	private int vertedoresUsados;
	
	public Vertederos() {
		
	}
	public Vertederos(ArrayList<Vertedero> vertederos) {
		this.vertederos = vertederos;
	}
	
	public void add(Vertedero vertedero) {
		if (this.vertederos == null) {
			this.vertederos = new ArrayList<Vertedero>();
		}
		this.vertederos.add(vertedero);
	}
	
	public Vertedero llenar(int volumenALlenar) {
		this.volumenALlenar = volumenALlenar;
		int llenado = 0;
		Vertedero vertedero;
		Vertedero vertederoAnterior;
		for (int i = 0; i < this.vertederos.size(); i++) {
			vertedero = this.vertederos.get(i);
			if (i != 0) {
				vertederoAnterior = this.vertederos.get(i-1);
				if (vertederoAnterior.cargadoHastaCañeria()) {
					llenado = vertedero.llenar(this.volumenALlenar);
				}
			} else {
				System.out.println(vertedero);
				llenado = vertedero.llenar(this.volumenALlenar);				
			}
			if (llenado != 0) {
				this.volumenALlenar -= llenado;
				this.vertedoresUsados++;
			}
			System.out.println(vertedero);
		}
		return null;
	}
	
	public ArrayList<Vertedero> getVertederos() {
		return this.vertederos;
	}
	
	public int getVertedoresUsados() {
		return this.vertedoresUsados;
	}
}
