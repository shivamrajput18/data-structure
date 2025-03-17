//package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

class Entry<K, V> {
    K key;
    V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap<K, V> {
    private final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>> [] buckets;
    int size;

    // constructor
    MyHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndexKey(K key) {
        int hascode = key.hashCode();
        //System.out.println(hascode);
        return hascode % DEFAULT_CAPACITY;
    }

    public void put(K key, V value) {

        LinkedList<Entry<K, V>> bucket = buckets[getIndexKey(key)];

        for (Entry<K, V> ele : bucket) {
            if (ele.key.equals(key)) {
                ele.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
        size++;
    }

    public V get(K key){
        LinkedList<Entry<K,V>> bucket = buckets[getIndexKey(key)];

        for(Entry<K,V> ele : bucket){
            if(ele.key.equals(key)){
                return ele.value;
            }
        }

        return null;
    }

    public void remove(K key){
        LinkedList<Entry<K,V>> bucket = buckets[getIndexKey(key)];
        for(Entry<K,V> ele : bucket){
            if(ele.key.equals(key)){
                bucket.remove(ele);
                return;
            }
        }
        System.out.println("Element not found");
    }


    @Override
    public String toString() {
        
        
        for(LinkedList<Entry<K,V>> bucket: buckets){
            if(bucket.size()>0){
                for(Entry<K,V> entry: bucket){
                    System.out.print("["+entry.key+ " = "+entry.value + "]");
                }
                System.out.println();
            }
        }

        return "";
    }

}

public class implementationOfHashMap {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hs = new MyHashMap();
        hs.put(55, "deepak");
        hs.put(21, "rohit");
        hs.put(111, "ritick");

        System.out.println(hs.get(21));
        hs.remove(21);
        System.out.println(hs.get(21));

        System.out.println(hs);
    }
}