package com.best2bee.logistica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.best2bee.logistica.api.model.Adress;

@Repository
public interface AdressRepository  extends JpaRepository<Adress, Integer>{

}
