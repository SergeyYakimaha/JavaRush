package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;

        Iterator<Integer> roundIterator =  list.iterator();

        int item1 = roundIterator.next();
        int item2 = roundIterator.next();
        int item3 = roundIterator.next();

        int item4 = roundIterator.next();
        roundIterator.remove();
        int item5 = roundIterator.next();
        int item6 = roundIterator.next();

        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator implements Iterator<T> {
        private Iterator<T> iterator = Solution.super.iterator();

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }

        @Override
        public boolean hasNext() {
            if(!iterator.hasNext())
                iterator = Solution.super.iterator();
            return iterator.hasNext();
            //return true;
        }

        @Override
        public T next() {
            if(!iterator.hasNext())
                iterator = Solution.super.iterator();
            return iterator.next();
        }
    }
}
