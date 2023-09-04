package leetcodes.basics;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "acab";
        System.out.println(canConstruct2(ransomNote, magazine));
        System.out.println(canConstruct(ransomNote, magazine));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);

            int currCount = magMap.getOrDefault(m, 0);
            magMap.put(m, currCount + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);

            int currCount = magMap.getOrDefault(r, 0);
            if (currCount == 0){
                return false;
            }
            magMap.put(r, currCount-1);
        }
        return true;
    }

    private static boolean canConstruct2(String ransomNote, String magazine){
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);

            int idx = magazine.indexOf(r);
            if (idx == -1){
                return  false;
            }
            magazine = magazine.substring(0, idx) + magazine.substring(idx + 1);
        }
        return true;
    }
}
