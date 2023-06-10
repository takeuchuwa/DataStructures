package com.horban.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph<T> {

    private final Map<T, List<T>> adjList = new HashMap<>();

    public boolean addVertex(T vertex) {
        return adjList.putIfAbsent(vertex, new ArrayList<>()) == null;
    }

    public Map<T, List<T>> getAdjList() {
        return adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }
}
