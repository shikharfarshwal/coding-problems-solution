import java.util.Optional;

/**
 * Created by Shikhar on 26-01-2019.
 */
public class CustomHashTable<K, V> {
    private Buckets[] data;

    CustomHashTable(int size) {
        this.data = new Buckets[size];
    }

    public void set(K key, V value) {
        if (key != null) {
            Buckets<K, V> buckets = new Buckets<>(key, value);
            int hash = hash(key);
            this.data[hash] = buckets;
        }
    }

    public Optional<Object> get(K key) {
        if (key != null) {
            int hash = hash(key);
            return Optional.of(this.data[hash]);
        }
        return Optional.empty();
    }

    class Buckets<T, L> {
        T key;
        L value;

        Buckets(T key, L value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Buckets{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private int hash(K key) {
        int hash = 0;
        for (int i = 0; i < ((String) key).length(); i++) {
            hash = (hash + ((String) key).charAt(i) * i) % this.data.length;
        }
        return hash;
    }

}


