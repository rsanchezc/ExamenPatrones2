package com.renta.peliculas;

import java.util.ArrayList;
import java.util.Iterator;

import com.renta.peliculas.Categoria;
import com.renta.peliculas.monto.*;

public class Cliente extends Catalogo{
	
	private ArrayList<Alquiler> alquileres;
	int puntosAlquilerFrecuente;    
	
	public Cliente(String pNombre) {
        super(pNombre);
        puntosAlquilerFrecuente = 0;
    }
	
	public Cliente(String pNombre, ArrayList<Alquiler> pAlquileres){
		super(pNombre);
		alquileres = pAlquileres;
		puntosAlquilerFrecuente = 0;
	}
	
    public String statement() {
        double montoTotal = 0;
        
        Iterator<Alquiler> iterator= alquileres.iterator();
        String result = "Alquileres de " + nombre + ":\n";
        
        while (iterator.hasNext()) {
            double montoAlquiler = 0;
            int diasAlquiler;

            Alquiler alquiler = iterator.next();            
            Categoria tipoPelicula = Categoria.values()[alquiler.getDisco().getPelicula().getCodigoPrecio()];
            diasAlquiler = alquiler.getDiasAlquilado();
            
            switch (tipoPelicula) {
                case NORMAL:
                	montoAlquiler +=  new MontoNormal().obtenerMonto(diasAlquiler);
                    break;
                case ESTRENO:
                	montoAlquiler +=  new MontoEstreno().obtenerMonto(diasAlquiler);
                    break;
                case INFANTIL:
                	montoAlquiler +=  new MontoInfantil().obtenerMonto(diasAlquiler);
                    break;
                default:
                	System.out.println("Categoria no existente");
                	break;
            }
            montoTotal += montoAlquiler;

            puntosAlquilerFrecuente ++;
                     
            if ((alquiler.getDisco().getPelicula().getCodigoPrecio() == 1) && alquiler.getDiasAlquilado() > 1) {
            	puntosAlquilerFrecuente++;
            }
            
            result += "\t" + alquiler.getDisco().getPelicula().getNombre()+ "\t" + String.valueOf(montoAlquiler) + "\n";

        }
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
