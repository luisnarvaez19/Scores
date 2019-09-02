# Scores
Bowling Scores

## Errors detected in the initial file and others:

1. The file do not exist in this directory
2. The data is not good, must be two fields or the rows are not tab-separated.
3. Error in the number of pines. It cannot be greater than 10
4. Error in the number of pines. It cannot be negative
5. Only the character F is accepted. No other character
6. If a player has a problem with their data, it is entered into a blacklist so as not to process their next records.


The player is also entered in the blacklist and removed from the game, if he has subsequent problems such as
 the sum of his frame being greater than 10


## Errors during the game:

1. The player made more than 10 frames.
2. Error adding score the frame's sum is greater 10
3. The player has a lot of throws for a frame.


## Cases handled:

1. A game where all rolls are 0.
2. All rolls are fouls (F).
3. A perfect game, where all rolls are strikes.
4. Unit test made.
5. Integration test performed: 


## It was also done:

Use Java 8 streams and lambdas

## Test the program

$  java -jar ./target/Score-1.0-SNAPSHOT.jar testfile

