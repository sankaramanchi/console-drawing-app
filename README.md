# Console Drawing Application

You're given the task of writing a simple console version of a drawing program.
At this time, the functionality of the program is quite limited but this might change in the future.

In a nutshell, the program should work as follows:
- Create a new canvas
- Start drawing on the canvas by issuing various commands
- Quit

## Commands

| COMMAND | DESCRIPTION |
| ------ | ------ |
| C w h | Should create a new canvas of width w and height h. |
| L x1 y1 x2 y2 | Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character. |
| R x1 y1 x2 y2 | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character. |
| B x y c | Should fill the entire area connected to (x,y) with "colour" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs. |
| Q | Should quit the program. |

## Sample I/O

Below is a sample run of the program. User input is prefixed with enter command:

```sh
enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
```

```sh
enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------
```

```sh
enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------
```

```sh
enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------
```

```sh
enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------
```

```sh
enter command: Q
exit from the application
```

## Features

- Commands are case insensitive. Can use lower/upper letters

## Tech

- [Maven] - Simple maven project
- [Java 1.8] - Used java for logic build

## Installation

Setup project as maven project in your favourite IDE. Or download zip file and do maven build

```sh
mvn clean install package
```

Jar file "console-drawing-app-1.0.0.jar" will be created in target folder
Navigate to the target folder and run below command to start using application

```sh
java -jar console-drawing-app-1.0.0.jar
```

## License

MIT
