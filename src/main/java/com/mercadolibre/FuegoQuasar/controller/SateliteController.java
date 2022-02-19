package com.mercadolibre.FuegoQuasar.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mercadolibre.FuegoQuasar.model.Satelite;
import com.mercadolibre.FuegoQuasar.model.Satelites;


@RestController
@RequestMapping("/topsecret/")
public class SateliteController {
	

	@PostMapping("")
	public ResponseEntity<double[]>  GetLocation(@RequestBody List<Satelites> satelites){
	
//	public Satelites  GetLocation(@RequestBody Satelites satelites){
		
		double[] answer;
		
		List<Double> list = new ArrayList<>();
		
		System.out.println(list.toString());
		
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
	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}
		
	}
	
}
