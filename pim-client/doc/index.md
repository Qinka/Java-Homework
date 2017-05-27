Personal Information Manager System User's Guide
===

This user's guide is for the version "after-final-project", and that means version 0.2.x.

## Snapshot

The Personal Information Manager has a client in command line interface, CLI for short,
and a client in graphical user interface, GUI for short. Such a system can be use to manage your person informations,
such as todo-list, appointment-list, etc.

This system will hold the four kinds of your personal information: todo list, notes, appointment, and contacts.
PIM system will storge these informations to file(via json), database or the backend. And you can wirte your own frontend interface and backend.

## Environment

Utill now, there is not any out-of-box environment. You need to build this project by yourself.

First of all, the JDK, whose version should higher than or equal to 1.8, is necessary.
This project is using lambda expression of Java 8.

For more there are three packages needed. `gson` is the Google's json serialization and deserialization package. `postgresql` is the PostgreSQL's JBDC driver. `miglayout` is the
layout-framework for swing.

And a GNU-like make and wget is also necessary.

## Content Table

*Here are the themes for user's guide*

1. [Build -- How to build this project](build.md)

2. [Operation -- Hot to operate this application](opt.md)

4. [Collection -- Storage and Backend](collection.md)

5. [Development](development.md)

7. [Feedback -- Bugs and Frequent Asked Questions](feedback.md)