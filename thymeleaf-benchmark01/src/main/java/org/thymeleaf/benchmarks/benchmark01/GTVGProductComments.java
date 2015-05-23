package org.thymeleaf.benchmarks.benchmark01;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.benchmarks.benchmark01.model.Product;
import org.thymeleaf.benchmarks.benchmark01.model.repositories.ProductRepository;
import org.thymeleaf.context.Context;

public class GTVGProductComments extends BaseBenchmark {

    private TemplateEngine engine;
    private Context context;

    @Setup
    public void setup() throws IOException {

        this.engine = buildTemplateEngine();

        final Product product = ProductRepository.getInstance().findById(Integer.valueOf(2));

        this.context = new Context(Locale.ENGLISH);
        this.context.setVariable("prod", product);

    }


    @Benchmark
    public String benchmark() throws Exception {
        Writer writer = new StringWriter();
        engine.process("product/comments", context, writer);
        return writer.toString();
    }


}
