package juan.challenges.ctci.bfsshortestreach;


import java.util.*;

/**
 * My solution to a graph search coding challenge from hackerrank.com.
 * Challenge description at https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 * 
 * 
 * @author juanespinet
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numQueries = in.nextInt();
        
        for (int i = 0; i < numQueries; i++) {
    		int numVertices = in.nextInt();
    		int numEdges = in.nextInt();
    		
    		Graph graph = new Graph(numVertices);
    		
    		setEdges(numEdges, graph, in);
    		
    		int startVertex = in.nextInt();
    		
    		System.out.println(getDistanceString(startVertex, graph));
		}
        
        in.close();
    }
    
    /**
     * Sets all edges for a single query as
     * defined in the challenge definition.
     * 
     * @param numEdges
     * @param graph
     * @param in
     */
    public static void setEdges(int numEdges, Graph graph, Scanner in) {
    	for (int i = 0; i < numEdges; i++) {
			int startVertex = in.nextInt();
			int endVertex = in.nextInt();
			
			graph.setEdge(startVertex, endVertex);
		}
    }
    
    /**
     * Returns a space-separated string of integers
     * indicating the distance from a specified start
     * vertex on the given graph to each other vertex.
     * 
     * @param startVertex
     * @param numVertices
     * @param graph
     * @return String of distance values
     */
    public static String getDistanceString(int startVertex, Graph graph) {
    	StringBuilder output = new StringBuilder();
    	int[] distances = graph.findAllDistances(startVertex);
    	
    	for (int i = 1; i < distances.length; i++) {
			if (i == startVertex) {
				continue;
			}
			
			output.append(distances[i]);
			
			if (i != distances.length - 1) {
				output.append(' ');
			}
		}
    	
    	return output.toString();
    }
}

/**
 * Simple undirected graph
 * @author juanespinet
 *
 */
class Graph {
	private Vertex[] vertices;
	private int edgeLength = 6;
	
	public Graph(int numVertices) {
		this.vertices = new Vertex[numVertices];
		
		for (int i = 0, vertexNumber = 1; i < numVertices; i++, vertexNumber++) {
			this.vertices[i] = new Vertex(vertexNumber);
		}
	}
	
	/**
	 * Gets the storage index for a given vertex
	 * number in the graphs internal storage array.
	 * 
	 * @param vertexNumber
	 * @return int Index number
	 */
	private int getIndex(int vertexNumber) {
		return vertexNumber - 1;
	}
	
	/**
	 * Sets an edge between two vertices.
	 * 
	 * @param from
	 * @param to
	 */
	public void setEdge(int from, int to) {
		Vertex fromVertex = this.getVertex(from);
		Vertex toVertex = this.getVertex(to);
		
		fromVertex.setEdegeTo(to);
		toVertex.setEdegeTo(from);
	}
	
