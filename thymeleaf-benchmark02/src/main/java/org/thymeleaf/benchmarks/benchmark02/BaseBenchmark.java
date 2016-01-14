package org.thymeleaf.benchmarks.benchmark02;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.springframework.jndi.support.SimpleJndiBeanFactory;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.benchmarks.benchmark02.model.User;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.expression.ThymeleafEvaluationContext;
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
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // We are not performing complete Spring initialization (afterPropertiesSet()), and we are not
        // specifying a Spring MessageSource, so the MessageResolver will be a standard one (non-Spring bound)
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


    protected void addEvaluationContext(final Context context) {

        final ThymeleafEvaluationContext evaluationContext =
                new ThymeleafEvaluationContext(new SimpleJndiBeanFactory(), null);
        context.setVariable(ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME, evaluationContext);

    }


}
