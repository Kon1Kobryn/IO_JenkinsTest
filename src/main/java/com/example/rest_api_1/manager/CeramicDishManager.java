package com.example.rest_api_1.manager;

import com.example.rest_api_1.dao.CeramicDishRepo;
import com.example.rest_api_1.dao.entity.CeramicDish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CeramicDishManager {
	private CeramicDishRepo ceramicDishRepo;

	@Autowired
	public CeramicDishManager(CeramicDishRepo ceramicDishRepo) {
		this.ceramicDishRepo = ceramicDishRepo;
	}

	public Optional<CeramicDish> findAllById(Long id){
		return ceramicDishRepo.findById(id);
	}

	public Iterable<CeramicDish> findAll(){
		return ceramicDishRepo.findAll();
	}

	public CeramicDish save(CeramicDish ceramicDish){
		return (CeramicDish) ceramicDishRepo.save(ceramicDish);
	}

	public void delete(Long id){
		ceramicDishRepo.deleteById(id);
	}

	public void fillDb(){
		save(new CeramicDish(1L, "talerz1", LocalDate.of(1980,1,1)));
		save(new CeramicDish(2L, "talerz2", LocalDate.of(1985,2,15)));
		save(new CeramicDish(3L, "talerz3", LocalDate.of(1988,3,20)));
		save(new CeramicDish(4L, "talerz4", LocalDate.of(1995,4,25)));
	}
}
