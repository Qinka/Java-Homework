Bug
===

## Frequently Asked Question (FAQ)

1.  About the error like:
```
  java.io.FileNotFoundException: .ignore/data (No such file or directory)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(FileInputStream.java:195)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at PIMIOCollection.pull(PIMIOCollection.java:48)
	at PIMManager.lambda$new$2(PIMManager.java:70)
	at PIMManager.runCmd(PIMManager.java:261)
	at PIMManager.runCmd(PIMManager.java:255)
	at PIMManager.runInteraction(PIMManager.java:243)
	at PIMManager.interaction(PIMManager.java:226)
	at PIMManager.main(PIMManager.java:31)
Exception in thread "main" java.lang.NullPointerException
	at java.util.ArrayList.addAll(ArrayList.java:577)
	at PIMIOCollection.pull(PIMIOCollection.java:63)
	at PIMManager.lambda$new$2(PIMManager.java:70)
	at PIMManager.runCmd(PIMManager.java:261)
	at PIMManager.runCmd(PIMManager.java:255)
	at PIMManager.runInteraction(PIMManager.java:243)
	at PIMManager.interaction(PIMManager.java:226)
	at PIMManager.main(PIMManager.java:31)
```
or
```
java.io.FileNotFoundException: .ignore/data (No such file or directory)
	at java.io.FileOutputStream.open0(Native Method)
	at java.io.FileOutputStream.open(FileOutputStream.java:270)
	at java.io.FileOutputStream.<init>(FileOutputStream.java:213)
	at java.io.FileOutputStream.<init>(FileOutputStream.java:101)
	at java.io.FileWriter.<init>(FileWriter.java:63)
	at PIMIOCollection.push(PIMIOCollection.java:72)
	at PIMManager.lambda$new$1(PIMManager.java:54)
	at PIMManager.runCmd(PIMManager.java:261)
	at PIMManager.runCmd(PIMManager.java:255)
	at PIMManager.runInteraction(PIMManager.java:243)
	at PIMManager.interaction(PIMManager.java:226)
	at PIMManager.main(PIMManager.java:31)
```

That means the file where storage the data can not be found. 
To solve such problems, you need run `make fix-1`.
