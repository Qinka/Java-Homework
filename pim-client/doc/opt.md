Operation
===

This part is about the operation for this application.

# Connection

Before you use this application, GUI especially. There are three backend: file, database, and http server.

## CLI

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
to use the `.ignore/data` as the default location where store datas, you can set the second param to the path of where you want to store.