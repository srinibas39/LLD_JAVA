public class MyHashMap<K,V> {


    // [{k,V} , {k,V} , {k , V}]
    private static final int INITIAL_SIZE = 16;
    private static final int FINAL_CAPACITY = 1 << 4;

    private Entry<K, V>[] table;


    public MyHashMap(){
        table = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        capacity = tableSizeFor(capacity);
        table = new Entry[capacity];
    }

    final int tableSizeFor(int cap) {
        // We want a no that is 2s power and less than or equal to cap
        int n = cap - 1;
        // setting the bits
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4; 
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >=  FINAL_CAPACITY) ?  FINAL_CAPACITY : n + 1;
    }

    public void put(K key , V value){
        int hashcode = key.hashCode();
        int index = hashcode % table.length;
        Entry node = table[index];

        if(node != null){
            if(node.getKey() == key){
                //replace
                node.setValue(value);
                return;
            }
            else{
                Entry newNode = new Entry(key,value);
                node.setNext(newNode);
            }
        }
        else{
            Entry newNode = new Entry(key,value);
            table[index] = newNode;
        }


    }

    public V get(K key) {
        int hashcode = key.hashCode();
        int index = hashcode % table.length;
        Entry node = table[index];
        while (node != null) {
            if (node.getKey() == key) {
                return (V) node.getValue();
            }
            node = node.getNext();
        }
        return null;

    }




    class Entry<K, V> {
        private K key;
        private V value;
        private Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }
        public Entry getNext() {
            return next;
        }
        public void setNext(Entry next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        MyHashMap<Integer,String> map = new MyHashMap<>(100);
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
    }
}
