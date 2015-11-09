import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

public class Test {

	private static int opcion;
	private static String ciudad1;
	private static String ciudad2;
	private static int a;
	
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
				
		a = 0;
		
		while(a==0){	
			System.out.println("Bienvenido al mapa de Guatemala");
	        System.out.println("Seleccione lo que desea hacer \n1. Nombre de Ciudad\n2. Ruta más corta\n3. Modificar grafo\n4. Finalizar programa");
	        System.out.println("Ingrese la opción numérica deseada:");
	        
	        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
	        try {
				opcion = entradaEscaner.nextInt();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("POR FAVOR! Ingrese un número");
				a = 0;
			}
	       try {
			if (opcion > 0 && opcion <=4){
			    	a = 1;
			   }
			   else{
				   a =0;
			   }
		
			try {
				if (opcion==1){
					System.out.println("Ingrese el nombre de la Ciudad1:");
						ciudad1 = entradaEscaner.next();
					System.out.println("Ingrese el nombre de la Ciudad2:");
						ciudad2 = entradaEscaner.next();
						
						
						FloydWarshall floyd = new FloydWarshall(vertices, edges);
						
						floyd.execute();
						
						
						Vertex source = vertexObjects.get(ciudad1);
						Vertex destination = vertexObjects.get(ciudad2);
						
						Vector<Vertex> path = floyd.path(source, destination);
						try {
							System.out.println("Source: "+source.getNombre()+"; Destination: "+destination.getNombre());
							System.out.println("Path lenght: "+floyd.pathLenght(source, destination)+"km");
							System.out.println("Path to follow:");
							for(Vertex vertex : path){
								System.out.print(vertex.getNombre()+"-->");
							}
							System.out.println("*\n");
							a = 0;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("Ciudades no encontradas, verifique ingresos");
							a = 0;
						}
											
				}
				if (opcion == 2){
					
				}
				if (opcion == 3){
					
				}
				if (opcion == 4){
					System.out.println("Gracias por haber utilizado el programa!!! Esperamos que su ruta haya sido la más corta");
				}
			} catch (Exception e) {
				System.out.println("Error de escritura en la ciudad");
				a = 0;
			} 
			
		}	
					
		 catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("POR FAVOR! Ingrese un número");
			a = 0;
		 	}
		}
		

	}
		
		
}

