package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    private List<Entry> entryLinkedList = new LinkedList<>();

    static class Entry<E> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry parent;
        Entry leftChild;
        Entry rightChild;
        int level;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }

        public boolean hasChild() {
            return rightChild != null | leftChild != null;
        }
    }

    public CustomTree() {
        root = new Entry<String>("root");
        root.level = 1;
        entryLinkedList.add(root);
    }

    @Override
    public String get(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public Entry get(String s) {
        Entry result = null;
        for (Entry entry : entryLinkedList) {
            if (entry.elementName.equals(s))
                result = entry;
        }
        return result;
    }

    @Override
    public int size() throws UnsupportedOperationException {
        return entryLinkedList.size() - 1;
    }

    public Entry[] getChild(String s) {
        List<Entry> listChild = new ArrayList<>();
        for (Entry entry : entryLinkedList) {
            if (entry.parent.elementName.equals(s))
                listChild.add(entry);
        }
        Entry[] result = new Entry[listChild.size()];
        for (int i = 0; i < listChild.size(); i++) {
            result[i] = listChild.get(i);
        }
        return result;
    }

    public Entry[] getChild(Entry entry) {
        List<Entry> listChild = new ArrayList<>();
        if (entry.leftChild != null)
            listChild.add(entry.leftChild);
        if (entry.rightChild != null)
            listChild.add(entry.rightChild);

        Entry[] result = new Entry[listChild.size()];
        for (int i = 0; i < listChild.size(); i++) {
            result[i] = listChild.get(i);
        }
        return result;
    }

    public boolean add(String s) {
        Entry newEntry = null;
        for (Entry entry : entryLinkedList) {
            if (entry.isAvailableToAddChildren()) {
                newEntry = new Entry(s);
                newEntry.parent = entry;
                if (entry.availableToAddLeftChildren) {
                    entry.leftChild = newEntry;
                    entry.availableToAddLeftChildren = false;
                    break;
                }
                if (entry.availableToAddRightChildren)
                    entry.rightChild = newEntry;
                entry.availableToAddRightChildren = false;
                break;
            }
        }
        entryLinkedList.add(newEntry);
        return true;
    }

    public String getParent(String s) {
        String result = null;
        for (int i = 1; i < entryLinkedList.size(); i++) {
            if (entryLinkedList.get(i).elementName.equals(s)) {
                result = entryLinkedList.get(i).parent.elementName;
                break;
            }
        }
        return result;
    }

    public String set(int index, String element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    ;

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }

        List<Entry> listEntry = new ArrayList<>();
        Entry root = get((String) o);
        Entry entry;

        Collections.addAll(listEntry, root);

        while (!listEntry.isEmpty()) {
            entry = listEntry.remove(0);
            entryLinkedList.remove(entry);
            if (entry.hasChild())
                Collections.addAll(listEntry, getChild(entry));
            else {
                Entry parentEntry = entry.parent;
                if (parentEntry.leftChild == entry) {
                    parentEntry.leftChild = null;
                    parentEntry.availableToAddLeftChildren = true;
                }
                if (parentEntry.rightChild == entry) {
                    parentEntry.rightChild = null;
                    parentEntry.availableToAddRightChildren = true;
                }

                int index = 0;

                for (int i = 0; i < entryLinkedList.size(); i++) {
                    if (entryLinkedList.get(i).elementName.equals(parentEntry.elementName)) {
                        index = i;
                        break;
                    }
                }

                entryLinkedList.set(index, parentEntry);
            }
        }
        return true;
    }

    public void add(int index, String element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    ;

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    ;

    public List<String> subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    ;

    protected void removeRange(int fromIndex, int toIndex) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    ;

    public boolean addAll(int index, Collection<? extends String> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    ;
}
