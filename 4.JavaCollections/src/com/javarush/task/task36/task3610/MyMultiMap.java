package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        V result = null;
        List<V> list = map.get(key);
        if (list == null) {
            List<V> vList = new ArrayList<>();
            vList.add(value);
            map.put(key, vList);
        } else {
            V lastElement = list.get(list.size() - 1);
            if (list.size() == repeatCount)
                list.remove(0);
            list.add(value);
            result = lastElement;

        }
        return result;
    }

    @Override
    public V remove(Object key) {
        if (!containsKey(key))
            return null;
        List<V> list = map.get(key);
        V firstValue = list.remove(0);
        if (list.isEmpty())
            map.remove(key);
        return firstValue;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> resultList = new ArrayList<>();
        for (List<V> entry : map.values()) {
            resultList.addAll(entry);
        }
        return resultList;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}