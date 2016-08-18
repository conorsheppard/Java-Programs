public class CharacterPermutations {

    public static void main(String[] args) {
        permuteString("abcd");
    }

    static void permuteString(String s) {
        int len = s.length();
        for(int i = 0; i < len; i++) {
            for(int x = 0; x < len; x++) {
                if(!(s.charAt(i) == (s.charAt(x)))) System.out.print(s.charAt(x));
            }
            System.out.println();
        }
    }
}