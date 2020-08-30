package com.niemiec.logic;

import java.util.List;

import com.niemiec.model.Node;

public class AlgorithmViewer {
	private static int line = 0;
	
	public static void viewCostsAndParents(Parents parents, Costs costs, List<Node> processed) {
		int size = getMaxSize(parents);

		//wyświetl nazwy tabelek - dopisać
		viewFrame("*", size);
		for (Node n : parents.getParents().keySet()) {
			viewParentsTab(n, parents, size);
			viewSpace(5);
			viewCostsTab(n, costs, size);
			viewSpace(5);
			viewProcessedTab(processed, size);
			println("");
		}
		for (int i = 0; i < parents.getParents().size(); i++) {
		}
		viewFrame("*", size);
		line = 0;
	}

	private static void viewSpace(int i) {
		for (int j = 0; j < i; j++) {
			print(" ");
		}
	}

	private static void viewProcessedTab(List<Node> processed, int size) {
		print("|");
		if (processed.size() > line) {
			viewName(processed.get(line).getName(), size);
			line++;
		} else {
			viewName("", size);
		}
		print("|");
	}

	private static void viewCostsTab(Node n, Costs costs, int size) {
		print("|");
		viewName(n.getName(), size);
		print("|");
		double cost = costs.getCost(n);
		viewName(String.valueOf(cost), size);
		print("|");
	}

	private static void viewParentsTab(Node n, Parents parents, int size) {
		print("|");
		viewName(n.getName(), size);
		print("|");
		String name = parents.getParent(n) == null ? "" : parents.getParent(n).getName();
		viewName(name, size);
		print("|");
	}

	private static void viewName(String name, int size) {
		int difference = size - name.length();
		if (name.equals("")) {
			for (int i = 0; i < size; i++) {
				print(" ");
			}
			return;
		}
		print(name);
		for (int i = 0; i < difference; i++) {
			print(" ");
		}
	}

	private static void viewFrame(String s, int size) {
		displayServeralTimes(s, size + 2);
		displayServeralTimes(s, size + 1);
		print("     ");
		displayServeralTimes(s, size + 2);
		displayServeralTimes(s, size + 1);
		print("     ");
		displayServeralTimes(s, size + 1);
		println("");
	}
	
	private static void displayServeralTimes(String s, int rep) {
		for (int i = 0; i < rep; i++) {
			print(s);
		}
	}
	
	private static int getMaxSize(Object o) {
		int size = 0;
		if (o instanceof Parents) {
			Parents p = (Parents) o;
			for (Node n : p.getParents().keySet()) {
				if (size < n.getName().length()) {
					size = n.getName().length();
				}
				if (p.getParent(n) != null && size < p.getParent(n).getName().length()) {
					size = p.getParent(n).getName().length();
				}
			}
		}
		return size;
	}
	
	private static void print(String s) {
		System.out.print(s);
	}
	
	private static void println(String s) {
		System.out.println(s);
	}

	public static void viewLowerCostNode(Node lovestCostNode, Double love) {
		waitForTheDisplay(1000L);
		if (lovestCostNode != null) {
			println("Węzeł z najmniejszym kosztem: " + lovestCostNode.getName() + ", koszt = " + love);
			println("* * *");
		}
	}

	public static void checkNeigbor(Node node, Node neighbor, Double cost, Double newCost) {
		waitForTheDisplay(1000L);
		println("Sprawdzanie sąsiada " + neighbor.getName() + ", koszt dotarcia od węzła " + node.getName() + ": " + node.getCost(neighbor));
		println("koszt dotarcia do węzła " + node.getName() + " z tabeli Costs: " + cost + ", a więc suma wynosi: " + newCost);
		println("* * *");
	}

	public static void updateCostAndParent(Node node, Node neighbor, Double newCost, Double neighborCost) {
		waitForTheDisplay(1000L);
		println("Koszt dotarcia do " + neighbor.getName() + " jest większy (" + neighborCost + "), więc aktualizaujemy na nowy koszt " + newCost);
		println("rodzicem " + neighbor.getName() + " staje się " + node.getName());
		println("* * *");
	}

	public static void createWay(Node node, Node startNode) {
		waitForTheDisplay(1000L);
		println("Teraz pobieramy rodziców z tabeli Parents zaczynając od węzła końcowego " + node.getName());
		println(", a kończąc na początkowym " + startNode.getName());
		println("");
	}

	public static void createWayInWhile(Node node, Node parent) {
		waitForTheDisplay(1000L);
		println("Rodzic węzła " + node.getName() + " --> " + parent.getName());
	}
	
	private static void waitForTheDisplay(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
