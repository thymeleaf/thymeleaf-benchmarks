package org.thymeleaf.benchmarks.benchmark01;

import java.util.Locale;

import org.junit.BeforeClass;
import org.junit.Test;

public class IterationTest {


    public static void main(final String[] args) throws Exception {

        Locale.setDefault(Locale.ENGLISH);

        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final GTVGHome gtvgHome = new GTVGHome();
        gtvgHome.setup();
        System.out.println(gtvgHome.benchmark());

        final GTVGOrderList gtvgOrderList = new GTVGOrderList();
        gtvgOrderList.setup();
        System.out.println(gtvgOrderList.benchmark());

        final GTVGOrderDetails gtvgOrderDetails = new GTVGOrderDetails();
        gtvgOrderDetails.setup();
        System.out.println(gtvgOrderDetails.benchmark());

        final GTVGProductList gtvgProductList = new GTVGProductList();
        gtvgProductList.setup();
        System.out.println(gtvgProductList.benchmark());

        final GTVGProductComments gtvgProductComments = new GTVGProductComments();
        gtvgProductComments.setup();
        System.out.println(gtvgProductComments.benchmark());

        for (int i = 0; i < 1000000; i++) {
            if (gtvgHome.benchmark() == null) {
                System.err.println("ERROR!");
            }
        }
        for (int i = 0; i < 1000000; i++) {
            if (gtvgOrderList.benchmark() == null) {
                System.err.println("ERROR!");
            }
        }
        for (int i = 0; i < 1000000; i++) {
            if (gtvgOrderDetails.benchmark() == null) {
                System.err.println("ERROR!");
            }
        }
        for (int i = 0; i < 1000000; i++) {
            if (gtvgProductList.benchmark() == null) {
                System.err.println("ERROR!");
            }
        }
        for (int i = 0; i < 1000000; i++) {
            if (gtvgProductComments.benchmark() == null) {
                System.err.println("ERROR!");
            }
        }

    }

}
