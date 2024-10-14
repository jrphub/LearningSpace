package com.dsa.IGraph.List;

import java.util.List;

public class Client {

	public static void main(String[] args) {
		GraphNode vertex1 = new GraphNode(1);
		GraphNode vertex2 = new GraphNode(2);
		GraphNode vertex3 = new GraphNode(3);
		GraphNode vertex4 = new GraphNode(4);
		GraphNode vertex5 = new GraphNode(5);


		vertex1.setVertices(List.of(vertex2, vertex3));
		vertex2.setVertices(List.of(vertex4));
		vertex3.setVertices(List.of(vertex5));
		vertex4.setVertices(null);
		vertex5.setVertices(List.of(vertex2, vertex4));

		MyGraph myGraph = new MyGraph();
		myGraph.setVertices(List.of(vertex1, vertex2, vertex3, vertex4, vertex5));
		System.out.println(myGraph);
	}
}
