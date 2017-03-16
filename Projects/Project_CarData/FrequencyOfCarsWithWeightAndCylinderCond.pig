CarsData = LOAD 'cars.csv' USING PigStorage(';') AS (Car, MPG, Cylinders:int, Displacement, Horsepower:long, Weight:long, Acceleration, Model, Origin);
--DUMP CarsData; 
CarsWithWeightCond = FILTER CarsData BY Weight<2500 AND (Cylinders==3 OR Cylinders==4 OR Cylinders==6); 
--DUMP CarsWithWeightCond; 
GroupByCylinder = GROUP CarsWithWeightCond BY Cylinders;
--DUMP GroupByCylinder; 
CarsByCylinders = FOREACH GroupByCylinder GENERATE group AS Cylinders, COUNT(CarsWithWeightCond) AS Frequency; 
STORE CarsByCylinders INTO 'FrequencyOfCarsWithWeightAndCylinderCond'; 
DUMP CarsByCylinders;  

