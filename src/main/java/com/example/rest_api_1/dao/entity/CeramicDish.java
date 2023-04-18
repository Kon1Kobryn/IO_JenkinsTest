package com.example.rest_api_1.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class CeramicDish {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nazwa;
	private LocalDate rokProdukcji;

	public CeramicDish(Long id, String nazwa, LocalDate rokProdukcji) {
		this.id = id;
		this.nazwa = nazwa;
		this.rokProdukcji = rokProdukcji;
	}

	public CeramicDish() {
		this.nazwa = "";
		this.rokProdukcji = LocalDate.of(1980,1,1);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public LocalDate getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(LocalDate rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}
}
