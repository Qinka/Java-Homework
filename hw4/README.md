Cal
===

Cal is a GUI application where can evaluate the simple computing.

## Build

Run `make` with a GNU-like make tool, and then the Caj will be compiled. The swing-gui layout-framework `miglayout` is needed;
meanwhile if the miglayout is missing, it will be download automatically according to the rules in the `Makefile`.

## Usage

If you want to launch it, run `make run` directly, even without building.
Afer the window launch, you can do what you want.

For example, if you want to compute `(1+2)*(3+4)`, you need to click `1`, `+`, `2`, and `=` in order, and get 3.
Then click  `CLR`, `3`, `+`, `4`, and `=` in order, and get 7. Final, click `+`, `3`, and `=`, and then get 21.