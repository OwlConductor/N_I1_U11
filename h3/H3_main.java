package h3;

import java.util.Arrays;

public class H3_main {
    public static void main(String[] args) {
        
    }

    public static int[] mergeSort(int[] numberArray) {
        if (numberArray==null || numberArray.length==0)
            return null;
        else if (numberArray.length==1)
            return numberArray;
        else {
            int[] leftNumberArray = mergeSort(Arrays.copyOfRange(numberArray, 0, numberArray.length/2));
            int[] rightNumberArray = mergeSort(Arrays.copyOfRange(numberArray, numberArray.length/2, numberArray.length));
            int[] mergedNumberArray = new int[leftNumberArray.length + rightNumberArray.length];
            int leftPosition = 0;
            int rightPosition = 0;
            int mergePosition = 0;
            while (leftPosition<leftNumberArray.length || rightPosition<rightNumberArray.length) {
                if(leftPosition>=leftNumberArray.length) {
                    mergedNumberArray[mergePosition]=rightNumberArray[rightPosition];
                    rightPosition++;
                } else if(rightPosition>=rightNumberArray.length) {
                    mergedNumberArray[mergePosition]=leftNumberArray[leftPosition];
                    leftPosition++;
                } else if (leftNumberArray[leftPosition]<rightNumberArray[rightPosition]) {
                    mergedNumberArray[mergePosition]=leftNumberArray[leftPosition];
                    leftPosition++;
                } else {
                    mergedNumberArray[mergePosition]=rightNumberArray[rightPosition];
                    rightPosition++;
                }
                mergePosition++;
            }
            return mergedNumberArray;
        }
    }
}
