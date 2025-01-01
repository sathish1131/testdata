package com.project.testdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.testdata.models.UserDataModel;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataModel, Integer>{

}