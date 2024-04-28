# DSAL Project: Library Management System

## Contributors
- Tirthraj Mahajan
- Advait Joshi
- Rinit Jain

---

**Project Title:** Library Management System

---

## Installation

1. Clone Git Repo
```bash
git clone https://github.com/tirthraj07/DSAL-Project.git
cd DSA-Project
```

2. Compile all the util package
```bash
javac .\utils\*.java
```

3. Complile Main.java
```
javac .\Main.java
```
This should also compile the Menu.java and SQL_DB.java file. If not, make sure to compile then

4. Run the Java Code with classpath of `sqlite-jdbc-3.45.3.0.jar` and `slf4j-api-1.7.36.jar`  

For Windows
```powershell
java -classpath ".;sqlite-jdbc-3.45.3.0.jar;slf4j-api-1.7.36.jar" Main
```

For Linux and macOS
```bash
java -classpath ".:sqlite-jdbc-3.45.3.0.jar:slf4j-api-1.7.36.jar" Main
```
---

## Project Description

The Library Management System is a command-line application designed to efficiently manage a library's collection of books. It provides users with the ability to browse the entire library catalog, search for specific books, and perform actions such as borrowing and returning books.

This project serves as an integration of various data structures and algorithms learned throughout our second year of engineering studies, implemented in Java. The emphasis on incorporating these structures ensures efficient and scalable operations, catering to potential growth in the library's collection over time.

### Functionality Overview

1. **Book Structure:**
   - The `Book` class represents a fundamental structure containing essential book information, such as the author and total number of available copies.

2. **Node Structure:**
   - The `Node` structure encapsulates a `Book` object along with left and right pointers for tree-based operations. Additionally, it includes a height attribute, facilitating constant-time access to the node's height.

3. **AVL Tree Structure:**
   - The AVL tree structure builds upon the `Node` structure, implementing functions for balancing the tree upon insertion. It features rotation procedures (LL, LR, RL, RR) to maintain optimal tree height and includes search functionality to locate specific nodes efficiently.

4. **HashNode Structure:**
   - The `HashNode` structure associates author names with corresponding AVL trees containing book information.

5. **Vector Structure:**
   - The `Vector` structure represents an array of `HashNodes` that dynamically expands to accommodate increasing data volume. It follows a conventional vector approach, doubling its size as needed.

6. **HashTable Structure:**
   - The `HashTable` structure manages a vector of `HashNodes` and incorporates a hash function to map author names to specific indices within the vector. Collision handling is implemented using Linear Probing, efficiently managing hash collisions.

### Database Integration

To ensure data persistence and efficient retrieval, the project utilizes SQLite, a SQL database, to store information related to authors and books. Below is the schema of the database:

```sql
CREATE TABLE IF NOT EXISTS 'authors' (
    id INTEGER PRIMARY KEY, 
    name TEXT
);

CREATE TABLE IF NOT EXISTS books (
    id INTEGER PRIMARY KEY,
    name TEXT,
    author_id INTEGER,
    total INTEGER,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);
```
The initiation process involves scanning the authors table and inserting entries into the hash table. Subsequently, each book is inserted with its corresponding author from the authors table, along with the total count of available copies.

---
## Time Complexity
Let `n` be the number of authors and `m` be the number of books in the database 

For searching book with author  

**Best Case** : O(1)  
**Average Case** : O(log m)  
**Worst Case** : O(n log m)  
