import java.util.ArrayList;
/**
 * Represents a House that is a type of Building.
 */
public class House extends Building {
  /**
   * The ArrayList of people who live in this House.
   */
  private ArrayList < String > residents;
  /**
   * The boolean representing if the House has a dining room.
   */
  private boolean hasDiningRoom;
  /**
   * The boolean representing if the House has an elevator.
   */
  private boolean hasElevator;
  /**
   * Default House Constructor set with default values.
   */
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1, false, false);
  }
  /**
   * Overloaded House constructor with address only
   * @param address The House's address
   */
  public House(String address) {
    this(); // Call default constructor
    this.address = address; // Override address
  }
  /**
   * Overloaded House constructor with name and hasDiningRoom
   * @param name The House's name
   * @param hasDiningRoom The boolean representing if the House has a dining room
   */
  public House(String name, boolean hasDiningRoom) {
    this();
    this.name = name;
    this.hasDiningRoom = hasDiningRoom;
  }
  /**
   * Full constructor for the House 
   * @param name The House's name
   * @param address The House's address
   * @param nFloors The House's number of floors
   * @param hasDiningRoom The boolean representing if the House has a dining hall
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList < String > ();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }
  /**
   * Accessor for if the House has a dining hall
   * @return The boolean value representing if the House has a dining hall
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }
  /**
   * Accessor for if the House has an elevator
   * @return The boolean value representing if the House has an elevator
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }
  /**
   * Checks if the House has an elevator and allows the person to go up to the requested floor 
   */
  public void goToFloor(int n) {
    if (this.hasElevator == true) {
      super.goToFloor(n);
    } else {
      while (activeFloor < n) {
        System.out.println("Going up to floor #" + (activeFloor + 1) + "!");
        activeFloor++;
      }
      System.out.println("You are now on floor #" + n + " of " + this.name + "!");
      this.activeFloor = n;
    }
  }
  /**
   * Accessor for the number of residents
   * @return The number of residents in the House
   */
  public int nResidents() {
    return this.residents.size();
  }
  /**
   * Checks if the given person is a resident of the House and adds them to roster
   * @param name The given person's name
   */
  public void moveIn(String name) {
    if (this.residents.contains(name)) {
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");
  }
  /**
   * Checks if the given person is a resident of the House and removes them from roster
   * @param name The name of the given person
   * @return The name of the given person who moved out
   */
  public String moveOut(String name) {
    if (this.residents.contains(name)) {
      this.residents.remove(name);
      System.out.println(name + " just moved out of " + this.name + "! Go say goodbye :-(");
    } else {
      throw new RuntimeException(name + " is not a resident of " + this.name);
    }
    return name;
  }
  /**
   * Checks if the given person is a resident of the House
   * @param person The given person's name
   * @return The boolean of whether or not a person is a resident of the House
   */
  public boolean isResident(String person) {
    if (this.residents.contains(person)) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * Creates a formatted description of the House
   * @return The formatted description
   */
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }
  /**
   * Shows all the House's possible options
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + hasElevator() \n + nResidents() \n + moveIn() \n + moveOut() \n + isResident()");
  }
  public void goToFloor(int floorNum, boolean hasElevator) {

  }
  /**
   * Main method created to test methods
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false, true);
    // System.out.println(morrow);
    // morrow.moveIn("Jack");
    // System.out.println(morrow.isResident("Jack"));
    // System.out.println(morrow);
    // House king = new House("King", "The Quad", 3, true);
    // king.moveIn("Jill");
    // System.out.println(king);
    // king.moveOut("Jill");
    // System.out.println(king);
    morrow.showOptions();
    // morrow.enter();
    // morrow.goToFloor(4);
  }
}