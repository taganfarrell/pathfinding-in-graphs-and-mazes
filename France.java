import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class France extends Problem {
    private HashMap<String, FrenchCity> cities = new HashMap<>();
    private FrenchCity initialState;
    private FrenchCity goalState;

    public France() {
        cities = new HashMap<>();

        // Initialize cities
        cities.put("nice", new FrenchCity("nice", new LatLong(43, 42, 12, 'N', 7, 15, 59, 'E')));
        cities.put("toulouse", new FrenchCity("toulouse", new LatLong(43, 36, 16, 'N', 1, 26, 38, 'E')));
        cities.put("limoges", new FrenchCity("limoges", new LatLong(45, 50, 7, 'N', 1, 15, 45, 'E')));
        cities.put("nancy", new FrenchCity("nancy", new LatLong(48, 41, 37, 'N', 6, 11, 5, 'E')));
        cities.put("dijon", new FrenchCity("dijon", new LatLong(47, 19, 0, 'N', 5, 1, 0, 'E')));
        cities.put("strasbourg", new FrenchCity("strasbourg", new LatLong(48, 35, 0, 'N', 7, 45, 0, 'E')));
        cities.put("caen", new FrenchCity("caen", new LatLong(49, 11, 0, 'N', 0, 22, 0, 'W')));
        cities.put("lyon", new FrenchCity("lyon", new LatLong(45, 46, 0, 'N', 4, 50, 0, 'E')));
        cities.put("rennes", new FrenchCity("rennes", new LatLong(48, 6, 53, 'N', 1, 40, 46, 'W')));
        cities.put("montpellier", new FrenchCity("montpellier", new LatLong(43, 36, 43, 'N', 3, 52, 38, 'E')));
        cities.put("grenoble", new FrenchCity("grenoble", new LatLong(45, 10, 18, 'N', 5, 43, 21, 'E')));
        cities.put("avignon", new FrenchCity("avignon", new LatLong(43, 57, 0, 'N', 4, 49, 0, 'E')));
        cities.put("nantes", new FrenchCity("nantes", new LatLong(47, 13, 5, 'N', 1, 33, 10, 'W')));
        cities.put("paris", new FrenchCity("paris", new LatLong(48, 51, 24, 'N', 2, 21, 3, 'E')));
        cities.put("marseille", new FrenchCity("marseille", new LatLong(43, 17, 47, 'N', 5, 22, 12, 'E')));
        cities.put("bordeaux", new FrenchCity("bordeaux", new LatLong(44, 35, 14, 'N', 5, 8, 7, 'E')));
        cities.put("calais", new FrenchCity("calais", new LatLong(50, 56, 53, 'N', 1, 51, 23, 'E')));
        cities.put("brest", new FrenchCity("brest", new LatLong(48, 23, 0, 'N', 4, 29, 0, 'W')));

        // Add all connections
        cities.get("nice").addConnection(cities.get("marseille"), 199);

        cities.get("toulouse").addConnection(cities.get("montpellier"), 243);
        cities.get("toulouse").addConnection(cities.get("bordeaux"), 244);
        cities.get("toulouse").addConnection(cities.get("limoges"), 290);

        cities.get("limoges").addConnection(cities.get("lyon"), 411);
        cities.get("limoges").addConnection(cities.get("toulouse"), 290);
        cities.get("limoges").addConnection(cities.get("bordeaux"), 223);
        cities.get("limoges").addConnection(cities.get("nantes"), 319);
        cities.get("limoges").addConnection(cities.get("paris"), 393);

        cities.get("nancy").addConnection(cities.get("strasbourg"), 159);
        cities.get("nancy").addConnection(cities.get("dijon"), 213);
        cities.get("nancy").addConnection(cities.get("paris"), 347);
        cities.get("nancy").addConnection(cities.get("calais"), 478);

        cities.get("dijon").addConnection(cities.get("strasbourg"), 330);
        cities.get("dijon").addConnection(cities.get("lyon"), 195);
        cities.get("dijon").addConnection(cities.get("paris"), 314);
        cities.get("dijon").addConnection(cities.get("nancy"), 213);

        cities.get("strasbourg").addConnection(cities.get("dijon"), 330);
        cities.get("strasbourg").addConnection(cities.get("nancy"), 159);

        cities.get("caen").addConnection(cities.get("calais"), 349);
        cities.get("caen").addConnection(cities.get("paris"), 250);
        cities.get("caen").addConnection(cities.get("rennes"), 184);

        cities.get("lyon").addConnection(cities.get("grenoble"), 113);
        cities.get("lyon").addConnection(cities.get("avignon"), 230);
        cities.get("lyon").addConnection(cities.get("limoges"), 411);
        cities.get("lyon").addConnection(cities.get("dijon"), 195);

        cities.get("rennes").addConnection(cities.get("caen"), 184);
        cities.get("rennes").addConnection(cities.get("paris"), 348);
        cities.get("rennes").addConnection(cities.get("brest"), 243);
        cities.get("rennes").addConnection(cities.get("nantes"), 113);

        cities.get("montpellier").addConnection(cities.get("avignon"), 95);
        cities.get("montpellier").addConnection(cities.get("toulouse"), 243);

        cities.get("grenoble").addConnection(cities.get("avignon"), 221);
        cities.get("grenoble").addConnection(cities.get("lyon"), 113);

        cities.get("avignon").addConnection(cities.get("grenoble"), 221);
        cities.get("avignon").addConnection(cities.get("marseille"), 103);
        cities.get("avignon").addConnection(cities.get("montpellier"), 95);
        cities.get("avignon").addConnection(cities.get("lyon"), 230);

        cities.get("nantes").addConnection(cities.get("limoges"), 319);
        cities.get("nantes").addConnection(cities.get("bordeaux"), 349);
        cities.get("nantes").addConnection(cities.get("rennes"), 113);

        cities.get("paris").addConnection(cities.get("calais"), 294);
        cities.get("paris").addConnection(cities.get("nancy"), 347);
        cities.get("paris").addConnection(cities.get("dijon"), 314);
        cities.get("paris").addConnection(cities.get("limoges"), 393);
        cities.get("paris").addConnection(cities.get("rennes"), 348);
        cities.get("paris").addConnection(cities.get("caen"), 250);

        cities.get("marseille").addConnection(cities.get("nice"), 199);
        cities.get("marseille").addConnection(cities.get("avignon"), 103);

        cities.get("bordeaux").addConnection(cities.get("limoges"), 223);
        cities.get("bordeaux").addConnection(cities.get("toulouse"), 244);
        cities.get("bordeaux").addConnection(cities.get("nantes"), 349);

        cities.get("calais").addConnection(cities.get("nancy"), 478);
        cities.get("calais").addConnection(cities.get("paris"), 294);
        cities.get("calais").addConnection(cities.get("caen"), 349);

        cities.get("brest").addConnection(cities.get("rennes"), 243);
    }

    @Override
    public ArrayList<Action> getActions(State state) {
        ArrayList<Action> actions = new ArrayList<>();
        if (state instanceof FrenchCity) {
            FrenchCity currentCity = (FrenchCity) state;
            Map<FrenchCity, Integer> connections = currentCity.getConnections();

            for (Map.Entry<FrenchCity, Integer> entry : connections.entrySet()) {
                FrenchCity destinationCity = entry.getKey();
                int distance = entry.getValue();

                // Use FrenchAction with destination city and distance
                Action action = new FrenchAction(destinationCity.getName(), distance);
                actions.add(action);
            }
        }
        return actions;
    }


    @Override
    public State getResult(State state, Action action) {
        if (state instanceof FrenchCity && action instanceof FrenchAction) {
            FrenchAction frenchAction = (FrenchAction) action;
            String destinationName = frenchAction.getDestinationName();

            FrenchCity destinationCity = cities.get(destinationName);
            
            if (destinationCity != null) {
                return destinationCity;
            } else {
                System.err.println("Destination city '" + destinationName + "' not found.");
            }
        } else {
            // Handle invalid input types
            System.err.println("Invalid state or action type.");
        }
        return null; // Return null if the destination city is not found or input types are invalid
    }

    @Override
    public double getActionCost(State state, Action action) {
        if (state instanceof FrenchCity && action instanceof FrenchAction) {
            FrenchAction moveAction = (FrenchAction) action;
    
            // Directly return the cost associated with this action
            return moveAction.getCost();
        } else {
            System.err.println("Invalid state or action type.");
        }
        return Double.POSITIVE_INFINITY; // Return a high cost if the action is not valid or possible
    }    

    @Override
    public double h(State state) {
        if (!(state instanceof FrenchCity)) {
            return Double.POSITIVE_INFINITY; // Indicate an invalid state
        }
        FrenchCity currentCity = (FrenchCity) state;
        
        FrenchCity goalCity = null;
        State goalState = this.getGoalState();
        if (goalState instanceof FrenchCity) {
            goalCity = (FrenchCity) goalState;
        } else {
            System.err.println("Goal state is not a valid FrenchCity.");
        }
        
        if (goalCity == null) {
            return Double.POSITIVE_INFINITY; // No goal city set
        }
    
        // Calculate the great-circle distance between the current city and the goal city
        return currentCity.getCoordinates().distanceTo(goalCity.getCoordinates());
    }

    @Override
    public void setInitialStateByName(String name) {
        State state = cities.get(name);
        if (state instanceof FrenchCity) {
            this.initial = (FrenchCity) state;
            // System.out.println("Initial state set to: " + name + " -> " + initial);
        } else {
            System.err.println("Initial state '" + name + "' is not a valid FrenchCity.");
        }
    }

    @Override
    public void setGoalStateByName(String name) {
        State state = cities.get(name);
        if (state instanceof FrenchCity) {
            this.goal = (FrenchCity) state;
            // System.out.println("Goal state set to: " + name + " -> " + goal);
        } else {
            System.err.println("Goal state '" + name + "' is not a valid FrenchCity.");
        }
    }

    // Method to get the cities map
    public Map<String, FrenchCity> getCities() {
        return this.cities;
    }

    public State getGoalState() {
        return this.goal;
    }

    public State getInitialState() {
        return this.initial;
    }
}
