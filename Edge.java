public class Edge {
	private double weight;
	private Vertex startVert;
	private Vertex targetVert;
	private int gabarit;
	private int ambuteiaj;

	/**
	 * This method is a constructor with param for an edge
	 * @param weight is the weight of an edge
	 * @param gabarit is the max gabarit allowed on that edge
	 * @param startVert is the start vertex of the edge
	 * @param targetVert is the destination vertex of the edge
	 * @param ambuteiaj is the restriction for circulation
	 */
	public Edge(double weight, int gabarit, Vertex startVert, Vertex targetVert, int ambuteiaj) {
		this.gabarit = gabarit;
		this.weight = weight;
		this.startVert = startVert;
		this.targetVert = targetVert;
		this.ambuteiaj = ambuteiaj;
	}


	public int getAmbuteiaj() {
		return ambuteiaj;
	}

	public void setAmbuteiaj(int ambuteiaj) {
		this.ambuteiaj = ambuteiaj;
	}

	public int getGabarit() {
		return gabarit;
	}

	public void setGabarit(int gabarit) {
		this.gabarit = gabarit;
	}
	public double getWeight() {
		return weight;
	}
 
	public void setWeight(double weight) {
		this.weight = weight;
	}
 
	public Vertex getStartVert() {
		return startVert;
	}
 
	public void setStartVert(Vertex startVert) {
		this.startVert = startVert;
	}
 
	public Vertex getTargetVert() {
		return targetVert;
	}
 
	public void setTargetVert(Vertex targetVert) {
		this.targetVert = targetVert;
	}
}