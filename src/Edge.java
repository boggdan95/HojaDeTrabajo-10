
public class Edge {
	Vertex source;
	Vertex destination;
	Double weight;
	/**
	 * @return the source
	 */
	public Vertex getSource() {
		return source;
	}
	/**
	 * @return the destination
	 */
	public Vertex getDestination() {
		return destination;
	}
	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Vertex source) {
		this.source = source;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Vertex destination) {
		this.destination = destination;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public Edge(Vertex source, Vertex destination, Double weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	
}
