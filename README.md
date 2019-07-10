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
  You can talk about the following points
  - Ps eudo code and workflow
  - Libraries
  - Diagrams
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
  This application allows you to create, read and delete tweets on Twitter from terminal. This is similar to the postman app that uses `HTTP GET`,`HTTP POST`  to get information is JSON String with limited feature. 
  - What does this app do?
  ## Usage
  - explain arguments and behaviour
  - usage examples
  ## Design and Implementation
  You can talk about the following points
  - Pseudo code and workflow
  - Libraries
  - Diagrams
  ## Enhancements and Issues
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTIxMDE5ODU0NywtMTI2NzkzMjQwNCwtMT
A4OTIzMzMxMCwxMjUyMTY2ODExLC02MDc3NDkzMjUsLTE5OTkz
OTY2NzUsMTI1NzQ3NDA2OCwtMTAzNDU2ODI2NiwtOTI0MTE4OT
QzLC0xODAwMDc2ODU2LC0xMDc1NDI5NDYxLC0yMDIwMDkxOTI5
LC0xNzQyMjE1MDY5LC01Mjg4NTQzMTAsMTk2OTYxNjYyMCwxNT
c3MTA3NTkyLDkxNTgxNjc3NiwtMjA2NDg2NTQ1MiwtMTU5Nzcx
MjExMywtMTk3NjE4MjUzMl19
-->