package com.company.Iterator;

public class IteratorApp {
    public static void main(String[] args){
        Aggregate arr = new ConcreteAggregate();
        Iterator it  = arr.getIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

interface Iterator{
    boolean hasNext();
    Object next();
}

interface Aggregate{
    Iterator getIterator();
}

class ConcreteAggregate implements Aggregate{
    private String[] keks = {"kek1","kek2","kek3","kek4","kek5"};
    @Override
    public Iterator getIterator() {
        return new KekIterator();
    }
    private class KekIterator implements Iterator{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < keks.length;
        }

        @Override
        public Object next() {
            return keks[index++];
        }
    }
}