import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FrenchCity extends State {
    private String name;
    private LatLong coordinates;
    private Map<FrenchCity, Integer> connections = new HashMap<>();

    // Constructor
    public FrenchCity(String name, LatLong coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FrenchCity clonedCity = new FrenchCity(this.name, this.coordinates);
        return clonedCity;
    }

    @Override
    public int compareTo(State other) {
        return this.name.compareTo(((FrenchCity) other).name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FrenchCity city = (FrenchCity) obj;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "FrenchCity{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

    // Getters for name and coordinates
    public String getName() {
        return name;
    }

    public LatLong getCoordinates() {
        return coordinates;
    }

    public void addConnection(FrenchCity city, int distance) {
        connections.put(city, distance);
    }

    public Map<FrenchCity, Integer> getConnections() {
        return connections;
    }
}

