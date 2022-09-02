package com.cl.food_app.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	BranchManager branchmanager;
	
	public BranchManager getBranchmanager() {
		return branchmanager;
	}

	public void setBranchmanager(BranchManager branchmanager) {
		this.branchmanager = branchmanager;
	}

	@OneToMany(mappedBy = "menu",cascade = CascadeType.ALL)
	List<FoodProduct>foods;

	

	public List<FoodProduct> getFoods() {
		return foods;
	}

	public void setFoods(List<FoodProduct> foods) {
		this.foods = foods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
