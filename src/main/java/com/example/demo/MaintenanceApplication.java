package com.example.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ServiceScan
@EnableMongoRepositories
@RestController
@EnableBinding(VehicleSink.class)
public class MaintenanceApplication {
	
	@Autowired
	MaintenanceRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceApplication.class, args);
	}
	
	@GetMapping("/")
	public List<Vehicle> getVehicles(){
		return repo.findAll();
	}
	
	@StreamListener(target=VehicleSink.INPUT)
	public void listenforEvenets(Vehicle vehicle) {
		UUID uuid = UUID.randomUUID();
		vehicle.setId(uuid.toString());
		vehicle.setEstimate(2000);
		repo.save(vehicle);
	}
}
