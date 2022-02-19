package com.mercadolibre.FuegoQuasar.model;

public class Satelites {
	
	String name;
	double ditance;
	String[] message;
	
	
	public Satelites() {
		super();
	}
	public Satelites(String name, double ditance, String[] message) {
		
		this.name = name;
		this.ditance = ditance;
		this.message = message;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDitance() {
		return ditance;
	}
	public void setDitance(double ditance) {
		this.ditance = ditance;
	}
	public String[] getMessage() {
		return message;
	}
	public void setMessage(String[] message) {
		this.message = message;
	}
	
	

}
