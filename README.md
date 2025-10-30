# Rubik's Cube Scrambler and Visualizer

A Java application that generates random Rubik's cube scrambles and provides a visual representation of the scrambled cube state.

## Features

- Generates random scramble sequences using standard Rubik's cube notation
- Visual representation of the cube state using a 2D net layout
- Interactive UI with ability to apply scrambles
- Prevention of redundant moves (no consecutive moves on the same face)

## How to Use

1. Run the application using the `Main` class
2. A window will appear showing:
   - A randomly generated scramble sequence (20 moves)
   - A 2D representation of the cube
   - An 'Apply Scramble' button
3. Click the 'Apply Scramble' button to see how the cube would look after applying the scramble

## Cube Notation

The program uses standard Rubik's cube notation:
- U: Up face
- D: Down face
- L: Left face
- R: Right face
- F: Front face
- B: Back face
- Prime ('): Counterclockwise turn
- 2: Double turn
