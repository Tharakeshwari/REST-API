package com.example.demo.pcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pdetails.Details;
import com.example.demo.pservice.DetailsService;

@RestController
@RequestMapping("/details")
public class DetailsController {
	@Autowired
	DetailsService service;
	@PostMapping("")
	public String add(@RequestBody Details details) {
		return service.addDetails(details);
	}
	@PutMapping("/{id}")
	public Details updateById(@PathVariable int id,@RequestBody Details details) {
		return service.updateDetailsById(details);
	}
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteDetailsById(id);
	}
	@GetMapping("")
	public List<Details> get(){
		return service.getDetails();
	}
	@GetMapping("/{id}")
	public Optional<Details> getById(@PathVariable int id){
		return service.getDetailsById(id);
	}
	@GetMapping("/sort/{field}")
	public List<Details> getSorted(@PathVariable String field){
		return service.getSortedDetails(field);
	}
	@GetMapping("/{offset}/{pagesize}")
	public List<Details> getWithPagination(@PathVariable int offset,@PathVariable int pagesize){
		return service.getDetailsWithPagination(offset,pagesize);
	}
	@GetMapping("/{offset}/{pagesize}/{field}")
	public List<Details> getWithSortedPagination(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
		return service.getDetailsWithSortedPagination(offset,pagesize,field);
	}
}
