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
Open a connection prepare 
#### Data Access Object (DAO)
Prepares a Statement to be executed  and with the help of JDBC it would be 
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
  - What does this app do?
  ## Usage
  - explain arguments and behaviour
  - usage examples
  ## Design and Implementation
  Twitter Application Workflow
  ![image](https://user-images.githubusercontent.com/51926543/61074879-bcfccb00-a3e6-11e9-83bc-4741447efa00.png)

  ## Enhancements 
  1. Allow multiple user to reuse this code with their credential to post, delete and show tweet.
  2. Support search History.
  3.  Print out user define selected field from Tweet Object.


<!--stackedit_data:
eyJoaXN0b3J5IjpbMTMxOTQyNTM1NiwtMTY2MjkzMzUyLDc2NT
kwMTc5MCwxNTA2NzgyNzQyLC02ODMwMjMzMiwtMjAxOTUyNTQ0
NCw5MjY5MDQ3OTAsMTM4OTg0ODIwOCw3OTIwMjU3NDQsMTczMj
E5Mzk1NiwtMTQwNjU4NzQ5OCwtMzcxNDY5MjY4LC0xNDU2Mjkx
OTk2LDY0OTQ4MjUxNywtMTI2NzkzMjQwNCwtMTA4OTIzMzMxMC
wxMjUyMTY2ODExLC02MDc3NDkzMjUsLTE5OTkzOTY2NzUsMTI1
NzQ3NDA2OF19
-->