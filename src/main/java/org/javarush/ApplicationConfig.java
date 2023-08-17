package org.javarush;

import jakarta.inject.Named;
import org.javarush.bpp.InjectRandomIntAnnotationBeanPostProcessor;
import org.javarush.bpp.ProfilingHandlerBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean(initMethod="init", name = "quoter")
    public Quoter quoter() {
        Quoter quoter = new Quoter();
        quoter.setMessage("Hello world!");
        return quoter;
    }

    @Bean
    public InjectRandomIntAnnotationBeanPostProcessor injectRandomIntAnnotationBeanPostProcessor() {
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }

    @Bean
    public ProfilingHandlerBeanPostProcessor profilingHandlerBeanPostProcessor() {
        return new ProfilingHandlerBeanPostProcessor();
    }

}
