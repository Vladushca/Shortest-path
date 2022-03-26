import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
	private boolean visited;
	private String name;
	private List<Edge> List;
	private double dist = Double.MAX_VALUE;
	private Vertex pr;

	/**
	 * This method is a constructor for a vertex
	 * @param name is the name of the vertex given to the constructor
	 */
	public Vertex(String name) {
		this.name = name;
		this.List = new ArrayList<>();
	}

	/**
	 * This method is a getter for the List
	 * @return is a value of List
	 */
	public List<Edge> getList() {
		return List;
	}

	/**
	 * This method is a getter for the name of the vertex
	 * @return is a value of string of name of the vertex
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is a setter of a name for a vertex
	 * @param name is the name to be set for a vertex
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method is a setter for List
	 * @param List is List to be set
	 */
	public void setList(List<Edge> List) {
		this.List = List;
	}

	/**
	 * This method adds a neighbour for a street
	 * @param edge is the street to be added
	 */
	public void addNeighbour(Edge edge) {
		this.List.add(edge);
	}

	/**
	 * This method decides if a vertex is visited or not
	 * @return is a value of boolean
	 */
	public boolean Visited() {
		return visited;
	}

	/**
	 * This method is a setter for the boolean variable visited
	 * @param visited is the boolean value to be set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * This method get the predecessor vertex
	 * @return returns the previous vertex
	 */
	public Vertex getPr() {
		return pr;
	}

	/**
	 * This is a setter for the previous vertex
	 * @param pr is the vertex to be set
	 */
	public void setPr(Vertex pr) {
		this.pr = pr;
	}

	/**
	 * This method is a getter for the Dist
	 * @return returns the Distance
	 */
	public double getDist() {
		return dist;
	}

	/**
	 * This is a setter for the Distance
	 * @param dist is the value to be set
	 */
	public void setDist(double dist) {
		this.dist = dist;
	}

	/**
	 * This is the overriden toString for the name of the vertex
	 * @return returns the string name
	 */
	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * This method compares 2 vertexes
	 * @param otherV is the vertex to be compared with
	 * @return returns an int after the comparison
	 */
	@Override
	public int compareTo(Vertex otherV) {
		return Double.compare(this.dist, otherV.getDist());
	}
}