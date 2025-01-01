package com.project.testdata.service;

import com.project.testdata.repository.TestDataRepository;
import com.project.testdata.models.TestDataModel;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TestDataService{

	@Autowired
	private TestDataRepository repo;

	public List<TestDataModel> getAllTestData(){
		return repo.findAll();
	}

	public void deleteTestData(int id){
		if(repo.existsById(id)){
			repo.deleteById(id);
		}else{
			throw new Error("Entity not found with id: " + id);
		}
	}

	public void updateTestData(int id, TestDataModel data){
		TestDataModel existingData = repo.findById(id).orElseThrow(() -> new Error("Entity not found with id: " + id));
		existingData.setName(data.getName());
		existingData.setData(data.getData());
		repo.save(existingData);
	}

	public void addTestData(TestDataModel data){
		repo.save(data);
	}

}