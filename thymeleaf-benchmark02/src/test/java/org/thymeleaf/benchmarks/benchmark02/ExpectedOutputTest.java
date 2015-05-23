package org.thymeleaf.benchmarks.benchmark02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

import org.junit.BeforeClass;
import org.junit.Test;
import org.thymeleaf.util.ClassLoaderUtils;

import static org.junit.Assert.assertEquals;


public class ExpectedOutputTest {

    @BeforeClass
    public static void beforeClass() {
        Locale.setDefault(Locale.ENGLISH);
    }





    @Test
    public void testGTVGHomeOutput() throws Exception {
        GTVGHome test = new GTVGHome();
        test.setup();
        assertOutput(test.benchmark(), "expected-home");
    }


    @Test
    public void testGTVGOrderListOutput() throws Exception {
        GTVGOrderList test = new GTVGOrderList();
        test.setup();
        assertOutput(test.benchmark(), "expected-order-list");
    }


    @Test
    public void testGTVGOrderDetailsOutput() throws Exception {
        GTVGOrderDetails test = new GTVGOrderDetails();
        test.setup();
        assertOutput(test.benchmark(), "expected-order-details");
    }


    @Test
    public void testGTVGProductListOutput() throws Exception {
        GTVGProductList test = new GTVGProductList();
        test.setup();
        assertOutput(test.benchmark(), "expected-product-list");
    }


    @Test
    public void testGTVGProductCommentsOutput() throws Exception {
        GTVGProductComments test = new GTVGProductComments();
        test.setup();
        assertOutput(test.benchmark(), "expected-product-comments");
    }





    private void assertOutput(final String output, final String expectedFileName) throws IOException {
        // We will compare without whitespaces, thus the replaceAll
        assertEquals(readExpectedOutputResource(expectedFileName), output.replaceAll("\\s", ""));
    }

    private String readExpectedOutputResource(final String expectedFileName) throws IOException {

        final ClassLoader classLoader = ClassLoaderUtils.getClassLoader(ExpectedOutputTest.class);

        InputStream is = null;
        try {
            is = classLoader.getResourceAsStream(expectedFileName + ".html");
            final BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            final StringBuilder builder = new StringBuilder();

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line);
            }

            return builder.toString().replaceAll("\\s", ""); // Remove whitespaces

        } finally {
            if (is != null) {
                is.close();
            }
        }

    }

}
