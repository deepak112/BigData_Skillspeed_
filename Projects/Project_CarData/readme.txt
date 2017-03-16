------------ Instructions ----------
Scripts to be run in local mode only

---- Data Set ------

cars.csv

or 

in folder Analyze_Car_Data/Data_set


---- Running Scripts ----

---- Problem Statement 1 (frequency of cars having Horsepower more than 200HP) ------

Running:
pig -x local FrequencyOfCarsAccordingToHorsePower.pig
Output:
cat FrequencyOfCarsAccordingToHorsePower/p*

---- Problem Statement 2 (number of cars of Model 75 and which have been developed in US, Europe and Japan individually) ------

Running:
pig -x local MostNumberOfCarsAccordingToModel.pig
Output:
cat CountOfCarsAccordingToCountryAndModel/p*
cat MostNumberOfCarsAccordingToCountry/p*

---- Problem Statement 3 (number of cars weighing less than 2500 kgs each having cylinder numbers 6, 4 and 3 individually) ------

Running:
pig -x local FrequencyOfCarsWithWeightAndCylinderCond.pig
Output:
cat FrequencyOfCarsWithWeightAndCylinderCond/p*
