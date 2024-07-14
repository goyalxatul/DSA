package DSA.hashing;

import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;  // number of key-value pairs
        private int N;  // size of the bucket array
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % N;
        }

        private int searchInLinkedList(K key, LinkedList<Node> bucket) {
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (LinkedList<Node> bucket : oldBuckets) {
                for (Node node : bucket) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            LinkedList<Node> bucket = buckets[bi];
            int di = searchInLinkedList(key, bucket);

            if (di == -1) {
                bucket.add(new Node(key, value));
                n++;
            } else {
                Node node = bucket.get(di);
                node.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            LinkedList<Node> bucket = buckets[bi];
            int di = searchInLinkedList(key, bucket);

            if (di == -1) {
                return null;
            } else {
                Node node = bucket.get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            LinkedList<Node> bucket = buckets[bi];
            int di = searchInLinkedList(key, bucket);

            return di != -1;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            LinkedList<Node> bucket = buckets[bi];
            int di = searchInLinkedList(key, bucket);

            if (di == -1) {
                return null;
            } else {
                Node node = bucket.remove(di);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        System.out.println("Value for key 1: " + map.get(1));
        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("Value for key 3: " + map.get(3));

        System.out.println("Map contains key 2: " + map.containsKey(2));
        System.out.println("Removing key 2: " + map.remove(2));
        System.out.println("Map contains key 2: " + map.containsKey(2));
    }
}
