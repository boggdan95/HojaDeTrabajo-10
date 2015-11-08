import java.util.Map;
import java.util.Vector;

import org.apache.commons.collections4.map.MultiKeyMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex ciudad1 = new Vertex("Ciudad 1");
		Vertex ciudad2 = new Vertex("Ciudad 2");
		Vertex ciudad3 = new Vertex("Ciudad 3");
		Vertex ciudad4 = new Vertex("Ciudad 4");
		Vertex ciudad5 = new Vertex("Ciudad 5");

		Edge edge1 = new Edge(ciudad1, ciudad4, 10.0);
		Edge edge2 = new Edge(ciudad1, ciudad2, 2.0);
		Edge edge3 = new Edge(ciudad2, ciudad3, 5.0);
		Edge edge4 = new Edge(ciudad3, ciudad4, 2.0);
		
		Vector<Vertex> vertices = new Vector<Vertex>();
		Vector<Edge> edges = new Vector<Edge>();

		vertices.addElement(ciudad1);
		vertices.addElement(ciudad2);
		vertices.addElement(ciudad3);
		vertices.addElement(ciudad4);
		vertices.addElement(ciudad5);

		edges.addElement(edge1);
		edges.addElement(edge2);
		edges.addElement(edge3);
		edges.addElement(edge4);
		
		FloydWarshall floyd = new FloydWarshall(vertices, edges);
		
		floyd.execute();
		Vector<Vertex> path = floyd.path(ciudad1, ciudad5);
		
		System.out.println("Path lenght: "+floyd.pathLenght(ciudad1, ciudad5));
		for(Vertex vertex : path){
			System.out.println(vertex.getNombre());
		}
	}
}
