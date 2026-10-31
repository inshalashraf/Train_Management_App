# Train Management App

A Java console application for managing an ordered train consist using the Java Collections Framework and `LinkedList`.

## Features

- Display all bogies in their current order
- Add a bogie at the front or rear
- Insert a bogie at a chosen zero-based position
- Remove the first or last bogie
- Search for a bogie by ID
- Remove a bogie by ID
- Validate blank IDs, duplicate IDs, invalid positions and empty-train removals
- Run automated tests without third-party libraries

## Tech Stack

- Java 17
- `LinkedList` and the `List` interface
- Java standard library
- GitHub Actions for continuous integration

## Project Structure

```text
Train_Management_App/
├── .github/workflows/java-tests.yml
├── Train_App/
│   ├── src/
│   │   ├── TrainConsist.java
│   │   └── TrainManagementApp.java
│   └── test/
│       └── TrainConsistTest.java
├── .gitignore
└── README.md
```

## Run the application

From the repository root:

```bash
mkdir -p build
javac -d build Train_App/src/TrainConsist.java Train_App/src/TrainManagementApp.java
java -cp build TrainManagementApp
```

The application starts with three sample bogies. Use the numbered menu to manage the consist.

## Run the tests

```bash
mkdir -p build
javac -d build Train_App/src/TrainConsist.java Train_App/test/TrainConsistTest.java
java -cp build TrainConsistTest
```

The test runner checks insertion, removal, searching, duplicate and blank IDs, invalid positions, and empty-list behavior.

## Data Structure Notes

The application uses a `LinkedList` to preserve bogie order. Adding or removing at either end is efficient. Insertion or searching by position/ID requires traversal.

## Scope

This project focuses on train-consist and bogie management. It is an educational console application, not a railway reservation or ticketing system.
