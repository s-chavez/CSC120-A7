/**
 * Represents a Cafe that is a type of Building.
 */
public class Cafe extends Building {
  /**
   * The number of coffee ounces in the Cafe.
   */
  private int nCoffeeOunces;
  /**
   * The number of sugar packets in the Cafe.
   */
  private int nSugarPackets;
  /**
   * The number of creams in the Cafe.
   */
  private int nCreams;
  /**
   * The number of cups in the Cafe.
   */
  private int nCups;

  /**
   * Default Cafe constructor that sets default values.
   */
  public Cafe() {
    this("<Name Unknown>", "<Address Unknown>", 1, 100, 100, 100, 100);
  }

  /**
   * Overloaded Cafe constructor with address only
   * @param name The name of the Cafe
   * @param address The address of the Cafe
   * @param nFloors The number of floors in the Cafe
   */
  public Cafe(String name, String address, int nFloors) {
    this(); // Call default constructor
    this.name = name;
    this.address = address; // Override address
    this.nFloors = nFloors;
  }
  /**
   * Full Constructor for Cafe
   * @param name The name of the Cafe
   * @param address The address of the Cafe
   * @param nFloors The number of floors in the Cafe
   * @param nCoffeeOunces The number of coffee ounces remaining in the Cafe's inventory
   * @param nSugarPackets The number of sugar packets remaining in the Cafe's inventory
   * @param nCreams The number of "splashes" of cream remaining in the Cafe's inventory
   * @param nCups The number of cups remaining in the Cafe's inventory
   */
  public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
    super(name, address, nFloors);
    this.nCoffeeOunces = nCoffeeOunces;
    this.nSugarPackets = nSugarPackets;
    this.nCreams = nCreams;
    this.nCups = nCups;
    System.out.println("You have built a cafe!");
  }
  /**
   * Method that doesn't permit movement off the first floor.
   */
  public void goToFloor(int n) {
    if (n > 1) {
      throw new RuntimeException("You can only access the first floor. Please go to floor 1.");
    } else {
      super.goToFloor(n);
    }
  }
  /**
   * Decreases inventory in each category by given parameters and restocks if necessary
   * @param size The size of coffee requested 
   * @param nSugarPackets The number of sugar packets requested
   * @param nCreams The number of creams requested
   */
  public void sellCoffee(int size, int nSugarPackets, int nCreams) {
    if (this.nCoffeeOunces < size) {
      this.restock(50, 0, 0, 0);
    }
    if (this.nSugarPackets < nSugarPackets) {
      this.restock(0, 50, 0, 0);
    }
    if (this.nCreams < nCreams) {
      this.restock(0, 0, 50, 0);
    }
    if (this.nCups < nCups) {
      this.restock(0, 0, 0, 50);
    } else {
      this.nCoffeeOunces -= size;
      this.nSugarPackets -= nSugarPackets;
      this.nCreams -= nCreams;
      this.nCups = nCups - 1;
    }
    System.out.println("Here is your " + size + " oz coffee with " + nSugarPackets + " sugar packets and " + nCreams + " creams, enjoy!");
  }
  /**
   * Allows coffee to be ordered based on size. Decreases inventory in each category by given parameters and restocks if necessary.
   * @param size The size of coffee requested
   */
  public void sellCoffee(String size) {
    if (size.equals("small")) {
      sellCoffee(10, 5, 3);
    } else if (size.equals("medium")) {
      sellCoffee(20, 10, 6);
    } else if (size.equals("large")) {
      sellCoffee(40, 20, 12);
    } else {
      throw new RuntimeException("Please choose a valid size. Our sizes are small, medium, and large.");
    }
  }
  /**
   * Restocks inventory in each of the given parameters 
   * @param nCoffeeOunces The number of coffee ounces to be restocked
   * @param nSugarPackets The number of sugar packets to be restocked
   * @param nCreams The number of creams to be restocked
   * @param nCups The number of cups to be restocked
   */
  private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
    this.nCoffeeOunces += nCoffeeOunces;
    this.nSugarPackets += nSugarPackets;
    this.nCreams += nCreams;
    this.nCups += nCups;
  }

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goToFloor(n) \n + sellCoffee() ");
  }
  /**
   * Main method created to test methods
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    Cafe compassCafe = new Cafe("Compass", "Smith", 3, 100, 100, 100, 100);
    // compassCafe.showOptions();
    compassCafe.sellCoffee("medium");
    //   compassCafe.enter();
    //   compassCafe.goToFloor(2);
  }
}