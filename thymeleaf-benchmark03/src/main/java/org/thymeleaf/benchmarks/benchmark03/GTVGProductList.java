package org.thymeleaf.benchmarks.benchmark03;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Locale;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.benchmarks.benchmark03.model.Product;
import org.thymeleaf.benchmarks.benchmark03.model.repositories.ProductRepository;
import org.thymeleaf.context.Context;

public class GTVGProductList extends BaseBenchmark {

    private TemplateEngine engine;
    private Context context;

    @Setup
    public void setup() throws IOException {

        this.engine = buildTemplateEngine();

        final List<Product> prods = ProductRepository.getInstance().findAll();

        this.context = new Context(Locale.ENGLISH);
        this.context.setVariable("prods", prods);

        addEvaluationContext(this.context);

    }


    @Benchmark
    public String benchmark() throws Exception {
        Writer writer = new StringWriter();
        engine.process("product/list", context, writer);
        return writer.toString();
    }


}
