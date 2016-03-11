>hdfs dfs -put ‘filename’

A = load 'filename' using PigStorage(',') as (date1:chararray,date2:chararray);

B = FOREACH A GENERATE DaysBetween(ToDate(date2, 'yyyy:MM:dd'), ToDate(date1, 'yyyy:MM:dd')) as days;

DUMP B;  
