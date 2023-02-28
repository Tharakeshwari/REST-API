package com.example.demo.pcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pcar.Car;
import com.example.demo.pservice.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarService service;
	@PostMapping("")
	public boolean add(@RequestBody Car car) {
		return service.addAll(car);
	}
	@GetMapping("/owners/{owners}")
	public List<Car> getOwners(@PathVariable int owners) {
		return service.getCarOwners(owners);
	}
	@GetMapping("/address/{address}")
	public List<Car> getAddress(@PathVariable String address) {
		return service.getCarAddress(address);
	}
	@GetMapping("/carname/{carname}")
	public List<Car> getCarName(@PathVariable String carname) {
		return service.getCarCarName(carname);
	}
	@GetMapping("owners/{owners}/cartype/{cartype}")
	public List<Car> getOwnersAndCarType(@PathVariable int owners,@PathVariable String cartype) {
		return service.getCarOwnersAndCarType(owners,cartype);
	}
}
