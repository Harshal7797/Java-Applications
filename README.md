# Java Grep App
  ## Introduction
  This app try to mimic Unix command called `grep` which stands for `global regular expression print`.This app searches for the text pattern or regular expression recursively in the given given directory and output the matched  lines to a temp file.
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
  1. 
  # Java JDBC App
  ## Introduction
  - What does this app do?
  ## Usage
  - explain arguments and behaviour
  - usage examples
  ## Design and Implementation
  You can talk about the following points
  - Ps eudo code and workflow
  - Libraries
  - Diagrams
  ## Enhancements and Issues
  # Twitter CLI App
  ## Introduction
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
eyJoaXN0b3J5IjpbLTE0ODAzMTAyNTQsMTU3NzEwNzU5Miw5MT
U4MTY3NzYsLTIwNjQ4NjU0NTIsLTE1OTc3MTIxMTMsLTE5NzYx
ODI1MzIsLTEyMzA5MzU0MTMsMjc0NjkwMzYwLDE4MDk5MTYxOT
gsMTA1MTAwMzExMF19
-->