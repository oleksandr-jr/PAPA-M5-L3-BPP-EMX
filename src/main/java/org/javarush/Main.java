package org.javarush;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.javarush");

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        Quoter quoter = context.getBean("quoter", Quoter.class);

        while (true){
            try {
                Thread.sleep(1000);
                quoter.sayQuote();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}