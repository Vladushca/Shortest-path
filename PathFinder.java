import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
public class PathFinder {

	/**
	 * This method searches for the shortest path to a vertex using a PriorityQueue
	 * As input contains vertexes with element "P", it will be replaced by "", for
	 * future working just with the int values of vertexes
	 * @param sourceV is the vertex of start
	 */
    public void ShortestP(Vertex sourceV) {
		sourceV.setDist(0);                  // required for using the PriorityQueue
		int g = Dijkstra.gabarit;
		int c = Dijkstra.cost;
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceV);
		sourceV.setVisited(true);

		while (!priorityQueue.isEmpty()) {
			Vertex actualVertex = priorityQueue.poll();
			for (Edge edge : actualVertex.getList()) {
				Vertex v = edge.getTargetVert();
				if (!v.Visited() && edge.getGabarit() >= g) {
					double newDistance = 0;
					if (Dijkstra.gabarite.get(edge.getStartVert().getName().replace("P", "")
							+ "-" + edge.getTargetVert().getName().replace("P", "")) != null) {

						//using the formula given in the enunciation of the homework
						newDistance = actualVertex.getDist() +
								Dijkstra.gabarite.get(edge.getStartVert().getName().replace("P", "")
										+ "-" + edge.getTargetVert().getName().replace("P", ""))
											+ edge.getWeight() * c;
					} else {
						newDistance = actualVertex.getDist() + 0 + edge.getWeight() * c;
					}

					if (newDistance < v.getDist()) {
						priorityQueue.remove(v);
						v.setDist(newDistance);
						v.setPr(actualVertex);
						priorityQueue.add(v);
					}
				}
			}
			actualVertex.setVisited(true);
		}
	}

	/**
	 * This is a getter for a string that is the shortest path
	 * @param targetVertex is the start vertex for searching the path
	 * @return result returns the string for the path
	 */
	public String getShortestP(Vertex targetVertex){
		List<Vertex> path = new ArrayList<>();
		for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPr()) {
			path.add(vertex);
		}
		Collections.reverse(path); //reversing the path as we used previously targetVertex as the start point
		String result = path.toString().replaceAll("[\\[\\]]", "").replaceAll(",", "");
		return result;
	}
}
