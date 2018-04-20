package com.renta.peliculas.monto;

public class MontoInfantil implements IMonto{
	
	@Override
	public double obtenerMonto(int pDiasAlquiler) {
		double montoAlquiler = 1.5;
		if (pDiasAlquiler > 3) {
	        montoAlquiler += (pDiasAlquiler - 3) * 1.5;
	    	}
        return montoAlquiler;       	
	}
	
    
}
