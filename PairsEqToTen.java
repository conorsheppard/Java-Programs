import java.util.HashMap;
import java.util.HashSet;

public class PairsEqToTen {
    public static void main(String[] args) {
        int[] intArray = {5, 3, 7, 2, 1, 4, 2, -3};
        int searchNum = 4;
        findPairs(intArray, searchNum);
    }

    public static void findPairs(int[] intArray, int searchNum) {
        HashMap<Integer, Integer> hashedArr = new HashMap<>();
        int i = 0;
        for(int num : intArray) {
//            if(!(num > searchNum)) // Include if all numbers in the array are positive
            hashedArr.put(num, i); // Key is the number and value is its index in the array
            i++;
        }
        // for every number in the array ...
        for(int x = 0; x < intArray.length; x++) {
            // ... does the hash map contain the number needed to add up to the target number
            try {
                // != x because a number can't pair with itself, has to be 2 numbers
                if (hashedArr.get(searchNum - intArray[x]) != x) {
                    System.out.println("The pair at index " + x + ", " + hashedArr.get(searchNum - intArray[x])
                            + " has the sum " + searchNum);
                }
            } catch (NullPointerException e) {}
        }
    }

    public static void numberPairsForSum(int[] intArray, int searchNum) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : intArray) {
            if (set.contains(searchNum - num)) {
                String s = num + ", " + (searchNum - num) + " add up to " + searchNum;
                System.out.println(s);
            }
            System.out.println("set.add(num): " + num);
            set.add(num);
        }
    }

}
