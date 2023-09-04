package leetcodes.arraysAndString;

public class ReverseStringSolution {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] s2 = {'H','a','n','n','a','h'};
//        int fisrt = 0;
//        int second = s.length -1;
//
//        while(fisrt < second){
//            swap(s, fisrt, second);
//           fisrt++;
//           second--;
//        }
//        System.out.println(s);
        reverseString(s2);
        System.out.println(s2);
    }
    private static void swap(char[] arr,int first, int second){
            char temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
    }

    private static void reverseString(char[] arr){
        int first = 0;
        int second = arr.length -1;

        while (first < second){
            char temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;

            first += 1;
            second -= 1;
        }
    }
}
