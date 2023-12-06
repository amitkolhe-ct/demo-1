package com.flight.service.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.service.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String>{

}
