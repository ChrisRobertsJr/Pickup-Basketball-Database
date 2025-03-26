all:
	javac *.java
	
run: all
	java Main

clean:
	rm -f *.class