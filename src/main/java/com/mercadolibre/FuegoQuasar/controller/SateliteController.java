package com.mercadolibre.FuegoQuasar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.FuegoQuasar.model.Satelite;
import com.mercadolibre.FuegoQuasar.model.Satelites;


@RestController
public class SateliteController {
	

	@PostMapping("/topsecret/")
	public ResponseEntity<double[]>  GetLocation(@RequestBody List<Satelites> satelites){
		
		
		double[] answer;
		
		List<Double> list = new ArrayList<>();
		
		for(Satelites sal : satelites) {
			list.add(sal.getDitance());
		}
		
		Satelite satelite = new Satelite();
		
		
		double [] distances = new double[list.size()];
		
		for (int i = 0; i < distances.length; i++) {
			distances[i] = list.get(i);
		}
		
		answer = satelite.GetLocation(distances);
		
		

		if (answer != null) {
			
			return ResponseEntity.status(HttpStatus.OK).body(answer);
		} else {
			//ERROR HTTP 404
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}
		
	}
	
}
