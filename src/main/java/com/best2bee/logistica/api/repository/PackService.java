package com.best2bee.logistica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2bee.logistica.api.model.Pack;

public interface PackService extends JpaRepository<Pack, Long> {

}
