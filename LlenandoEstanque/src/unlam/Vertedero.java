package unlam;

public class Vertedero {

	int superficie;
	int profundidad;
	int profundidadCaneria;
	int litrosLlenados;
	boolean ultimo = false;

	public Vertedero(int superficie, int profundidad, int profundidadCaneria) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCaneria = profundidad - profundidadCaneria;
	}
	
	public Vertedero(int superficie, int profundidad) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCaneria = profundidad;
		this.ultimo = true;
	}

	public int llenar(int litrosALlenar) {

		if (this.litrosLlenados < this.superficie * this.profundidad) {
			if (this.profundidadCaneria * this.superficie < this.litrosLlenados + litrosALlenar) {
				this.litrosLlenados = this.profundidadCaneria * this.superficie;
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
	
	public boolean cargadoHastaCaneria() {
		return this.litrosLlenados >= this.superficie * this.profundidadCaneria;
	}
	
	public String toString() {
		return "superficie " + this.superficie + " profundidad " + this.profundidad + " llenados " + this.litrosLlenados;
	}

}
