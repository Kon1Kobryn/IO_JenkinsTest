package com.example.rest_api_1.api;

import com.example.rest_api_1.dao.entity.CeramicDish;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/ceramics")
public class CeramicDishApi {
	ArrayList<CeramicDish> dishes;

	public CeramicDishApi(){
		this.dishes = new ArrayList<CeramicDish>();
		dishes.add(new CeramicDish(1L, "Talerz", LocalDate.of(2021, 5, 10)));
		dishes.add(new CeramicDish(2L, "Brytwanka", LocalDate.of(2022, 9, 15)));
		dishes.add(new CeramicDish(3L, "Dzbanek", LocalDate.of(2020, 3, 17)));
		dishes.add(new CeramicDish(4L, "Talerz", LocalDate.of(2020, 2, 20)));
		dishes.add(new CeramicDish(5L, "Talerzyk", LocalDate.of(2019, 1, 2)));
	}

	@GetMapping("/getAll")
	public ArrayList<CeramicDish> getAll(){
		return dishes;
	}
	@GetMapping("/get")
	public Optional<CeramicDish> get(@RequestParam("id") int id){
		return Optional.of( dishes.stream().filter((element) -> element.getId() == id).findFirst().get() );
	}

	@PostMapping("/add")
	public boolean addDish(@RequestBody CeramicDish dish){
		return dishes.add(dish);
	}

	@PutMapping("/mod")
	public boolean changeDish(@RequestParam("id") int id, @RequestParam("newId") Long newId, @RequestParam("nazwa") String nazwa, @RequestParam("rok") LocalDate rokProdukcji){
		if(dishes.stream().anyMatch((element) -> element.getId() == id)){
			CeramicDish dish = dishes.stream().filter((element) -> element.getId() == id).findFirst().get();
			dish.setId(newId);
			dish.setNazwa(nazwa);
			dish.setRokProdukcji(rokProdukcji);
			return true;
		}
		return false;
	}

	@DeleteMapping("/delete")
	public boolean deleteDish(@RequestParam("id") int id){
		return dishes.removeIf((element) -> element.getId() == id);
	}
}
