package DSA.hashing;

import java.util.HashMap;

//find path through hashmap
public class FindItenary {
    public static String getStart(HashMap<String ,String >tick){
        HashMap<String ,String >revMap = new 
        HashMap<>();
        for(String key : tick.keySet()){
            revMap.put(tick.get(key),key);
        }

        for(String  key :tick.keySet()){
            if(!revMap.containsKey(key)){
        return key;
            }
        }
        return null;
}



    public static void main(String args[]){
        HashMap<String ,String > tick= new HashMap<>();
        tick.put("chennai","bengaluru");
        String start = getStart(tick);
        while(tick.containsKey(start)){
            System.out.println(start);
            start= tick.get(start);
        }
    }
}