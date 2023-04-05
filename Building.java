/**
 * Represents a building 
 */
public class Building {
    /**
     * The name of this Building.
     */
    protected String name;
    /**
     * The address of this Building.
     */
    protected String address;
    /**
     * The number of floors in this Building.
     */
    protected int nFloors;
    /**
     * The active floor the person is currently on in this Building. Default value of -1 indicates we are not inside this building.
     */
    protected int activeFloor = -1;
  
    /**
     * Default Building Constructor set with default values.
     */
    public Building() {
      this("<Name Unknown>", "<Address Unknown>", 1);
    }
  
    /**
     * Overloaded Building constructor with address only
     * @param address The address of the Building
     */
    public Building(String address) {
      this(); // Call default constructor
      this.address = address; // Override address
    }
    /**
     * Overloaded Building constructor with name and address
     * @param name The name of the Building
     * @param address The address of the Building
     */
    public Building(String name, String address) {
      this(name, address, 1); // Call full constructor with hard-coded # floors
    }
    /**
     * Full Building Constructor.
     * @param name The name of the Building
     * @param address The address of the Building
     * @param nFloors The number of floors in the building
     */
    public Building(String name, String address, int nFloors) {
      if (name != null) {
        this.name = name;
      }
      if (address != null) {
        this.address = address;
      }
      if (nFloors < 1) {
        throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
      }
      this.nFloors = nFloors;
    }
  
    /**
     * Accessor for Building's name
     * @return The Building's name
     */
    public String getName() {
      return this.name;
    }
    /**
     * Accessor for Building's address
     * @return The Building's address
     */
    public String getAddress() {
      return this.address;
    }
    /**
     * Accessor for Building's number of floors
     * @return The Building's number of floors
     */
    public int getFloors() {
      return this.nFloors;
    }
    /**
     * Navigation method that allows the person to enter the Building
     * @return A pointer to the current Building
     */
    public Building enter() {
      if (activeFloor != -1) {
        throw new RuntimeException("You are already inside this Building.");
      }
      this.activeFloor = 1;
      System.out.println("You are now inside " + this.name + " on the ground floor.");
      return this;
    }
    /**
     * Navigation method that allows the person to exit the Building
     * @return null The person is now outside of the Building
     */
    public Building exit() {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
      }
      if (this.activeFloor > 1) {
        throw new RuntimeException("You have fallen out a window from floor #" + this.activeFloor + "!");
      }
      System.out.println("You have left " + this.name + ".");
      this.activeFloor = -1;
      return null;
    }
    /**
     * Navigation method that allows the person to go to a certain floor of the Building
     * @param floorNum The person's current floor number in that Building 
     */
    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
    /**
     * Method that allows the person to go up one floor.
     */
    public void goUp() {
      this.goToFloor(this.activeFloor + 1);
    }
    /**
     * Method that allows the person to go down one floor.
     */
    public void goDown() {
      this.goToFloor(this.activeFloor - 1);
    }
    /**
     * Shows all the Building's possible options
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }
    /**
     * Creates a String that states the Building's name, number of floors, and address.
     * @return A modified String
     */
    public String toString() {
      return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }
    /**
     * Main method created to test methods
     * @param args The command line arguments
     */
    public static void main(String[] args) {
      System.out.println("------------------------------------");
      System.out.println("Test of Building constructor/methods");
      System.out.println("------------------------------------");
  
      Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
      System.out.println(fordHall);
      fordHall.showOptions();
  
      System.out.println("-----------------------------------");
      System.out.println("Demonstrating enter/exit/navigation");
      System.out.println("-----------------------------------");
      fordHall.enter();
      fordHall.goUp();
      fordHall.goDown();
      fordHall.exit();
    }
  }