package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] array;
    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;

    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int counter = 0;
        ArrayList<T> merge = new ArrayList<>();

        for (int i = 0; i < array.length; i++){
            merge.add(array[i]);
        }
        for (int i = 0; i < arrayToMerge.length; i++){
            merge.add(arrayToMerge[i]);
        }
        for (int i = 0; i < merge.size(); i++){
            if (merge.get(i) == valueToEvaluate){
                counter++;
            }
        }
        return counter;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T mostCommon = null;
        int count = 0;
        int temp = 0;

        for (T type : arrayToMerge){
            temp = countDuplicatesInMerge(arrayToMerge, type);

            if (temp > count){
                count = temp;
                mostCommon = type;
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int counter = 0;

        for (int i = 0; i < array.length; i++){
            if (array[i] == valueToEvaluate){
                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        int size = getNumberOfOccurrences(valueToRemove);

        T[] newArray = (T[]) Array.newInstance(valueToRemove.getClass(),array.length - size);

        int newArrayIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)){
                newArray[newArrayIndex] = array[i];
                newArrayIndex++;
            }

        }
        return newArray;
    }
}
