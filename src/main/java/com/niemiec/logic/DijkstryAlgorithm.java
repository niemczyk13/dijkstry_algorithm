package com.niemiec.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.niemiec.model.Graph;
import com.niemiec.model.Node;

public class DijkstryAlgorithm {
	private static Graph graph;
	private static Costs costs;
	private static Parents parents;
	private static List<Node> processed = new ArrayList<Node>();
	
	public static List<Node> count(Graph g) {
		createStartupVariables(g);
		
		Node node = findLowerCostNode();
		while (node != null) {
			checkNeighborsCosts(node);
			node = findLowerCostNode();
		}
		
		return getWay(graph, parents);
	}
	
	private static void createStartupVariables(Graph g) {
		graph = g;
		costs = new Costs(graph);
		parents = new Parents(graph);
	}

	private static void checkNeighborsCosts(Node node) {
		Double cost = costs.getCost(node);
		List<Node> neighbors = graph.getNeighbors(node);
		for (Node neighbor : neighbors) {
			Double newCost = cost + node.getCost(neighbor);
			updateCostAndParent(node, neighbor, newCost);
		}
		processed.add(node);
	}

	private static void updateCostAndParent(Node node, Node neighbor, Double newCost) {
		if (costs.getCost(neighbor) > newCost) {
			costs.updateCost(neighbor, newCost);
			parents.updateParent(neighbor, node);
		}
	}

	private static List<Node> getWay(Graph graph, Parents parents) {
		List<Node> way = new ArrayList<Node>();
		Node startNode = graph.getStartNode();
		Node node = graph.getEndNode();
		way = createWay(startNode, node, way);
		Collections.reverse(way);
		return way;
	}
	
	private static List<Node> createWay(Node startNode, Node node, List<Node> way) {
		way.add(node);
		while (true) {
			node = parents.getParent(node);
			way.add(node);
			if (node == startNode) break;
		}
		return way;
	}

	private static Node findLowerCostNode() {
		Double lovestCost = Double.POSITIVE_INFINITY;
		Node lovestCostNode = null;
		
		for (Node node : costs.getCosts().keySet()) {
			Double cost = costs.getCost(node);
			if (cost < lovestCost && noProcessed(node)) {
				lovestCost = cost;
				lovestCostNode = node;
			}
		}
		return lovestCostNode;
	}

	private static boolean noProcessed(Node node) {
		return !processed.stream().anyMatch(e -> e.equals(node));
	}
}
