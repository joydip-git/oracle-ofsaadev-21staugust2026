import java.util.HashSet;

public class MyMap<K, V> {
    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.key.equals((K)obj);
        }
    }

    private final Set<Entry<K,V>> entries = new HashSet<Entry<K,V>>();
    public Set<Entry<K,V>> entrySet(){
        return entries;
    }

    public void put(K key, V value){
        entries.add(new Entry<K,V>(key,value));
    }
}
