---- Data Set ------

Movies.csv

or 

in folder Analyze_Movie_Data/Data_set

-- Loading the files into HDFS ----

1. Create Directory MovieData in hdfs -
hadoop fs -mkdir /MovieData
hadoop fs -mkdir /MovieData/inputs

2. Change Directory to Analyze_Movie_Data/Data_set/BX-CSV-Dump

3. Copy data to /BookData/inputs in hdfs
hadoop fs -put Movies.csv /MovieData/inputs/



------- Using jar files with hadoop ----------

Move to Directory Project_MovieData where jars are available



---- Problem Statement 1 (block buster movie of each decade) ------

Running -
hadoop jar BlockBusterMovie.jar /MovieData/inputs/Movies.csv /MovieData/BlockBusterMovie
To see Output(Sample output is given) - 
hadoop fs -cat /MovieData/BlockBusterMovie/p*

----- Problem Statement 2(3 most promising pair of actor and actress) ------

Running -
hadoop jar ActorActressPair.jar /MovieData/inputs/Movies.csv /MovieData/ActorActressPair
To see Output(Sample output is given) - 
hadoop fs -cat /MovieData/ActorActressPair/p*

----- ProblemStatement 3(top 5 stable actors) --------

Running -
hadoop jar MovieStableActor.jar /MovieData/inputs/Movies.csv /MovieData/MovieStableActor
To see Output(Sample output is given) - 
hadoop fs -cat /MovieData/MovieStableActor/p*

----- ProblemStatement 4-1(top 5 stable actress) --------

Running -
hadoop jar MovieStableActress.jar /MovieData/inputs/Movies.csv /MovieData/MovieStableActress
To see Output(Sample output is given) - 
hadoop fs -cat /MovieData/MovieStableActress/p*

----- ProblemStatement 4-2(top 5 stable Directors) --------

Running -
hadoop jar MovieStableDirector.jar /MovieData/inputs/Movies.csv /MovieData/MovieStableDirector
To see Output(Sample output is given) - 
hadoop fs -cat /MovieData/MovieStableDirector/p*

---- Problem Statement 5(Best Horror Movie)--------

Running -
hadoop jar MovieHorrorAward.jar /MovieData/inputs/Movies.csv /MovieData/MovieHorrorAward
To see Output(Sample output is given) - 
hadoop fs -cat /MovieData/MovieHorrorAward/p*

