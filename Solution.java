/*
 * Solution.java
 * Copyright (c) 2024 Mark Maloof.  All Rights Reserved.  See LICENSE.
 */

import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private Node finalNode;
    private int explored;
    private int expanded;
    private int maintained;
    private final List<Action> actions;
    private double cost;

    public Solution(Node finalNode, int explored, int expanded, int maintained) {
      this.explored = explored;
      this.expanded = expanded;
      this.maintained = maintained;
      this.cost = finalNode.getPathCost();
      this.actions = new ArrayList<>();

      Node current = finalNode;
      while (current != null && current.getAction() != null) { 
          actions.add(0, current.getAction());
          current = current.getParent();
      }
    }

    public int size() {
      return actions.size(); 
    }

    public double getCost() {
        return this.cost; 
    }

    // Add getters for explored, expanded, and maintained counts
    public int getExplored() { return explored; }
    public int getExpanded() { return expanded; }
    public int getMaintained() { return maintained; }

    // Method to print or retrieve the action sequence, if needed
    public List<Action> getActions() {
        return actions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // TODO: Implement the toString method using StringBuilder
        // Example: sb.append("Cost: ").append(cost);
        return sb.toString();
    }
}

