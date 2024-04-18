import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Maze extends Problem {
    private char[][] maze;
    private MazeState initialState;
    private MazeState goalState;

    public Maze(String filename) throws IOException {
        readMaze(filename);
    }

    private void readMaze(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        int height = lines.size();
        int width = lines.get(0).length();
        maze = new char[height][width];
        int a = 0, b = 0, c = 0, d = 0;
    
        System.out.println("Loaded maze:");
        for (int y = 0; y < height; y++) {
            String line = lines.get(y);
            for (int x = 0; x < width; x++) {
                char ch = line.charAt(x);
                maze[y][x] = ch;
                if (ch == 'S') {
                    initialState = new MazeState(x, y);
                    setInitialState(initialState);
                    a = x;
                    b = y;
                } else if (ch == 'G') {
                    goalState = new MazeState(x, y);
                    setGoalState(goalState);
                    c = x;
                    d = y;
                }
            }
            System.out.println(line); // Print each line of the maze
        }
        System.out.println("Initial state set at: " + this.initial);
        System.out.println("Final goal state set at: " + this.goal);

    }    

    @Override
    public ArrayList<Action> getActions(State state) {
        if (!(state instanceof MazeState)) {
            throw new IllegalArgumentException("State must be an instance of MazeState");
        }
        MazeState mazeState = (MazeState) state;
        ArrayList<Action> actions = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Down, Right, Up, Left

        for (int[] dir : directions) {
            int newX = mazeState.getX() + dir[0];
            int newY = mazeState.getY() + dir[1];
            if (newX >= 0 && newX < maze[0].length && newY >= 0 && newY < maze.length && maze[newY][newX] != '%') {
                actions.add(new MazeAction(newX, newY));
            }
        }
        return actions;
    }

    @Override
    public State getResult(State state, Action action) {
        if (!(action instanceof MazeAction)) {
            throw new IllegalArgumentException("Action must be an instance of MazeAction");
        }
        MazeAction mazeAction = (MazeAction) action;
        return new MazeState(mazeAction.getX(), mazeAction.getY());
    }

    @Override
    public double getActionCost(State state, Action action) {
        return 1.0;
    }

    @Override
    public double h(State state) {
        if (!(state instanceof MazeState)) return Double.POSITIVE_INFINITY;
        MazeState mazeState = (MazeState) state;
        return Math.abs(mazeState.getX() - goalState.getX()) + Math.abs(mazeState.getY() - goalState.getY());
    }

    @Override
    public void setInitialState(State state) {
        this.initial = state;
    }

    @Override
    public void setGoalState(State state) {
        this.goal = state;
    }

    @Override
    public void setInitialStateByName(String s) {
        // NA
    }

    @Override
    public void setGoalStateByName(String s) {
        // NA
    }

    // Getters for initialState and goalState to use in the main method if needed
    public MazeState getInitialState() {
        return this.initialState;
    }

    public MazeState getGoalState() {
        return this.goalState;
    }
}
