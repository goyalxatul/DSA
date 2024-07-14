package DSA.hashing;
import java.util.*;
import java.util.HashMap;

public class hashmap {

    public static void main(String args[]){
        HashMap<String,Integer>map = new HashMap<>();
        map.put("india" , 120);
        map.put("us",30);
        map.put("china",150);

        System.out.println(map);
        map.put("china", 140);
        System.out.println(map);

        for(Map.Entry<String,Integer>a:map.entrySet()){
            System.out.println(a.getKey());
            System.out.println(a.getValue());
        }

        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println();
        }

        map.remove(keys, keys);
        
    }
    
}
