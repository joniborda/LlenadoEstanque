package unlam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
		int mayorAlturaLlenadaEnIteracion = 0;
		Set<Integer> vertederosQuePuedenCargar = new TreeSet<Integer>();

		while (this.volumenALlenar > 0) {

			for (int i = 0; i < this.vertederos.size(); i++) {
				vertedero = this.vertederos.get(i);
				if (vertedero.litrosLlenados < vertedero.superficie * vertedero.nivelCañeria) {
					vertederosQuePuedenCargar.add(i);

					if (i == 0 || this.vertederos.get(i - 1).litrosLlenados >= this.vertederos.get(i - 1).superficie
							* this.vertederos.get(i - 1).nivelCañeria) {

						mayorAlturaLlenadaEnIteracion = vertedero.profundidadCaneria;
					}
					break;
				} else if (i + 1 < this.vertederos.size()) {
					if (this.vertederos.get(i + 1).litrosLlenados < this.vertederos.get(i + 1).superficie
							* this.vertederos.get(i).profundidadCaneria) {

						mayorAlturaLlenadaEnIteracion = this.vertederos.get(i).profundidadCaneria;
						vertederosQuePuedenCargar.add(i + 1);
						break;
					}
					vertederosQuePuedenCargar.add(i);
				}
			}
			for (Iterator iterator = vertederosQuePuedenCargar.iterator(); iterator.hasNext();) {
				Integer i = (Integer) iterator.next();
				// falta ver que al llenar no llene todo en el primero sino que se reparta a la altura que puede
				this.volumenALlenar -= this.vertederos.get(i).llenar(this.volumenALlenar);
			}
		}
		/*
		 * for (int i = 0; i < this.vertederos.size(); i++) { vertedero =
		 * this.vertederos.get(i); if (i != 0) { vertederoAnterior =
		 * this.vertederos.get(i - 1); if (vertederoAnterior.cargadoHastaCañeria()) {
		 * llenado = vertedero.llenar(this.volumenALlenar); } } else {
		 * System.out.println(vertedero); llenado =
		 * vertedero.llenar(this.volumenALlenar); } if (llenado != 0) {
		 * this.volumenALlenar -= llenado; this.vertedoresUsados++; }
		 * System.out.println(vertedero); }
		 */
		return null;
	}

	public ArrayList<Vertedero> getVertederos() {
		return this.vertederos;
	}

	public int getVertedoresUsados() {
		return this.vertedoresUsados;
	}
}
