package com.niemiec.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.stream.Collectors;

public class Neighbors {
	private Map<Node, Double> neighborsCosts = new HashMap<Node, Double>();

	public void addNeighbor(Node node, Double cost) {
		neighborsCosts.put(node, cost);
	}

	public Double getCost(Node node) {
		return neighborsCosts.get(node);
	}

	public List<Node> getNeighbors() {
		return neighborsCosts.keySet().stream().collect(Collectors.toList());
	}
}
