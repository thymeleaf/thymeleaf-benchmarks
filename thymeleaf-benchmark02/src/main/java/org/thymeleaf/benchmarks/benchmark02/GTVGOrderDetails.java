package org.thymeleaf.benchmarks.benchmark02;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.benchmarks.benchmark02.model.Order;
import org.thymeleaf.benchmarks.benchmark02.model.repositories.OrderRepository;
import org.thymeleaf.context.Context;

public class GTVGOrderDetails extends BaseBenchmark {

    private TemplateEngine engine;
    private Context context;

    @Setup
    public void setup() throws IOException {

        this.engine = buildTemplateEngine();

        final Order order = OrderRepository.getInstance().findById(Integer.valueOf(1));

        this.context = new Context(Locale.ENGLISH);
        this.context.setVariable("order", order);

        addEvaluationContext(this.context);

    }


    @Benchmark
    public String benchmark() throws Exception {
        Writer writer = new StringWriter();
        engine.process("order/details", context, writer);
        return writer.toString();
    }


}
