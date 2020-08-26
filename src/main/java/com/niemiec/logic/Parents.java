package com.niemiec.logic;

import java.util.HashMap;
import java.util.Map;

import com.niemiec.model.Graph;
import com.niemiec.model.Node;

import lombok.Getter;

public class Parents {
	@Getter
	private Map<Node, Node> parents;
	
	public Parents(Graph graph) {
		this.parents = new HashMap<Node, Node>();
		createParents(graph);
	}

	private void createParents(Graph graph) {
		Node start = graph.getStartNode();
		addNodesToParentsMap(start, graph);
		updateStartNeighbors(start);
	}
	
	private void addNodesToParentsMap(Node start, Graph graph) {
		for (Node grNodes : graph.getNodes()) {
			if (grNodes != start)	
				parents.put(grNodes, null);
		}
	}

	private void updateStartNeighbors(Node start) {
		for (Node stNode : start.getNeighbors()) {
			if (stNode != start)
				parents.replace(stNode, start);
		}
	}

	public void updateParent(Node node, Node parent) {
		parents.replace(node, parent);
	}
	
	public Node getParent(Node node) {
		return parents.get(node);
	}
	
	public void write() {
		parents.entrySet().stream().forEach(e -> System.out.println(e));
	}
}
