package com.renta.peliculas;

import java.util.ArrayList;
import java.util.Iterator;
import com.renta.peliculas.Categoria;

public class Cliente {
	private String nombre;
	private ArrayList<Alquiler> alquileres;
	
	public Cliente(String pNombre) {
        nombre = pNombre;
    }
	
	public Cliente(String pNombre, ArrayList<Alquiler> pAlquileres){
		nombre = pNombre;
		alquileres = pAlquileres;
	}
	
    public String statement() {
        double montoTotal = 0;
        int puntosAlquilerFrecuente = 0;
        Iterator<Alquiler> iterator= alquileres.iterator();
        String result = "Alquileres de " + nombre + ":\n";
        while (iterator.hasNext()) {
            double montoAlquiler = 0;
            Alquiler alquiler = iterator.next();

            //determine amounts for each line
            Categoria tipoPelicula = Categoria.values()[alquiler.getDisco().getPelicula().getCodigoPrecio()];           
            switch (tipoPelicula) {
                case NORMAL:                	
                    montoAlquiler += 2;
                    if (alquiler.getDiasAlquilado() > 2)
                        montoAlquiler += (alquiler.getDiasAlquilado() - 2) * 1.5;
                    break;
                case ESTRENO:
                    montoAlquiler += alquiler.getDiasAlquilado() * 3;
                    break;
                case INFANTIL:
                    montoAlquiler += 1.5;
                    if (alquiler.getDiasAlquilado() > 3)
                        montoAlquiler += (alquiler.getDiasAlquilado() - 3) * 1.5;
                    break;
                 default:
                	 System.out.println("Categoria no existente");
                	 break;
            }
            montoTotal += montoAlquiler;

            puntosAlquilerFrecuente ++;
            
            // agregar bono por alquiler de pelicula "estreno"
            if ((alquiler.getDisco().getPelicula().getCodigoPrecio() == 1) && alquiler.getDiasAlquilado() > 1) puntosAlquilerFrecuente ++;

            //mostrar datos
            result += "\t" + alquiler.getDisco().getPelicula().getNombre()+ "\t" + String.valueOf(montoAlquiler) + "\n";

        }
        //fin del reporte
        result +=  "Monto total:  " + String.valueOf(montoTotal) + "\n";
        result += "Gano " + String.valueOf(puntosAlquilerFrecuente) + " puntos por alquiler frecuente";
        return result;

    }
    
    public void addRental(Alquiler arg) {
    	alquileres.add(arg);
    }
    public static Cliente get(String name) {
    	return (Cliente) Registrar.get("Clientes", name);
    }
    
	public String getNombre() {
		return nombre;
	}
	
    public void persist() {
    	Registrar.add("Clientes", this);
    }
    
}
