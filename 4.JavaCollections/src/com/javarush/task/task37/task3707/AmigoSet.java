package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable {

    private static final Object PRESENT = new Object();

    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) (collection.size() / .75f) + 1);
        map = new HashMap<>(capacity);
        addAll(collection);
    }

    @Override
    public boolean add(Object o) {
        return (map.put((E) o, PRESENT) == null);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet<E> amigoSet = new AmigoSet<>();
            amigoSet.map = (HashMap<E, Object>) this.map.clone();
            return amigoSet;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException, NullPointerException {
        out.defaultWriteObject();
        out.writeInt((int)HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeFloat((float)HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        //List<E> list = new ArrayList<>(map.keySet());
        out.writeObject(new ArrayList<>(map.keySet()));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        this.map = new HashMap<>(capacity, loadFactor);
        List<E> list = (List<E>)in.readObject();
        for (E entry: list){
            map.put((E)entry, PRESENT);
        }
    }

    //implements Serializable, Cloneable, Set
}
