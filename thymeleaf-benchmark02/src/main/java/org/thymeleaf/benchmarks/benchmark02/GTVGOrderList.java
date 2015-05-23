package org.thymeleaf.benchmarks.benchmark02;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Locale;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.benchmarks.benchmark02.model.Order;
import org.thymeleaf.benchmarks.benchmark02.model.repositories.OrderRepository;
import org.thymeleaf.context.Context;

public class GTVGOrderList extends BaseBenchmark {

    private TemplateEngine engine;
    private Context context;

    @Setup
    public void setup() throws IOException {

        this.engine = buildTemplateEngine();

        final List<Order> orders = OrderRepository.getInstance().findAll();

        this.context = new Context(Locale.ENGLISH);
        this.context.setVariable("orders", orders);

    }


    @Benchmark
    public String benchmark() throws Exception {
        Writer writer = new StringWriter();
        engine.process("order/list", context, writer);
        return writer.toString();
    }


}
