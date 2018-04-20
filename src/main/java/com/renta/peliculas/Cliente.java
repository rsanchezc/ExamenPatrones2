package com.renta.peliculas;

import java.util.ArrayList;
import java.util.Iterator;

import com.renta.peliculas.Categoria;
import com.renta.peliculas.monto.*;

public class Cliente extends Catalogo{
	
	private ArrayList<Alquiler> alquileres;
	
	public Cliente(String pNombre) {
        super(pNombre);
    }
	
	public Cliente(String pNombre, ArrayList<Alquiler> pAlquileres){
		super(pNombre);
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
            int diasAlquiler = alquiler.getDiasAlquilado();
            switch (tipoPelicula) {
                case NORMAL:
                	montoAlquiler +=  new MontoNormal().obtenerMonto(diasAlquiler);
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
	
    public void persist() {
    	Registrar.add("Clientes", this);
    }

    
}
