/*
 * MarksMain.java
 * Copyright (c) 2024 Mark Maloof.  All Rights Reserved.  See LICENSE.
 */

 public class Main {

  public static void main(String[] args) {
      String[][] cityPairs = {
          {"brest", "marseille"},
          {"montpellier", "calais"},
          {"strasbourg", "bordeaux"},
          {"paris", "grenoble"},
          {"grenoble", "paris"},
          {"brest", "grenoble"},
          {"grenoble", "brest"}
      };

      Search search = new Search();
      Problem problem = new France();

      for (int i = 0; i < cityPairs.length; i++) {
          String initial = cityPairs[i][0];
          String goal = cityPairs[i][1];

          // System.out.printf("\n---Testing Path from %s to %s---\n", initial, goal);

          // Set initial and goal states
          problem.setInitialStateByName(initial);
          problem.setGoalStateByName(goal);

          // Uniform Cost Search
          performSearch(search, problem, "UCS", initial, goal);

          // Greedy Best-First Search
          performSearch(search, problem, "GBFS", initial, goal);

          // A* Search
          performSearch(search, problem, "A*", initial, goal);
      }
  }

  private static void performSearch(Search search, Problem problem, String searchType, String initial, String goal) {
    Solution solution;
    switch (searchType) {
        case "UCS":
            solution = search.ucs(problem);
            break;
        case "GBFS":
            solution = search.gbfs(problem);
            break;
        case "A*":
            solution = search.astar(problem);
            break;
        default:
            System.out.println("Invalid search type.");
            return;
    }

    if (solution == null) {
        System.out.println(searchType + " from " + initial + " to " + goal);
        System.out.println("No solution was found.");
    } else {
        // Construct the path from the actions
        StringBuilder path = new StringBuilder();
        solution.getActions().forEach(action -> path.append(action).append(" "));
        int actionsSize = solution.getActions().size();

        // Print out in the specified format
        System.out.println(searchType + " from " + initial + " to " + goal);
        System.out.print(solution.getCost() + " " + path.toString().trim());
        System.out.print(" " + solution.getExplored());
        System.out.print(" " + solution.getExpanded());
        System.out.println(" " + solution.getMaintained());
        System.out.println("Cost: " + solution.getCost());
        System.out.println("Number of actions: " + actionsSize);
        System.out.println("\n");
    }
  }
}




