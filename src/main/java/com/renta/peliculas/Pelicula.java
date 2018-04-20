package com.renta.peliculas;

public class Pelicula extends Catalogo{
	    
		private int codigoPrecio;		

		public Pelicula(String pNombre, int pCodigoPrecio) {
			super(pNombre);
			codigoPrecio = pCodigoPrecio;
		}

		public int getCodigoPrecio() {
			return codigoPrecio;
		}

		public void persist() {
			Registrar.add ("Movies", this);
		}

		public static Pelicula get(String name) {
			return (Pelicula) Registrar.get("Peliculas", name);
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
}
