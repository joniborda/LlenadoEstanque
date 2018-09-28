package unlam;

public class Vertedero {

	private float superficie;
	private float profundidad;
	private float nivelCaneria;
	private float profundidadCaneria = 0;
	private float litrosLlenados;

	public Vertedero(float superficie, float profundidad, float profundidadCaneria) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.nivelCaneria = profundidad - profundidadCaneria;
		this.profundidadCaneria = profundidadCaneria;
	}

	public Vertedero(float superficie, float profundidad) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.nivelCaneria = profundidad;
	}

	public float getSuperficie() {
		return this.superficie;
	}

	/**
	 * Nivel donde se encuentra la caneria medido desde el abajo
	 * 
	 * @return Nivel
	 */
	public float getNivelCaneria() {
		return this.nivelCaneria;
	}

	/**
	 * Nivel donde se encuentra la caneria medido desde el arriba
	 * 
	 * @return Nivel
	 */
	public float getProfundidadCaneria() {
		return this.profundidadCaneria;
	}

	public float getLitrosLlenados() {
		return this.litrosLlenados;
	}

	/**
	 * Nivel de agua medido desde el fondo
	 * 
	 * @return Nivel
	 */
	public float nivelAgua() {
		return this.litrosLlenados / this.superficie;
	}

	/**
	 * Nivel de agua medido desde arriba
	 * 
	 * @return Nivel
	 */
	public float nivelAguaArriba() {
		return this.profundidad - (this.litrosLlenados / this.superficie);
	}

	public float llenar(float altura, float maximoALlenar) {
		float ret = (this.profundidad - altura) * this.superficie - this.litrosLlenados;
		if (ret > maximoALlenar) {
			ret = maximoALlenar;
		}
		this.litrosLlenados = this.litrosLlenados + ret;
		System.out.print(" altura " + altura + " litrostotales " + this.litrosLlenados + " ret " + ret + "\n");
		return ret;
	}
	
	public float rebalsar(float altura) {
		return altura * this.superficie;
	}

	public String toString() {
		return "superficie " + (int) this.superficie + " profundidad " + (int) this.profundidad + " llenados "
				+ (int) this.litrosLlenados;
	}
}