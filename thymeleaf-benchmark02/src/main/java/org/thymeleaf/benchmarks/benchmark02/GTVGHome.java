package org.thymeleaf.benchmarks.benchmark02;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.benchmarks.benchmark02.model.CalendarUtil;
import org.thymeleaf.context.Context;

public class GTVGHome extends BaseBenchmark {

    private TemplateEngine engine;
    private Context context;

    @Setup
    public void setup() throws IOException {

        this.engine = buildTemplateEngine();

        this.context = new Context(Locale.ENGLISH);
        this.context.setVariable("user", buildUser());
        this.context.setVariable("today", CalendarUtil.calendarFor(2015, 1, 1, 8, 0));

        addEvaluationContext(this.context);

    }


    @Benchmark
    public String benchmark() throws Exception {
        Writer writer = new StringWriter();
        engine.process("home", context, writer);
        return writer.toString();
    }


}
