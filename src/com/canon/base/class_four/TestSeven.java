package com.canon.base.class_four;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @PackageName: com.canon.base.class_four
 * @Description:
 * @author: canon
 * @date: 2020/8/25 17:32
 * @Version: 1.0
 */
public class TestSeven {
    private static Map<String, String> map = new LinkedHashMap<String, String>(5, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            if (size() > getCacheLimit()) {
                return true;
            }
            return super.removeEldestEntry(eldest);

        }
    };

    private static Map<String, String> cache = new LinkedHashMap<String, String>(5, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            if (size() > getCacheLimit()) {
                return true;
            }
            return super.removeEldestEntry(eldest);

        }
    };
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            map.put(""+i, null);
        }
        System.out.println(map);
    }

    static int getCacheLimit() {
        return 5;
    }
}
