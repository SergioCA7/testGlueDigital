package com.sergiocuenca.util;

import java.util.HashMap;

public  class HashMapUtils {

    public static Integer getAllValueSum(HashMap<String, Integer> hashmap) {
        return hashmap.values().stream().reduce(0, Integer::sum);
    }
}
