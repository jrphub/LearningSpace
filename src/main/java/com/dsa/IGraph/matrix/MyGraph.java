package com.dsa.IGraph.matrix;

public interface MyGraph {
	public enum GraphType {
		DIRECTED,
		UNDIRECTED
	}

	int[][] adjacencyMatrix = new int[0][];
	int numVertices = 0;
}
