package juan.challenges.bfsshortestreach;

import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.util.*;

/**
 * My solution to coding challenge from hackerrank.com.
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
		}
    }
}

/**
 * Simple undirected graph
 * @author juanespinet
 *
 */
class Graph {
	private Vertex[] vertices;
	
	public Graph(int numVertices) {
		this.vertices = new Vertex[numVertices];
		
		for (int i = 0, vertexNumber = 1; i < numVertices; i++, vertexNumber++) {
			this.vertices[i] = new Vertex(vertexNumber);
		}
	}
	
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
		Vertex fromVertex = vertices[this.getIndex(from)];
		Vertex toVertex = vertices[this.getIndex(to)];
	}
	
	/**
	 * Fetches the vertex of the matching number.
	 * 
	 * @param number The number of the requested vertex
	 * @return Vertex
	 */
	public Vertex getVertex(int number) {
		return vertices[this.getIndex(number)];
	}
}

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
	 * Gets an iterator for all edges
	 * adjacent to this vertex.
	 * 
	 * @return Iterator or null no adjacent edges
	 */
	public Iterator<Integer> getEdgeIterator() {
		if (this.edges.isEmpty()) {
			return null;
		}
		return this.edges.iterator();
	}
}