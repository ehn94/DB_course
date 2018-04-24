# Assignment 9 
### 1. Describe the setup of your experiment
I have used the small CSV files for this assignment, as I was not able to import the larger files into the Neo4j database. 
Both Neo4J and MySQL run on my Windows machine. 
I have written my program in Java in a Netbeans Maven project. 

To construct the experiment you'll need to follow these steps: 
* Setup a Neo4J database and a SQL database- this does not have to be MySQL
* Import the social network datasets into the databases
* Connect to the two databases 
* Construct queries in SQL and in Cypher, which find
  - all persons that a person endorses, i.e., endorsements of depth one.
  - all persons that are endorsed by endorsed persons of a person, i.e., endorsements of depth two.
  - endorsements of depth three.
  - endorsements of depth four.
  - endorsements of depth five.
* Write some kind of helper methods to take time, find the average and the median. 

### 2. Present the execution time of each query for each of the 20 random nodes per database
|   |  Neo4  |
|---|---|
|getDepthOne:	|{0.02,0.03,0.01,0.01,0.02,0.03,0.04,0.04,0.03,0.01,0.03,0.01,0.03,0.03,0.03,0.03,0.03,0.03,0.03,0.02}	|
|getDepthTwo:	|{0.02,0.04,0.07,0.03,0.03,0.04,0.01,0.03,0.04,0.04,0.04,0.02,0.01,0.01,0.04,0.04,0.03,0.03,0.01,0.02}	|
|getDepthThree:	|{0.07,0.03,0.07,0.03,0.06,0.04,0.03,0.07,0.05,0.03,0.03,0.02,0.07,0.05,0.03,0.06,0.03,0.06,0.07,0.04}	|
|getDepthFour:	|{0.3,0.03,0.12,0.03,0.3,0.03,0.07,0.03,0.08,0.03,0.05,0.1,0.03,0.03,0.02,0.03,0.05,0.04,0.03,0.04}	|
|getDepthFive:	|{0.3,0.03,0.12,0.03,0.13,0.03,0.07,0.03,0.08,0.03,0.05,0.1,0.13,0.03,0.02,0.03,0.05,0.04,0.03,0.04}	|

|   | MySQL |
|---|---|
|getDepthOne:	| {0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.07,0.07,0.08,0.08,0.09,0.1,0.1,0.16,0.22}	|
|getDepthTwo:	| {0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.06,0.06,0.06,0.06,0.06,0.07,0.07,0.07,0.07,0.07,0.1,0.12,0.16} |
|getDepthThree:	| {0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.06,0.06,0.06,0.06,0.06,0.12,0.12,0.14,0.35,0.45}	|
|getDepthFour:	|{0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.06,0.06,0.06,0.14,0.65,0.92,2.25,2.37}	|
|getDepthFive:	| {0.05,0.05,0.05,0.05,0.05,0.05,0.05,0.06,0.06,0.06,0.06,0.06,0.06,0.06,0.08,0.19,12.31,16.03,35.11,40.45}	

### 3. Present the average and the median runtime of each of the queries per database
The average and median value is given in seconds. 

|   | Neo4  Average  | Neo4  Median | MySQL Average |   MySQL Median |
|---|---|---|---|---|
|getDepthOne:	|0.0032	|0.003	|0.02	|0.01	|
|getDepthTwo:	|0.00445	|0.004	|0.025	|0.01 |
|getDepthThree:	|0.0098	|0.007	|0.1 |0.05 |
|getDepthFour:	|0.3345	|0.032	|0.36 |0.05 |
|getDepthFive:	|0.14605	|0.16	|1.25	|0.06|

### 4. Differences & conclusion
Eventhough I have used the small CSV file, we are able to see a slight difference in the average execution time for the queries. This would ofcourse be more obvious if the large datasets were used. 
As we can see Neo4j has the shortest average execution time.  
Graph databases are faster when you perform seaches on nested relations, where relational databases work faster on straight value seaches. 
In this case, the graph database is a better choice. 
