
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

To install gnuplot using brew:
```
$ brew install gnuplot --cairo
```


