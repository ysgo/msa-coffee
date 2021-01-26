package org.example.msa.springboot.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.msa.domain.model.CoffeeOrderCVO;
import org.example.msa.springboot.messageq.KafkaProducer;
import org.example.msa.springboot.service.CoffeeOrderServiceImpl;
import org.example.msa.springboot.service.IMsaServiceCoffeeMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeOrderRestController {

  @Autowired
  private CoffeeOrderServiceImpl coffeeOrderServiceImpl;

  @Autowired
  private KafkaProducer kafkaProducer;

  @Autowired
  private IMsaServiceCoffeeMember iMsaServiceCoffeeMember;

  @HystrixCommand
  @RequestMapping(value = "/coffeeOrder", method = RequestMethod.POST)
  public ResponseEntity<CoffeeOrderCVO> coffeeOrder(@RequestBody CoffeeOrderCVO coffeeOrderCVO) {

    // is member
    if(iMsaServiceCoffeeMember.coffeeMember(coffeeOrderCVO.getCustomerName())) {
      System.out.println(coffeeOrderCVO.getCustomerName() + " is a member!");
    }

    // coffee order
    coffeeOrderServiceImpl.coffeeOrder(coffeeOrderCVO);

    // kafka
    kafkaProducer.send("msa-kafka-test", coffeeOrderCVO);

    return new ResponseEntity<>(coffeeOrderCVO, HttpStatus.OK);
  }
}
