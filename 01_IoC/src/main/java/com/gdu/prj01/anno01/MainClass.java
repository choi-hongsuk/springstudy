package com.gdu.prj01.anno01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.gdu.prj01.xml01.Calculator;

public class MainClass {

  public static void main(String[] args) {

    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Appconfig.class);
  
    Calculator calculator =ctx.getBean("calculator", Calculator.class);
    
    calculator.add(10, 20);
    calculator.sub(10, 5);
    calculator.mul(10, 3);
    calculator.div(10, 4);
    
    ctx.close();
  }

}
