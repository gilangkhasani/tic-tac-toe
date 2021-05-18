# Tic Tac Toe

A simple web app to play Tic Tac Toe against a dummy computer opponent.
 
## Features & Notes:
* Play a game of Tic Tac Toe on a custom row column board based on path variable / URI Segments.
* Start a new game at any time with an option to go first or after the computer opponent.
* Computer opponent's AI is simple and chooses squares at random (except when going first, then center tile is always picked).
* Game data persists to user's http session.
* For sake of simplicity web app does not come with a test suite or ability to persist data to a database.
* App has been designed to render each time through a full page refresh (also in the name of simplicity).
* Player can leave the game and come back later to finish it (as long as his session persists).

## Tech Stack:
* Language: Java 8
* Framework: Spring Boot
* UI Layer: HTML, CSS, Javascript, jQuery, Bootstrap, [Thymeleaf](http://www.thymeleaf.org/) (Java Template Engine)
* Build Tool: Maven

## Install & Run:
* Install Java 11.
* Install Maven 3
* git clone https://github.com/randomvlad/TicTacToe.git
* Make sure your host file is configured for localhost. Example: map IP 127.0.0.1 to localhost.
* Run with mvn spring-boot:run
* Once Maven has finished and is running, go to [http://localhost:8080/tictactoe/3](http://localhost:8080/tictactoe/3) and play a game with 3x3.
* To terminate mvn spring-boot:run, kill process with CTRL + C. 
