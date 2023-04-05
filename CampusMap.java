import java.util.ArrayList;
/**
 * Represents a map of Campus
 */
public class CampusMap {
  /**
   * Lists the Buildings in the Campus Map
   */
  ArrayList < Building > buildings;
  /**
   * Default constructor, initalizes empty ArrayList
   */
  public CampusMap() {
    buildings = new ArrayList < Building > ();
  }
  /**
   * Adds a Building to the map
   * @param b the Building to add
   */
  public void addBuilding(Building b) {
    System.out.println("Adding building...");
    buildings.add(b);
    System.out.println("-->Successfully added " + b.getName() + " to the map.");
  }
  /**
   * Removes a Building from the map
   * @param b the Building to remove
   * @return the removed Building
   */
  public Building removeBuilding(Building b) {
    System.out.println("Removing building...");
    buildings.remove(b);
    System.out.println("-->Successfully removed " + b.getName() + " to the map.");
    return b;
  }
  /**
   * Creates a directory of Buildings
   * @return The directory of Buildings
   */
  public String toString() {
    String mapString = "DIRECTORY of BUILDINGS";

    for (int i = 0; i < this.buildings.size(); i++) {
      mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
    }
    return mapString;
  }
  /**
   * Main method created to test methods
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    CampusMap myMap = new CampusMap();
    myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
    myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063"));
    myMap.addBuilding(new Building("Burton Hall", "46 College Ln, Northampton, MA 01063", 4));
    myMap.addBuilding(new House("Wilder House", "1 Mandelle Rd", 4, true, true));
    myMap.addBuilding(new House("Cutter House", true));
    myMap.addBuilding(new House("1 Henshaw Avenue, Northampton, MA 01063"));
    myMap.addBuilding(new Library("Hillyer Library", "20 Elm Street, Northampton, MA 01063", true));
    myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true));
    myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063", 1));
    myMap.addBuilding(new Cafe("Compass Cafe", "Neilson Library 110, 7 Neilson Drive, Northampton, MA 01063", 1, 10000, 10000, 10000, 10000));
    System.out.println(myMap);
  }

}