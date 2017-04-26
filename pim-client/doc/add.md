Add (create)
===

This document is about how to add an item to system.

## Prepair

Before you add an item, you need to read the documents in the section *Build* and *Bug*.
The subsection *launch* in *Build* is about how to launch such system, and the subsection *FAQ* in *Bug*
is about the problems might be frequent.

## Usage

When you want to create an item, firstly, you need to type in a `create` to tell the app you want to create.

```
--- Enter a command (supported commands are quit save load list create) ---
create
```

Then you need to type in the type of the item with the hint from app.

```
Enter an item type (todo, note, contact or appointment)
todo
```

After you typed the type of the item, we need to type in the other informations with the hint from the app.

```
Enter date for item(yyyy-MM-dd):
2017-01-01
Enter priority for item:
URGENT
Enter the things to do for item:
Star this repo
Enter your name:
YOUR nAME
```

The followings are the examples for other items:

```
--- Enter a command (supported commands are quit save load list create) ---
create
Enter an item type (todo, note, contact or appointment)
note
Enter priority for item:
URGENT
Enter the note for item:
Ha ha ha ha!
Enter your name:
YOUR NaME
--- Enter a command (supported commands are quit save load list create) ---
create
Enter an item type (todo, note, contact or appointment)
contact
Enter priority for item:
URGENT
Enter the fisrt name for item:
a
Enter the last name for item:
b
Enter the email for item:
a@b.c
Enter your name:
YOUR NAmE
--- Enter a command (supported commands are quit save load list create) ---
create
Enter an item type (todo, note, contact or appointment)
appointment
Enter date for item(yyyy-MM-dd):
2018-01-01
Enter priority for item:
URGENT
Enter the your appointment for the item:
Hi
Enter your name:
YOUR NAMe
```