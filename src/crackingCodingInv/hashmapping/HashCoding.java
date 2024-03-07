package crackingCodingInv.hashmapping;

import java.util.HashMap;
import java.util.HashSet;

class MapUsingHash {

    private Entity[] entities;
    public MapUsingHash(){
        entities = new Entity[100];
    }

    public void put(String key, String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value);
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash] = null;
        }
    }

    private class Entity {
        String key;
        String value;
        public Entity(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}


public class HashCoding {
    public static void main(String[] args) {

        MapUsingHash map = new MapUsingHash();

        map.put("x", "abc");
        map.put("y", "cde");
        map.put("z", "efg");

        System.out.println(map.get("x"));
        System.out.println(map.get("z"));
//        HashMap<String, Integer> map = new HashMap<>();
//
//        map.put("X", 10);
//        map.put("Y", 11);
//        map.put("Z", 12);
//
////        System.out.println(map.get("Z"));
////        System.out.println(map.getOrDefault("A", 14));
////        System.out.println(map.containsKey("Y"));
////        System.out.println(map.containsValue(15));
//
//        HashSet<Integer> set = new HashSet<>();
//        int[] arr = {15,13,12,14,15,16,17,14};
//        for (int item: arr){
//            set.add(item);
//        }
//        System.out.println(set);
    }
}
