import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class WordChainAlgorithm {

    public static void main(String[] args) {
        boolean sameLength = false;
        String beginWord = "";
        String endWord = "";

        while(!sameLength) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter the starting word: ");
            beginWord = getWord(in);
            System.out.println("Please enter the target word: ");
            endWord = getWord(in);
            if(beginWord.length() == endWord.length()) sameLength = true;
            else System.out.println("Error: words are not the same length");
        }
        WordChainAlgorithm wca = new WordChainAlgorithm();
        Set<String> dictionary = wca.getDictionary(beginWord);
        List<List<String>> wordChains = wca.getWordChains(beginWord, endWord, dictionary);

        int i = 1;
        for(List<String> l : wordChains) {
            System.out.println("* * * * *\n\tList " + i);
            for(String s : l) System.out.println("\t\t"+s);
            i++;
        }
    }

    public static String getWord(Scanner in) {
        String word = in.next();
        return word;
    }

    // Return all shortest paths from the starting word to the target word
    public List<List<String>> getWordChains(String beginWord, String endWord, Set<String> dictionary) {
        List<List<String>> res = new ArrayList<>(); // the correct word chains
        HashMap<String, ArrayList<String>> neighbourNodes = new HashMap<>(); // neighbours for every node
        HashMap<String, Integer> distance = new HashMap<>(); // distance of every node from the start node
        ArrayList<String> solution = new ArrayList<>();
        dictionary.add(endWord);
        bfs(beginWord, endWord, dictionary, neighbourNodes, distance);
        dfs(beginWord, endWord, neighbourNodes, distance, solution, res);

        return res;
    }

    // Use breadth first search to record every node's distance from the start node (level by level).
    private void bfs(String beginWord, String endWord, Set<String> dict,
                            HashMap<String, ArrayList<String>> neighbourNodes, HashMap<String, Integer> distance) {

        for(String str : dict)
            neighbourNodes.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord); // add beginWord as the tail of the queue
        distance.put(beginWord, 0); // initialize HashMap distance
        while(!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;

            for(int i = 0; i < count; i++) { // iterate over the queue
                String cur = queue.poll(); // set cur = to the head of the queue and remove it from the queue
//                int curDistance = distance.get(cur);
                ArrayList<String> neighbours = getNeighbours(cur, dict); // initialize neighbours with next level nodes

                for(String neighbour : neighbours) { // iterate over neighbours
                    neighbourNodes.get(cur).add(neighbour); // add neighbour as the value to key cur in neighbourNodes
                    if(!distance.containsKey(neighbour)) { // Check if visited
                        distance.put(neighbour, distance.get(cur)+1);
                        if(endWord.equals(neighbour)) // check if we've reached the target word
                            foundEnd = true; // found the shortest path
                        else
                            queue.offer(neighbour); // add neighbour to the tail of the queue
                    }
                } // end for

            } // end for
            if (foundEnd) break; // break from while loop
        } // end while
    }

    // Find all next level nodes by iterating over the current node, swapping out all combinations of letters and
    // adding the resulting words, which are in the dictionary, to the list. Return the list.
    private ArrayList<String> getNeighbours(String node, Set<String> dict) {
        ArrayList<String> neighbours = new ArrayList<>(); // list of next level nodes
        char chars[] = node.toCharArray(); // convert the string to a character array
        // iterate over alphabet
        for(char ch ='a'; ch <= 'z'; ch++) {
            // iterate over the given node passed in to this method
            for(int i = 0; i < chars.length; i++) {
                if (chars[i] == ch) continue; // if same, skip
                char old_ch = chars[i]; // old_ch = char to replace
                chars[i] = ch; // replace the current char with the current letter we are iterating over
                if(dict.contains(String.valueOf(chars))) // Check if the word is in the dictionary
                    neighbours.add(String.valueOf(chars)); // Add the new word to the list
                chars[i] = old_ch; // reset the char
            }
        }
        return neighbours;
    }

    // Use depth first search to find all shortest paths.
    private void dfs(String cur, String end, HashMap<String, ArrayList<String>> neighbourNodes,
                            HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur); // Add the current node (beginWord at first, then successive nodes) to the list
        if(end.equals(cur)) {
            // Base case in recursive method
            res.add(new ArrayList<>(solution)); // res.add(solution); ??
        } else {
            for(String next : neighbourNodes.get(cur)) {
                if(distance.get(next) == distance.get(cur)+1)
                    dfs(next, end, neighbourNodes, distance, solution, res);
            }
        }
        solution.remove(solution.size()-1);
    }

    // Add words, of relevant size, to the dictionary
    public Set<String> getDictionary(String beginWord) {
        int stringLength = beginWord.length();
        Set<String> dictionary = new HashSet<>();
        String fileName = "websters-dictionary.txt";
        try {
            // Create object of FileReader
            FileReader inputFile = new FileReader(fileName);
            // Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);
            // Variable to hold one line data
            String line;

            // Read file line by line and add all relevant words to the hashset
            while (((line = bufferReader.readLine()) != null))
                if (line.length() == stringLength) dictionary.add(line.toLowerCase());

            // Close the buffer reader
            bufferReader.close();
        } catch(Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        return dictionary;
    }
}