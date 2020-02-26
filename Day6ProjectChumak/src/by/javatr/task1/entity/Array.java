package by.javatr.task1.entity;

import by.javatr.task1.exception.InvalidIndexException;
import by.javatr.task1.exception.NegativeSizeException;
import by.javatr.exception.NullArgumentException;

import java.util.Arrays;

public class Array {

    private static final Integer[] EMPTY_ARRAY = {};
    private int size;
    private Integer[] array;


    public Array() {
        this.array = EMPTY_ARRAY;
    }

    public Array(int size) throws NegativeSizeException {
        if (size > 0) {
            this.setSize(size);
            this.array = new Integer[size];
        } else {
            this.array = EMPTY_ARRAY;
        }
    }

    public Array(Integer...arr){
        if (arr != null && (size = arr.length) != 0) {
            array = Arrays.copyOf(arr, size);
        } else {
            array = EMPTY_ARRAY;
        }
    }

    public Array(Array array) throws NullArgumentException {
        if (array == null){
            throw new NullArgumentException("array argument is null");
        }
        this.size = array.getSize();
        this.setArray(array.getArray());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void increaseSize(int toSize){
        int oldCapacity = this.array.length;
        int newCapacity = oldCapacity + 1;
        if (newCapacity - toSize < 0)
            newCapacity = toSize;
        array = Arrays.copyOf(array, newCapacity);
    }

    public void add(Integer element) throws NullArgumentException {
        if (element == null){
            throw new NullArgumentException("element argument is null");
        }
        increaseSize(size + 1);
        array[size++] = element;
    }

    public void add(int index, Integer element) throws InvalidIndexException, NullArgumentException {
        if (index < 0){
            throw new InvalidIndexException("Index argument is negative");
        }
        if (element == null){
            throw new NullArgumentException("element argument is null");
        }
        increaseSize(size + 1);
        System.arraycopy(array, index, array, index + 1,
                size - index);
        array[index] = element;
        size++;
    }

    public Integer remove(int index) throws InvalidIndexException {
        if(index > size-1){
            throw new InvalidIndexException("Index larger than size of array");
        }
        if (index < 0){
            throw new InvalidIndexException("Index argument is negative");
        }
        int oldValue = array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        array[--size] = 0;
        return oldValue;
    }

    public void doInsertionSort()
    {
        Integer key;
        int i = 0;
        for(int j = 1;j<size;j++){
            key = array[j];
            i = j-1;
            while(i>=0 && ((Comparable)(Integer)array[i]).compareTo(key) > 0){
                array[i+1] = array[i];
                i = i-1;
                array[i+1]=key;
            }
        }
    }

    public void doBubbleSort()
    {
        Integer tmp = 0;
        for(int i = 0;i<size;i++){
            for(int j = (size-1);j>=(i+1);j--){
                if(((Comparable)array[j]).compareTo(array[j-1]) < 0 ){
                    tmp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                }
            }
        }
    }

    public void doSelectionSort()
    {
        int j = 0;
        Integer tmp = 0;
        for(int i=0; i<size; i++){
            j = i;
            for(int k = i; k<size; k++){
                if(((Comparable)array[j]).compareTo(array[k]) > 0 ){
                    j = k;
                }
            }
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    public int findIndexOf(Integer element) throws NullArgumentException {
        if (element == null){
            throw new NullArgumentException("element argument is null");
        }
        doInsertionSort();
        int mid;
        int left = 0;
        int right = size;
        while (true)
        {
            mid = (left + right) / 2;
            if (((Comparable)element).compareTo(array[mid]) < 0){
                right = mid - 1;
            } else if (((Comparable)element).compareTo(array[mid]) > 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
    }

    public Integer get(int index){
        return array[index];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) throws NegativeSizeException {
        if (size < 0) {
            throw new NegativeSizeException("Illegal Capacity: " + size);
        }
        this.size = size;
    }

    public Integer[] getArray() {
        return array.clone();
    }

    public void setArray(Integer[] array) throws NullArgumentException {
        if (array == null){
            throw new NullArgumentException("array argument is null");
        }
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array1 = (Array) o;
        return size == array1.size &&
                Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        int result = 1;
        final int prime = 31;
        result = prime * result + Arrays.hashCode(array);
        result = prime * result + size;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "@ size=" + size +
                ", array=" + Arrays.toString(array);
    }
}
