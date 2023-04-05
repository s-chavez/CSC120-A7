import java.util.Hashtable;
/**
 * Represents a Library that is a type of Building.
 */
public class Library extends Building {
  /**
   * Hashtable of a book's title and author (concatenated together as one String) and boolean value to record whether or not the book is available
   */
  private Hashtable < String, Boolean > collection;
  /**
   * The boolean representing if the House has an elevator.
   */
  private boolean hasElevator;
  /**
   * Default Building Constructor set with default values.
   */
  public Library() {
    this("<Name Unknown>", "<Address Unknown>", 1, false);
  }
  /**
   * Overloaded Library constructor with address only
   * @param address The address of the Library
   */
  public Library(String address) {
    this(); // Call default constructor
    this.address = address; // Override address
  }

  /**
   * Overloaded Library constructor with name, address, hasElevator
   * @param name The name of the Library
   * @param address The address of the Library
   * @param hasElevator The boolean representing if the Library has an elevator
   */
  public Library(String name, String address, boolean hasElevator) {
    this();
    this.name = name;
    this.address = address;
    this.hasElevator = hasElevator;
  }
  /**
   * Full constructor for Library
   * @param name Name of the Library
   * @param address Address of the Library
   * @param nFloors Number of floors in the Library
   * @param hasElevator The boolean value of if the Library has an elevator
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable < String, Boolean > ();
    System.out.println("You have built a library!");
    this.hasElevator = hasElevator;
  }
  /**
   * The boolean representing if the Library has an elevator.
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }
  /**
   * Checks if the Library has an elevator and allows the person to go up to the requested floor
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
   * Updates the Library's collection to add the title
   * @param title The title of the given book
   */
  public void addTitle(String title) {
    if (this.collection.containsKey(title)) {
      throw new RuntimeException(title + " is already a part of the collection.");
    } else {
      this.collection.put(title, true);
    }
  }
  /**
   * Updates the Library's collection to remove the title
   * @param title The title of the given book
   * @return The title of the book that was removed
   */
  public String removeTitle(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.remove(title);
      return title;
    } else {
      throw new RuntimeException(title + " was never in this collection.");
    }
  }
  /**
   * Checks out the book by changing boolean to false
   * @param title The title of the given book
   */
  public void checkOut(String title) {
    this.collection.replace(title, true, false);
  }
  /**
   * Returns the book by changing the boolean to true
   * @param title The title of the given book
   */
  public void returnBook(String title) {
    this.collection.replace(title, false, true);
  }
  /**
   * Checks the Library's collection for the given book's title
   * @param title The title of the given book
   * @return The boolean of whether the book appears as a key in the Library's collection
   */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * Checks the Library's collection to see if the book is available
   * @param title The title of the given book
   * @return The boolean of whether the book is currently available
   */
  public boolean isAvailable(String title) {
    if (this.collection.get(title) == true) {
      System.out.println(title + " is available.");
      return true;
    } else {
      System.out.println(title + " is not available.");
      return false;
    }
  }
  /**
   * Prints out the Library's collection including checkout status
   */
  public void printCollection() {
    for (String key: this.collection.keySet()) {
      if (this.collection.get(key) == true) {
        System.out.println(key + " is currently available.");
      } else {
        System.out.println(key + " is currently not available.");
      }
    }
  }
  /**
   * Method that shows the options for the Library class
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()");
  }
  /**
   * Main method created to test methods
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    Library neilsonLibrary = new Library("neilson", "smith", 4, true);
    // neilsonLibrary.addTitle("Harry Potter");
    // neilsonLibrary.addTitle("Hunger Games");
    // neilsonLibrary.addTitle("Pinnochio");
    // System.out.println(neilsonLibrary.isAvailable("Harry Potter"));
    // neilsonLibrary.checkOut("Harry Potter");
    // System.out.println(neilsonLibrary.isAvailable("Harry Potter"));
    // neilsonLibrary.printCollection();
    neilsonLibrary.showOptions();
    // neilsonLibrary.enter();
    // neilsonLibrary.goToFloor(4);
  }
}