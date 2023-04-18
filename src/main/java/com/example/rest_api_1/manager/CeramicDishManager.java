package com.example.rest_api_1.manager;

import com.example.rest_api_1.dao.CeramicDishRepo;
import com.example.rest_api_1.dao.entity.CeramicDish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		save(new CeramicDish(1L))
	}
}
