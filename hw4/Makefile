PATH_SPILT=:
MIGLAYOUT_VERSION=4.0
MIGLAYOUT_JAR=miglayout-$(MIGLAYOUT_VERSION)-swing.jar
SOURCE_DIR=./

all:	Cal.class \
	CalWindows.class

run: 	all
	@java -cp "$(SOURCE_DIR)$(PATH_SPILT)$(MIGLAYOUT_JAR)" Cal $(RUN_ARGS)

%.class: %.java $(MIGLAYOUT_JAR)
	javac -g -encoding utf8 -cp "$(SOURCE_DIR)$(PATH_SPILT)$(MIGLAYOUT_JAR)" $<

clean:
	@find . | grep -E '*.class' | awk "{print \"rm -rf \'\"\$$0\"\'\"}" | sh

deepclean: clean
	@find . | grep -E '*/'$(MIGLAYOUT_JAR) | awk '{print "rm -rf "$0}' | sh

$(MIGLAYOUT_JAR):
	@wget http://www.migcalendar.com/miglayout/versions/$(MIGLAYOUT_VERSION)/$(MIGLAYOUT_JAR)
