package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayListTest {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        arrayList.clear();
    }

    @Test
    public void sizeTest() {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        Assert.assertTrue(myArrayList.size()==arrayList.size());
    }

    @Test
    public void isEmptyTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        Assert.assertEquals(arrayList.isEmpty(),myArrayList.isEmpty());
        arrayList.clear();
        myArrayList.clear();
        Assert.assertEquals(arrayList.isEmpty(),myArrayList.isEmpty());
    }

    @Test
    public void containsTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        Assert.assertEquals(arrayList.contains(2),myArrayList.contains(2));
        Assert.assertEquals(arrayList.contains(5),myArrayList.contains(5));
    }

    @Test
    public void iteratorTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        arrayList.add(1);
        myArrayList.add(151);
        arrayList.add(151);
        Iterator<Integer> javaIterator = arrayList.iterator();
        Iterator myIterator = myArrayList.iterator();
        Assert.assertTrue(myIterator.hasNext());
        Assert.assertEquals(javaIterator.next(), myIterator.next());
        Assert.assertTrue(myIterator.hasNext());
        Assert.assertEquals(javaIterator.next(), myIterator.next());
        Assert.assertFalse(myIterator.hasNext());

    }

    @Test
    public void toArrayTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        Assert.assertArrayEquals(myArrayList.toArray(),arrayList.toArray());
    }

    @Test
    public void toArrayIntoCollectionTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        Integer[] list1 = new Integer[101];
        Integer[] list2 = new Integer[101];
        arrayList.toArray(list1);
        myArrayList.toArray(list2);
        Assert.assertArrayEquals(list1,list2);
    }

    @Test
    public void addTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        for(int i=0;i<myArrayList.size();i++){
            Assert.assertEquals(arrayList.get(i),myArrayList.toArray()[i]);
        }
    }

    @Test
    public void removeTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        myArrayList.remove(new Integer(3));
        arrayList.remove(new Integer(3));
        myArrayList.remove(new Integer(5));
        arrayList.remove(new Integer(5));
        Assert.assertArrayEquals(myArrayList.toArray(),arrayList.toArray());
    }

    @Test
    public void containsAllTest(){
        MyArrayList myArrayList=new MyArrayList();
        Integer[] list1 = new Integer[3];
        Integer[] list2 = new Integer[3];
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        for(int i=0;i<3;i++){
            list1[i]=i+1;
            list2[i]=3-i;
        }
        Assert.assertTrue(myArrayList.containsAll(Arrays.asList(list1))==arrayList.containsAll(Arrays.asList(list1)));
        Assert.assertTrue(myArrayList.containsAll(Arrays.asList(list2))==arrayList.containsAll(Arrays.asList(list2)));
    }

    @Test
    public void addAllTest(){
        MyArrayList myArrayList=new MyArrayList();
        Integer[] list1 = new Integer[3];
        for(int i=0;i<3;i++){
            list1[i]=i+1;
        }
        myArrayList.addAll(Arrays.asList(list1));
        arrayList.addAll(Arrays.asList(list1));
        Assert.assertArrayEquals(arrayList.toArray(),myArrayList.toArray());
    }

    @Test
    public void addAllPosTest(){
        MyArrayList myArrayList=new MyArrayList();
        Integer[] list1 = new Integer[3];
        for(int i=0;i<3;i++){
            list1[i]=i+1;
        }
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        myArrayList.addAll(1,Arrays.asList(list1));
        arrayList.addAll(1,Arrays.asList(list1));
        Assert.assertArrayEquals(arrayList.toArray(),myArrayList.toArray());

    }

    @Test
    public void removeAllTest(){
        MyArrayList myArrayList=new MyArrayList();
        Integer[] list1 = new Integer[3];
        for(int i=0;i<3;i++){
            list1[i]=i+1;
        }
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        myArrayList.add(4);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(4);
        myArrayList.removeAll(Arrays.asList(list1));
        arrayList.removeAll(Arrays.asList(list1));
        Assert.assertArrayEquals(arrayList.toArray(),myArrayList.toArray());
    }

    @Test
    public void retainAllTest(){
        MyArrayList myArrayList=new MyArrayList();
        Object[] myArray = myArrayList.toArray();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        myArrayList.add(4);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(4);
        Integer[] list1 = new Integer[3];
        for(int i=0;i<3;i++){
            list1[i]=i+2;
        }
        arrayList.retainAll(Arrays.asList(list1));
        myArrayList.retainAll(Arrays.asList(list1));
        Assert.assertArrayEquals(arrayList.toArray(),myArrayList.toArray());
    }

    @Test
    public void clearTest(){
        MyArrayList myArrayList=new MyArrayList();
        Object[] myArray = myArrayList.toArray();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.clear();
        myArrayList.clear();
        Assert.assertEquals(arrayList.size(),myArrayList.size());
    }

    @Test
    public void getTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        Assert.assertEquals(myArrayList.get(2),arrayList.get(2));
    }

    @Test
    public void setPosTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        myArrayList.set(2,5);
        arrayList.set(2,5);
        Assert.assertArrayEquals(arrayList.toArray(),myArrayList.toArray());
    }

    @Test
    public void addPosTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        myArrayList.add(1,5);
        arrayList.add(1,5);
        Assert.assertArrayEquals(arrayList.toArray(),myArrayList.toArray());
    }

    @Test
    public void removePosTest(){
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        myArrayList.remove(2);
        arrayList.remove(2);
        Assert.assertArrayEquals(myArrayList.toArray(),arrayList.toArray());
    }

    @Test
    public void indexOfTest(){
        MyArrayList myArrayList=new MyArrayList();
        Object[] myArray = myArrayList.toArray();
    }

    @Test
    public void lastIndexOfTest(){
        MyArrayList myArrayList=new MyArrayList();
        Object[] myArray = myArrayList.toArray();
    }

    @Test
    public void listIteratorTest(){
        MyArrayList myArrayList=new MyArrayList();
        Object[] myArray = myArrayList.toArray();
    }

    @Test
    public void listIteratorPosTest(){
        MyArrayList myArrayList=new MyArrayList();
        Object[] myArray = myArrayList.toArray();
    }

    @Test
    public void subListTest(){
        MyArrayList myArrayList=new MyArrayList();
        Object[] myArray = myArrayList.toArray();
    }
}