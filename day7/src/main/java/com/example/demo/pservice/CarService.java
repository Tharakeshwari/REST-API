package com.example.demo.pservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pcar.Car;
import com.example.demo.prepository.CarRepository;
@Service
public class CarService {
	@Autowired
	CarRepository repository;
	public boolean addAll(Car car) {
		repository.save(car);
		return true;
	}
	public List<Car> getCarOwners(int owners) {
		return repository.findByOwners(owners);
	}
	public List<Car> getCarAddress(String address) {
		return repository.findByAddress(address);
	}
	public List<Car> getCarCarName(String carname) {
		return repository.findByCarName(carname);
	}
	public List<Car> getCarOwnersAndCarType(int owners,String cartype) {
		return repository.findByOwnersAndCarType(owners,cartype);
	}

}
