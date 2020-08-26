package com.niemiec.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Node {
	@Getter @Setter
	private String name;
	@Setter
	private Neighbors neighbors;
	
	public Node(String name) {
		this.name = name;
		this.neighbors = new Neighbors();
	}

	public void addNeighbor(Node node, Double cost) {
		neighbors.addNeighbor(node, cost);
	}
	
	public Double getCost(Node node) {
		return neighbors.getCost(node);
	}
	
	public List<Node> getNeighbors() {
		return neighbors.getNeighbors();
	}
}
