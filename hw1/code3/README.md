Book, Course, & Student
===

(Version 0.1.0.20)

These class are about book, course, and student.
These three class are to perform simple course-selecting system.

## Usage

Input the the student id and the course(s) you want to select, and then it will output the information about your selects.

E.G.:

```shell
$ java Course 14130140331 Haskell
14130140331 choose Haskell
$ java Course 14130140331 Microservices 'Haskell High Performance Programming'
14130140331 choose Microservices, and Haskell High Performance Programming
$ java Course 14130140331
14130140331 do not choose anything
```

## Build

With GNU-make, there we can do build and clean.

### Make

To build the single class, the command you need is `make xx.class`.

For example, if you want to build `class Book`:

```shell
$ make Book.class
javac Book.java
```

**WARNING:** ***It is useless to build the single class.***

### Clean

Using `make clean` can delete the class files.

## Class

The details for the classes, refer to Report1.tex (or Report1.pdf).
