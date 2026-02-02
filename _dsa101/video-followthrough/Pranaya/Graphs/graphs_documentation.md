# Graphs - Personal Notes

## What is a Graph?
Think of it like a social network. You have people (nodes) and friendships (edges). A connects to B, B connects to C, etc. That's basically a graph.

## The Two Maps We Use

Line 22: `Map<String, Node> nodes` - This is like a phonebook. Give me a name like "A", I give you the actual Node object. Quick lookup.

Line 23: `Map<Node, List<Node>> adjacencyList` - This is the real graph structure. For each node, it stores a list of who that node is connected to. Like A's friend list contains [B, C].

## Adding Nodes (lines 25-29)
When you add a node, you create the Node object, put it in the nodes map for quick access, and initialize an empty list in adjacencyList. The empty list means "this node exists but has no connections yet."

## Adding Edges (lines 31-39)
This is where connections happen. You get both nodes from the nodes map, check they exist, then add the "to" node into the "from" node's adjacency list. One-way connection - A can point to B without B pointing back.

## Printing (lines 41-47)
Just loop through all nodes and print who they're connected to. Simple iteration through the adjacency list.

## Removing Nodes (lines 49-60)
Tricky part - when you remove a node, you gotta clean up everywhere. Loop through all nodes and remove the deleted node from their adjacency lists. Then remove it from both maps. Important: do the cleanup first, then remove from maps.

## Removing Edges (lines 62-70)
Easier than removing nodes. Just get both nodes, check they exist, then remove the "to" node from the "from" node's list. Done.

## Depth First Traversal (lines 72-87)
This is the interesting part. You start at a root node, print it, mark it as visited. Then for each neighbor, if you haven't visited it yet, go deep into that neighbor recursively. The visited set prevents infinite loops - without it, you'd keep going in circles.

The recursion goes deep first - it explores one path completely before backtracking. Like exploring a maze - go down one path until you hit a dead end, then come back and try another path.

## Key Things to Remember

- Always check if nodes exist before using them. Null checks are your friend.
- The visited set in traversal is crucial - without it, cycles will break your code.
- Adjacency list is the core - it's how we represent connections efficiently.
- When removing a node, clean up all references to it first, then remove it.
- toString() override in Node class makes printing much cleaner - otherwise you'd see object addresses.

## Common Mistakes
- Forgetting to check if nodes exist before adding edges
- Not using visited set in traversal (infinite loop waiting to happen)
- Removing node from maps before cleaning up references (leaves dangling connections)
- Mixing up from and to when adding/removing edges

