import java.util.Vector;

import org.apache.commons.collections4.map.MultiKeyMap;

public class FloydWarshall {
	MultiKeyMap<Vertex, Double> distances;
	MultiKeyMap<Vertex, Vertex> next;
	Vector<Vertex> vertices;
	Vector<Edge> edges;
	
	/**
	 * @param vertices
	 * @param edges
	 */
	public FloydWarshall(Vector<Vertex> vertices, Vector<Edge> edges) {
		super();
		this.vertices = vertices;
		this.edges = edges;
		
		distances = new MultiKeyMap<Vertex, Double>();
		next = new MultiKeyMap<Vertex, Vertex>();
		
		//Initializing distances map
		for(Vertex source : vertices){
			for(Vertex destination : vertices){
				distances.put(source, destination, Double.POSITIVE_INFINITY);
			}
		}
		
		//Initializing next map
		for(Vertex source : vertices){
			for(Vertex destination : vertices){
				next.put(source, destination, null);
			}
		}
	}
	
	public void execute(){
		Vertex source;
		Vertex destination;
		
		for(Edge edge : edges){
			source = edge.getSource();
			destination = edge.getDestination();
			distances.put(source, destination, edge.getWeight());
			next.put(source, destination, destination);
		}
		
		for(Vertex k : vertices){
			for(Vertex i : vertices){
				for(Vertex j : vertices){
					if(distances.get(i, k) + distances.get(k, j) < distances.get(i, j)){
						distances.put(i, j, (distances.get(i, k) + distances.get(k, j)));
						next.put(i, j, next.get(i, k));
					}
				}
			}
		}
	}
	
	public Double pathLenght(Vertex source, Vertex destination){
		return distances.get(source, destination);
	}
	
	public Vector<Vertex> path(Vertex source, Vertex destination){
		if(next.get(source, destination)==null){
			return new Vector<Vertex>();
		} else {
			Vector<Vertex> path = new Vector<Vertex>();
			path.addElement(source);
			while(source!=destination){
				source = next.get(source, destination);
				path.addElement(source);
			}
			return path;
		}
	}
	
	/**
	 * Adds the edge.
	 *
	 * @param newEdge the new edge
	 */
	public void addEdge(Edge newEdge){
		edges.addElement(newEdge);
		
		//Resetting arrays
		for(Vertex source : vertices){
			for(Vertex destination : vertices){
				distances.put(source, destination, Double.POSITIVE_INFINITY);
			}
		}
		for(Vertex source : vertices){
			for(Vertex destination : vertices){
				next.put(source, destination, null);
			}
		}
		
		//Recalculating
		execute();
	}
}
