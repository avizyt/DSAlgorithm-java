package fundamentals;

import java.util.Random;

public class LargeNumberStringArray {
    public static void main(String[] args) {
        int arrSize = 20;
        int strLength = 5;
        String[] a = randomStringGenerator(arrSize, strLength);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static String[] randomStringGenerator(int arrSize, int strLength) {
        String[] strings = new String[arrSize];
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrSize; i++) {
            sb.setLength(0);
            for (int j = 0; j < strLength; j++) {
                char randomChar = (char) (random.nextInt(26) + 'a');
                sb.append(randomChar);
            }
            strings[i] = sb.toString();
        }
        return  strings;
    }
}
