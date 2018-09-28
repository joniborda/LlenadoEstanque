package unlam;

import java.util.ArrayList;

public class Vertedero {

	int superficie;
	int profundidad;
	int nivelCaneria;
	int profundidadCaneria;
	int litrosLlenados;
	boolean ultimo = false;

	public Vertedero(int superficie, int profundidad, int profundidadCaneria) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.nivelCaneria = profundidad - profundidadCaneria;
		this.profundidadCaneria = profundidadCaneria;
	}

	public Vertedero(int superficie, int profundidad) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.nivelCaneria = profundidad;
		this.ultimo = true;
	}

	public int llenar(int litrosALlenar) {

		if (this.litrosLlenados < this.superficie * this.profundidad) {
			if (this.litrosLlenados + litrosALlenar > this.profundidad * this.superficie) {
				this.litrosLlenados = this.profundidad * this.superficie;
				return this.litrosLlenados - this.profundidad * this.superficie;
			} else {
				this.litrosLlenados += litrosALlenar;
				return litrosALlenar;
			}
		}
		return 0;
	}

	public int litrosLlenados() {
		return this.litrosLlenados;
	}

	public int nivel() {
		return this.litrosLlenados / this.superficie;
	}

	public boolean cargadoHastaCañeria() {
		return this.litrosLlenados >= this.superficie * this.nivelCaneria;
	}

	public String toString() {
		return "superficie " + this.superficie + " profundidad " + this.profundidad + " llenados "
				+ this.litrosLlenados;
	}

	public int puedeLlenar(ArrayList<Vertedero> vertederos, int position) {
		if (vertederos.get(position).litrosLlenados < this.superficie * this.nivelCaneria) {
			return this.superficie * this.nivelCaneria - this.litrosLlenados;
		}

		return 0;
	}

}