package com.mercadolibre.FuegoQuasar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Satelite {

	double kenobiX = -500;
	double kenobiY = -200;
	double satoX = 500;
	double satoY = 100;
	double skywalkerX = 100;
	double skywalkerY = -100;
	double[] enemyPosition;


	

	 public Satelite() {
		this.enemyPosition = new double[2];
	}

	 
	 
	public double[] GetLocation(double[] distances) {
		
		//hacer verificación para que funcione con el tamaño de distancis de 3
		
		if(distances.length <=3) {
			
		
			//son tres listas las cuales contienen las coordenadas de cada satelite,
			//uso esas listas para luego usarlas en los vectores
			ArrayList<Double> kenobiPosition = new ArrayList<Double>(Arrays.asList(kenobiX,kenobiY));
			ArrayList<Double> skywalkerPosition = new ArrayList<Double>(Arrays.asList(skywalkerX,skywalkerY));
			ArrayList<Double> satoPosition = new ArrayList<Double>(Arrays.asList(satoX,satoY));
			
			// creo los tres vecotres los cuales son los satelites
			Vector<Double> kenobiVector = new Vector<Double>(kenobiPosition);
			Vector<Double> skywalkerVector = new Vector<Double>(skywalkerPosition); 
			Vector<Double> satoVector = new Vector<Double>(satoPosition); 
			
			//arreglo temporal que contiene la respuesta de una resta entre vectores
			Vector<Double> subs = substrac(skywalkerVector, kenobiVector);
			
			//double temporal que almacena la magnitud de un vector Subs
			double magnitude = Magnitude(subs.firstElement(), subs.lastElement());
			
			// vector que almacena la respuesta de la siguiente operación (P2 - P1) / (P2 - P1).magnitude
			Vector<Double> ex = divide((substrac(skywalkerVector, kenobiVector)),magnitude);
			
			// variable j que almacena el producto punto de p2-p1
			double i = DotProduct(ex, (substrac(skywalkerVector, kenobiVector)));
			
			// vectores temporales que almacena la resta entre dos vectores
			Vector<Double> subsTwo = substrac(satoVector, kenobiVector);
			Vector<Double> subsThree = substrac(subsTwo, multiply(ex, i));	
			
			//double temporal que almacena la magnitud del vector SubsThree
			double magnitudeTwo = Magnitude(subsThree.firstElement(), subsThree.lastElement());
			
			//Vector que almacena la siguiente operacion (P3 - P1 - i * ex) / (P3 - P1 - i * ex).maginutde
			Vector<Double> ey = divide(subsThree,magnitudeTwo);
			
			// variable j que almacena el producto punto de p3-p1
			double j = DotProduct(ey, (substrac(satoVector, kenobiVector)));
			
			//variable X e Y son las respuestas de las coordenadas de la nave enemiga
			double x = (Math.pow(distances[0], 2) - Math.pow(distances[1], 2) + Math.pow(magnitude, 2)) / (2 * magnitude);
			double y = ((Math.pow(distances[0], 2) - Math.pow(distances[2], 2) + Math.pow(i, 2) + Math.pow(j, 2)) / (2 * j)) - ((i / j) * x);
			
			// al arreglo enemyPosition le agrego la coordenada X e Y 
			enemyPosition[0]=x;
			enemyPosition[0]=y;
			
			// retorno las coordenadas
			return enemyPosition;
			
		} else {
			return null;
		}
	}
	
	public double Magnitude(double x, double y) {
		
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public Vector<Double> substrac(Vector<Double>x, Vector<Double>y){
		Vector<Double> answer = new Vector<Double>();
		double vectorX,vectorY;
		vectorX = x.firstElement()-y.firstElement();
		vectorY = x.lastElement()-y.lastElement();
		answer.add(vectorX);
		answer.add(vectorY);
		return answer;
	}
	
	public Vector<Double> divide(Vector<Double> vec ,double x){
		Vector<Double> answer = new Vector<Double>();
		answer.add((vec.firstElement()/x));
		answer.add((vec.lastElement()/x));
		return answer;
	}
	
	public Double DotProduct(Vector<Double> vecOne, Vector<Double> vecTwo  ){
		double answer = (vecOne.firstElement() * vecTwo.firstElement()) + (vecOne.lastElement() * vecTwo.lastElement());
		return answer;
	}
	
	public Vector<Double> multiply(Vector<Double> vec ,double x){
		Vector<Double> answer = new Vector<Double>();
		answer.add((vec.firstElement()*x));
		answer.add((vec.lastElement()*x));
		return answer;
	}
	

}
