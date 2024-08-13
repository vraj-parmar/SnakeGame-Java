# Snake Game

A classic Snake game implemented in Java using JavaFX and Swing. This project demonstrates basic game development concepts like animation, collision detection, and user input handling.

## Features

- **Classic Snake Gameplay:** Control the snake to eat apples and grow in length.
- **Responsive Controls:** Use arrow keys to navigate the snake in different directions.
- **Game Over Screen:** A dedicated screen that shows the final score and allows restarting or quitting the game.
- **Score Tracking:** Keep track of the score based on the number of apples eaten.
- **Restart and Quit Options:** Restart the game by pressing 'R' or quit the game by pressing 'Q' on the Game Over screen.

## Classes Overview

### 1. `Apple`
- **Purpose:** Manages the position of the apple in the game and renders it on the screen.
- **Key Methods:**
  - `newApple()`: Randomly generates a new position for the apple.
  - `draw(Graphics g)`: Draws the apple on the game board.

### 2. `GameFrame`
- **Purpose:** Sets up the main game window using JFrame.
- **Key Features:**
  - Configures the game window's title, size, and behavior on closing.
  - Adds the `GamePanel` to the frame.

### 3. `GameOverScreen`
- **Purpose:** Handles the display of the game over screen, including the final score and restart/quit options.
- **Key Methods:**
  - `draw(Graphics g, int score)`: Displays the game over message, score, and options to restart or quit.

### 4. `GamePanel`
- **Purpose:** Core game panel where the gameplay occurs. Manages the game loop, rendering, and user input.
- **Key Features:**
  - Initialises the game components (`Snake`, `Apple`, `GameOverScreen`).
  - Handles game state transitions between running and game over.
  - Manages the game loop using `Timer` to control game updates.
  - Responds to user input for controlling the snake and handling game over actions.
  
### 5. `Snake`
- **Purpose:** Represents the snake in the game, handling its movement, growth, and collision detection.
- **Key Methods:**
  - `move()`: Updates the snake's position based on its direction.
  - `checkCollisions()`: Checks if the snake has collided with itself or the wall.
  - `draw(Graphics g)`: Renders the snake on the game board.

### 6. `SnakeGame`
- **Purpose:** The entry point of the game that initialises and runs the game by creating an instance of `GameFrame`.

## Installation and Running the Game

### Prerequisites
- Java Development Kit (JDK) 8 or later.
- An IDE or text editor to edit and run Java code.

### Running the Game
1. Clone the repository:
   ```bash
   git clone https://github.com/vraj-parmar/SnakeGame-Java.git
   cd SnakeGame-Java
   ```
2. Compile and run the game:
   - Using the command line:
     ```bash
     javac SnakeGame.java
     java SnakeGame
     ```
   - Or by running the `SnakeGame` class directly from your IDE.

## Controls

- **Arrow Keys:** Control the snake's direction.
- **R:** Restart the game after a game over.
- **Q:** Quit the game from the game over screen.
