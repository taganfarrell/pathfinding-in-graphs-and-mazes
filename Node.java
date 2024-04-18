/*
 * Node.java
 * Copyright (c) 2024 Mark Maloof.  All Rights Reserved.  See LICENSE.
 */

 public class Node implements Comparable<Node> {

  private State state;
  private Action action;
  private Node parent;
  private double pathCost;
  private double fValue;

  // Constructor
  public Node(State state, Node parent, Action action, double pathCost) {
    this.state = state;
    this.action = action;
    this.parent = parent;
    this.pathCost = pathCost;
    this.fValue = pathCost;
  }

  // Getters
  public State getState() { return state; }
  public Node getParent() { return parent; }
  public Action getAction() { return action; }
  public double getPathCost() { return pathCost; }
  public double getFValue() { return fValue; }

  public void setFValue(double heuristicValue) {
    this.fValue = this.pathCost + heuristicValue;
  }


  @Override
  public int compareTo(Node other) {
      return Double.compare(this.fValue, other.fValue);
  }
}

