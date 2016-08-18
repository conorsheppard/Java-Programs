import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class PrintFreq {
    public static void main(String[] args) {
        int[] intArray = {1, 4, 5, 7, 23, 4, 10, 15, 15, 4, 2};
        int biggestVal = 0;
        int mostFreqKey = 0;
        int arrayLen = Array.getLength(intArray);
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < arrayLen; i++) {
            if (countMap.containsKey(intArray[i])) {
                countMap.put(intArray[i], countMap.get(intArray[i]) + 1);
            } else {
                countMap.put(intArray[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(biggestVal < entry.getValue()) {
                biggestVal = entry.getValue();
                mostFreqKey = entry.getKey();
            }
        }
        System.out.println("The most frequent number is " + mostFreqKey);
    }
}
