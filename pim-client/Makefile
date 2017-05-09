PATH_SPILT=:
GSON_VERSION=2.8.0
GSON_JAR=gson-$(GSON_VERSION).jar
PGJDBC_VERSION=42.1.1
PGJDBC_JAR=postgresql-$(PGJDBC_VERSION).jar
MIGLAYOUT_VERSION=4.0
MIGLAYOUT_JAR=miglayout-$(MIGLAYOUT_VERSION)-swing.jar
JARS=$(PATH_SPILT)$(GSON_JAR)$(PATH_SPILT)$(PGJDBC_JAR)$(PATH_SPILT)$(MIGLAYOUT_JAR)
SOURCE_DIR=./src

all:    src/pro/qinka/pim/PIMManager.class \
	src/pro/qinka/pim/collection/PIMBaseCollection.class \
	src/pro/qinka/pim/collection/PIMCollection.class \
	src/pro/qinka/pim/collection/PIMCollectionStored.class \
	src/pro/qinka/pim/collection/db/PIMDBCollection.class \
	src/pro/qinka/pim/collection/db/SQLStatementProvider.class \
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

%.class: %.java $(GSON_JAR) $(PGJDBC_JAR) $(MIGLAYOUT_JAR)
	javac -g -encoding utf8 -cp "$(SOURCE_DIR)$(JARS)" $<

clean:
	@find . | grep -E '*.class' | awk "{print \"rm -rf \'\"\$$0\"\'\"}" | sh
deepclean: clean
	@find . | grep -E '*/'$(PGJDBC_JAR) | awk '{print "rm -rf "$0}' | sh
	@find . | grep -E '*/'$(PGJDBC_JAR) | awk '{print "rm -rf "$0}' | sh

run: $(GSON_JAR) all
	java -cp '$(SOURCE_DIR)$(JARS)' pro.qinka.pim.PIMManager $(ARGS)

debug: (GSON_JAR) all
	jdb -classpath '$(SOURCE_DIR)$(JARS)' $(ARGS)


$(GSON_JAR):
	@wget http://repo1.maven.org/maven2/com/google/code/gson/gson/$(GSON_VERSION)/$(GSON_JAR)

$(PGJDBC_JAR):
	@wget https://jdbc.postgresql.org/download/$(PGJDBC_JAR) 

$(MIGLAYOUT_JAR):
			@wget http://www.migcalendar.com/miglayout/versions/$(MIGLAYOUT_VERSION)/$(MIGLAYOUT_JAR)


fix-1:
	mkdir -p .ignore
	touch .ignore/data
	echo [] > .ignore/data
