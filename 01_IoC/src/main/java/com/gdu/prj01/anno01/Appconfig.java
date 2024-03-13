package com.gdu.prj01.anno01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // IoC Container 에 bean 을 등록하는 클래스
public class Appconfig {
  
  /*
   * 반환타입 : bean 의 타입, <bean class="">
   * 메소드명 : bean 의 이름, <bead id="">
   */
  @Bean
  public Calculator calculator() {
    return new Calculator();
  }
  
  @Bean(name="calculator")
  public Calculator asdfghjkl() {
    return new Calculator();
  }
  
  public Computer computer1() {
    Computer computer1 = new Computer();
    computer1.setModel("gram");
    computer1.setPrice(200);
    computer1.setCalculator(null);
    return computer1;
  }
  
}



