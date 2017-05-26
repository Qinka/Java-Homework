Build
===

## Prepair

Just like what index page written, before build this system,
you need to setup google's gson(*) for JSON serialization,
postgresql's driver for JDBC,
miglayout for swing. 
However, the JDK is necessary, whose version need be not lower than 1.8, because of using lambda expression.

For the building tool, I just use the GNU-make, but if you want to do that, you can use other tools for build,
or just using your hands.

> (*) When you using GNU-like make, the rules in my `Makefile` will automatically download the dependent jar packages files with wget.

## Make

If you using GNU-like make, what you need to do is just typing in `make` and the files will be compiled under the control of the Makefile.

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

If you want to just compile the CLI one, you can use `make cli-only` to build it.

## Launch

When you want to launch the GUI or the CLI application, you can type into your terminal with
`make run` or `make rungui`, for GUI. These two command can be execute directly, beacuse with the rules, the sources will be automatically build.

## For Windows

The above are might not available for the Windows, because of the differences between Windows and *nix.
The known issue for Windows is that Windows is using ';' to split each item in the `PATH`, but *nix using ':'.
To solve this problem, you need add `PATH_SPILT=';'` when using (msys2 or mingw) make on Windows.

For example:
```
make PATH_SPILT=';'
make run ARGS=PIMManager PATH_SPILT=';'
```