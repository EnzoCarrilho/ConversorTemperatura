package br.dev.enzo.temperatura.model;

public class Temperatura {
	
private double celsius;
	
	public double getCelsius() {
		return celsius;
	}
	
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	
	public double converterParaKelvin() {
		
		double valorKelvin = getCelsius() + 273.15;
		return valorKelvin;
		
	}
	
	public double converterParaFahreinheit() {
		
		double valorFahreinheit = (getCelsius() * 1.8) + 32;
		return valorFahreinheit;
	}
	
}
