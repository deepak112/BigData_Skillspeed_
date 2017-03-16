CarsData = LOAD 'cars.csv' USING PigStorage(';') AS (Car, MPG, Cylinders, Displacement, Horsepower:long, Weight, Acceleration, Model, Origin);
--DUMP CarsData; 
CarsWithHorsePowerCond = FILTER CarsData BY Horsepower>200; 
DUMP CarsWithHorsePowerCond; 
GroupByCars = GROUP CarsWithHorsePowerCond ALL;
CountCarsAccordingToHorsePower = FOREACH GroupByCars GENERATE CONCAT('Frequency of Cars Having Horse Power More then 200 :', (chararray)COUNT(CarsWithHorsePowerCond));
STORE CountCarsAccordingToHorsePower INTO 'FrequencyOfCarsAccordingToHorsePower';
DUMP CountCarsAccordingToHorsePower; 

