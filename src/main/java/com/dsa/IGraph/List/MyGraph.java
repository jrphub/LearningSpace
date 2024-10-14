package com.dsa.IGraph.List;

import java.util.List;

public class MyGraph {
	List<GraphNode> vertices;

	public void setVertices(List<GraphNode> vertices) {
		this.vertices = vertices;
	}

	public List<GraphNode> getVertices() {
		return vertices;
	}

	@Override
	public String toString() {
		return "MyGraph{" +
			"vertices=" + vertices +
			'}';
	}
}
