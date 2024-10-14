package com.dsa.IGraph.List;

import java.util.List;

public class GraphNode {
	private int vertexId;
	private List<GraphNode> vertices;

	public GraphNode(int vertexId) {
		this.vertexId = vertexId;
	}

	public int getVertexId() {
		return vertexId;
	}

	public void setVertexId(int vertexId) {
		this.vertexId = vertexId;
	}

	public List<GraphNode> getVertices() {
		return vertices;
	}

	public void setVertices(List<GraphNode> vertices) {
		this.vertices = vertices;
	}

	@Override
	public String toString() {
		return "GraphNode{" +
			"vertexId=" + vertexId +
			", vertices=" + vertices +
			'}';
	}
}
