# Lab 2 
CS401: Variables and Control Structures

## Build

### Maven
Project builds are configured via [Maven](https://maven.apache.org).
Eclipse can also be used to run this project.

To build, run 
```
 mvn package
```

## Usage

This lab contains 3 individual problems. Instructions for each are as follows.

### Calories
To run
```
mvn exec:java@calorie
```

### Mad Libs
To run
```
mvn exec:java@madlib
```

### Monopoly ATM
To run
```
mvn exec:java@monopoly
```
_You will need an X server in order to run this program, as_ `JOptionPane` 
_is used for input._
