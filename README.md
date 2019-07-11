# Java Grep App
  ## Introduction
  This app tries to mimic Unix command called `grep` which stands for `global regular expression print`.This app searches for the text pattern or regular expression recursively in the given directory and output the matched  lines to a temp file.
  ## Usage
  To run the following app open up Intellij and click on edit configuration on top left of the IDE and type the argument `.*data.* /home/dev/jrvs/bootcamp/ /tmp/grep.out` in program parameters separated by space.
  ![image](https://user-images.githubusercontent.com/51926543/60534768-90eb9680-9cd0-11e9-839b-b329ef2b90ba.png)
  It searches all the files in `/home/dev/jrvs/bootcamp/`  directory , sub directory and looks for the key word data and output it to file located in tmp folder with the fine name of `grep.out`.
  ##### Note: You can also search for different keyword instead of data.
  ##### For Example: Lets say you have stored your password somewhere in the directory but you do not know where it is. Instead of opening all the file and checking if it is there which is time consuming, we can make use of this such application that will output the result in milliseconds by onlu chnaging the regex pattern to `.*password.*`.
The three armument that are passed are `regex rootPath, outFile`
##### regex
Regex stands for regular expression is a sequence of character that defines search pattern. Usually such pattern are used by String searching algorithm  for "find" or "find and replace" operation on Strings.
##### rootPath
Root directory path that need searching for your desired keyword.
##### outFile
The output from the result is directed to the file name of your choice and location instead of displaying on terminal.
  
  ## Design and Implementation
  You can talk about the following points
  - Pseudo code and workflow
  - Libraries
  - Diagrams
  ## Enhancements and Issues
  #### Enhancements
  1. Instead of searching all the files we can specify which file need to be search for example (.txt,. csv etc.), this would eliminate searching for irrelevant files and reduce time complexity.
  2. Implement features like `fgrep` which will search for a fixed string rather than regex pattern. 
  3.  Output the total matches found just like Google search.
  #### Issue
  4. Make sure to close the buffer reader by doing so it releases any system resources associated with it.  If you do not close the buffer reader it may cause memory leak.
  
  # Java JDBC App
  ## Introduction
  JDBC stands for Java Database Connectivity. This JDBC app uses Java API to connect and execute the query with the database. JDBC API uses JDBC driver to connect with database. By the help of JDBC API, we can save, create, update and fetch tabular data from the database.
  ## Design and Implementation
  
  
  Basic Java Application Workflow
 ![image](https://user-images.githubusercontent.com/51926543/61073755-1b747a00-a3e4-11e9-8f17-6b8c654e9579.png)
#### Service
Open a connection sends request to Data Access Object (DAO).
#### Data Access Object (DAO)
Prepares a Statement to be executed  and with the help of JDBC it will connect to the database and retrieve, insert, update and delete the relevant information.
  ## Enhancements and Issues
   #### Enhancements
  1. Use Connection Polling
  2. Use Stored Procedure
  3. Use Statement Polling
  4. Remove Auto-Commit 
  #### Issue
  5. The Docker image does not retain database information for the next time I want to work on.  
  # Twitter CLI App
  ## Introduction
  This application allows you to create, read and delete tweets on Twitter from terminal. This is similar to the postman app that uses `HTTP GET`,`HTTP POST`  to get information is JSON String . Twitter CLI app has three main features that user uses most of the time in real world. 
  ## Usage
  1. `Show Tweet`
 
  Lookup a tweet by ID and print the tweet object in JSON format. To run this application pass in the following arguments `TwitterCLI show tweet_id [field1,fields2]` if the fields are empty then display all all fields in JSON document. For example: `TwitterCLI show 210462857140252672 null`
  
  2. `Delete Tweets`
	
	 Delete a list of tweets by id and output the deleted tweet object in JSON format. To run this application pass in the following arguments ` TwitterCLI delete tweet_ids` a comma- separated list of tweets ids. For example: ` TwitterCLI delete (210462857140252672, 210462857140252672)`
	 
3.   `Post Tweet`

Create a tweet with a geotag and output the created tweet object in JSON format. To run this application pass in the following arguments ` TwitterCLI post "tweet_text" "latitude:longitude"`

## Design and Implementation
  Twitter Application Workflow
  ![image](https://user-images.githubusercontent.com/51926543/61077272-07347b00-a3ec-11e9-91b2-7b22d6aa5388.png)

1. `HttpHelper` 
Making HTTP request `GET/PUT/DELETE` and handle authentication

2. `TwitterRestDAO`
Data Access Object Which handles tweet object. `DAO` depends on `HttpHelper`

3. `Twitter Service`
Manipulate twitter object according to application requirement. This component is knows as Business logic.

4. `TwitterCLIRunner`
Parse user CLI inputs and then calls the corresponding service methods.

5. `TwitterCLI (Main)`
Create above components and start applications.
  ## Enhancements 
  1. Allow multiple user to reuse this code with their credential to post, delete and show tweet.
  2. Support search History.
  3.  Print out user define selected field from Tweet Object.


<!--stackedit_data:
eyJoaXN0b3J5IjpbMTAxNzExMDk2Niw1MzYwOTQ2MSwtNjQ3Mj
k0OTk2LC0xNjAxMDU2ODY4LC0xNzY0NTI4NzYsLTczNDQ2OTQy
MiwxNTg3ODE1OTYxLC0xODQ0NzUzNDIyLC01Mzg0NTk0NDgsLT
E2NjI5MzM1Miw3NjU5MDE3OTAsMTUwNjc4Mjc0MiwtNjgzMDIz
MzIsLTIwMTk1MjU0NDQsOTI2OTA0NzkwLDEzODk4NDgyMDgsNz
kyMDI1NzQ0LDE3MzIxOTM5NTYsLTE0MDY1ODc0OTgsLTM3MTQ2
OTI2OF19
-->