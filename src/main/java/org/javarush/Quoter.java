package org.javarush;

import org.javarush.annotation.InjectRandomInt;
import org.javarush.annotation.Profiling;

@Profiling
public class Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;
    private String message;

    public Quoter() {
        System.out.println("-----------------------------------");
        System.out.println("++ |Phase 1: Quoter constructor");
        System.out.println("   | - Var repeat = " + repeat);
    }

    public void init() {
        System.out.println("-----------------------------------");
        System.out.println("++ |Phase #2: Quoter init");
        System.out.println("   | - Var repeat = " + repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
