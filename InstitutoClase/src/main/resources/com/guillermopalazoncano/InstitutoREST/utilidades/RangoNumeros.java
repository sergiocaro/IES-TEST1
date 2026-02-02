/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guillermopalazoncano.InstitutoREST.utilidades;

/**
 *
 * @author guille
 */

public class RangoNumeros {
    private int minimo;
    private int maximo;
    
	public RangoNumeros(int minimo, int maximo) {
		super();
		this.minimo = minimo;
		this.maximo = maximo;
	}
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
    
}
