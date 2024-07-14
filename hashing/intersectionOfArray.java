package DSA.hashing;

import java.util.HashSet;

public class intersectionOfArray {
    public static int intersection(int arr1[],int arr2[]){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int count=0;
         HashSet<Integer> map = new HashSet<>();
         for(int i = 0 ; i < n1 ;i++){
            map.add(arr1[i]);
        }
        for(int j = 0 ; j < n2 ;j++){
            if(map.contains(arr2[j])){
                count ++;
                map.remove(arr2[j]);

            }

        }
         return count;
    }

    public static void main(String args[]){
        int arr1[]= {7,3,9};
        int arr2[]= {6,3,9,2,9,4};

        System.out.println(intersection(arr1, arr2));


    }
}
