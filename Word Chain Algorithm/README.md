I have implemented two forms of tree traversal. 

- Breadth First Search, using a Dijkstra-like algorithm to record all the nodes one level down (i.e. one change in letter) from the current node, starting with the first node at level 0.

and

- Depth First Search, using a recursive method to find all of the shortest paths from the start word to the target word.

I also keep track of the distance from every node to the first node using HashMap<String, Integer> distance.
I use a Set of Strings to hold all of the dictionary words that are needed for any given run of the program.
I call on a method "getNeighbours" to iterate over all characters of the alphabet and swap them out, in turn, with all characters in the current node. This returns all of the next level "neighbours" for the current node as an ArrayList of Strings.

I have annotated the Java file with comments to make clear what steps are being taken to fulfill the task of this assessment. 

Directions: To run the program, simply open a terminal window, navigate to the folder and run "java WordChainAlgorithm". 
You will be prompted for two words, a start word and an end word, make sure they are the same length. 
The program will then pretty print all of the shortest paths from the first word to the target word.