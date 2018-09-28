package unlam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Vertederos {

	private ArrayList<Vertedero> vertederos;
	public float volumenALlenar;
	private float vertedoresUsados;
	private float rebalsan = 0;

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

	public void llenar() {
		this.llenar(this.volumenALlenar);
	}

	public void llenar(float volumenALlenar) {
		this.volumenALlenar = volumenALlenar;
		float llenado = 0;
		Vertedero vertedero;
		Vertedero vertederoAnterior;
		float mayorAlturaLlenadaEnIteracion = 0;
		Set<Integer> vertederosQuePuedenCargar = new TreeSet<Integer>();

		while (this.volumenALlenar > 0) {
			vertederosQuePuedenCargar.clear();
			llenado = 0;
			for (int i = 0; i < this.vertederos.size(); i++) {
				vertedero = this.vertederos.get(i);
				if (vertedero.litrosLlenados < vertedero.superficie * vertedero.nivelCaneria) {
					vertederosQuePuedenCargar.add(i);

					if (i == 0 || this.vertederos.get(i - 1).litrosLlenados >= this.vertederos.get(i - 1).superficie
							* this.vertederos.get(i - 1).nivelCaneria) {

						mayorAlturaLlenadaEnIteracion = vertedero.nivelCaneria;
						llenado = vertedero.nivelCaneria * vertedero.superficie - vertedero.litrosLlenados;
					}
					break;
				} else if (i + 1 < this.vertederos.size()) {
					if (this.vertederos.get(i + 1).litrosLlenados < this.vertederos.get(i + 1).superficie
							* this.vertederos.get(i).nivelCaneria) {

						mayorAlturaLlenadaEnIteracion = this.vertederos.get(i).nivelCaneria;
						llenado += (this.vertederos.get(i).nivelCaneria * this.vertederos.get(i).superficie
								- this.vertederos.get(i).litrosLlenados);
						
						vertederosQuePuedenCargar.add(i + 1);
						break;
					}
					vertederosQuePuedenCargar.add(i);
				}
			}
			if (vertederosQuePuedenCargar.size() == 0) {
				if (this.volumenALlenar > 0) {
					this.rebalsan = (int)this.volumenALlenar;
				}

				return;
			}
			
			for (Iterator iterator = vertederosQuePuedenCargar.iterator(); iterator.hasNext();) {
				Integer i = (Integer) iterator.next();
				if (this.vertedoresUsados < i) {
					this.vertedoresUsados = i;
				}
				System.out.print("carga " + i);
				// falta ver que al llenar no llene todo en el primero sino que se reparta a la
				// altura que puede
				if (vertederosQuePuedenCargar.size() > 1) {
					// tengo que dividir los litros de acuerdo a la cantidad de estanques a llenar
					float litros = (this.vertederos.get(i).superficie * mayorAlturaLlenadaEnIteracion) / vertederosQuePuedenCargar.size();
					this.volumenALlenar -= this.vertederos.get(i).llenar(litros / this.vertederos.get(i).superficie);
				} else {					
					this.volumenALlenar -= this.vertederos.get(i).llenar(mayorAlturaLlenadaEnIteracion);
				}
			}
		}
		return;
	}

	public ArrayList<Vertedero> getVertederos() {
		return this.vertederos;
	}

	public float getVertedoresUsados() {
		return this.vertedoresUsados;
	}

	public String toString() {
		if (this.rebalsan > 0) {
			return "Rebalsan: " + this.rebalsan;
		}
		String ret = this.vertedoresUsados + "\n";
		for (int i = 0; i < this.vertedoresUsados; i++) {
			ret += (i + 1) + " " + this.vertederos.get(i).nivel() + "\n";
		}
		return ret;
	}
}
