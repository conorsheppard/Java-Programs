public class RevString {
    public static String reverseString(String s) {
        String reversedStr = "";
        int len = s.length();
        for(int i = len-1; i >= 0; i--) {
            reversedStr += s.charAt(i);
        }
        return reversedStr;
    }

    public static void main(String[] args) {
        String str = "hello";

        System.out.println(reverseString(str));
    }
}
