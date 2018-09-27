package unlam;

import java.util.ArrayList;

public class Vertedero {

	int superficie;
	int profundidad;
	int nivelCa�eria;
	int profundidadCa�eria;
	int litrosLlenados;
	boolean ultimo = false;

	public Vertedero(int superficie, int profundidad, int profundidadCa�eria) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.nivelCa�eria = profundidad - profundidadCa�eria;
		this.profundidadCa�eria = profundidadCa�eria;
	}
	
	public Vertedero(int superficie, int profundidad) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.nivelCa�eria = profundidad;
		this.ultimo = true;
	}

	public int llenar(int litrosALlenar) {

		if (this.litrosLlenados < this.superficie * this.profundidad) {
			if (this.nivelCa�eria * this.superficie < this.litrosLlenados + litrosALlenar) {
				this.litrosLlenados = this.nivelCa�eria * this.superficie;
			} else {
				this.litrosLlenados += litrosALlenar;
			}
			return this.litrosLlenados;
		}
		return 0;
	}

	public int litrosLlenados() {
		return this.litrosLlenados;
	}

	public int nivel() {
		return this.litrosLlenados / this.superficie;
	}
	
	public boolean cargadoHastaCa�eria() {
		return this.litrosLlenados >= this.superficie * this.nivelCa�eria;
	}
	
	public String toString() {
		return "superficie " + this.superficie + " profundidad " + this.profundidad + " llenados " + this.litrosLlenados;
	}
	
	public int puedeLlenar(ArrayList<Vertedero> vertederos, int position) {
		if (vertederos.get(position).litrosLlenados < this.superficie * this.nivelCa�eria) {
			return this.superficie * this.nivelCa�eria - this.litrosLlenados;
		}
		
		
		
		return 0;
	}

}
