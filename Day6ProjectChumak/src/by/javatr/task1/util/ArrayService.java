package by.javatr.task1.util;

import by.javatr.task1.entity.Array;
import by.javatr.task1.entity.Expression;
import by.javatr.exception.NullArgumentException;
import by.javatr.task1.exception.ZeroSizeException;

public class ArrayService {

    private static final int MAX_ONE_DIGIT_NUMBER = 9;

    private static boolean isPrime(int number){
        boolean answer = true;
        if (number > 0) {
            for (int i = 2; i < (number ^ (1 / 2)); i++) {
                if (number % i == 0) {
                    answer = false;
                }
            }
        }else{
            answer = false;
        }
        return answer;
    }

    private static boolean isFibonacciNumber(int number){
        boolean answer = false;
        if (number > 0) {
            if (number <= 2) {
                answer = true;
            }
            int x = 1;
            int y = 1;
            int sum = 0;
            for (int i = 2; i <= number; i++) {
                sum = x + y;
                x = y;
                y = sum;
                if (y == number) {
                    answer = true;
                }
            }
        }
        return answer;
    }

    private static boolean hasDifferentDigits(int number)
    {
        boolean answer = true;
        int digit;
        int flags = 0;
        int mask;
        if(Math.abs(number) > MAX_ONE_DIGIT_NUMBER) {
            while (Math.abs(number) > 0) {
                digit = number % 10;
                number /= 10;
                mask = 1 << digit;
                if ((flags & mask) != 0) {
                    answer = false;
                }
                flags ^= mask;
            }
        }else{
            answer = false;
        }
        return answer;
    }

    private static boolean hasDuplicate(Integer[] array, int element){
        boolean condition = false;
        for (int i=0;i<array.length;i++){
            if (array[i] == element){
                condition = true;
            }
        }
        return condition;
    }

    private static Integer[] getArray(Array array, Expression expression) throws NullArgumentException {
        if (array == null){
            throw new NullArgumentException("array argument is null");
        }
        Array numbers = new Array();
        for (int i=0;i<array.getSize();i++){
            if (expression.isUnique(array.get(i))){
                if(!hasDuplicate(numbers.getArray(),array.get(i))) {
                    numbers.add(array.get(i));
                }
            }
        }
        return numbers.getArray();
    }

    public static Integer[] findAllPrimeNumbers(Array array) throws NullArgumentException {
        return getArray(array,ArrayService::isPrime);
    }

    public static Integer[] findAllFibonacciNumbers(Array array) throws NullArgumentException {
        return getArray(array,ArrayService::isFibonacciNumber);
    }

    public static Integer[] findDifferentDigitsNumbers(Array array) throws NullArgumentException {
        return getArray(array,ArrayService::hasDifferentDigits);
    }

    public static int findMaxElement(Array integerArray) throws NullArgumentException, ZeroSizeException {
        if (integerArray == null){
            throw new NullArgumentException("integerArray argument is null");
        }
        if (integerArray.getSize() == 0) {
            throw new ZeroSizeException("integerArray has zero size");
        }
            int max = integerArray.get(0);
            for (int i = 0; i < integerArray.getSize(); i++) {
                if (integerArray.get(i) > max) {
                    max = integerArray.get(i);
                }
            }
            return max;
    }

    public static int findMinElement(Array integerArray) throws NullArgumentException, ZeroSizeException {
        if (integerArray == null){
            throw new NullArgumentException("integerArray argument is null");
        }
        if (integerArray.getSize() == 0) {
            throw new ZeroSizeException("integerArray has zero size");
        }
        int min = integerArray.get(0);
        for(int i = 0; i < integerArray.getSize(); ++i)
        {
            if(integerArray.get(i) < min)
            {
                min = integerArray.get(i);
            }
        }
        return min;
    }

}
