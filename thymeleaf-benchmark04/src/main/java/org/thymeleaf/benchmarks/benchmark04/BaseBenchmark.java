package org.thymeleaf.benchmarks.benchmark04;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.benchmarks.benchmark04.model.User;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.expression.ThymeleafEvaluationContext;
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
        enableSpELCompilation(templateEngine);
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
                new ThymeleafEvaluationContext(new ClassPathXmlApplicationContext(), null);
        context.setVariable(ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME, evaluationContext);

    }


    private static void enableSpELCompilation(final SpringTemplateEngine springTemplateEngine) {

        try {

            try {
                final Method enableSpELMethod = SpringTemplateEngine.class.getMethod("setEnableSpringELCompiler", new Class[] { boolean.class });
                enableSpELMethod.invoke(springTemplateEngine, true);
            } catch (final NoSuchMethodException e) {
                try {
                    Class.forName("org.thymeleaf.Thymeleaf");
                    throw new RuntimeException("Could not activate SpEL Compiler in SpringStandardDialect for Spring >= v4");
                } catch (final ClassNotFoundException cnf) {
                    // OK, This is not Thymeleaf 3. Makes sense that SpEL compiler could not be enabled
                }
            }

        } catch (final Exception e) {
            throw new RuntimeException("Cannot create instance of SpringStandardDialect", e);
        }
    }

}
