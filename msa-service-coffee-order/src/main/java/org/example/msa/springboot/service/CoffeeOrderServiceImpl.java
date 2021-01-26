package org.example.msa.springboot.service;

import org.example.msa.domain.repository.ICoffeeOrderRepository;
import org.example.msa.domain.service.CoffeeOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoffeeOrderServiceImpl extends CoffeeOrder {

  public CoffeeOrderServiceImpl(ICoffeeOrderRepository iCoffeeOrderRepository) {
    super(iCoffeeOrderRepository);
  }
}
