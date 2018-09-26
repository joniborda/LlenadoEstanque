package unlam;

public class Vertedero {

	int superficie;
	int profundidad;
	int profundidadCa�eria;
	int litrosLlenados;
	boolean ultimo = false;

	public Vertedero(int superficie, int profundidad, int profundidadCa�eria) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCa�eria = profundidad - profundidadCa�eria;
	}
	
	public Vertedero(int superficie, int profundidad) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.profundidadCa�eria = profundidad;
		this.ultimo = true;
	}

	public int llenar(int litrosALlenar) {

		if (this.litrosLlenados < this.superficie * this.profundidad) {
			if (this.profundidadCa�eria * this.superficie < this.litrosLlenados + litrosALlenar) {
				this.litrosLlenados = this.profundidadCa�eria * this.superficie;
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
		return this.litrosLlenados >= this.superficie * this.profundidadCa�eria;
	}
	
	public String toString() {
		return "superficie " + this.superficie + " profundidad " + this.profundidad + " llenados " + this.litrosLlenados;
	}

}
