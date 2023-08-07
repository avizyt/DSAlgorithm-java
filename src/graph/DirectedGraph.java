package graph;
import java.util.*;

public class DirectedGraph {
    private final Map<Integer, List<Integer>> adjList;

    public DirectedGraph() {
        adjList = new HashMap<>();
    }

    public void addNode(int node) {
        adjList.put(node, new ArrayList<>());
    }

    public void removeNode(int node) {
        adjList.remove(node);
        for (List<Integer> neighbors : adjList.values()) {
            neighbors.remove(Integer.valueOf(node));
        }
    }

    public void addEdge(int fromNode, int toNode) {
        adjList.get(fromNode).add(toNode);
    }

    public void removeEdge(int fromNode, int toNode) {
        adjList.get(fromNode).remove(Integer.valueOf(toNode));
    }

    public List<Integer> getNode() {
        return new ArrayList<>(adjList.keySet());
    }

    public List<Integer> getEdges(int node) {
        return new ArrayList<>(adjList.getOrDefault(node, new ArrayList<>()));
    }

    public boolean hasNode(int node) {
        return adjList.containsKey(node);
    }

    public boolean hasEdge(int fromNode, int toNode) {
        return adjList.containsKey(fromNode) && adjList.get(fromNode).contains(toNode);
    }

    public boolean isEmpty() {
        return adjList.isEmpty();
    }

    public int size() {
        return adjList.size();
    }

    public boolean isCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (int node : adjList.keySet()) {
            if (isCycleUtil(node, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCycleUtil(int node, Set<Integer> visited, Set<Integer> recursionStack) {
        if (recursionStack.contains(node)) return true;
        if (visited.contains(node)) return false;
        visited.add(node);
        recursionStack.add(node);

        for (int neighbor : getEdges(node)) {
            if (isCycleUtil(neighbor, visited, recursionStack)) {
                return true;
            }
        }
        recursionStack.remove(node);
        return false;
    }

    public List<Integer> topologicalSort() {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                topologicalSortUtil(node, visited, result);
            }
        }
            return result;
    }
    private void topologicalSortUtil(int node, Set<Integer> visited, List<Integer> result) {
        visited.add(node);
        for (int neighbor : getEdges(node)) {
            if (!visited.contains(neighbor)) {
                topologicalSortUtil(neighbor, visited, result);
            }
        }
        result.add(0, node);
    }

    // Other important algorithms related to digraph
    public List<Integer> BFS(int startNode){
        List<Integer> results = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()){
            int node = queue.poll();
            results.add(node);

            for (int neighbor : getEdges(node)){
                if (!visited.contains(neighbor)){
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return results;
    }

}
