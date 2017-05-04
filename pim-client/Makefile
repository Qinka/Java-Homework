PATH_SPILT=:
GSON_VERSION=2.8.0
SOURCE_DIR=./src

all:    src/pro/qinka/pim/PIMManager.class \
	src/pro/qinka/pim/collection/PIMBaseCollection.class \
	src/pro/qinka/pim/collection/PIMCollection.class \
	src/pro/qinka/pim/collection/PIMCollectionStored.class \
	src/pro/qinka/pim/collection/http/PIMHTTPCollection.class \
	src/pro/qinka/pim/collection/io/PIMIOCollection.class \
	src/pro/qinka/pim/entity/IPIMDateable.class \
	src/pro/qinka/pim/entity/PIMAppointment.class \
	src/pro/qinka/pim/entity/PIMContact.class \
	src/pro/qinka/pim/entity/PIMDateable.class \
	src/pro/qinka/pim/entity/PIMEntity.class \
	src/pro/qinka/pim/entity/PIMEntityIC.class \
	src/pro/qinka/pim/entity/PIMNote.class \
	src/pro/qinka/pim/entity/PIMTodo.class

%.class: %.java gson-$(GSON_VERSION).jar
	javac -g -encoding utf8 -cp "$(SOURCE_DIR)$(PATH_SPILT)gson-$(GSON_VERSION).jar" $<

clean:
	@find . | grep -E '*.class' | awk '{print "rm -rf "$0}' | sh

run: gson-$(GSON_VERSION).jar all
	java -cp '$(SOURCE_DIR)$(PATH_SPILT)gson-$(GSON_VERSION).jar' $(ARGS)

debug: gson-$(GSON_VERSION).jar
	jdb -classpath '$(SOURCE_DIR)$(PATH_SPILT)gson-$(GSON_VERSION).jar' $(ARGS)


gson-$(GSON_VERSION).jar:
	@wget http://repo1.maven.org/maven2/com/google/code/gson/gson/$(GSON_VERSION)/gson-$(GSON_VERSION).jar


fix-1:
	mkdir -p .ignore
	touch .ignore/data
	echo [] > .ignore/data
