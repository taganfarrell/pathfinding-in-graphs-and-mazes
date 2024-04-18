import java.util.Objects;


public class FrenchAction extends Action {
    private String destinationName;
    private int cost;

    public FrenchAction(String destinationName, int cost) {
        this.destinationName = destinationName;
        this.cost = cost;
    }

    @Override
    protected Object clone() {
        return new FrenchAction(this.destinationName, this.cost);
    }

    @Override
    public int compareTo(Action o) {
        if (o instanceof FrenchAction) {
            return Integer.compare(this.cost, ((FrenchAction) o).cost);
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FrenchAction)) return false;
        FrenchAction that = (FrenchAction) o;
        return cost == that.cost && Objects.equals(destinationName, that.destinationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationName, cost);
    }

    @Override
    public String toString() {
        return "Move to " + destinationName + " with cost " + cost;
    }

    // Getters
    public String getDestinationName() {
        return destinationName;
    }

    public int getCost() {
        return cost;
    }
}
