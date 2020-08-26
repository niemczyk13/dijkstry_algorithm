package com.niemiec.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;

public class Graph {
	private Map<String, Node> graph;
	@Getter
	private Node startNode;
	@Getter
	private Node endNode;

	public Graph() {
		graph = new HashMap<String, Node>();
	}

	public void setNode(Node node) {
		graph.put(node.getName(), node);
	}

	public void setNeighbor(Node node, Node neighbor, Double cost) {
		graph.get(node.getName()).addNeighbor(neighbor, cost);
	}

	public void setStartNode(Node node) {
		if (graph.containsKey(node.getName())) {
			startNode = node;
		} else {
			System.out.println("Węzeł nie istnieje w grafie");
		}
	}
	
	public void setEndNode(Node node) {
		if (graph.containsKey(node.getName())) {
			endNode = node;
		} else {
			System.out.println("Węzeł nie istnieje w grafie");
		}
	}
	
	public void writeNodeGraph() {
		for (Node n : graph.values()) {
			System.out.print("Name: " + n.getName() + " neighbords: ");
			for (Node n2 : n.getNeighbors()) {
				System.out.print(n2.getName() + " - " + n.getCost(n2) + ", ");
			}
			System.out.println();
		}
	}
	
	public Node getNode(String name) {
		return graph.get(name);
	}
	
	public List<Node> getNodes() {
		return new ArrayList<Node>(graph.values());
	}
	
	public List<Node> getNeighbors(Node node) {
		return graph.get(node.getName()).getNeighbors();
	}
}
