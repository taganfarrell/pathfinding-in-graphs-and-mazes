import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;
import java.util.function.Function;
import java.util.HashMap;
import java.util.Map;

public class Search {

    // Generic best-first search
    private Solution bestFirstSearch(Problem problem, Function<Node, Double> costFunction, Function<State, Double> heuristicFunction) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingDouble(node -> costFunction.apply(node) + heuristicFunction.apply(node.getState())));
        Set<State> explored = new HashSet<>();
        Map<State, Double> stateCostMap = new HashMap<>();
        Node initialNode = new Node(problem.getInitialState(), null, null, 0.0);
        initialNode.setFValue(heuristicFunction.apply(initialNode.getState()));
        frontier.add(initialNode);
        stateCostMap.put(initialNode.getState(), 0.0);

        int nodesExplored = 0;
        int nodesExpanded = 0;

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            nodesExplored++;
            if (currentNode == null || currentNode.getState() == null) {
                // System.out.println("Current node or its state is null.");
                continue; // Skip to the next iteration if the current node or state is null
            }
            State currentState = currentNode.getState();

            if (explored.contains(currentState) && stateCostMap.get(currentState) <= currentNode.getPathCost()) {
                continue;
            }

            if (problem.goalTest(currentState)) {
                // System.out.println("Goal found: " + currentState);
                return new Solution(currentNode, nodesExplored, nodesExpanded, frontier.size());
            }         

            explored.add(currentState);
            stateCostMap.put(currentState, currentNode.getPathCost());

            for (Action action : problem.getActions(currentState)) {
                nodesExpanded++;
                State nextState = problem.getResult(currentState, action);
                if (nextState == null) {
                    // System.out.println("Next state generation returned null.");
                    continue;
                }
                double actionCost = problem.getActionCost(currentState, action);
                double newPathCost = currentNode.getPathCost() + actionCost;

                if (!stateCostMap.containsKey(nextState) || newPathCost < stateCostMap.get(nextState)) {
                    Node nextNode = new Node(nextState, currentNode, action, newPathCost);
                    nextNode.setFValue(newPathCost + heuristicFunction.apply(nextState));
                    frontier.add(nextNode);
                    stateCostMap.put(nextState, newPathCost);
                }
            }
        }

        // If the loop exits without finding a solution
        return null;
    }

    public Solution ucs(Problem problem) {
        return bestFirstSearch(problem, Node::getPathCost, node -> 0.0); // UCS uses only g(n)
    }

    public Solution gbfs(Problem problem) {
        return bestFirstSearch(problem, node -> 0.0, problem::h); // GBFS uses only h(n)
    }

    public Solution astar(Problem problem) {
        return bestFirstSearch(problem, Node::getPathCost, problem::h); // A* uses g(n) + h(n)
    }
}
