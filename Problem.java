/*
 * Problem.java
 * Copyright (c) 2024 Mark Maloof.  All Rights Reserved.  See LICENSE.
 */

import java.util.ArrayList;

public abstract class Problem
{
  protected State initial;
  protected State goal;

  public Problem() { }
  abstract public ArrayList<Action> getActions( State state );
  public State getGoalState() { return goal; };
  public State getInitialState() { return initial; };
  abstract public State getResult( State state, Action action );
  abstract public double getActionCost( State state, Action action );
  public boolean goalTest( State state ) { 
    return this.goal.equals(state);
  }
  abstract public double h( State state );
  public void setInitialState( State initial ) { this.initial = initial; }
  public void setGoalState( State goal ) { this.goal = goal; }
  abstract public void setInitialStateByName( String s );
  abstract public void setGoalStateByName( String s );
}
