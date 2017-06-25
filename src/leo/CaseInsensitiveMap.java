package leo;

import java.util.HashMap;

// Idea: store all keys lower case
public class CaseInsensitiveMap<V> extends HashMap<String, V> {
    @Override
    public V put(String key, V value) {
        return super.put(key.toLowerCase(), value);
    }

    @Override
    public V get(Object key) {
        return super.get(((String) key).toLowerCase());
    }

}
