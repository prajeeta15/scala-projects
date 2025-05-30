# scala-projects
beginner to intermediate level Scala projects

## 🛠️ How to Run

### 📦 Requirements
- [Scala](https://www.scala-lang.org/download/) installed (v2.13 or v3)
- Java JDK installed (you must configure JAVA_HOME correctly)
- sbt build tool (recommended)

## check 
terminal: java --version
scala --version
![image](https://github.com/user-attachments/assets/1b89208e-f3e9-4ae6-b2cd-da70846448ef)
this is how it should look once correctly installed and system path variables edited.
if it says "scala is not recognized .." edit the system variables. 
java_home (if present or create it) -> copy the location from "where java" on cmd to be precise 
then path -> edit -> add java_home so scala can recognize the JVM
check in cmd again.


# 1. Simple Chess Game in Scala

This is a **simple console-based chess game** built in Scala to help beginners understand both **Scala programming** and **chess rules**! ♟️

Currently, this version supports:
- Pawns (`PW`, `PB`) and Kings (`KW`, `KB`)
- Turn-based movement for White and Black
- Move validation based on piece type
- Visual display of an 8x8 chessboard in the terminal

## 🎯 Why This Project?

- I'm learning to play chess
- helps with problem solving
- helps with understanding Scala functions, OOP, game logic, modelling movement.

### ▶️ Run the Game

If using **sbt**:
sbt run

If running manually:
bash
scala chess.scala

### 📋 How to Play

When the game starts:
You’ll see the board printed in the terminal
You’ll be prompted to enter a move like:
e2 e3
This moves a White Pawn from e2 to e3
Valid Input Format
Always enter moves like: e2 e4 or d7 d6
Lowercase only
No special characters


## use of each function is written within the code in comments

# 2. upcoming (twitter clone)
