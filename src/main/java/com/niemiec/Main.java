package com.niemiec;

import java.util.List;

import com.niemiec.logic.DijkstryAlgorithm;
import com.niemiec.model.Graph;
import com.niemiec.model.Node;

public class Main {

	public static void main(String[] args) {
//		Node ksiazka = new Node("Książka");
//		Node rzadkaPlyta = new Node("Rzadka płyta");
//		Node gitaraBasowa = new Node("Gitara basowa");
//		Node fortepian = new Node("Fortepian");
//		Node plakat = new Node("Plakat");
//		Node perkusja = new Node("Perkusja");
//		
//		ksiazka.addNeighbor(rzadkaPlyta, 5.0);
//		ksiazka.addNeighbor(plakat, 0.0);
//		
//		rzadkaPlyta.addNeighbor(gitaraBasowa, 15.0);
//		rzadkaPlyta.addNeighbor(perkusja, 20.0);
//		
//		gitaraBasowa.addNeighbor(fortepian, 20.0);
//		
//		plakat.addNeighbor(gitaraBasowa, 30.0);
//		plakat.addNeighbor(perkusja, 35.0);
//		
//		perkusja.addNeighbor(fortepian, 10.0);
//		
//		Graph graph = new Graph();
//		graph.setNode(ksiazka);
//		graph.setNode(rzadkaPlyta);
//		graph.setNode(gitaraBasowa);
//		graph.setNode(fortepian);
//		graph.setNode(plakat);
//		graph.setNode(perkusja);
//		
//		graph.setStartNode(ksiazka);
//		graph.setEndNode(gitaraBasowa);
		
//		graph.writeNodeGraph();
		
//		List<Node> list = DijkstryAlgorithm.count(graph);
		
//		list.stream().forEach(e -> System.out.println(e.getName()));
		
		Node start = new Node("Start");
		Node meta = new Node("Meta");
		Node a = new Node("A");
		Node b = new Node("B");
		
		start.addNeighbor(a, 10.0);
		start.addNeighbor(b, 1.0);
		
		a.addNeighbor(meta, 1.0);
		a.addNeighbor(b, 1.0);
		
		b.addNeighbor(a, 1.0);
		b.addNeighbor(meta, 1.0);
		
		Graph g = new Graph();
		g.setNode(start);
		g.setNode(a);
		g.setNode(b);
		g.setNode(meta);
		g.setStartNode(start);
		g.setEndNode(meta);
		
		List<Node> list = DijkstryAlgorithm.count(g);
		
		list.stream().forEach(e -> System.out.println(e.getName()));
	}

}
