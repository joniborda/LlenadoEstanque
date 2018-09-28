package unlam;

import java.util.ArrayList;

public class Vertedero {

	float superficie;
	float profundidad;
	float nivelCaneria;
	float profundidadCaneria;
	float litrosLlenados;
	boolean ultimo = false;

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
		this.ultimo = true;
	}

	public float llenar(float altura) {
		float ret = altura * this.superficie - this.litrosLlenados;
		this.litrosLlenados = altura * this.superficie;
		System.out.print(" altura " + altura);
		System.out.print(" litros " + this.litrosLlenados + "ret " + ret + "\n");
		return ret;
	}

	public float litrosLlenados() {
		return this.litrosLlenados;
	}

	public float nivel() {
		return this.litrosLlenados / this.superficie;
	}

	public boolean cargadoHastaCañeria() {
		return this.litrosLlenados >= this.superficie * this.nivelCaneria;
	}

	public String toString() {
		return "superficie " + this.superficie + " profundidad " + this.profundidad + " llenados "
				+ this.litrosLlenados;
	}

	public float puedeLlenar(ArrayList<Vertedero> vertederos, int position) {
		if (vertederos.get(position).litrosLlenados < this.superficie * this.nivelCaneria) {
			return this.superficie * this.nivelCaneria - this.litrosLlenados;
		}

		return 0;
	}

}