package algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph2 {
    private List<Node> nodes;
    private Map<Integer, Set<Integer>> edges;
    private int[][] matrix;
    private boolean buildMatrix = false;

    public Graph2() {
        nodes = new ArrayList<>();
        edges = new HashMap<>();
    }

    public void addNode(Node e) {
        nodes.add(e);
        buildMatrix = false;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addEdge(int src, int dest) {
        edges.computeIfAbsent(src, (k) -> {
            Set<Integer> nodes = new HashSet<>();
            nodes.add(dest);
            return nodes;
        });
        edges.computeIfPresent(src, (k, v) -> {
            v.add(dest);
            return v;
        });
        buildMatrix = false;
    }

    private void buildMatrix() {
        matrix = new int[nodes.size()][nodes.size()];
        edges.forEach((k, values) -> {
            for (int v : values) {
                matrix[k][v] = 1;
            }
        });
        buildMatrix = true;
    }

    public boolean checkEdgeExist(int src, int dest) {
        if (!buildMatrix) {
            buildMatrix();
        }
        return matrix[src][dest] == 1;
    }

    public List<List<Node>> depthFirstSearch() {
        List<List<Node>> result = new ArrayList<>();
        boolean[] visited = new boolean[nodes.size()]; // keep track of unvisited nodes in other components
        System.out.println("Depth-First Search:");

        for (Node node : nodes) {
            if (!visited[nodes.indexOf(node)]) {
//                result.addAll(dfs(node, visited));
                List<Node> perComponent = dfs(node, visited);
                result.add(perComponent);
            }
        }
        return result;
    }

    private List<Node> dfs(Node start, boolean[] visited) {
        List<Node> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Node v = stack.peek();
            int index = nodes.indexOf(v);

            if (!visited[index]) {
                visited[index] = true;
                result.add(v);
                boolean foundUnvisited = false;
                for (int i = 0; i < nodes.size(); i++) {
                    if (!visited[i] && checkEdgeExist(index, i)) {
                        stack.push(nodes.get(i));
                        System.out.println("pushing " + v  + " into stack ");
                        foundUnvisited = true;
                        break;
                    }
                }
                if (!foundUnvisited) {
                    System.out.println("poping " + v  + " out of stack ");
                    stack.pop();
                }
            } else {
                System.out.println("poping " + v  + " out of stack ");
                stack.pop();
            }
        }

        return result;
    }

    public List<List<Node>> breadthFirstSearch() {
        List<List<Node>> result = new ArrayList<>();
        boolean[] visited = new boolean[nodes.size()];  // keep track of unvisited nodes in other components

        System.out.println("Breadth-First Search:");

        for (Node node : nodes) {
            int index = nodes.indexOf(node);
            if (!visited[index]) {
//                result.addAll(bfs(node, visited));
                List<Node> perComponent = bfs(node, visited);
                result.add(perComponent);
            }
        }
        return result;
    }

    private List<Node> bfs(Node start, boolean[] visited) {
        List<Node> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        int startIndex = nodes.indexOf(start);

        queue.offer(start);
        visited[startIndex] = true;

        while (!queue.isEmpty()) {
            Node v = queue.poll();
            int index = nodes.indexOf(v);

            result.add(v);

            for (int i = 0; i < nodes.size(); i++) {
                if (!visited[i] && checkEdgeExist(index, i)) {
                    visited[i] = true;
                    queue.offer(nodes.get(i));
                }
            }
        }
        return result;
    }

    public void printMatrix() {
        System.out.print("  ");
        for (Node n : nodes) {
            System.out.print(n.getLabel() + " ");
        }
        System.out.println();
        if (!buildMatrix) {
            buildMatrix();
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).getLabel() + " ");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph2 g = new Graph2();
        g.addNode(new Node("A")); // 0
        g.addNode(new Node("B")); // 1
        g.addNode(new Node("C")); // 2
        g.addNode(new Node("D")); // 3
        g.addNode(new Node("E")); // 4
        g.addNode(new Node("F")); // 5
        g.addNode(new Node("G")); // 6
        g.addNode(new Node("H")); // 7
        g.addNode(new Node("I")); // 8

        g.addEdge(0, 1); // AB
        g.addEdge(1, 0); // BA

        g.addEdge(0, 2); // AC
        g.addEdge(2, 0); // CA

        g.addEdge(1, 5); // BF
        g.addEdge(5, 1); // FB

        g.addEdge(0, 5); // AF
        g.addEdge(5, 0); // FA

        g.addEdge(2, 5); // CF
        g.addEdge(5, 2);

        g.addEdge(2, 6); // CG
        g.addEdge(6, 2);

        g.addEdge(5, 7); // FH
        g.addEdge(7, 5);

        g.addEdge(7, 6); // HG
        g.addEdge(6, 7);

        g.addEdge(3, 4); // DE
        g.addEdge(4, 3);

        g.addEdge(4, 8); // EI
        g.addEdge(8, 4);

        g.addEdge(3, 8); // DI
        g.addEdge(8, 3);

        g.printMatrix();

        System.out.println();
        List<List<Node>> dfsResult = g.depthFirstSearch();
        for (int i = 0; i < dfsResult.size(); i++) {
            System.out.print("Component " + (i + 1) + ": ");
            System.out.println(dfsResult.get(i));
        }

        System.out.println();

        List<List<Node>> bfsResult = g.breadthFirstSearch();
        for (int i = 0; i < bfsResult.size(); i++) {
            System.out.print("Component " + (i + 1) + ": ");
            System.out.println(bfsResult.get(i));
        }
    }

    static class Node {

        private String label;

        public Node(String label) {
            super();
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
