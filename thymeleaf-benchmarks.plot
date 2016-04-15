set title 'Thymeleaf Benchmark Results'
set ylabel 'executions/sec'

set autoscale

set terminal pngcairo enhanced size 800,600 font "Helvetica,12"
set grid
set xtics rotate by -90
set key off

set boxwidth 0.7 relative
set style line 1 lc rgb '#99CC33' lt 1
set style fill solid

set output 'thymeleaf-benchmarks.png'

set datafile separator ','
plot 'thymeleaf-benchmarks.csv' every ::1 using 0:5:xticlabels(stringcolumn(1)) with boxes ls 1,\
     'thymeleaf-benchmarks.csv' every ::1 using 0:($5 + 300):(sprintf("%d",$5)) with labels
