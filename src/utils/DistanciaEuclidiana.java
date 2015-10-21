package utils;

import java.util.HashMap;
import java.util.Map.Entry;

public class DistanciaEuclidiana {
	
	private HashMap<Double, Double> atributos;
	
	public DistanciaEuclidiana(HashMap<Double, Double> atributos){
		this.atributos = atributos;
	}
	
	
	public double getDistancia(){
		double resultado = 0;
		
		for(Entry<Double, Double> entry : atributos.entrySet()) {
		    resultado += Math.pow((entry.getKey() - entry.getValue()), 2);
		}
		
		return Math.sqrt(resultado);
	}

}
