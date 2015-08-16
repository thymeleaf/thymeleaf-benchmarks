
# Thymeleaf Benchmarks

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
