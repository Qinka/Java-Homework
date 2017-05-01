PATH_SPILT=:

all:    IPIMDateable.class \
	PIMAppointment.class \
	PIMBaseCollection.class \
	PIMCollection.class \
	PIMContact.class \
	PIMDateable.class \
	PIMEntity.class \
	PIMEntityIC.class \
	PIMHTTPCollection.class \
	PIMIOCollection.class \
	PIMManager.class \
	PIMNote.class \
	PIMTodo.class

GSON_VERSION=$(GSON_VERSION)

%.class: %.java gson-$(GSON_VERSION).jar
	javac -g -encoding utf8 -cp ".$(PATH_SPILT)gson-$(GSON_VERSION).jar" $<

clean:
	rm -rf *.class

run: gson-$(GSON_VERSION).jar all
	java -cp '.$(PATH_SPILT)gson-$(GSON_VERSION).jar' $(ARGS)

debug: gson-$(GSON_VERSION).jar
	jdb -classpath '.$(PATH_SPILT)gson-$(GSON_VERSION).jar' $(ARGS)


gson-$(GSON_VERSION).jar:
	@wget http://repo1.maven.org/maven2/com/google/code/gson/gson/$(GSON_VERSION)/gson-$(GSON_VERSION).jar


fix-1:
	mkdir -p .ignore
	touch .ignore/data
	echo [] > .ignore/data
