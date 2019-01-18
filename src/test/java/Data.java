import java.util.HashMap;
import java.util.Map;

public class Data {
    static private HashMap<String,Long> map;

    public static Map<String, Long> getMap() {
        return map;
    }

    public static void setToMap(String key, Long value) {
        map.put(key,value);
    }
}
