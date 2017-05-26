PATH_SPILT=:
GSON_VERSION=2.8.0
GSON_JAR=gson-$(GSON_VERSION).jar
PGJDBC_VERSION=42.1.1
PGJDBC_JAR=postgresql-$(PGJDBC_VERSION).jar
MIGLAYOUT_VERSION=4.0
MIGLAYOUT_JAR=miglayout-$(MIGLAYOUT_VERSION)-swing.jar
JARS=$(PATH_SPILT)$(GSON_JAR)$(PATH_SPILT)$(PGJDBC_JAR)$(PATH_SPILT)$(MIGLAYOUT_JAR)
SOURCE_DIR=./src

all: cli entity collection collection-io collection-http collection-db gui

cli-only: cli entity collection collection-io collection-http collection-db

cli: \
	src/pro/qinka/pim/PIMManager.class

entity: \
	src/pro/qinka/pim/entity/IPIMDateable.class \
	src/pro/qinka/pim/entity/PIMAppointment.class \
	src/pro/qinka/pim/entity/PIMContact.class \
	src/pro/qinka/pim/entity/PIMDateable.class \
	src/pro/qinka/pim/entity/PIMEntity.class \
	src/pro/qinka/pim/entity/PIMEntityIC.class \
	src/pro/qinka/pim/entity/PIMNote.class \
	src/pro/qinka/pim/entity/PIMTodo.class

collection: \
	src/pro/qinka/pim/collection/PIMBaseCollection.class \
	src/pro/qinka/pim/collection/PIMCollection.class \
	src/pro/qinka/pim/collection/PIMCollectionStored.class

collection-io: \
	src/pro/qinka/pim/collection/io/PIMIOCollection.class

collection-http: \
	src/pro/qinka/pim/collection/http/PIMHTTPCollection.class
	
collection-db: \
	src/pro/qinka/pim/collection/db/PIMDBCollection.class \
	src/pro/qinka/pim/collection/db/SQLStatementProvider.class


gui: \
  src/pro/qinka/pim/PIMGUI.class \
	src/pro/qinka/pim/gui/AddItem.class \
	src/pro/qinka/pim/gui/ConnectionWindows.class \
	src/pro/qinka/pim/gui/Connector.class \
	src/pro/qinka/pim/gui/ConnectSelect.class \
	src/pro/qinka/pim/gui/DayItem.class \
	src/pro/qinka/pim/gui/MainWindows.class \
	src/pro/qinka/pim/gui/ShowItem.class


%.class: %.java $(GSON_JAR) $(PGJDBC_JAR) $(MIGLAYOUT_JAR)
	javac -g -encoding utf8 -cp "$(SOURCE_DIR)$(JARS)" $<

clean:
	@find . | grep -E '*.class' | awk "{print \"rm -rf \'\"\$$0\"\'\"}" | sh
deepclean: clean
	@find . | grep -E '*.jar' | awk "{print \"rm -rf \'\"\$$0\"\'\"}" | sh

run: $(GSON_JAR)  $(PGJDBC_JAR) $(MIGLAYOUT_JAR) cli-only
	java -cp '$(SOURCE_DIR)$(JARS)' pro.qinka.pim.PIMManager $(ARGS)

rungui: $(GSON_JAR)  $(PGJDBC_JAR) $(MIGLAYOUT_JAR) all
	java -cp '$(SOURCE_DIR)$(JARS)' pro.qinka.pim.PIMGUI $(ARGS)

debug: $(GSON_JAR) $(PGJDBC_JAR) $(MIGLAYOUT_JAR) all
	jdb -classpath '$(SOURCE_DIR)$(JARS)' $(ARGS)

runsome: $(GSON_JAR) $(PGJDBC_JAR) $(MIGLAYOUT_JAR) all
	java -cp '$(SOURCE_DIR)$(JARS)' $(ARGS)

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
