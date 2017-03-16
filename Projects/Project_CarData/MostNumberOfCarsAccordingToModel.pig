CarsData = LOAD 'cars.csv' USING PigStorage(';') AS (Car, MPG, Cylinders, Displacement, Horsepower, Weight, Acceleration, Model:int, Origin); 
FilterByModelAndCountry = FILTER CarsData BY Model==75 AND (Origin=='US' OR Origin=='Europe' OR Origin=='Japan');
--DUMP FilterByModelAndCountry;
GroupByOrigin = GROUP FilterByModelAndCountry BY Origin;
--DUMP GroupByOrigin;
CountByCountry = FOREACH GroupByOrigin GENERATE group AS Origin, COUNT(FilterByModelAndCountry) AS Frequency;
STORE CountByCountry INTO 'CountOfCarsAccordingToCountryAndModel';
DUMP CountByCountry;
OrderByFrequency = ORDER CountByCountry BY Frequency DESC;
--DUMP OrderByFrequency;
MostNumberOfCarsAccordingToCountry = LIMIT  OrderByFrequency 1;
STORE MostNumberOfCarsAccordingToCountry INTO 'MostNumberOfCarsAccordingToCountry';
DUMP MostNumberOfCarsAccordingToCountry;

