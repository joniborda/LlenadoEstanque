package unlam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Vertederos {

	private ArrayList<Vertedero> vertederos;
	private float volumenALlenar;
	private float vertedoresUsados = 0;
	private float rebalsan = 0;

	public void add(Vertedero vertedero) {
		if (this.vertederos == null) {
			this.vertederos = new ArrayList<Vertedero>();
		}
		this.vertederos.add(vertedero);
	}

	public void setVolumenALlenar(int volumen) {
		this.volumenALlenar = volumen;
	}

	public void llenar() {

		float totalQuePuedeLlenarHastaElNivel = 0;
		float sumaQueLlenaPorNivel = 0;
		Vertedero vertedero;
		float mayorAlturaLlenadaEnIteracion = 0;
		Set<Integer> vertederosQuePuedenCargar = new TreeSet<Integer>();
		int i;

		while (this.volumenALlenar > 0) {
			vertederosQuePuedenCargar.clear();
			sumaQueLlenaPorNivel = 0;
			totalQuePuedeLlenarHastaElNivel = 0;
			mayorAlturaLlenadaEnIteracion = 0;
			for (i = 0; i < this.vertederos.size(); i++) {
				vertedero = this.vertederos.get(i);
				if (vertedero.getLitrosLlenados() < vertedero.getSuperficie() * vertedero.getNivelCaneria()) {

					if (i == 0 || this.vertederos.get(i - 1)
							.getLitrosLlenados() >= this.vertederos.get(i - 1).getSuperficie()
									* this.vertederos.get(i - 1).getNivelCaneria()) {

						mayorAlturaLlenadaEnIteracion = vertedero.getProfundidadCaneria();
						sumaQueLlenaPorNivel += vertedero.getSuperficie();
						totalQuePuedeLlenarHastaElNivel = vertedero.getNivelCaneria() * vertedero.getSuperficie()
								- vertedero.getLitrosLlenados();
					}

					vertederosQuePuedenCargar.add(i);
					break;
				} else if (i + 1 < this.vertederos.size()) {
					// el siguiente no llego al nivel del anterior
					if (this.vertederos.get(i + 1).getLitrosLlenados() < this.vertederos.get(i + 1).getSuperficie()
							* this.vertederos.get(i).getNivelCaneria()) {

						mayorAlturaLlenadaEnIteracion = vertedero.getProfundidadCaneria();
						sumaQueLlenaPorNivel += this.vertederos.get(i + 1).getSuperficie();
						totalQuePuedeLlenarHastaElNivel += vertedero.getNivelCaneria() * vertedero.getSuperficie()
								- vertedero.getLitrosLlenados();

						vertederosQuePuedenCargar.add(i + 1);
						i= i +1;
						break;
					}

					mayorAlturaLlenadaEnIteracion = vertedero.getProfundidadCaneria();
					sumaQueLlenaPorNivel += vertedero.getSuperficie();
					totalQuePuedeLlenarHastaElNivel = vertedero.getNivelCaneria() * vertedero.getSuperficie()
							- vertedero.getLitrosLlenados();
					vertederosQuePuedenCargar.add(i);

				} else {
					i++;
				}
			}
			if (vertederosQuePuedenCargar.size() == 0) {
				if (this.volumenALlenar > 0) {
					this.rebalsan = (int) this.volumenALlenar;
				}

				return;
			}

			for (Iterator<Integer> iterator = vertederosQuePuedenCargar.iterator(); iterator.hasNext();) {
				Integer index = (Integer) iterator.next();
				if (this.vertedoresUsados < index) {
					this.vertedoresUsados = index;
				}
				System.out.print("carga " + index);

				if (vertederosQuePuedenCargar.size() > 1) {
					if (this.volumenALlenar < totalQuePuedeLlenarHastaElNivel) {
						totalQuePuedeLlenarHastaElNivel = this.volumenALlenar;
					}

					// si se pasa del nivel de caneria del ultimo que puede llenar
					// x*120 + x*80 = 260; => x= 260/160
					mayorAlturaLlenadaEnIteracion = totalQuePuedeLlenarHastaElNivel / sumaQueLlenaPorNivel;
					/*if (mayorAlturaLlenadaEnIteracion < this.vertederos.get(i).getProfundidadCaneria()) {
						mayorAlturaLlenadaEnIteracion = this.vertederos.get(i).getProfundidadCaneria();
					}*/
				}
				float nivel = 0;
				if (mayorAlturaLlenadaEnIteracion < 0) {
					System.out.println(" va a cargar de mas");
					nivel = mayorAlturaLlenadaEnIteracion;

//					mayorAlturaLlenadaEnIteracion = 0;
				}
				this.volumenALlenar -= this.vertederos.get(index).llenar(mayorAlturaLlenadaEnIteracion,
						this.volumenALlenar);
				if (nivel < 0) {
					this.rebalsan = this.vertederos.get(index).rebalsar(nivel);
				}
			}
			System.out.println(this.rebalsan);
		}
		return;
	}

	public ArrayList<Vertedero> getVertederos() {
		return this.vertederos;
	}

	public float getVertedoresUsados() {
		return this.vertedoresUsados + 1;
	}

	public String toString() {
		if (this.rebalsan > 0) {
			return "Rebalsan: " + this.rebalsan;
		}
		String ret = (int) this.getVertedoresUsados() + "\n";
		for (int i = 0; i < this.getVertedoresUsados(); i++) {
			ret += (i + 1) + " " + (int) this.vertederos.get(i).nivelAgua() + "\n";
		}
		return ret;
	}
}
