//package by.epam.shape.action;
//
//import by.epam.shape.entity.Triangle;
//import by.epam.shape.exception.InvalidIndexException;
//import by.epam.shape.exception.NullArgumentException;
//
//import java.util.Comparator;
//import java.util.List;
//
//public class TriangleSorter {
//
//    private void checkForNullArguments(List<Triangle> triangles, Comparator<Triangle> comparator) throws NullArgumentException {
//        if (triangles == null) {
//            throw new NullArgumentException("Triangles argument is null");
//        }
//        if (comparator == null) {
//            throw new NullArgumentException("Comparator argument is null");
//        }
//    }
//
//    public void doBubbleSort(List<Triangle> triangles, Comparator<Triangle> comparator) throws NullArgumentException {
//        checkForNullArguments(triangles,comparator);
//        for (int i = 0; i < triangles.size(); i++) {
//            for (int j = triangles.size() - 1; j > i; j--) {
//                if (comparator.compare(triangles.get(j), triangles.get(j - 1)) < 0) {
//                    triangles.set(j, triangles.set(j-1, triangles.get(j)));
//                }
//            }
//        }
//    }
//
//    public void doInsertionSort(List<Triangle> triangles, Comparator<Triangle> comparator) throws NullArgumentException {
//        checkForNullArguments(triangles,comparator);
//        for (int i = 1; i < triangles.size(); i++) {
//            Triangle current = triangles.get(i);
//            int j = i - 1;
//            while(j >= 0 && comparator.compare(current,triangles.get(j)) < 0) {
//                triangles.set(j+1,triangles.get(j));
//                j--;
//            }
//            triangles.set(j+1,current);
//        }
//    }
//
//    public void doSelectionSort(List<Triangle> triangles, Comparator<Triangle> comparator) throws NullArgumentException{
//        checkForNullArguments(triangles,comparator);
//        for (int i = 0; i < triangles.size(); i++) {
//            Triangle min = triangles.get(i);
//            int minId = i;
//            for (int j = i+1; j < triangles.size(); j++) {
//                if (comparator.compare(triangles.get(j),min) < 0) {
//                    min = triangles.get(j);
//                    minId = j;
//                }
//            }
//            Triangle temp = triangles.get(i);
//            triangles.set(i,min);
//            triangles.set(minId, temp);
//        }
//    }
//
//    private int doPartition(List<Triangle> triangles, int begin, int end, Comparator<Triangle> comparator) {
//        int pivot = end;
//
//        int counter = begin;
//        for (int i = begin; i < end; i++) {
//            if (comparator.compare(triangles.get(i), triangles.get(pivot)) < 0) {
//                Triangle temp = triangles.get(counter);
//                triangles.set(counter,triangles.get(i));
//                triangles.set(i, temp);
//                counter++;
//            }
//        }
//        Triangle temp = triangles.get(pivot);
//        triangles.set(pivot, triangles.get(counter));
//        triangles.set(counter, temp);
//
//        return counter;
//    }
//
//    public void doQuickSort(List<Triangle> triangles, int begin, int end, Comparator<Triangle> comparator) throws NullArgumentException, InvalidIndexException {
//        checkForNullArguments(triangles,comparator);
//        if (end <= begin){
//            return;
//        }
//        if (begin < 0){
//            throw new InvalidIndexException("Begin index is less than zero");
//        }
//        if (end > triangles.size()){
//            throw new InvalidIndexException("End index is larger than container size");
//        }
//        int pivot = doPartition(triangles, begin, end,comparator);
//        doQuickSort(triangles, begin, pivot-1,comparator);
//        doQuickSort(triangles, pivot+1, end,comparator);
//    }
//
//
//}
