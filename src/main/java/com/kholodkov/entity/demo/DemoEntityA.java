package com.kholodkov.entity.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet#5-1 time 2:08:23
 */
public class DemoEntityA {
    private String string;
    private String[] array;
    private List<Integer> list;
    private Map<String, String> map;
    private DemoEntityB demoEntityB;

    public DemoEntityA() {
        this.string = "string";
        this.array = new String[] {"AAA", "BBB", "CCC"};
        this.list = Arrays.asList(123, 456, 789);
        this.map = new HashMap<String, String>() {{put("key-0", "value-0");}};
        this.demoEntityB = new DemoEntityB();
    }

    public String getString() {
        return string;
    }

    public String[] getArray() {
        return array;
    }

    public List<Integer> getList() {
        return list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public DemoEntityB getDemoEntityB() {
        return demoEntityB;
    }
}
