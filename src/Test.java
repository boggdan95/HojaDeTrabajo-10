import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

public class Test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("grafo.txt"));
		String edge;
		String[] edgeString;
		Vector<String> vertexNames = new Vector<String>();
		Map<String, Vertex> vertexObjects = new HashMap<String,Vertex>();;
		Vector<Vertex> vertices = new Vector<Vertex>();
		Vector<Edge> edges = new Vector<Edge>();
		
		while((edge = in.readLine()) != null){
		    edgeString = edge.split(" ");
		    if(!vertexNames.contains(edgeString[0])){
		    	vertexNames.addElement(edgeString[0]);
		    	vertexObjects.put(edgeString[0], new Vertex(edgeString[0]));
		    }
		    if(!vertexNames.contains(edgeString[1])){
		    	vertexNames.addElement(edgeString[1]);
		    	vertexObjects.put(edgeString[1], new Vertex(edgeString[1]));
		    }
		    edges.addElement(new Edge(vertexObjects.get(edgeString[0]), vertexObjects.get(edgeString[1]), Double.parseDouble(edgeString[2])));
		}
		in.close();
		
		Iterator<Entry<String, Vertex>> iterator = vertexObjects.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, Vertex> pair = (Entry<String, Vertex>)iterator.next();
			vertices.addElement(pair.getValue());
		}
		
		FloydWarshall floyd = new FloydWarshall(vertices, edges);
		
		floyd.execute();
		
		Vertex source = vertexObjects.get("ciudad4");
		Vertex destination = vertexObjects.get("ciudad2");
		
		Vector<Vertex> path = floyd.path(source, destination);
		System.out.println("Source: "+source.getNombre()+"; Destination: "+destination.getNombre());
		System.out.println("Path lenght: "+floyd.pathLenght(source, destination)+"km");
		System.out.println("Path to follow:");
		for(Vertex vertex : path){
			System.out.print(vertex.getNombre()+"-->");
		}
		System.out.println("*");
		
	}
}
