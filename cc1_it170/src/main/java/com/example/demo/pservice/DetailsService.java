package com.example.demo.pservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.pdetails.Details;
import com.example.demo.prepository.DetailsRepository;

@Service
public class DetailsService {
	@Autowired
	DetailsRepository repository;
	public String addDetails(Details details) {
		repository.save(details);
		return "Admitted";
	}
	public String deleteDetailsById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
	public Details updateDetailsById(Details details) {
		return repository.save(details);
	}
	public List<Details> getDetails(){
		return repository.findAll();
	}
	public Optional<Details> getDetailsById(int id){
		return repository.findById(id);
	}
	public List<Details> getSortedDetails(String field){
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public List<Details> getDetailsWithPagination(int offset,int pagesize){
		Page<Details> details=repository.findAll(PageRequest.of(offset, pagesize));
		return details.getContent();
	}
	public List<Details> getDetailsWithSortedPagination(int offset,int pagesize,String field){
		Page<Details> details=repository.findAll(PageRequest.of(offset, pagesize,Sort.by(field)));
		return details.getContent();
	}
}
