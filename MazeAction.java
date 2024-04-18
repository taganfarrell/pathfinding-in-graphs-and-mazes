import java.util.Objects;

public class MazeAction extends Action {
    private final int x;
    private final int y;

    public MazeAction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Implement abstract methods from Action class
    @Override
    public MazeAction clone() {
        return new MazeAction(this.x, this.y);
    }

    @Override
    public int compareTo(Action other) {
        if (!(other instanceof MazeAction)) {
            throw new IllegalArgumentException("Can only compare MazeAction objects.");
        }
        MazeAction otherAction = (MazeAction) other;
        int xCompare = Integer.compare(this.x, otherAction.x);
        if (xCompare != 0) return xCompare;
        return Integer.compare(this.y, otherAction.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MazeAction that = (MazeAction) obj;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Move to (" + x + ", " + y + ")";
    }

    // Getter methods for x and y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
