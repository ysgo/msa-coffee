package org.example.msa.springboot.repository.jpa;

import lombok.Getter;
import lombok.Setter;
import org.example.msa.domain.model.OrderEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class OrderEntityJPO extends OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  String orderNumber;
  String coffeeName;
  String coffeeCount;
  String customerName;
}
