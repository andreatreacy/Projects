# Music Visualiser Project

Name: Andrea Treacy

Student Number: C19718305

# Note
THIS PROJECT IS NOT COMPLETE ON GITHUB. The file was too big to store. This is just to show my code but it will not work if it is downloaded without the additional files. You can view the program working properly in this YouTube video:
[![YouTube](http://img.youtube.com/vi/pAm0JFgpbM0/0.jpg)](https://www.youtube.com/watch?v=pAm0JFgpbM0)

# Description of the assignment
My assignment contains both a game and a visual. A menu displays when it starts where you can choose from the two options. The fill colour changes on the play icons when the mouse hovers over them. 
The game contains a bunker at the bottom of the screen and three bombs and a health pack at the top of the screen that start descending when the game starts. The objective of the game is to shot the bombs and catch the health pack before they hit the bunker. The mouse is used to aim and click on the object as it is falling to shoot/catch them. The player's score and health is altered when you hit a bomb, catch a health pack, or when a bomb hits the bunker. The bombs and health pack respawn at the top of the screen when the player hits them or when they hit the bunker. The game ends when the bunker is destroyed and the player's score is displayed with a "Game Over" message.

The visual consists of 8 different visuals:
1. A spiral that responds to music.
2. A space scene containing a sound wave that responds to music, planets that rotate in place and pulse with the music, planets that rotate, and stars. The planets have a colour fill and a different colour outline to make them look more 3D. The stars are randomly placed to recreate a space scene.
3. Four circles that start at size 0 then rapidly increase in size, and then return to 0 and start growing again. This gives the illusion of forward movement.
4. A scene containing two tall speakers that pulse with the music, and multi-coloured music symbols flying around them. If the music symbols go outside the boundary of the screen size they respawn in a random location within the screen.
5. A scene that contains a brightly coloured sound wave that responds to music and a multi-layered sphere centred in the middle of it. The sphere rotates in place, flashes different colours, and pulses with the music.
6. Flashing text that corresponds to the lyrics playing at the time.
7. A scene that contains dancing cubes. There can be 1, 2, or 4 cubes displayed at a time depending on the timing. Each cube contains three layers of pink, red, and yellow.
8. A scene containing a stick man who's eyes pulse with the music. His feet tap, and coloured light beams from his hands. These beams are responsive to the music.

There is a timer in place that counts the number of seconds that have passed. At different times different visuals are displayed.

# Instructions
When the program runs it displays a menu. You can choose to play game or play visual. Position the mouse over the play icon for the option you want to pick and left click on it to select it. 
If you choose to play game, the game will start immediately. You start of with a score of 0 and 30 health. There is a bunker at the bottom of the screen and three bombs and a health pack will descend from the top of the screen. The mouse has a target drawn around it so you can aim at the falling items. You need to shoot the bombs and catch the health pack before they fall on the bunker. This can be done by aiming at the item and left clicking the mouse. If you successfully hit a bomb your score is increased by 10 and the bomb respawns at the top of the screen. If you successfully catch a health pack, the bunker's health is increased by 10 and the health pack respawns at the top of the screen. If a bomb descends low enough to hit the bunker, the bunker's health decreases by 10 and the bomb will respawn at the top of the screen. If a health pack descends low enough to hit the bunker, it will respawn at the top of the screen.
The game will continue until the bunker's health is at 0. A "Game Over" message will appear along with your score.
Press 0 to return to the menu. You can play again by selecting play game or click on play visual to view the visual. If you select the visual it does not require any user input, although you can pause the visual by using the space bar. (Warning: Pausing may disrupt the sync of the visuals).

# How it works
The visuals are accessed through a switch statement. I have a variable called which that stores the value of the case to be displayed at any time. Case 0 is accessed when the program runs first to display the menu. The user must click inside the play icon of their choice to start. The mouseClicked method is used to know which option the user picked and the value of which is changed accordingly. This also determines which audio file is loaded as the game and visual use different audio tracks.

## Game
During setup a Game object, a Health object, and three Bomb objects are created. The three Bomb objects are stored in an ArrayList. The Game object stores the score which starts at 0 and health which starts at 30. The Bomb and Health classes implement the GameStats class which is an interface class. GameStats contains a method called updateStats that is to be used to update the player's health in the Game object. This method is implemented in both the Bomb and Health class. The Bomb and Health class also have methods to render the objects to the screen, update the objects position on the screen, and respawn the object after it is hit or it reaches it's destination.
When the user starts the game case 9 is accessed and the objects are rendered to the screen. The bombs and health pack start at the top of the screen in a random x position and move down towards the bunker at the bottom by increasing their y value. There is a target drawn around the mouse which is used to aim at an object and shoot with the left click. In the mouseClicked method dist() is used to check if the mouse is in range of the object for it to be considered a hit. If the object is hit it respawns at the top of the screen in a random x position. Score or health are increased depending on the object hit.
When an object reaches the bunker it respawns at the top of the screen in a random x position. When the value of the player's health needs to be changed when a bomb hits the bunker or when the user catches a health pack the updateStats method is used to change it.

## Visual
During setup 100 Star objects are added to an ArrayList for case 2 (space scene) and 20 MusicSymbol objects are added to an ArrayList for case 4 (speaker scene). They will be rendered when their case is selected.
I have a class called StopWatch that uses System.currentTimeMillis() to keep track of the time passed since the visual started playing. This is accessed with the timer object. The time is checked every time the draw method runs to chick which visual should be displayed and it changes the value of which to the correct value.
When the draw method runs it calculates a learped average from the elements in the audio buffer. This is used to make the visuals respond to the music.
I used an abstract class called Shape which has variables for x, y and size as the classes that extend this class need these variables. Shape also has an abstract method called render. All classes that extend Shape must implement this method. Shape is extended by the Sphere, Cube, and MusicSymbol classes in order to access the method and variables associated with it.
For case 7 (dancing cubes) I have a variable called numCubes that is used to determine how many cubes are displayed 1, 2 or 4. The timer changes this value depending on what type of visual needs to be displayed.
For case 8 (stick man) I have a boolean variable called tap that is used to make the stick man tap his feet. The value of tap is changed by checking the timer. The value changes between true (feet are drawn flat) and false (feet are drawn raised).

# What I am most proud of in the assignment
I am proud of how my visuals turned out. They all look the way I wanted them to look and they respond well to the music I chose.
I was very happy with how my StopWatch class worked. Getting the visuals to display at the right time was essential and the StopWatch class made that possible.
I was also happy with how creating separate classes for drawing objects cut down on the amount of code needed in my assignment class. The inheritance also made it a lot easier to create objects without using so much code.
I also like how the game turned out. It is fun, it does what I wanted it to do, and it keeps track of the score and health accurately.


