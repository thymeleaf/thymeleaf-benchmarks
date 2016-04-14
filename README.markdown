
# Thymeleaf Benchmarks

  * Benchmark 01: Using the templates and data from the GTVG example application, meant to test different versions of
                  Thymeleaf in non-Spring environments (i.e. using OGNL).
  * Benchmark 02: Using the templates and data from the GTVG example application, meant to test different versions of
                  Thymeleaf in Spring 3.x-enabled environments. 
  * Benchmark 03: Using the templates and data from the GTVG example application, meant to test different versions of
                  Thymeleaf in Spring 4.x-enabled environments. 
  * Benchmark 04: Using the templates and data from the GTVG example application, meant to test different versions of
                  Thymeleaf in Spring 4.x-enabled environments with SpringEL compilation enabled (for Thymeleaf >= v3). 


# How to use the Benchmarks

To create the benchmark artifacts:
```
mvn -P {version} clean compile package
```
(Currently available version profiles are: `2.1.4`, `3.0.0`)

To execute jmh benchmarks with CSV output:
```
java -jar target/thymeleaf-benchmarkXX.jar {BenchmarkName01 BenchmarkName02 ...}? -rf csv -rff benchmarkoutput.csv
```

### Plotting results

To install gnuplot using brew:
```
$ brew install gnuplot --with-cairo
```

In order to do the plotting, combine the several `.csv` files output from the benchmark executions into one
called `thymeleaf-benchmarks.csv` (preferrably changing the names in the first column to smaller, more
displayable names) and place it in the projects root folder. Then execute:
```
$ gnuplot thymeleaf-benchmarks.plot
```

This should create a file called `thymeleaf-benchmarks.png` containing the results graph.

