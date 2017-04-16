PATH_SPILT=:

all:    IPIMDateable.class \
	PIMAppointment.class \
	PIMBaseCollection.class \
	PIMCollection.class \
	PIMContact.class \
	PIMDateable.class \
	PIMEntity.class \
	PIMEntityIC.class \
	PIMIOCollection.class \
	PIMManager.class \
	PIMNote.class \
	PIMTodo.class

%.class: %.java gson-2.8.0.jar
	javac -encoding utf8 -cp ".$(PATH_SPILT)gson-2.8.0.jar" $<

clean:
	rm -rf *.class

run: gson-2.8.0.jar
	@echo "java -cp '.$(PATH_SPILT)gson-2.8.0.jar'" $(ARGS)
test: Main.class gson-2.8.0.jar
	java -cp .$(PATH_SPILT)gson-2.8.0.jar Main


gson-2.8.0.jar:
	@wget http://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.0/gson-2.8.0.jar
