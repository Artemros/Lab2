package org.example;


import java.util.*;

public class MyArrayList<T> implements List<T> {
    private Object[] myArr;
    private int mSize;
    private int minSize=2;

    public MyArrayList() {
        myArr = new Object[minSize];
        mSize = 0;
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public boolean isEmpty() {
        return mSize == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < mSize; i++) {
            if (myArr[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        MyIterator myIterator=new MyIterator(mSize);
        return myIterator;
    }
    private class MyIterator implements Iterator<T>{
        private int itSize;
        private int itNow=0;

        public MyIterator(int size){
            itSize=size;
        }
        @Override
        public boolean hasNext() {
            return itNow+1<=itSize;
        }

        @Override
        public T next() {
            return (T) myArr[itNow++];
        }
    }

    @Override
    public Object[] toArray() {
        Object[] o = new Object[mSize];
        for (int i = 0; i < mSize; i++) {
            o[i] = myArr[i];
        }
        return o;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        for (int i = 0; i < mSize; i++) {
            a[i] = (T) myArr[i];
        }
        for (int i = mSize; i < a.length; i++) {
            a[i] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        if(mSize+1>=minSize){
            minSize+=100;
        }
        Object[] dop=new Object[minSize];
        for(int i=0;i<mSize;i++){
            dop[i]=myArr[i];
        }
        myArr=dop;
        myArr[mSize++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int j=0;
        for (int i = 0; i < mSize; i++) {
            if (o.equals(myArr[i])) {
                myArr[i] = null;
                mSize--;
                Object[] dop = new Object[mSize];
                for (int k = 0; k < mSize+1; k++) {
                    if (myArr[k] != null) {
                        dop[j]= (Integer) myArr[k];
                        j++;
                    }
                }
                myArr=dop;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            boolean flag = false;
            for (int i = 0; i < mSize; i++) {
                if (myArr[i] == e) {
                    flag = true;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if(mSize+c.size()>=minSize){
            minSize+=100;
        }
        Object[] dop=new Object[minSize];
        for(int i=0;i<mSize;i++){
            dop[i]=myArr[i];
        }
        myArr=dop;
        Object[] dopArr = new Object[mSize + c.size() + 1];
        int j = 0;
        for (int i = 0; i < mSize; i++) {
            dopArr[j++] = myArr[i];
        }
        for (T item : c) {
            dopArr[j++] = item;
        }
        myArr = dopArr;
        mSize += c.size();
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean flag=true;
        if(c.size()==0){
            flag=false;
        }
        if(mSize+c.size()>minSize){
            minSize+=100;
        }
        Object[] dop=new Object[minSize];
        for(int i=0;i<mSize;i++){
            dop[i]=myArr[i];
        }
        myArr=dop;
        Object[] dopArr = new Object[mSize + c.size() + 1];
        int j = 0;
        for (int i = 0; i < mSize; i++) {
            if (i != index) {
                dopArr[j++] = myArr[i];
            } else {
                for (T item : c) {
                    dopArr[j++] = item;
                }
                dopArr[j++] = myArr[i];
            }
        }
        myArr = dopArr;
        mSize += c.size();
        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flago=true;
        if(c.size()==0){
            flago=false;
        }
        Object[] dopArr = new Object[mSize];
        int size = 0;
        int j = 0;
        for (int i = 0; i < mSize; i++) {
            boolean flag = true;
            for (Object e : c) {
                if (myArr[i] == e) {
                    flag = false;
                }
            }
            if (flag) {
                dopArr[j++] = myArr[i];
                size++;
            }
        }
        myArr = dopArr;
        mSize = size;
        return flago;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Object[] dopArr = new Object[mSize];
        int size = 0;
        int j = 0;
        for (int i = 0; i < mSize; i++) {
            boolean flag = false;
            for (Object e : c) {
                if (myArr[i] == e) {
                    flag = true;
                }
            }
            if (flag) {
                dopArr[j++] = myArr[i];
                size++;
            }
        }
        myArr = dopArr;
        mSize = size;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < mSize; i++) {
            myArr[i] = null;
        }
        mSize = 0;
    }

    @Override
    public T get(int index) {
        return (T) myArr[index];
    }

    @Override
    public T set(int index, T element) {
        myArr[index] = element;
        return null;
    }

    @Override
    public void add(int index, T element) {
        if(mSize+1>minSize){
            minSize+=100;
        }
        Object[] dop=new Object[minSize];
        for(int i=0;i<mSize;i++){
            dop[i]=myArr[i];
        }
        myArr=dop;
        Object[] dopArr = new Object[mSize + 1];
        int j = 0;
        for (int i = 0; i < mSize; i++) {
            if (i != index) {
                dopArr[j++] = myArr[i];
            } else {
                dopArr[j++] = element;
                dopArr[j++] = myArr[i];
            }
        }
        myArr = dopArr;
        mSize++;
    }

    @Override
    public T remove(int index) {
        Object[] dopArr = new Object[mSize];
        int j = 0;
        for (int i = 0; i < mSize; i++) {
            if (i != index) {
                dopArr[j++] = myArr[i];
            }
        }
        myArr = dopArr;
        mSize--;
        return (T) myArr;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < mSize; i++) {
                if (myArr[i] == null) {
                    return i;
                }
            }
        }
        for (int i = 0; i < mSize; i++) {
            if (o.equals(myArr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = mSize - 1; i >= 0; i--)
                if (myArr[i] == null)
                    return i;
        } else {
            for (int i = mSize - 1; i >= 0; i--)
                if (o.equals(myArr[i]))
                    return i;
        }
        return -1;
    }


    public ListIterator<T> listIterator() {
        MyListIterator myListIterator=new MyListIterator(0);
        return (ListIterator<T>) myListIterator;
    }
    private class MyListIterator implements ListIterator<T>{
        private int itSize;
        private int itNow=0;

        public MyListIterator(int mSize) {
            itSize=mSize;
        }

        @Override
        public boolean hasNext() {
            return itNow+1<=itSize;
        }

        @Override
        public T next() {
            return (T) myArr[itNow++];
        }

        @Override
        public boolean hasPrevious() {
            return itNow-1>=0;
        }

        @Override
        public T previous() {
            return (T) myArr[itNow--];
        }

        @Override
        public int nextIndex() {
            return itNow;
        }

        @Override
        public int previousIndex() {
            return itNow - 1;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(itNow);
        }

        @Override
        public void set(T t) {
            MyArrayList.this.set(itNow,t);
        }

        @Override
        public void add(T t) {
            int i = itNow;
            MyArrayList.this.add(i, t);
            itNow = i + 1;
        }
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        MyListIterator myListIterator=new MyListIterator(index);
        return (ListIterator<T>) myListIterator;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> sublist = new MyArrayList<T>();
        for(int i=fromIndex;i<=toIndex;i++){
            sublist.add((T) myArr[i]);
        }
        return sublist;
    }
}
