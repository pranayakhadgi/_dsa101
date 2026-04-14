//REFACTORING AND INTRO TO AUTOMATE TESTING

package Pranaya.HashMap;

import java.util.LinkedList;

public class HashmapEx3_hashtable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {//the put method - part 1
        var entry = getEntry(key);
        if(entry != null) {
            entry.value = value;
            return;
        }

        // case of ADD jumping story so it was dragged down
        getOrCreateBucket(key).add(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);

        return (entry == null) ? null : entry.value;
//        var index = hash(key);
//        var bucket = entries[index];
//        if (bucket != null) {
//            for (var entry : bucket)
//                if (entry.key == key)
//                    return entry.value;
//        }
//        return null;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if(entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
//        var index = hash(key);
//        var bucket = entries[index];
//        if(bucket == null)
//            throw new IllegalStateException();
//        for (var entry : bucket) {
//            if(entry.key == key) {
//                bucket.remove(entry);
//                return;
//            }
//        }
//        throw new IllegalStateException();
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key){
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null)
            entries[index] = new LinkedList<>();

        return bucket;
    }

    private Entry getEntry(int key){

        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}

