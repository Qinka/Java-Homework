Build
===

## Prepair

Before build this system, you need to setup google's gson(*) for JSON serialization. However, the JDK is necessary, whose version need be not lower than 1.8, because of using lambda expression.

For the building tool, I just use the GNU-make, but if you want to do that, you can use other tools for build,
or just using your hands.

 (*) When you using GNU-make, my `makefile` will automatically download gson's jar file with wget.

## Make

If you using GNU-make, what you need to do is just typing in `make` and the files will be compiled under the control of the Makefile.

If you do not want to using make, you need to find out a way to compile all the java source files.

The output adn input might look like this:

```
$ make
javac -encoding utf8 -cp ".:gson-2.8.0.jar" IPIMDateable.java
javac -encoding utf8 -cp ".:gson-2.8.0.jar" PIMAppointment.java
javac -encoding utf8 -cp ".:gson-2.8.0.jar" PIMBaseCollection.java
javac -encoding utf8 -cp ".:gson-2.8.0.jar" PIMCollection.java
javac -encoding utf8 -cp ".:gson-2.8.0.jar" PIMEntityIC.java
javac -encoding utf8 -cp ".:gson-2.8.0.jar" PIMIOCollection.java
javac -encoding utf8 -cp ".:gson-2.8.0.jar" PIMManager.java
Note: PIMManager.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
```

## Launch

When you need to launch this system. The normal way of that is just typing in `make run ARGS=PIMManager`.
And you can also run with `java -cp ".:gson-2.8.0.jar" PIMManager`, or even `java PIMManager`.

## For Windows

The above are might not available for the Windows, because of the differences between Windows and *nix.
The known issue for Windows is that Windows is using ';' to split each item in the `PATH`, but *nix using ':'.
To solve this problem, you need add `PATH_SPILT=';'` when using (msys2 or mingw) make on Windows.

For example:
```
make PATH_SPILT=';'
make run ARGS=PIMManager PATH_SPILT=';'
```