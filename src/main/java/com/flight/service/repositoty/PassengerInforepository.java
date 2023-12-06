package com.flight.service.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.service.entity.PassengerInfo;

public interface PassengerInforepository extends JpaRepository<PassengerInfo, Long>{

}
