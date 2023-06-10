package com.horban.study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BidirectionalAdjacencyListGraph<T> {

    private final Map<T, Set<T>> adjList = new HashMap<>();

    public boolean addVertex(T vertex) {
        return adjList.putIfAbsent(vertex, new HashSet<>()) == null;
    }

    public boolean addEdge(T vertex1, T vertex2) {
        return adjList.get(vertex1) != null && adjList.get(vertex2) != null
                && adjList.get(vertex1).add(vertex2) && adjList.get(vertex2).add(vertex1);
    }

    public boolean removeEdge(T vertex1, T vertex2) {
        return adjList.get(vertex1) != null && adjList.get(vertex2) != null
                && adjList.get(vertex1).remove(vertex2) && adjList.get(vertex2).remove(vertex1);
    }

    public boolean removeVertex(T vertex) {
        Set<T> edges = adjList.get(vertex);
        if (edges == null) return false;

        for (T edge : edges) {
            adjList.get(edge).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

    public Map<T, Set<T>> getAdjList() {
        return adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }
}
