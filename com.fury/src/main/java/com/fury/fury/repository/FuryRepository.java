package com.fury.fury.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fury.fury.model.Fury;
@Repository
public interface FuryRepository extends JpaRepository<Fury, Long> {

}
