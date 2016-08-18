import java.util.HashMap;
import java.util.Map;

public class IsUnique {
    // 1.1 Check if a string has all unique characters
    // Time complexity: O(n); Space complexity: O(1)

    public static void main(String[] args) {
        HashMap<String, Boolean> tests = new HashMap<>();
        tests.put("hello", false);
        tests.put("Dennis", false);
        tests.put("", true);
        tests.put("  ", false);
        tests.put("HAHA!", false);
        tests.put("Hypem", false);

        for(Map.Entry<String, Boolean> entry : tests.entrySet())
            System.out.println(assert_equal(isUniqueChars(entry.getKey()), tests.get(entry.getKey())));
    }

    private static boolean isUniqueChars(String str) {
        if(str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) { // Already found this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    private static String assert_equal(boolean expected, boolean actual) {
//      Basic equality assertion. Prints PASS or FAIL.
        String result = "FAIL";

        if(expected == actual)
            result = "PASS";

        return result;
    }
}
