package DSA.hashing;

import java.util.HashMap;

public class unionofarrays {
    public static int union(int arr1[],int arr2[]){
        int n1 = arr1.length;
        int n2 = arr2.length;
         HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n1 ;i++){
            map.put(arr1[i],1);

        }
        for(int j = 0 ; j < n2 ;j++){
            map.put(arr2[j],1);

        }
        return map.size();
    }

    public static void main(String args[]){
        int arr1[]= {7,3,9};
        int arr2[]= {6,3,9,2,9,4};

        System.out.println(union(arr1, arr2));

}
    
}