	/**
	 * Fetches the vertex of the matching number.
	 * Returns null if the vertex does not exist.
	 * 
	 * @param number The number of the requested vertex
	 * @return Vertex
	 */
	public Vertex getVertex(int number) {
		try {
			return vertices[this.getIndex(number)];
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	/**
	 * Finds the minimum distance from one node
	 * to another, using the node numbers. Returns
	 * -1 if no path is found.
	 * 
	 * This method was not used in the final
	 * challenge solution, but kept because it
	 * might be useful for reference in the future.
	 * 
	 * @param startNum
	 * @param endNum
	 * @return The distance between the two edges.
	 */
	public int findMinDistance(int startNum, int endNum) {
		// set up variables for search pattern
		int currentDistance = this.edgeLength;
		LinkedList<Vertex> currentLayer = new LinkedList<Vertex>(); 
		LinkedList<Vertex> nextLayer = new LinkedList<Vertex>();
		HashSet<Integer> searched = new HashSet<Integer>();
		
		// set starting point
		currentLayer.offer(this.getVertex(startNum));
		searched.add(startNum);
		
		// check using BFS layer by layer
		while (currentLayer.size() > 0) {
			Vertex currentVertex = currentLayer.poll();
			
			// check if current vertex is adjacent
			if (currentVertex.adjacentTo(endNum)) {
				return currentDistance;
			}
			
			// get adjacent vertices and queue them for search
			Iterator<Integer> edges = currentVertex.getEdgeIterator();
			while (edges.hasNext()) {
				int nextNum = edges.next();
				
				// make sure we don't search backwards
				if (!searched.contains(nextNum)) {
					nextLayer.offer(this.getVertex(nextNum));
					searched.add(nextNum);
				}
			}
			
			// check if we have hit the end of a distance layer
			if (currentLayer.size() == 0 && nextLayer.size() > 0) {
				// set the next layer as the current so we keep going
				currentLayer = nextLayer;
				// reset the next layer
				nextLayer = new LinkedList<Vertex>();
				// increment the distance counter
				currentDistance += this.edgeLength;
			}
		}
		
		// search completed without success
		return -1;
	}
	
	/**
	 * Finds the minimum distance from one vertex
	 * to all other vertices. Returns or -1 for each
	 * vertex where there is no path.
	 * 
	 * @param startNum
	 * @return An integer array of minimum distances,
	 * which where the vertex number matches its index
	 * in the array (index 0 and the index matching the
	 * start point will always be -1);
	 */
	public int[] findAllDistances(int startNum) {
		int[] results = new int[this.vertices.length + 1];
		Arrays.fill(results, -1);
		
		// set up variables for search pattern
		int currentDistance = this.edgeLength;
		LinkedList<Vertex> currentLayer = new LinkedList<Vertex>(); 
		LinkedList<Vertex> nextLayer = new LinkedList<Vertex>();
		HashSet<Integer> found = new HashSet<Integer>();
		
		// set starting layer
		Vertex startVertex = this.getVertex(startNum);
		found.add(startNum);
		Iterator<Integer> startEdges = startVertex.getEdgeIterator();
		while (startEdges.hasNext()) {
			int nextNum = startEdges.next();
			currentLayer.offer(this.getVertex(nextNum));
			found.add(nextNum);
		}
		
		
		// check using BFS layer by layer
		while (currentLayer.size() > 0) {
			// add the results for this vertex
			Vertex currentVertex = currentLayer.poll();
			results[currentVertex.getVertexNumber()] = currentDistance;
			
			// get adjacent vertices and queue them for search
			Iterator<Integer> edges = currentVertex.getEdgeIterator();
			while (edges.hasNext()) {
				int nextNum = edges.next();
				
				// make sure we don't search backwards
				if (!found.contains(nextNum)) {
					nextLayer.offer(this.getVertex(nextNum));
					found.add(nextNum);
				}
			}
			
			// check if we have hit the end of a distance layer
			if (currentLayer.size() == 0 && nextLayer.size() > 0) {
				// set the next layer as the current so we keep going
				currentLayer = nextLayer;
				// reset the next layer
				nextLayer = new LinkedList<Vertex>();
				// increment the distance counter
				currentDistance += this.edgeLength;
			}
		}
		
		// search completed without success
		return results;
	}
}

/**
 * One vertex of an undirected graph.
 * 
 * @author juanespinet
 *
 */
class Vertex {
	private int vertexNumber;
	private HashSet<Integer> edges;
	
	public Vertex(int number) {
		this.vertexNumber = number;
		this.edges = new HashSet<>();
	}
	
	/**
	 * Indicates whether this vertex
	 * is adjacent to the given vertex.
	 * 
	 * @param vertex number
	 * @return boolean
	 */
	public boolean adjacentTo(int vertexNumber) {
		return this.edges.contains(vertexNumber);
	}
	
	/**
	 * Adds an edge from this
	 * vertex to the specified vertex
	 * number. 
	 * 
	 * @param to
	 */
	public void setEdegeTo(int to) {
		this.edges.add(to);
	}
	
	public int getVertexNumber() {
		return vertexNumber;
	}
	
	/**
	 * Gets an iterator for all edge numbers
	 * adjacent to this vertex.
	 * 
	 * @return Iterator of Integers
	 */
	public Iterator<Integer> getEdgeIterator() {
		return this.edges.iterator();
	}
	
	public int edgeCount() {
		return this.edges.size();
	}
}