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
import com.example.demo.prepository.CarRepository;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarRepository repository;
	@PostMapping("")
	public boolean add(@RequestBody Car car) {
		repository.save(car);
		return true;
	}
	@GetMapping("/owners/{owners}")
	public List<Car> getOwners(@PathVariable int owners) {
		return repository.findByOwners(owners);
	}
	@GetMapping("/address/{address}")
	public List<Car> getAddress(@PathVariable String address) {
		return repository.findByAddress(address);
	}
	@GetMapping("/carname/{carname}")
	public List<Car> getCarName(@PathVariable String carname) {
		return repository.findByCarName(carname);
	}
	@GetMapping("owners/{owners}/cartype/{cartype}")
	public List<Car> getCarName(@PathVariable int owners,@PathVariable String cartype) {
		return repository.findByOwnersAndCarType(owners,cartype);
	}
}
