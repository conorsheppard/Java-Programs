**Task: Word Chain Solver**

Word chains are a simple game often found in the games and puzzles section of newspapers. The aim of the game is to get from one word to another by changing one letter of the word each time. Each change of letter must result in a legal intermediate word. For example, we can change LEAD into GOLD through the following steps:

	LEAD → LOAD → GOAD → GOLD

Using Java, create an automated solver method that accepts the start and end words and prints a list of steps required to do the transform. There’s a dictionary of legal words to use in your solver in this zip file. You can assume the dictionary will be in the same directory as your executable. Start and end words should be the same length as each other.

To solve this problem I have implemented two forms of tree traversal.

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