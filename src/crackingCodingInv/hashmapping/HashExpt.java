package crackingCodingInv.hashmapping;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashExpt {
    public static void main(String[] args) {

        HashMap<Integer, String> lang = new HashMap<>();

        // Treemap
        TreeMap<Integer, String> evenNumb = new TreeMap<>();
        evenNumb.put(1, "One");
        evenNumb.put(2, "Two");
        evenNumb.put(3, "Three");
        System.out.println("TreeMap: " + evenNumb);

        // Create hashmap from treemap
        HashMap<Integer, String> map = new HashMap<>(evenNumb);
        map.put(4, "Four");
        System.out.println("HashMap: " + map);


        lang.put(1, "Java");
        lang.put(2, "Python");
        lang.put(3, "JavaScript");
//        System.out.println("HashMap: " + lang);
//
//        System.out.println("Keys: ");
//        for (Integer key: lang.keySet()){
//            System.out.println(key);
//            System.out.println(", ");
//        }
//
//        System.out.println("\nValues");
//        for (String val: lang.values()){
//            System.out.println(val);
//            System.out.println(", ");
//        }
//
//        System.out.println("\nEntries");
//        for (Map.Entry<Integer, String> entry: lang.entrySet()){
//            System.out.println(entry);
//            System.out.println(", ");
//        }
    }
}
