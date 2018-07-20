package com.niranjan.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niranjan.model.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long>, CalendarEventRepository
{

}
