package com.example.demo.prepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pdetails.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details,Integer>{

}
