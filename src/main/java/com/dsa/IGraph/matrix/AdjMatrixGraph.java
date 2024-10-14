package com.dsa.IGraph.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjMatrixGraph implements MyGraph {

	private GraphType type;
	private int numOfVertices;
	private int[][] adjMatrix;

	public AdjMatrixGraph(int numOfVertices, GraphType graphType) {
		this.numOfVertices = numOfVertices;
		this.type = graphType;

		adjMatrix = new int[numOfVertices][numOfVertices];
		for (int i = 0; i < numOfVertices; i++) {
			for (int j = 0; j < numOfVertices; j++) {
				adjMatrix[i][j] = 0;
			}
		}
	}

	public void addEdge(int v1, int v2) {
		//base case
		if (v1 < numOfVertices || v1 < 0 || v2 < numVertices || v2 < 0) {
			throw new IllegalArgumentException("v1 or v2 are invalid");
		}

		adjMatrix[v1][v2] = 1;

		if (type == GraphType.UNDIRECTED) {
			adjMatrix[v2][v1] = 1;
		}
	}

	public List<Integer> getAdjVertices(int v) {
		if (v < 0 || v > numVertices) {
			throw new IllegalArgumentException("Invalid vertex");
		}
		List<Integer> adjVerticesList = new ArrayList<>();
		for (int i = 0; i< numOfVertices; i++) {
			if (adjMatrix[v][i] == 1) {
				adjVerticesList.add(i);
			}
		}

		Collections.sort(adjVerticesList);

		return adjVerticesList;
	}
}
