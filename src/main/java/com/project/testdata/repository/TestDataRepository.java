package com.project.testdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.testdata.models.TestDataModel;

@Repository
public interface TestDataRepository extends JpaRepository<TestDataModel, Integer>{

}