# Inventory Management System Documentation

## 1. Project Overview and Objectives
The objective of this project is to develop an Advanced Inventory Management System using the Java Collections Framework. The system is designed to handle product data efficiently by selecting the optimal data structure for each specific business requirement, such as uniqueness, sorting, and historical tracking.

### Key Objectives
• Unique Identification: Ensuring no two products share the same SKU.

• Automatic Sorting: Maintaining a catalog sorted by product code.

• Undo Functionality: Allowing users to revert the last inventory change.

• Process Management: Handling pending update requests in a First-In-First-Out (FIFO) manner.

## 2. Setup and Installation Instructions**

1. JDK Requirement: Ensure JDK 11 or higher is installed on your system.

2. Project Import:
   - Clone the repository from GitHub.
   - Open the project folder in IntelliJ IDEA.

3. Compilation: Allow IntelliJ to index the files and ensure the src folder is marked as the "Sources Root."

4. Execution: Locate Main.java, right-click, and select Run 'Main.main()'.
5. User Manual:
   
    - The console will display the initial inventory sorted by SKU.
    - Observe the "Undo" operation removing the last added item.
    - View the queue processing pending restock requests.
    - Review the final transaction history log.

## 3. Code Structure Explanation

The system is organized into three primary components to ensure modularity and clean code:

| Component | Responsibility | 
| :--- | :--- |
| **Product Class** | Acts as the data model. It implements Comparable to define natural sorting and overrides equals/hashCode for uniqueness. | 
| **InventoryManager** | The core engine that manages various Collections (HashSet, TreeSet, Stack, Queue) and provides methods for business logic. | 
| **Main Class** | The driver class that demonstrates the system's capabilities and handles console output. | 

## 4. Technical Requirements Details

The following advanced Java Collections were utilized to meet the project's technical specifications:

• HashSet: Implemented to manage a registry of unique SKUs. This provides $O(1)$ time complexity for checking if a product exists before adding it.

• TreeSet: Used for the product catalog to ensure all items are automatically sorted by their SKU.

• LinkedList: Utilized to maintain a persistent "Transaction History" log of every action taken in the system.

• Stack: Implemented for the Undo feature. Each new addition is pushed onto the stack; the pop() method is used to revert the most recent change.

• Queue: Used to manage a "Pending Updates" list. This ensures that restock requests are processed in the exact order they were received (FIFO).

• Comparable Interface: Implemented in the Product class to provide natural sorting logic based on the SKU.

• Custom Comparators: Created specific sorting logic to allow the inventory to be viewed by Price or Quantity independently of the SKU.


## 5. System Workflow & Data Optimization
  The system optimizes performance by matching operations to the correct data structures:
  
1. **Entry**: When a product is added, the HashSet checks for duplicates instantly.

2. **Organization**: The TreeSet places the item in its correct sorted position.

3. **Safety**: The Stack records the change for potential reversal.

4. **Processing**: The Queue holds secondary tasks (like restocks) without interrupting the main catalog.

## 6. Screenshots & Diagrams
UML Class Diagram

This diagram shows the relationship between the Book, Member, and Library classes.


https://github.com/adityabliss25/Library-Management-System/blob/master/docs/Images/Use%20Case%20Diagram.png


Console Output
https://github.com/adityabliss25/Library-Management-System/blob/master/docs/Images/Console%20Output.png
