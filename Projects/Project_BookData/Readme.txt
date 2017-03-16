---- Data Set ------

Link: https://www.dropbox.com/s/088v50nvtk39kg2/BX-CSV-Dump.zip?dl=0

Download file from the link and save it in folder /Project_BookData/Analyze_Book_Data/Data_set/

------ Load the files into HDFS -------

1. Create Directory BookData in hdfs -
hadoop fs -mkdir /BookData
hadoop fs -mkdir /BookData/inputs

2. Change Directory to Analyze_Book_Data/Data_set/(first extract BX-CSV-Dump.zip)

3. Copy data to /BookData/inputs in hdfs
hadoop fs -put BX-Book-Ratings.csv /BookData/inputs/
hadoop fs -put BX-Books.csv /BookData/inputs/
hadoop fs -put BX-Users.csv /BookData/inputs/


------- Using jar files with hadoop ----------

1. Move to Directory Project_BookData where jars are available(Source code is also available)


--- Problem Statement 1 (Frequency of books Published each year)------

Running -
hadoop jar BookFrequency.jar books.data.BookFrequency /BookData/inputs/BX-Books.csv /BookData/BookFrequency 
To see Output(Sample output is given) - 
hadoop fs -cat /BookData/BookFrequency/p*

--- Problem Statement 2 (Maximum books published in which year)------

Running -
hadoop jar MaxBooksPublished.jar books.data.MaxBooksPublished /BookData/inputs/BX-Books.csv /BookData/MaxBooksPublished 
To see Output(Sample output is given) - 
hadoop fs -cat /BookData/MaxBooksPublished/p*


--- Problem Statement 3 (books published based on ranking in the year 2002)--------

Running -
hadoop jar BooksDataRank.jar books.data.BooksDataRank /BookData/inputs/BX-Books.csv /BookData/inputs/BX-Book-Ratings.csv /BookData/BooksDataRankTemp /BookData/BooksDataRank
To see Output(Sample output is given) - 
hadoop fs -cat /BookData/BooksDataRank/p*

