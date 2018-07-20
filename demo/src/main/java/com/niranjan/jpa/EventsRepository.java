package com.niranjan.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niranjan.model.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long>{

}
