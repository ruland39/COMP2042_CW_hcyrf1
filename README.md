# COMP2042_CW_hcyrf1  
Ruland Muhammad Furqan - 20312846  
2048 Game
1. Your name and student number,
2. How to compile the code to produce the application,
3. Where your Javadoc documentation is stored (the path to the directory)
4. A list of features that are implemented and are working properly,
5. A list of features that are implemented and are not working properly,
6. A list of features, if any, that are not implemented with an explanation of why they
were not implemented,
7. A list of new Java classes that you introduced for the assignment,
8. A list of Java classes that you modified from the given code base

## How to Compile and Run 2048 Game
1. Download the Source Code ZIP File by pressing the Green Code Button
2. After finish downloading, extract and open the file
3. Open your IDE of choice could be IntelliJ or Eclipse 
4. Open the project file in the IDE
5. Please download JavaFX from [here](https://gluonhq.com/products/javafx/) Or https://gluonhq.com/products/javafx/
6. Extract the JavaFX files and go back to your IDE
7. Navigate through File -> Project Structure -> Library
8. Press the plus button and add the library folder from the JavaFX files you have downloaded
9. Build the project files and go to the main.java file
10. You are good to go to play the game. Press Run and Have Fun!

## Javadoc Documentation
Javadoc Documentation is available [here](JavaDoc/com.example.demo/module-summary.html) JavaDoc/com.example.demo/module-summary.html

## Design Diagram
Design Diagram PDF is available [here](https://www.youtube.com)

## List of Features
### List of Features that are implemented and working properly
- Implemented Animation (Translation, Rotation, Scale)
- Options to play the game in 2x2, 3x3, 4x4, 5x5 Grid
- Interesting Game Mode: Reversible Arrow Mode (⬆️ = Down, ⬇️ = Up, ⬅️ = Right, ➡️ = Left)
- Additional controls using WASD
- Applied Background Music that loops infinitely
- Added Color Cycle Toggle Button that changes all the background colour to a pre-selected interesting colours
- Making window screen size adjustable (square in main menu but extends to rectangle in gameScene)
- Used custom style for text, buttons, and others using CSS
- Addition of Retry Button at EndGame to bring back to Main Menu
- Permanent HighScore List Table View

### List of Features that are implemented but not working properly
- None

### List of Features that are not implemented
- ComboBox/ChoiceBox containing all the possible combination for the cell grid e.g.2x2,3x3,4x4,5x5 and only two play buttons (One for normal game mode and One for Reversible Arrow Mode)
- Animation using transition for changing scenes
- Animation for sliding cells

## Additional Classes
- GameScene2
- GameScene3
- GameScene4
- GameScene5
- HighScore
- WriteToFile

## Modified Classes
- Account
- Cell
- Controller
- Endgame
- GameScene
- Main
- TextMaker

## Report
This software maintenance project provides understanding on how to refactoring is an essential skill a programmer/developer needs to fix bugs and extending the feature that certain project already have without starting to build the project from scratch. It also teaches us code smell and how to make a particular code to be more readable as well as using the proper naming convention in this case the Camel Case. This project gives insight on library to use in a project, in this case we are using JavaFX. This is also a good learning curve on how to build an interactive GUI that people will actually appreciate on a program. Moreover, we are also using Junit for testing methods and verifying it. The use of git and github in this project is really useful in the future so we are familiar on the environment of pushing code to github. The most challenging part of this project is working with JavaFX since this is our first time using it. However, by reading docs as well as watching tutorials on it online, I managed to get everything working and started to explore on what JavaFX has to offer. By changing the setStyle properties and using CSS, the interface and design can be altered as to our preference which I really enjoy thinkering. This project is not only important for our modules it gives us an insight on the working environment we will be having in the future.
