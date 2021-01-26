package org.example.msa.domain.repository;

import org.example.msa.domain.model.OrderEntity;

public interface ICoffeeOrderRepository {

  public String coffeeOrderSave(OrderEntity orderEntity);
}
