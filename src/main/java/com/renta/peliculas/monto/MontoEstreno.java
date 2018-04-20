package com.renta.peliculas.monto;

public class MontoEstreno implements IMonto{

	@Override
	public double obtenerMonto(int pDiasAlquiler) {
		double montoAlquiler = pDiasAlquiler * 3;
		
        return montoAlquiler;       	
	}
}
