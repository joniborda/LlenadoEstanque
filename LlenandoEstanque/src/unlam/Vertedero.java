package unlam;

public class Vertedero {

	int superficie;
	int profundidad;
	int profundidadCañeria;
	int litrosLlenados;
	boolean ultimo = false;

	public Vertedero(int superficie, int profundidad, int profundidadCañeria) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCañeria = profundidad - profundidadCañeria;
	}
	
	public Vertedero(int superficie, int profundidad) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCañeria = profundidad;
		this.ultimo = true;
	}

	public int llenar(int litrosALlenar) {

		if (this.litrosLlenados < this.superficie * this.profundidad) {
			if (this.profundidadCañeria * this.superficie < this.litrosLlenados + litrosALlenar) {
				this.litrosLlenados = this.profundidadCañeria * this.superficie;
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
	
	public boolean cargadoHastaCañeria() {
		return this.litrosLlenados >= this.superficie * this.profundidadCañeria;
	}
	
	public String toString() {
		return "superficie " + this.superficie + " profundidad " + this.profundidad + " llenados " + this.litrosLlenados;
	}

}
