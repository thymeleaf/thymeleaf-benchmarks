
# Thymeleaf Benchmarks

To create the benchmark artifacts:
```
mvn clean compile package
```

To execute jmh benchmarks with CSV output:
```
java -jar target/thymeleaf-benchmarkXX.jar {BenchmarkName01 BenchmarkName02 ...}? -rf csv -rff benchmarkoutput.csv
```

To install gnuplot using brew:
```
$ brew install gnuplot --cairo
```
