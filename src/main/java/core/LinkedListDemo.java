package core;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by golagem on 10/3/17.
 */
class LinkedListDemo {
    public static void main(String... args) {
        MyList<String> myList = new MyList<>();
        myList.add("Oye");
        myList.add("Hello1");
        myList.add("Hello2");
        myList.add("Hello3");
        myList.add("Hello4");


        myList.remove(0);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }

    public static <E> void printArray(E[] elements) {
        for (E element : elements) {
            System.out.println(element);
        }
        System.out.println();
    }


}

class MyList<L> {

    int size;

    int initialCapacity = 4;

    int totalCapacity = initialCapacity;

    Object[] objects = new Object[initialCapacity];

    void add(L obj) {
        ensureCapacity(size + 1);
        objects[size++] = obj;
    }

    public L get(int index) {
        return (L) objects[index];
    }

    public int size() {
        return objects.length;
    }

    public void ensureCapacity(int capacity) {
        if (capacity >= totalCapacity) {
            int newCapacity = totalCapacity + (initialCapacity >> 1);
            totalCapacity = newCapacity;
            objects = Arrays.copyOf(objects, newCapacity);
        }
    }

    public L remove(int index) {
        L oldValue = (L) objects[index];

        //20== 10 == 20-10-1=9th place removed
        int numMoved = size - index - 1; //2=Hello2
        if (numMoved > 0)
            System.arraycopy(objects, index + 1, objects, index,
                    numMoved);
        objects[--size] = null; // clear to let GC do its work

        return oldValue;
    }

}
