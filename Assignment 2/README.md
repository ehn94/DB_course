# twitterExercise

Database setup: 
* Run docker run --rm -v $(pwd)/data:/data/db --publish=27017:27017 --name dbms -d mongo:latest
* Run docker exec -it {id returned from last command} bash
* Run apt-get update
* Run apt-get install -y wget unzip git python3 python3-pip
* Run wget http://cs.stanford.edu/people/alecmgo/trainingandtestdata.zip
* Run unzip trainingandtestdata.zip
* Run sed -i '1s;^;polarity,id,date,query,user,text\n;' training.1600000.processed.noemoticon.csv
* Run mongoimport --drop --db social_net --collection tweets --type csv --headerline --file training.1600000.processed.noemoticon.csv

Run the program: 
* The program is written in java, therefore you will need to install the latest JDK. 
* Clone https://github.com/ehn94/twitterExercise.git 
* Enter the target folder and open your terminal from this location.
* Enter the command: java -jar "Twitter-2.0.jar"

Results:  
Ex1: How many Twitter users are in the database:  
There are 1600000 Twitter users in the database. 

Ex2: Which Twitter users link the most to other Twitter users? (Provide the top ten.):
1. tsarnick with 129 links
2. shutupmeg with 88 links
3. NoteRobot with 84 links
4. Jeff_Hardyfan with 83 links
5. dogzero with 81 links
6. sunshine_diva with 80 links
7. 19c816tf9227 with 59 links
8. DaisyFab with 47 links
9. twishes with 46 links
10. Hugasaurus with 46 links

Ex3: Who are the most mentioned Twitter users? (Provide the top five.):  
I couldn't figure this one out :(

Ex4: Who are the most active Twitter users (top ten)?  
Woops, I made a top 5. But they are: 
1. lost_dog who wrote 549 tweets
2. webwoke who wrote 345 tweets
3. tweetpet who wrote 310 tweets
4. SallytheShizzle who wrote 281 tweets
5. VioletsCRUK who wrote 279 tweets

Ex5: Who are the five most grumpy (most negative tweets) and the most happy (most positive tweets)? (Provide five users for each group):  
The most grumpy: 
1. _TheSpecialOne_
2. scotthamilton
3. mattycus
4. ElleCTF
5. Karoli

The most happy: 
1. ersle
2. becca210
3. Wingman29
4. katarinka
5. _EmilyYoung


