Personal Information Manager System
===

# Snapshot

The personal information manager, in this homework, is a command line interface application for hold your personal informations as its name.
This system will hold the four kinds of your personal information: todo list, notes, appointment, and contacts.
PIM system will storge these informations to file(via json) or the backend. And you can wirte your own frontend interface and backend.

# Build

For your with *nix os, you need a GNU-make and a `javac`.

When you need to build, just run `make` , and the class fils will be generated.

If your os is Windows, you need run `make PATH_SPILT=';'`, because windows
is using `;` for spilt each item of the `PATH` environment.


# Usage

To using these cli-app, run `make run ARGS='pro.qinka.pim.PIMManager'`, and then the interaction will be launched.

If your os is Windows, you need run `make run ARGS='PIMManager' PATH_SPILT=';'`, because windows
is using `;` for spilt each item of the `PATH` environment.

The above command will print the real command to run the app, and if you might be able to use `make run ARGS='pro.qinka.pim.PIMManager' | sh` to run the app. 

For usage's details, you can read the documents(User's Guide) in the doc directory or just to look through [User's Guide](http://prj.qinka.pw/java-homework/pim/usersguide).

*For some reasons, the url for the guide might be http://prj.qinka.pro/java-homework/pim/userguide, and the change of domain is under process.*



# Also See

## Backend

The normal backend for this cli-app is [github:Qinka/pim-be](https://github.com/Qinka/pim-be), which is written via in Haskell.

## More

For the more informations, you need look up or through the report for this homework and the document in pim-be, which is about the api and interfaces.

## Feedback

Bug tracker: [github.com/Qinka/Java-Homework/issues](https://github.com/Qinka/Java-Homework/issues).
