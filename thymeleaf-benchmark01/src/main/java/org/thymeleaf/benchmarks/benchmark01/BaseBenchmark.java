package org.thymeleaf.benchmarks.benchmark01;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.benchmarks.benchmark01.model.User;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Fork(5)
@Warmup(iterations = 8)
@Measurement(iterations = 10)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class BaseBenchmark {


    protected TemplateEngine buildTemplateEngine() {
        final TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(buildTemplateResolver());
        return templateEngine;
    }

    protected ITemplateResolver buildTemplateResolver() {
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }


    protected User buildUser() {
        return new User("John", "Apricot", "Antarctica", null);
    }

}
