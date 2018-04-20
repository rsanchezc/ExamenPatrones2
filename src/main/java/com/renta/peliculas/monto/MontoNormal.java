package com.renta.peliculas.monto;

public class MontoNormal implements IMonto{
	
	@Override
	public double obtenerMonto(int pDiasAlquiler) {
		double montoAlquiler = 2;
        if (pDiasAlquiler > 2) {
             montoAlquiler += (pDiasAlquiler - 2) * 1.5;
        }
        return montoAlquiler;       	
	}
}
