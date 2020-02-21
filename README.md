# SportSquares

This application that I made is based of the Super Bowl Squares. Basically, you would pick certain squares on a 10x10 board and random numbers are distributed from the top row and left column.
When you watch the Super Bowl, prizes could be given out if at the end of a quarter, half or game if a square matches up with a particualar score on the 1s digit.
For example, if team 1 had a score of 20 and team 2 had a score of 17, the person who had the square of 0 on team 1's row and 7 on team 2's column would be the winner.

Since choosing squares can be hard, why not have a program do it? 

## How to run this program
1. You must have **JDK 13.0.1** or higher in order to run this. Also make sure your **JAVA_HOME** enviroment variable is up to date.
2. This program uses Gradle as the build automator. If you don't have Gradle, you can download it for free [right here](https://gradle.org/)
3. Inside where you have placed the contents, use a terminal or command line prompt to go to that directory. You can then type in `gradle clean` and `gradle build`.
4. You can run the program from there by using `gradle run`. If you want a distribution copy, go to *build/distributions* and choose either the *.tar* or *.zip*
5. If using the distribution, you can run the batch file or the unix executable located in the *bin* of the distribution.


## Future Plans
1. Color design using css
2. The ability to print out the squares.
3. Highlight squares that have winners. 
