package com.kholodkov.entity.demo;

import java.util.Map;

/**
 * Spring#7-1 1:24:30
 */
public class SpringDemoA {
    private int[] intArray;
    private Map<String, SpringDemoB> map;

    public SpringDemoA() {
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public Map<String, SpringDemoB> getMap() {
        return map;
    }

    public void setMap(Map<String, SpringDemoB> map) {
        this.map = map;
    }
}
