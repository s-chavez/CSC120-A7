Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
In the House class, I decided to overload the constructor. If someone is making the House, there is a possibility they only know the address and no other information, so I have an overloaded constructor with the address only. I also made another overloaded constructor for the House with the name, address, and hasDiningRoom because maybe this person is working with the dining staff to organize the dining room for this House. Also, in the default constructor for the House class I set hasElevator to false as not all houses have elevators and I also set hasDiningRoom to false as more Houses do not have dining halls at Smith.  

In the Library class, I overloaded the constructor with address only because the location is the first thing the person creating this Library should know. I also overloaded the constructor a second time with the name, address, and hasElevator in case the person creating the Library wants to list if the building is accessible, meaning it has an elevator. Also, in the default constructor for the Library I set the hasElevator to false as most libraries have elevators, but not all. 

In the Cafe class, I overloaded the constructor with the name, address, and number of floors in case the person making the Cafe does not know their exact inventory yet. I also overloaded the sellCoffee method because most Cafes do have size options and not all people would know exactly how many ounces of coffee, sugar, or creams they would like so this overloaded method gives them less customization so that it is easier for them.  

- What worked, what didn't, what advice would you give someone taking this course in the future?
It helped to think about what the user would see after the code has ran. It was easier to think about what methods to overload while imagining I was the person trying to create the certain type of Building. 