JAVA = java
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

# Define the target class files based on the source files
CLASSES := $(wildcard *.java)

default: classes



# Rule to compile all Java source files into class files
classes:
	$(JC) $(JFLAGS) $(CLASSES)

clean:
	$(RM) *.class

server:
	$(JAVA) -classpath . store.Server

client:
	$(JAVA) -classpath . store.Client
jar:
	jar cf store.jar $(shell find . -name '*.class' -printf '%P ')
