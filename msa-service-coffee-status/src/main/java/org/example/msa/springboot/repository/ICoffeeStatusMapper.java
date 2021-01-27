package org.example.msa.springboot.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.msa.springboot.repository.dvo.OrderStatusDVO;

@Mapper
public interface ICoffeeStatusMapper {
  int insertCoffeeOrderStatus(OrderStatusDVO orderStatusDVO);
  OrderStatusDVO selectCoffeeOrderStatus();
  int createStatusTable();
}
