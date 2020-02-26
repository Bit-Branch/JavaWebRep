package by.javatr.task1.entity;

import by.javatr.task1.exception.InvalidIndexException;
import by.javatr.task1.exception.NegativeSizeException;
import by.javatr.exception.NullArgumentException;

import java.util.Arrays;

public class GenericArray<T> {

    private final Object[] EMPTY_ARRAY = {};
    private int size;
    private Object[] array;


    public GenericArray() {
        this.array = EMPTY_ARRAY;
    }

    public GenericArray(int size) throws NegativeSizeException {
        if (size > 0) {
            this.setSize(size);
            this.array = new Object[size];
        } else {
            this.array = EMPTY_ARRAY;
        }
    }

    public GenericArray(T...arr){
        if (arr != null && (size = arr.length) != 0) {
            array = Arrays.copyOf(arr, size);
        } else {
            array = EMPTY_ARRAY;
        }
    }

    public GenericArray(GenericArray<T> array) throws NullArgumentException {
        if (array == null){
            throw new NullArgumentException("array argument is null");
        }
        this.size = array.getSize();
        this.setArray((T[])array.getArray());
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

    public void add(T element) throws NullArgumentException {
        if (element == null){
            throw new NullArgumentException("element argument is null");
        }
        increaseSize(size + 1);
        array[size++] = element;
    }

    public void add(int index, T element) throws InvalidIndexException, NullArgumentException {
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

    public T remove(int index) throws InvalidIndexException {
        if(index > size-1){
            throw new InvalidIndexException("Index larger than size of array");
        }
        if (index < 0){
            throw new InvalidIndexException("Index argument is negative");
        }
        T oldValue = (T)array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        array[--size] = 0;
        return oldValue;
    }

    public void doInsertionSort()
    {
        T key;
        int i = 0;
        for(int j = 1;j<size;j++){
            key = (T)array[j];
            i = j-1;
            while(i>=0 && ((Comparable)array[i]).compareTo(key) > 0){
                array[i+1] = array[i];
                i = i-1;
                array[i+1]=key;
            }
        }
    }

    public void doBubbleSort()
    {
        T tmp;
        for(int i = 0;i<size;i++){
            for(int j = (size-1);j>=(i+1);j--){
                if(((Comparable)array[j]).compareTo(array[j-1]) < 0 ){
                    tmp = (T)array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                }
            }
        }
    }

    public void doSelectionSort()
    {
        int j = 0;
        T tmp;
        for(int i=0; i<size; i++){
            j = i;
            for(int k = i; k<size; k++){
                if(((Comparable)array[j]).compareTo(array[k]) > 0 ){
                    j = k;
                }
            }
            tmp = (T)array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    public int findIndexOf(T element) throws NullArgumentException {
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

    public T get(int index){
        return (T)array[index];
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

    public T[] getArray() {
        return (T[])array.clone();
    }

    public void setArray(T[] array) throws NullArgumentException {
        if (array == null){
            throw new NullArgumentException("array argument is null");
        }
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericArray<T> array1 = (GenericArray<T>) o;
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
