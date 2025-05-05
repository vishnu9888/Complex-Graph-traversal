# Complex-Graph-traversal
Reads nodes (ID|Name) and edges (ID->ID), prints names in dependency order. Uses Kahn's algorithm with defaultdict/deque. Handles stdin input, outputs sorted node names. Compact Python implementation.
Graph Traversal - Topological Sort

Overview:

This Java program reads a list of nodes and edges to perform a topological sort on a directed graph.
Each node has a unique ID and a name. An edge from one node to another means the first node must be processed before the second.
The program prints the names of the nodes in a valid topological order, followed by the count of processed nodes.

How to Run:

1. Compile the program:
   javac GraphTraversal.java

2. Run the program:
   java GraphTraversal

3. Input Format:

First, enter the number of nodes.
Then enter each node in the format: nodeID: nodeName
After that, enter the number of edges.
Then enter each edge in the format: fromNodeID: toNodeID

Example Input:
4
1: A
2: B
3: C
4: D
3
1: 2
1: 3
3: 4

Expected Output:
A
B
C
D
4

Explanation:

- The nodes and edges are stored in maps.
- The program calculates the in-degree (number of incoming edges) for each node.
- It starts with the nodes that have no incoming edges.
- Using a queue, it visits each node and reduces the in-degree of its children.
- When a child's in-degree becomes zero, it is added to the queue.
- This ensures nodes are printed only after their dependencies are printed.

Tools Used:

- Java programming language
- Java built-in classes like HashMap, ArrayList, Queue, and Scanner

Assumptions:

- The input is correct and well-formed.
- There are no cycles in the graph.
- Each node ID is unique.

Design Choices:

- Used maps for fast access to node names and relationships.
- Used a queue to handle the order of processing based on dependencies.
- BFS-based approach (Kahn’s Algorithm) ensures the correct order is maintained.
