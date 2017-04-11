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

%.class: %.java
	javac -cp .:gson-2.8.0.jar $<

clean:
	rm -rf *.class

run:
	@echo "java -cp .:gson-2.8.0.jar" $(ARGS)
test: Main.class
	java -cp .:gson-2.8.0.jar Main
