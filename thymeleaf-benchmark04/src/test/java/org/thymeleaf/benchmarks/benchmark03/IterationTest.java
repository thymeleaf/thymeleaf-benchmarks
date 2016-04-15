package org.thymeleaf.benchmarks.benchmark03;

import java.util.Locale;

import org.thymeleaf.benchmarks.benchmark04.GTVGHome;
import org.thymeleaf.benchmarks.benchmark04.GTVGOrderDetails;
import org.thymeleaf.benchmarks.benchmark04.GTVGOrderList;
import org.thymeleaf.benchmarks.benchmark04.GTVGProductComments;
import org.thymeleaf.benchmarks.benchmark04.GTVGProductList;

public class IterationTest {

    private static final int ITERATIONS = 1000000;

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

        System.out.println("## GTVG HOME ##");
        for (int i = 0; i < ITERATIONS; i++) {
            if (gtvgHome.benchmark() == null) {
                System.err.println("ERROR!");
            }
            if ((i + 1) % (ITERATIONS / 10) == 0) {
                System.out.println("   [" + (i + 1) + "]");
            }
        }
        System.out.println("## GTVG ORDER LIST ##");
        for (int i = 0; i < ITERATIONS; i++) {
            if (gtvgOrderList.benchmark() == null) {
                System.err.println("ERROR!");
            }
            if ((i + 1) % (ITERATIONS / 10) == 0) {
                System.out.println("   [" + (i + 1) + "]");
            }
        }
        System.out.println("## GTVG ORDER DETAILS ##");
        for (int i = 0; i < ITERATIONS; i++) {
            if (gtvgOrderDetails.benchmark() == null) {
                System.err.println("ERROR!");
            }
            if ((i + 1) % (ITERATIONS / 10) == 0) {
                System.out.println("   [" + (i + 1) + "]");
            }
        }
        System.out.println("## GTVG PRODUCT LIST ##");
        for (int i = 0; i < ITERATIONS; i++) {
            if (gtvgProductList.benchmark() == null) {
                System.err.println("ERROR!");
            }
            if ((i + 1) % (ITERATIONS / 10) == 0) {
                System.out.println("   [" + (i + 1) + "]");
            }
        }
        System.out.println("## GTVG PRODUCT COMMENTS ##");
        for (int i = 0; i < ITERATIONS; i++) {
            if (gtvgProductComments.benchmark() == null) {
                System.err.println("ERROR!");
            }
            if ((i + 1) % (ITERATIONS / 10) == 0) {
                System.out.println("   [" + (i + 1) + "]");
            }
        }

    }

}
