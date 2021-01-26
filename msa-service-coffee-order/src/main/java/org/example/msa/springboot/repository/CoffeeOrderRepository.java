package org.example.msa.springboot.repository;

import com.netflix.discovery.converters.Auto;
import org.example.msa.domain.model.OrderEntity;
import org.example.msa.domain.repository.ICoffeeOrderRepository;
import org.example.msa.springboot.repository.jpa.OrderEntityJPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoffeeOrderRepository implements ICoffeeOrderRepository {
  
  @Autowired
  private ICoffeeOrderRepository iCoffeeOrderRepository;
  
  @Override
  public String coffeeOrderSave(OrderEntity orderEntity) {

    OrderEntityJPO orderEntityJPO = new OrderEntityJPO();
    orderEntityJPO.setOrderNumber(orderEntity.getOrderNumber());
    orderEntityJPO.setCoffeeName(orderEntity.getCoffeeName());
    orderEntityJPO.setCoffeeCount(orderEntity.getCoffeeCount());
    orderEntityJPO.setCustomerName(orderEntity.getCustomerName());

    iCoffeeOrderRepository.coffeeOrderSave(orderEntityJPO);
    return orderEntityJPO.getId();
  }
}
