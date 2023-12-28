# Graph Traversal Simulator

## Overview
This Java application is designed to simulate graph traversal processes. It builds a graph data structure from a given set of nodes and edges and performs both depth-first and breadth-first searches starting from a specified node. The project helps users understand the underlying concepts of graph theory and traversal techniques, as well as the practical implementation of the Comparable interface for sorting in Java.

## Features
- **Graph Construction**: Builds a graph data structure from user-provided input in standard input format.
- **Neighbor Listing**: For each node in the graph, outputs a list of its neighbors.
- **Depth-First Search (DFS)**: Performs a depth-first traversal from a given starting node, following the textbook's pseudocode.
- **Breadth-First Search (BFS)**: Implements a breadth-first traversal from the starting node, also following textbook guidelines.
- **Alphabetical Ordering**: When traversing, neighbors are visited in alphabetical order as per textbook conventions.

## Input Format
The input format for describing the graph is as follows:
- First line: A list of node names in alphabetical order.
- Second line: The name of the starting node for the traversal.
- Subsequent lines: Each defines one edge in the graph, with the format `node1 node2`. Edges are undirected.
- Last line: Three asterisks `***` to signify the end of the edge definitions.

## Example
![The graph used looks like the following](https://github.com/DanielH987/Graph-Traversal/blob/main/blob/graph.png)  

Input:  
>A B C D E F G H I J  
>F  
>A B  
>A D  
>A C  
>B C  
>B E  
>B G  
>C E  
>C F  
>D F  
>E F  
>E G  
>F H  
>G H  
>H I  
>I J  
>G J  
>\***  

Output:  
Node Neighbors:  
>A: B C D   
>B: A C E G  
>C: A B E F  
>D: A F  
>E: B C F G  
>F: C D E H  
>G: B E H J  
>H: F G I  
>I: H J  
>J: G I  
>Depth-First Search:  
>F C A B E G H I J D  
>Breadth-First Search:  
>F C D E H A B G I J  

The application will output the neighbors of each node, followed by the order of nodes visited in both depth-first and breadth-first searches.

## Usage
1. Compile and run the Java program.
2. Provide the graph description through standard input.
3. Review the output for neighbor listings and traversal orders.

## Contributing
Contributions to enhance the functionality, improve the efficiency of traversal algorithms, or improve documentation are welcome. Please maintain adherence to the project's code style and contribute via pull requests.
