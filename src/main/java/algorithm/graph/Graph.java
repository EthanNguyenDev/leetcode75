package algorithm.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {
    private final Set<T> vertices;
    private final Map<T, Set<T>> edges;

    public Graph(Set<T> vertices, Map<T, Set<T>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public static void main(String[] args) {
        Set<String> vertices = Set.of("A", "B", "C", "D", "E", "F", "G", "H", "I");
        Map<String, Set<String>> edges = Map.of(
                "A", Set.of("B", "C", "F"),
                "B", Set.of("A", "F"),
                "C", Set.of("A", "F", "G"),
                "D", Set.of("E", "I"),
                "E", Set.of("I", "D"),
                "F", Set.of("A", "B", "C", "H"),
                "G", Set.of("C", "H"),
                "H", Set.of("G", "F"),
                "I", Set.of("D", "E")
        );
        Graph<String> graph = new Graph<>(vertices, edges);
        Map<Integer, Set<String>> components;
        System.out.println("Find components through DFS");
        components = graph.getComponents(SearchAlgorithm.DFS);
        System.out.println("-------------");
        printComponents(components);

        System.out.println("*************");

        System.out.println("Find components through BFS");
        components = graph.getComponents(SearchAlgorithm.BFS);
        System.out.println("-------------");
        printComponents(components);
    }

    private static void printComponents(Map<Integer, Set<String>> components) {
        System.out.println("Components:");
        components.forEach((index, vertices) -> {
            System.out.printf("\t%d = %s\n", index, vertices);
        });
    }

    public Map<Integer, Set<T>> getComponents(SearchAlgorithm searchAlgorithm) {
        Map<Integer, Set<T>> components = new HashMap<>();

        Map<T, Integer> visited;
        if (SearchAlgorithm.DFS == searchAlgorithm) {
            visited = dfs();
        } else {
            visited = bfs();
        }
        visited.forEach((vertex, componentIndex) -> {
            components.computeIfAbsent(componentIndex, (k) -> {
                Set<T> vertices = new HashSet<>();
                vertices.add(vertex);
                return vertices;
            });
            components.computeIfPresent(componentIndex, (k, v) -> {
                v.add(vertex);
                return v;
            });
        });
        return components;
    }

    public Map<T, Integer> bfs() {
        Queue<T> queue = new ArrayDeque<>();
        Map<T, Integer> visited = new HashMap<>();
        int componentIndex = -1;
        for (T vertex : vertices) {
            if (visited.containsKey(vertex)) {
                continue;
            }
            componentIndex++;
            queue.add(vertex);
            visited.put(vertex, componentIndex);
            System.out.println("Queue Add " + vertex);
            while (!queue.isEmpty()) {
                T v = queue.poll();
                System.out.println("Queue Poll " + v);
                visited.put(v, componentIndex);
                Set<T> vEdges = edges.getOrDefault(v, new HashSet<>());
                for (T e : vEdges) {
                    if (visited.containsKey(e)) {
                        continue;
                    }
                    queue.add(e);
                    System.out.println("Queue Add " + e);
                    visited.put(e, componentIndex);
                }
            }
        }

        return visited;
    }

    public Map<T, Integer> dfs() {
        Stack<T> stack = new Stack<>();
        Map<T, Integer> visited = new HashMap<>();
        int componentIndex = -1;
        for (T vertex : vertices) {
            if (visited.containsKey(vertex)) {
                continue;
            }
            componentIndex++;
            stackUp(vertex, stack, visited, componentIndex);
        }

        return visited;
    }

    private void stackUp(T vertex, Stack<T> stack, Map<T, Integer> visited, int componentIndex) {
        if (!visited.containsKey(vertex)) {
            stack.push(vertex);
            System.out.println("Stack Push " + vertex);
            visited.put(vertex, componentIndex);
        }

        Set<T> vEdges = edges.getOrDefault(vertex, new HashSet<>());
        if (vEdges.isEmpty()) {
            if (stack.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            T v = stack.pop();
            System.out.println("Stack Pop " + v);
            stackUp(v, stack, visited, componentIndex);
            return;
        }
        boolean allVisited = vEdges.stream().allMatch(visited::containsKey);
        if (allVisited) {
            if (stack.isEmpty()) {
                return;
            }
            T v = stack.pop();
            System.out.println("Stack Pop " + v);
            stackUp(v, stack, visited, componentIndex);
            return;
        }
        for (T e : vEdges) {
            if (!visited.containsKey(e)) {
                stackUp(e, stack, visited, componentIndex);
                break;
            }
        }
    }

    public enum SearchAlgorithm {
        DFS,
        BFS
    }
}