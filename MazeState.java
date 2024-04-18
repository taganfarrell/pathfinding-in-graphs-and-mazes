import java.util.Objects;

public class MazeState extends State {
    private int x, y;

    public MazeState(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public MazeState clone() {
        return new MazeState(this.x, this.y);
    }

    @Override
    public int compareTo(State other) {
        if (!(other instanceof MazeState)) {
            throw new IllegalArgumentException("Cannot compare MazeState with a different type of State");
        }
        MazeState otherMazeState = (MazeState) other;
        int result = Integer.compare(this.x, otherMazeState.x);
        if (result == 0) {
            return Integer.compare(this.y, otherMazeState.y);
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MazeState other = (MazeState) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "MazeState{" + "x=" + x + ", y=" + y + '}';
    }

    // Getter methods for x and y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
