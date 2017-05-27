Operation
===

This part is about the operation for this application.


# CLI


## Connection

Before you use this application, GUI especially. There are three backend: file, database, and http server.

For CLI, you can just run the `make run` to launch the application for `io` is the default choose.
The following is the snapshot of the command.

```bash
make run # with the io(default) and the file localed in .ignore/data(default)
make run ARGS='io' # with the io and the file localed in .ignore/data
make run ARGS='io path/to/file' # with io and the file localed in path/to/file
make run ARGS='db' # with database and the remote dataabase is jdbc:postgresql://api.qinka.pro:54321/postgres(default)
make run ARGS='db jdbc:postgresql://url.to/database' # with database and the remote dataabase is jdbc:postgresql://url.to/database
make run ARGS='http' # with http and the remote base-url is https://api.qinka.pro/pim(default)
make run ARGS='http http://url.to/pim' # with http and the remote base-url is http://url.to/pim
```

### IO

When using file to store datas, you need to set the first param to `io`. If you don't want
to use the `.ignore/data` as the default location where store datas, you can set the second param to the path of the file where you want to store.

### HTTP
 
When using http backend to store datas, you need to set first param to `http`.
If you don't want to use the `https://api.qinka.pro/pim` as the default apis
to store the datas, you can set the second param to url which you want to use.

### Database

When using database to store datas, you need to set first param to `db`.
If you don't want to use the `jdbc:postgresql://api.qinka.pro:54321/postgres`
as the default database, you can set the second param to the connection string to your owner.


## Create

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

## List

Type in the command `list` to show the list of items.

```
--- Enter a command (supported commands are quit save load list create) ---
list
There are 4 items
Item 1: TODO URGENT 2017-01-01
	Star this repo
Item 2: NOTE URGENT
	 Ha ha ha ha!
Item 3: CONTACT URGENT
	 Name: a b
	 EMail: a@b.c
Item 4: APPOINTMENT URGENT 2018-01-01
	 Hi
```

## Save & Load

Type in the `save` or `load`, and then the application will synchronizate the items

# GUI

For gui, when you launch the application, the first window displayed is the connect-window, where you need to choose the place to store the datas.

You need to type your name into the field `Your name`. The URI where
store the datas, need to be typed into field `Connection Param`.
If you using database, you need to fill your name and password to database.

After you success to launch this application, then you can operate this application.

## ``Month''

In the window, the buttons on either hand of "year" and "month" are the button to jump to the next month or the previous month.

## Synchronization

When the application launched, application will synchronizate automatically. If you want to push the new 
items to or pull its from the remote of file, you can click the menu `remote -> save` and `remote -> load`.

## List

The todo items and appointment items will be display on the list of each day automatically, but notes and contacts will not. If you want to list them, you need to click the menu `operation -> list`.

## Detail

If you want to know the detail of each item, just click them, and the detail will be displayed in a small dialog.

## Create 

Click `operation -> create`, and create a new item. You just need to fill the fields and click the OK.

## Other Operations

* `PIM -> disconnection` Disconnect the current "link", but without quiting.
* `PIM -> quit` Quit the application.