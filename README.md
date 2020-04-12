# cityHeist
Java Game based on the LEGO:City Heist Board Game (https://www.amazon.com/LEGO-Games-City-Alarm-3865/dp/B005VPRCPU), made by https://github.com/Swiindle

## Rational for this project:
This game is a small project used to incorporte as many O-O concepts from programming class as possible. I started working on the game July of 2019 after my First Year of University, and finished it after my Second Year.

At this point in my O-O understanding career, I have been taught about the following concepts: 

*"Java types, Inheritance, polymorphism, interfaces, method overriding, object class, Enumerations, object references, abstract classes, deep and shallow copy, access control, mutability, class variables and methods, inner classes, packages, class factories, reflection, generics, collections, recursion..."*

Not everything has been implemented yet, but as with every not programming project, not everything should.

## How to play the game?

The goal for the Robbers is to rob all the Buildings. They can do this by landing on the coins adjacent to the building.

The goal for the Cops is to catch all the Robbers before they can do that.

In order for the Robbers/Cop pieces to move around, a six-sided dice is used to inform a player how many tiles awway they can move.

You can only move one piece per turn, with the Cops and Robbers alternating. Robbers start first.

## Things missing from the original game:

I consider that the game in its current state is **playable**, but it's not completed yet. Here are some of the features that are missing from the board game edition.

- More board game space to move the pieces around
- A jail that will house all the captured robbers. Robbers landing adjacent will release all of the robbers back into the game!
- Subway tiles that allow the pieces to teleport around the map
- A dice that is used to determine how much money the robbers can get + whether a helicopter can be called in
- A helicopter that protects buildings, which the cops get to use.

## Things still need to be implemented into the game:

- Better graphics
- Better ui
- Exceptions
- Packages
- .jar file for easier execution
- Menu options for navigating through the game
- Class inheritence restructuring (I want it so that classes extending/inheriting the Abstract and Interfaces I provided can easily be part of the game as well, currently on instances of Cops and Robbers work :( )
