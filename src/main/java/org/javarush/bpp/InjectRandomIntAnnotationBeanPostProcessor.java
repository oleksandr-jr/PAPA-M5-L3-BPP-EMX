package org.javarush.bpp;

import org.javarush.annotation.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Arrays;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----------------------------------");
        System.out.println("++ POST PROCESSOR: BEFORE INITIALIZATION");
        Field[] declaredFields = bean.getClass().getDeclaredFields();

        Arrays.stream(declaredFields)
                .filter(field -> field.isAnnotationPresent(InjectRandomInt.class))
                .forEach(field -> {
                    InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                    int min = annotation.min();
                    int max = annotation.max();
                    int random = min + (int) (Math.random() * ((max - min) + 1));
                    field.setAccessible(true);
                    try {
                        field.set(bean, random);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----------------------------------");
        System.out.println("++ POST PROCESSOR: AFTER INITIALIZATION");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
