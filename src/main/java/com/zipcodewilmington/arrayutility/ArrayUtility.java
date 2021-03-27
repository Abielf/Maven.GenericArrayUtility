package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T [] array;
    public ArrayUtility(T [] inputArray) {
        array=inputArray;

    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
         Integer count=0;
        for(T i:array){
            if (i==valueToEvaluate){count++;}
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        T[] newArray= Arrays.copyOf(array, array.length-getNumberOfOccurrences(valueToRemove));
        int count =0;
        for(int i=0;i< array.length;i++){
             if (array[i]!=valueToRemove){
                 newArray[count]=array[i];
                 count++;
             }
        }
        return newArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
       Integer dupes= getNumberOfOccurrences(valueToEvaluate);
       for (T i:arrayToMerge){
           if(i==valueToEvaluate){dupes++;}
       }
       return dupes;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T returnThis = null;
        Integer freqency=0;
        for (T i:array){
            if (countDuplicatesInMerge(arrayToMerge, i)>freqency){
                freqency=countDuplicatesInMerge(arrayToMerge,i);
                returnThis=i;
            }
        }
        for (T i:arrayToMerge){
            if (countDuplicatesInMerge(arrayToMerge, i)>freqency){
                freqency=countDuplicatesInMerge(arrayToMerge,i);
                returnThis=i;
            }
        }
        return returnThis;
    }

}
