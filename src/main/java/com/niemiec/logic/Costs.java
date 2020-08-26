package com.niemiec.logic;

import java.util.HashMap;
import java.util.Map;

import com.niemiec.model.Graph;
import com.niemiec.model.Node;

import lombok.Getter;

public class Costs {
	@Getter
	private Map<Node, Double> costs;

	public Costs(Graph graph) {
		costs = new HashMap<Node, Double>();
		createCosts(graph);
	}

	private void createCosts(Graph graph) {
		Node start = graph.getStartNode();
		for (Node grNode : graph.getNodes()) {
			if (grNode != start)
				costs.put(grNode, Double.POSITIVE_INFINITY);
		}
		
		for (Node stNode : start.getNeighbors()) {
			if (stNode != start)
				costs.replace(stNode, start.getCost(stNode));
		}
	}

	public Double getCost(Node node) {
		return costs.get(node);
	}
	
	public void updateCost(Node node, Double cost) {
		costs.replace(node, cost);
	}
}
