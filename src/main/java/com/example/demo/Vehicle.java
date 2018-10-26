package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Vehicle {
	
	private String id;
	
	private String vin;
	
	@NonNull
	private String make;
	
	@NonNull
	private String model;
	
	@NonNull
	private String year;
	
	private int estimate;
	
	private int repairCost;
	

}
