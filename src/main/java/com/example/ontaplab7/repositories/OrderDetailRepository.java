package com.example.ontaplab7.repositories;

import com.example.ontaplab7.models.OrderDetail;
import com.example.ontaplab7.pks.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}