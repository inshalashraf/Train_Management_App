# Train Management App

A Java console application for practicing train-consist management using standard collection data structures.

## Features

- Maintains an ordered train consist
- Inserts a bogie at a specific position
- Removes the front and rear bogies
- Displays the state of the consist after each operation

## Tech Stack

- Java
- Java Collections Framework
- `LinkedList`

## Project Structure

```text
Train_Management_App/
├── Train_App/
│   └── src/
│       ├── TrainManagementApp.java   # Main application
│       └── uc1.java                  # Original use-case implementation
├── .gitignore
└── README.md
```

## Run

From `Train_App/src`:

```bash
javac TrainManagementApp.java
java TrainManagementApp
```

## Example Flow

1. Create an ordered consist containing three bogies.
2. Insert `Bogie-1A` at position 1.
3. Remove the first and last bogies.
4. Print the final consist.

## Learning Goal

This project demonstrates practical use of Java's `List` interface and `LinkedList` implementation for ordered data that changes through insertion and removal operations.

## Status

The project is currently a console-based learning application. Future use cases can add train search, passenger booking, cancellation, seat management, and persistent storage.
