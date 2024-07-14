package DSA.hashing;

import java.util.HashMap;

public class Majority {
    public static void majority(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Build the frequency map
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        // Find and print elements with frequency greater than nums.length / 3
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }
    }

    public static void main(String args[]) {
        int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        majority(nums);
    }
}

