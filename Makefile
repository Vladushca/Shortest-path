build:
	javac Dijkstra.java
	javac Edge.java
	javac Vertex.java
	javac PathFinder.java

run:
	java Dijkstra

clean:
	$(RM) $*.class