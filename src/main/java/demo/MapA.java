package demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
class MapA {

    private final Map<String, String> map = new HashMap<>();


    Object addEntry(String entry) {
        if (entry == null) {
            return all();
        }

        String key = Hasher.hashAndEncode(entry);
        map.put(key, entry);
        return key;
    }

    String getEntry(String key) {
        return map.get(key);
    }

    Map<String, String> all() {
        return map;
    }

    boolean verify(String entry, String hash) {
        return map.containsKey(hash) && map.get(hash).equals(entry);
    }
}